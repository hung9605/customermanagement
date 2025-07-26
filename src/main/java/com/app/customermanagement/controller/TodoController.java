package com.app.customermanagement.controller;

import com.app.customermanagement.dto.response.ResponseBean;
import com.app.customermanagement.model.Todo;
import com.app.customermanagement.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/todo")
@CrossOrigin("*")
public class TodoController extends BaseController{

    private final TodoService todoService;

    @GetMapping("/list")
    public ResponseEntity<?> list(){
        try {
            return response(new ResponseBean( todoService.list()));
        } catch (Exception e) {
            return responseError(new ResponseBean(e.getMessage()), e);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Todo todo){
        try {
            return response(new ResponseBean( todoService.add(todo)));
        } catch (Exception e) {
            return responseError(new ResponseBean(e.getMessage()), e);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Todo todo){
        try {
            return response(new ResponseBean( todoService.update(todo)));
        } catch (Exception e) {
            return responseError(new ResponseBean(e.getMessage()), e);
        }
    }

}
