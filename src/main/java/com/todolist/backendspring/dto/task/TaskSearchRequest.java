package com.todolist.backendspring.dto.task;

import lombok.Data;

@Data
public class TaskSearchRequest {

    private String title;
    private Boolean completed;
    private Long priorityId;
    private Long categoryId;
    private String sortDirection;
    private String sortColumn;
    private Integer pageNumber;
    private Integer pageSize;
}
