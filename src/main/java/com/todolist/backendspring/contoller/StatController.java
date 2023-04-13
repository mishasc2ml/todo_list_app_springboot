package com.todolist.backendspring.contoller;

import com.todolist.backendspring.repository.StatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/stat")
public class StatController {

    private final StatRepository statRepository;
}
