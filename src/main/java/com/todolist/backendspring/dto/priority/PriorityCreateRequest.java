package com.todolist.backendspring.dto.priority;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PriorityCreateRequest {

    @Size(min = 1, max = 45, message = "Priority length should be between 1 and 45 symbols")
    @NotBlank(message = "Priority title can't be blank")
    private String title;

    @Size(min = 3, max = 7, message = "Priority color length should be between 3 and 7 symbols")
    @NotBlank(message = "Priority color can't be blank")
    private String color;
}
