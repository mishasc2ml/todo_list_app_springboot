package com.todolist.backendspring.contoller;

import com.todolist.backendspring.dto.task.TaskCreateRequest;
import com.todolist.backendspring.dto.task.TaskSearchRequest;
import com.todolist.backendspring.dto.task.TaskUpdateRequest;
import com.todolist.backendspring.entity.Task;
import com.todolist.backendspring.mapper.TaskMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskMapper taskMapper;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskMapper.getAllTasks());
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long taskId) {
        return ResponseEntity.ok(taskMapper.getTaskById(taskId));
    }

    @PostMapping("/new")
    public ResponseEntity<Task> createTask(@Valid @RequestBody TaskCreateRequest task,
                                           BindingResult bindingResult) {
        return ResponseEntity.ok(taskMapper.createTask(task, bindingResult));
    }

    @DeleteMapping("{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable Long taskId) {
        return ResponseEntity.ok(taskMapper.deleteTask(taskId));
    }

    @PutMapping("{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId,
                                           @Valid @RequestBody TaskUpdateRequest task,
                                           BindingResult bindingResult) {
        return ResponseEntity.ok(taskMapper.updateTask(task, taskId, bindingResult));
    }

    @GetMapping("/{taskId}/set_complete")
    public ResponseEntity<String> setTaskComplete(@PathVariable Long taskId) {
        return ResponseEntity.ok(taskMapper.setTaskComplete(taskId));
    }

    @GetMapping("/{taskId}/set_uncompleted")
    public ResponseEntity<String> setTaskUncompleted(@PathVariable Long taskId) {
        return ResponseEntity.ok(taskMapper.setTaskUncompleted(taskId));
    }

    @PostMapping("/search")
    public ResponseEntity<List<Task>> findTasksByParams(@RequestBody TaskSearchRequest filter) {
        return ResponseEntity.ok(taskMapper.findTasksByParams(filter));
    }
}
