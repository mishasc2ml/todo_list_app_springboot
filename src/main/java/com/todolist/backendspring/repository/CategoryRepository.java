package com.todolist.backendspring.repository;

import com.todolist.backendspring.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByTitle(String title);

    List<Category> findAllByOrderByTitleAsc();

    @Query("SELECT c FROM Category c WHERE" +
            "(:title IS NULL OR :title='' OR lower(c.title) LIKE lower(concat('%',:title,'%')))")
    List<Category> findByTitle(@Param("title") String title);
}
