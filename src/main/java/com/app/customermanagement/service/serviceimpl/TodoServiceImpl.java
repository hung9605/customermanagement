package com.app.customermanagement.service.serviceimpl;

import com.app.customermanagement.model.Todo;
import com.app.customermanagement.repository.TodoRepository;
import com.app.customermanagement.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    /**
     * @param todo
     * @return
     * @throws Exception
     */
    @Override
    public Todo add(Todo todo) throws Exception {
        return todoRepository.save(todo);
    }

    /**
     * @param todo
     * @return
     * @throws Exception
     */
    @Override
    public Todo update(Todo todo) throws Exception {
        return todoRepository.save(todo);
    }

    /**
     * @return
     * @throws Exception
     */
    @Override
    public List<Todo> list() throws Exception {
        return todoRepository.findAll();
    }
}
