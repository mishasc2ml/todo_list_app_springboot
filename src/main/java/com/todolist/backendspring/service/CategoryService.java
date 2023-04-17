package com.todolist.backendspring.service;

import com.todolist.backendspring.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    List<Category> findByTitle(String title);

    Category getCategoryById(Long categoryId);

    Category createCategory(Category category);

    String deleteCategory(Long categoryId);

    Category updateCategory(Category category, Long categoryId);
}
