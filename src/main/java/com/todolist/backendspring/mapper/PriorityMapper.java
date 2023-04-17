package com.todolist.backendspring.mapper;

import com.todolist.backendspring.dto.priority.PriorityCreateRequest;
import com.todolist.backendspring.dto.priority.PriorityUpdateRequest;
import com.todolist.backendspring.entity.Priority;
import com.todolist.backendspring.exception.InputFieldException;
import com.todolist.backendspring.service.PriorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PriorityMapper {

    private final PriorityService priorityService;
    private final CommonMapper commonMapper;

    public List<Priority> getAllPriorities() {
        return priorityService.getAllPriorities();
    }

    public Priority getPriorityById(Long id) {
        return priorityService.getPriorityById(id);
    }

    public Priority createPriority(PriorityCreateRequest priorityRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
        return priorityService.createPriority(commonMapper.convertToEntity(priorityRequest, Priority.class));
    }

    public String deletePriority(Long id) {
        return priorityService.deletePriority(id);
    }

    public Priority updatePriority(PriorityUpdateRequest priorityUpdateRequest, Long id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
        return priorityService.updatePriority(commonMapper.convertToEntity(priorityUpdateRequest, Priority.class), id);
    }
}
