package com.todolist.backendspring.dto.category;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryRequest {

    @Size(min = 1, max = 45, message = "Category length should be between 1 and 40 symbols")
    private String title;
}
