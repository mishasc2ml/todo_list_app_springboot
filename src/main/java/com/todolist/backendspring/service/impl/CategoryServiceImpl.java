package com.todolist.backendspring.service.impl;

import com.todolist.backendspring.entity.Category;
import com.todolist.backendspring.exception.NotFoundException;
import com.todolist.backendspring.exception.NotUniqueValueException;
import com.todolist.backendspring.repository.CategoryRepository;
import com.todolist.backendspring.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAllByOrderByTitleAsc();
    }

    @Override
    public List<Category> findCategoriesByTitle(String title) {
        return categoryRepository.findCategoriesByTitle(title);
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException("Category not found, not valid id", HttpStatus.NOT_FOUND));
    }

    @Override
    @Transactional
    public Category createCategory(Category category) {
        String newCategoryTitle = category.getTitle();
        if (categoryRepository.findAllByTitle(newCategoryTitle).size() > 0) {
            throw new NotUniqueValueException("Such category already exists");
        }
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException("Category not found, not valid id", HttpStatus.NOT_FOUND));
        categoryRepository.delete(category);
        return "Category deleted successfully";
    }

    @Override
    @Transactional
    public Category updateCategory(Category updatedCategory, Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException("Category not found, not valid id", HttpStatus.NOT_FOUND));
        category.setTitle(updatedCategory.getTitle());
        return categoryRepository.save(category);
    }
}
