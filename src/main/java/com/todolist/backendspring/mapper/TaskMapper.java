package com.todolist.backendspring.mapper;

import com.todolist.backendspring.dto.task.TaskCreateRequest;
import com.todolist.backendspring.dto.task.TaskSearchRequest;
import com.todolist.backendspring.dto.task.TaskUpdateRequest;
import com.todolist.backendspring.entity.Task;
import com.todolist.backendspring.exception.InputFieldException;
import com.todolist.backendspring.service.TaskService;
import com.todolist.backendspring.util.Sorting;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TaskMapper {

    private final TaskService taskService;
    private final CommonMapper commonMapper;

    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    public Task getTaskById(Long taskId) {
        return taskService.getTaskById(taskId);
    }

    public Page<Task> findTasksByParams(TaskSearchRequest task) {
        return taskService.findTasksByParams(
                task.getTitle(),
                task.getCompleted(),
                task.getPriorityId(),
                task.getCategoryId(),
                Sorting.setUp(
                        task.getPageNumber(),
                        task.getPageSize(),
                        task.getSortDirection(),
                        task.getSortColumn()
                )
        );
    }

    public Task createTask(TaskCreateRequest task, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
        return taskService.createTask(commonMapper.convertToEntity(task, Task.class));
    }

    public String deleteTask(Long taskId) {
        return taskService.deleteTask(taskId);
    }

    public Task updateTask(TaskUpdateRequest task, Long taskId, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
        return taskService.updateTask(commonMapper.convertToEntity(task, Task.class), taskId);
    }

    public String setTaskComplete(Long taskId) {
        return taskService.setTaskComplete(taskId);
    }

    public String setTaskUncompleted(Long taskId) {
        return taskService.setTaskUncompleted(taskId);
    }
}
