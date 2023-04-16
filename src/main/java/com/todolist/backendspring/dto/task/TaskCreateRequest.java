package com.todolist.backendspring.dto.task;

import com.todolist.backendspring.entity.Category;
import com.todolist.backendspring.entity.Priority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskCreateRequest {

    @Size(min = 1, max = 45, message = "Task title length should be between 1 and 45 symbols")
    @NotBlank(message = "Task title can't be blank")
    private String title;

    @NotNull(message = "Date can't be empty")
    private LocalDate datetime;

    @NotNull(message = "Category can't be empty")
    private Category category;

    @NotNull(message = "Priority can't be empty")
    private Priority priority;
}
