package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.TodoEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	TodoRepository todoRepository;
	
	public void createList(String title, String detail) {
		TodoEntity list = new TodoEntity(title,detail,false);
		todoRepository.save(list);
	}

	public List<TodoEntity> getList() {
		return todoRepository.findAll();
	}
	
	public TodoEntity updateList(Long id,TodoEntity todoentity) {
		TodoEntity todo = todoRepository.findById(id).orElseThrow(
				 () -> new ResourceNotFoundException("List", "id", id)
				 );
		todo.setTitle(todoentity.getTitle());
		todo.setDetail(todoentity.getDetail());
		todo.setStatus(todo.getStatus());
		TodoEntity tododetails = todoRepository.save(todo);
		return tododetails;	
				 
	}
	public void deleleteList(Long id) {
		  todoRepository.deleteById(id);

	}
}

