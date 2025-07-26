package com.app.customermanagement.service;

import com.app.customermanagement.model.Todo;

import java.util.List;

public interface TodoService {

    Todo add(Todo todo) throws Exception;
    Todo update(Todo todo) throws Exception;
    List<Todo> list() throws  Exception;
}
