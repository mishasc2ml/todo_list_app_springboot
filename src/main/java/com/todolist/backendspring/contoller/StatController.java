package com.todolist.backendspring.contoller;

import com.todolist.backendspring.mapper.StatMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/stat")
public class StatController {

    private final StatMapper statMapper;

    @GetMapping("/completed")
    public ResponseEntity<Map<String, Integer>> getCompletedTasksCount() {
        return ResponseEntity.ok(statMapper.getCompletedTasksCount());
    }

    @GetMapping("/uncompleted")
    public ResponseEntity<Map<String, Integer>> getUncompletedTasksCount() {
        return ResponseEntity.ok(statMapper.getUncompletedTasksCount());
    }
}
