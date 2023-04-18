package com.todolist.backendspring.repository;

import com.todolist.backendspring.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT c FROM Task c WHERE" +
            "(:title IS NULL OR :title='' OR lower(c.title) LIKE lower(concat('%',:title,'%'))) AND" +
            "(:completed IS NULL OR c.completed = :completed) AND" +
            "(:priorityId IS NULL OR c.priority.id = :priorityId) AND" +
            "(:categoryId IS NULL OR c.category.id = :categoryId)")
    List<Task> findTasksByParams(@Param("title") String title,
                                 @Param("completed") Boolean completed,
                                 @Param("priorityId") Long priorityId,
                                 @Param("categoryId") Long categoryId);
}
