package com.example.my_first_rest_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ToDoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping ("/todo")
    public ResponseEntity<Todo> get(@RequestParam(value = "id") int id){

        Todo newTodo = new Todo();
        newTodo.setId(id);
        newTodo.setDescription("Einkaufen gehen");
        newTodo.setIsDone(true);

        return new ResponseEntity<Todo>(newTodo, HttpStatus.OK);
    }

    @PostMapping ("/todo")
    public ResponseEntity<Todo> create(@RequestBody Todo newTodo) {
        //save todo in db
        todoRepository.save(newTodo);
        return new ResponseEntity<Todo>(newTodo, HttpStatus.OK);
    }
}
