package com.todolist.backendspring.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommonMapper {

    private final ModelMapper modelMapper;

    public <T, R> R convertToResponse(T data, Class<R> entityType) {
        return modelMapper.map(data, entityType);
    }

    public <T, R> R convertToEntity(T data, Class<R> entityType) {
        return modelMapper.map(data, entityType);
    }
}
