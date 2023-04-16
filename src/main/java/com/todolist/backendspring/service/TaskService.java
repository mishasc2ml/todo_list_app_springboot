package com.todolist.backendspring.service;

import com.todolist.backendspring.dto.task.TaskUpdateRequest;
import com.todolist.backendspring.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();

    Task getTaskById(Long taskId);

    Task createTask(Task task);

    String deleteTask(Long taskId);

    Task updateTask(TaskUpdateRequest taskUpdateRequest, Long taskId);

    String setTaskComplete(Long taskId);

    String setTaskUncompleted(Long taskId);
}
