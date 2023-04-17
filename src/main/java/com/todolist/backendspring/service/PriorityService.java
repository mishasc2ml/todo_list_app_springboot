package com.todolist.backendspring.service;

import com.todolist.backendspring.entity.Priority;

import java.util.List;

public interface PriorityService {

    List<Priority> getAllPriorities();

    Priority getPriorityById(Long id);

    Priority createPriority(Priority priority);

    String deletePriority(Long id);

    Priority updatePriority(Priority priority, Long id);
}
