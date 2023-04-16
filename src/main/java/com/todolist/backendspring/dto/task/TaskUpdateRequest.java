package com.todolist.backendspring.dto.task;

import com.todolist.backendspring.entity.Category;
import com.todolist.backendspring.entity.Priority;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskUpdateRequest {

    @Size(min = 1, max = 45, message = "Task title length should be between 1 and 45 symbols")
    private String title;

    private LocalDate datetime;

    private Category category;

    private Priority priority;
}
