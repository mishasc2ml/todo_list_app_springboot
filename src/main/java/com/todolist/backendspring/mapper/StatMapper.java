package com.todolist.backendspring.mapper;

import com.todolist.backendspring.service.StatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class StatMapper {

    private final StatService statService;

    public Map<String, Integer> getCompletedTasksCount() {
        Map<String, Integer> completedTasks = new HashMap<>();
        completedTasks.put("completedTasksTotalCount", statService.getCompletedTasksCount());
        return completedTasks;
    }

    public Map<String, Integer> getUncompletedTasksCount() {
        Map<String, Integer> uncompletedTasks = new HashMap<>();
        uncompletedTasks.put("uncompletedTasksTotalCount", statService.getUncompletedTasksCount());
        return uncompletedTasks;
    }
}
