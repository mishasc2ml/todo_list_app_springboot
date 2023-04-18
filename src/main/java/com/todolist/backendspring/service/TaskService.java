package com.todolist.backendspring.service;

import com.todolist.backendspring.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();

    List<Task> findTasksByParams(String title,
                                 Boolean completed,
                                 Long priorityId,
                                 Long categoryId);

    Task getTaskById(Long taskId);

    Task createTask(Task task);

    String deleteTask(Long taskId);

    Task updateTask(Task task, Long taskId);

    String setTaskComplete(Long taskId);

    String setTaskUncompleted(Long taskId);
}
