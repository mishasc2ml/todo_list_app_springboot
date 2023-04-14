package com.todolist.backendspring.service;

public interface StatService {

    Integer getCompletedTasksCount();

    Integer getUncompletedTasksCount();
}
