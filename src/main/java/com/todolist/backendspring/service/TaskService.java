package com.todolist.backendspring.service;

import com.todolist.backendspring.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();

    Page<Task> findTasksByParams(String title, Boolean completed, Long priorityId,
                                 Long categoryId, Pageable pageable);

    Task getTaskById(Long taskId);

    Task createTask(Task task);

    String deleteTask(Long taskId);

    Task updateTask(Task task, Long taskId);

    String setTaskComplete(Long taskId);

    String setTaskUncompleted(Long taskId);
}
