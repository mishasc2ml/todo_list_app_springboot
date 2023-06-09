package com.todolist.backendspring.contoller;

import com.todolist.backendspring.dto.priority.PriorityCreateRequest;
import com.todolist.backendspring.dto.priority.PriorityUpdateRequest;
import com.todolist.backendspring.entity.Priority;
import com.todolist.backendspring.mapper.PriorityMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/priority")
public class PriorityController {

    private final PriorityMapper priorityMapper;

    @GetMapping
    public ResponseEntity<List<Priority>> getAllPriorities() {
        return ResponseEntity.ok(priorityMapper.getAllPriorities());
    }

    @GetMapping("/{priorityId}")
    public ResponseEntity<Priority> getPriorityById(@PathVariable Long priorityId) {
        return ResponseEntity.ok(priorityMapper.getPriorityById(priorityId));
    }

    @PostMapping("/new")
    public ResponseEntity<Priority> createPriority(@Valid @RequestBody PriorityCreateRequest priority,
                                                   BindingResult bindingResult) {
        return ResponseEntity.ok(priorityMapper.createPriority(priority, bindingResult));
    }

    @DeleteMapping("{priorityId}")
    public ResponseEntity<String> deletePriority(@PathVariable Long priorityId) {
        return ResponseEntity.ok(priorityMapper.deletePriority(priorityId));
    }

    @PatchMapping("{priorityId}")
    public ResponseEntity<Priority> updatePriority(@PathVariable Long priorityId,
                                                   @Valid @RequestBody PriorityUpdateRequest priority,
                                                   BindingResult bindingResult) {
        return ResponseEntity.ok(priorityMapper.updatePriority(priority, priorityId, bindingResult));
    }
}
