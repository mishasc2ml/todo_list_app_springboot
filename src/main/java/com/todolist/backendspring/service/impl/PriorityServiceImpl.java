package com.todolist.backendspring.service.impl;

import com.todolist.backendspring.repository.PriorityRepository;
import com.todolist.backendspring.service.PriorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriorityServiceImpl implements PriorityService {

    private final PriorityRepository priorityRepository;


}
