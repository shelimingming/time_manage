package com.mj.time.service;

import com.mj.time.domain.Tag;
import com.mj.time.domain.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> selectUserTodoList(Integer userId);

    void addTodo(Todo todo);
}
