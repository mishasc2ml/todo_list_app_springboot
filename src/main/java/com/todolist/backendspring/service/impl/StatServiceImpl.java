package com.todolist.backendspring.service.impl;

import com.todolist.backendspring.entity.Stat;
import com.todolist.backendspring.exception.NotFoundException;
import com.todolist.backendspring.repository.StatRepository;
import com.todolist.backendspring.service.StatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatServiceImpl implements StatService {

    private final StatRepository statRepository;
    private final Long defaultId = 1L;

    @Override
    public Integer getCompletedTasksCount() {
        Stat stat = statRepository.findById(defaultId)
                .orElseThrow(() -> new NotFoundException("Not valid id", HttpStatus.NOT_FOUND));
        return stat.getCompletedCountTotal();
    }

    @Override
    public Integer getUncompletedTasksCount() {
        Stat stat = statRepository.findById(defaultId)
                .orElseThrow(() -> new NotFoundException("Not valid id", HttpStatus.NOT_FOUND));
        return stat.getUncompletedCountTotal();
    }
}

