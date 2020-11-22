package com.mj.time.controller;

import com.mj.time.common.CommonResponse;
import com.mj.time.domain.Todo;
import com.mj.time.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/time/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PutMapping
    CommonResponse<Object> addTodo(Todo todo) {
        todoService.addTodo(todo);
        return new CommonResponse<Object>();
    }

    @GetMapping("/user/{userId}")
    CommonResponse<List<Todo>> getUserTodo(@PathVariable("userId") Integer userId) {
        List<Todo> todoList = todoService.selectUserTodoList(userId);
        return new CommonResponse<List<Todo>>(todoList);
    }
}
