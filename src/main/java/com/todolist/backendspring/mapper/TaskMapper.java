package com.todolist.backendspring.mapper;

import com.todolist.backendspring.dto.task.TaskCreateRequest;
import com.todolist.backendspring.dto.task.TaskUpdateRequest;
import com.todolist.backendspring.entity.Task;
import com.todolist.backendspring.exception.InputFieldException;
import com.todolist.backendspring.service.TaskService;
import lombok.RequiredArgsConstructor;
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

    public Task createTask(TaskCreateRequest taskCreateRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
        return taskService.createTask(commonMapper.convertToEntity(taskCreateRequest, Task.class));
    }

    public String deleteTask(Long taskId) {
        return taskService.deleteTask(taskId);
    }

    public Task updateTask(TaskUpdateRequest taskUpdateRequest, Long taskId, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
        return taskService.updateTask(taskUpdateRequest, taskId);
    }

    public String setTaskComplete(Long taskId) {
        return taskService.setTaskComplete(taskId);
    }

    public String setTaskUncompleted(Long taskId) {
        return taskService.setTaskUncompleted(taskId);
    }
}
