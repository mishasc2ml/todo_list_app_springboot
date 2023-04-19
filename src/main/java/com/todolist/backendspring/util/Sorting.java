package com.todolist.backendspring.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class Sorting {
    public static PageRequest setUp(Integer pageNumber, Integer pageSize, String direction, String column) {
        return PageRequest.of(
                setPageNumber(pageNumber),
                setPageSize(pageSize),
                setDirection(direction),
                setColumn(column));
    }
    private static Sort.Direction setDirection(String direction) {
        return direction != null && !direction.isBlank() &&
                direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
    }
    private static String setColumn(String column) {
        return column != null && !column.isBlank() ? column : "title";
    }
    private static Integer setPageNumber(Integer pageNumber) {
        return pageNumber != null ? pageNumber : 0;
    }
    private static Integer setPageSize(Integer pageSize) {
        return pageSize != null ? pageSize : 5;
    }
}
