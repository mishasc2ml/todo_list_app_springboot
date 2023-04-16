package com.todolist.backendspring.dto.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryRequest {

    @Size(min = 1, max = 45, message = "Category title length should be between 1 and 45 symbols")
    @NotBlank(message = "Category title can't be blank")
    private String title;
}
