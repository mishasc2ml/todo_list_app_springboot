package com.todolist.backendspring.contoller;

import com.todolist.backendspring.repository.PriorityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/priority")
public class PriorityController {

    private final PriorityRepository priorityRepository;
}
