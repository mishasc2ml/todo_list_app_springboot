package com.todolist.backendspring.service.impl;

import com.todolist.backendspring.dto.task.TaskUpdateRequest;
import com.todolist.backendspring.entity.Category;
import com.todolist.backendspring.entity.Priority;
import com.todolist.backendspring.entity.Task;
import com.todolist.backendspring.exception.NotFoundException;
import com.todolist.backendspring.repository.CategoryRepository;
import com.todolist.backendspring.repository.PriorityRepository;
import com.todolist.backendspring.repository.TaskRepository;
import com.todolist.backendspring.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final CategoryRepository categoryRepository;
    private final PriorityRepository priorityRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new NotFoundException("Task not found, not valid id", HttpStatus.NOT_FOUND));
    }

    @Override
    @Transactional
    public Task createTask(Task validTask) {
        Task task = new Task();
        Category category = categoryRepository.findById(validTask.getCategory().getId())
                .orElseThrow(() -> new NotFoundException("Category not found, not valid id", HttpStatus.NOT_FOUND));
        category.setUncompletedCount(category.getUncompletedCount() + 1);
        System.out.println(category);
        Priority priority = priorityRepository.findById(validTask.getPriority().getId())
                .orElseThrow(() -> new NotFoundException("Priority not found, not valid id", HttpStatus.NOT_FOUND));
        System.out.println(priority);
        task.setTitle(validTask.getTitle());
        task.setDatetime(validTask.getDatetime());
        task.setCategory(category);
        task.setPriority(priority);
        System.out.println(task);
        return taskRepository.save(task);
    }

    @Override
    @Transactional
    public String deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new NotFoundException("Task not found, not valid id", HttpStatus.NOT_FOUND));
        taskRepository.delete(task);
        return "Task deleted successfully";
    }

    @Override
    @Transactional
    public Task updateTask(TaskUpdateRequest taskUpdateRequest, Long taskId) {
        return taskRepository.findById(taskId)
                .map(task -> {
                    Optional.ofNullable(taskUpdateRequest.getTitle()).ifPresent(task::setTitle);
                    Optional.ofNullable(taskUpdateRequest.getDatetime()).ifPresent(task::setDatetime);
                    Optional.ofNullable(taskUpdateRequest.getPriority()).ifPresent(givenPriority -> {
                        Priority priority = priorityRepository.findById(givenPriority.getId())
                                .orElseThrow(() -> new NotFoundException("Priority not found, not valid id", HttpStatus.NOT_FOUND));
                        givenPriority.setTitle(priority.getTitle());
                        givenPriority.setColor(priority.getColor());
                        task.setPriority(givenPriority);
                    });
                    Optional.ofNullable(taskUpdateRequest.getCategory()).ifPresent(givenCategory -> {
                        Category category = categoryRepository.findById(givenCategory.getId())
                                .orElseThrow(() -> new NotFoundException("Category not found, not valid id", HttpStatus.NOT_FOUND));
                        givenCategory.setTitle(category.getTitle());
                        givenCategory.setCompletedCount(category.getCompletedCount());
                        givenCategory.setUncompletedCount(category.getUncompletedCount());
                        if (task.getCompleted()) {
                            givenCategory.setCompletedCount(givenCategory.getCompletedCount() + 1);
                        } else {
                            givenCategory.setUncompletedCount(givenCategory.getUncompletedCount() + 1);
                        }
                        task.setCategory(givenCategory);
                    });
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new NotFoundException("Task not found, not valid id", HttpStatus.NOT_FOUND));
    }

    @Override
    @Transactional
    public String setTaskComplete(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new NotFoundException("Task not found, not valid id", HttpStatus.NOT_FOUND));
        if (!task.getCompleted()) {
            task.setCompleted(true);
        }
        taskRepository.save(task);
        return "Task " + taskId + " was set as complete";
    }

    @Override
    @Transactional
    public String setTaskUncompleted(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new NotFoundException("Task not found, not valid id", HttpStatus.NOT_FOUND));
        if (task.getCompleted()) {
            task.setCompleted(false);
        }
        taskRepository.save(task);
        return "Task " + taskId + " was set as uncompleted";
    }
}

