package com.todolist.backendspring.service;

import com.todolist.backendspring.dto.category.CategoryRequest;
import com.todolist.backendspring.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(Long categoryId);

    Category createCategory(Category category);

    String deleteCategory(Long categoryId);

    Category updateCategory(CategoryRequest categoryRequest, Long categoryId);

}
