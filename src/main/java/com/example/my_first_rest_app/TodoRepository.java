package com.example.my_first_rest_app;

import org.springframework.data.repository.CrudRepository;

import java.util.Set;


public interface TodoRepository extends CrudRepository<Todo, Integer> {

}
