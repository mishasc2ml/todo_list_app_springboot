package com.todolist.backendspring.service.impl;

import com.todolist.backendspring.entity.Priority;
import com.todolist.backendspring.exception.NotFoundException;
import com.todolist.backendspring.exception.NotUniqueValueException;
import com.todolist.backendspring.repository.PriorityRepository;
import com.todolist.backendspring.service.PriorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PriorityServiceImpl implements PriorityService {

    private final PriorityRepository priorityRepository;

    @Override
    public List<Priority> getAllPriorities() {
        return priorityRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Priority getPriorityById(Long id) {
        return priorityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Priority not found, not valid id", HttpStatus.NOT_FOUND));
    }

    @Override
    @Transactional
    public Priority createPriority(Priority validPriority) {
        String newPriorityTitle = validPriority.getTitle();
        if (priorityRepository.findAllByTitle(newPriorityTitle).size() > 0) {
            throw new NotUniqueValueException("Such priority already exists");
        }
        return priorityRepository.save(validPriority);
    }

    @Override
    @Transactional
    public String deletePriority(Long id) {
        Priority priority = priorityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Priority not found, not valid id", HttpStatus.NOT_FOUND));
        priorityRepository.delete(priority);
        return "Priority deleted successfully";
    }

    @Override
    @Transactional
    public Priority updatePriority(Priority updatedPriority, Long id) {
        Priority priority = priorityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Priority not found, not valid id", HttpStatus.NOT_FOUND));
        priority.setTitle(updatedPriority.getTitle());
        return priorityRepository.save(priority);
    }
}
