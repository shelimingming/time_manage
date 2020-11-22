package com.mj.time.service.impl;

import com.mj.time.domain.Tag;
import com.mj.time.domain.Todo;
import com.mj.time.mapper.TagMapper;
import com.mj.time.mapper.TodoMapper;
import com.mj.time.service.TagService;
import com.mj.time.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoMapper todoMapper;


    @Override
    public List<Todo> selectUserTodoList(Integer userId) {
        List<Todo> todoList = todoMapper.selectByUserId(userId);
        return todoList;
    }

    @Override
    public void addTodo(Todo todo) {
        int insert = todoMapper.insert(todo);
    }
}
