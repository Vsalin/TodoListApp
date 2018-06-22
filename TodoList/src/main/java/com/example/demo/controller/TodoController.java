package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TodoEntity;
import com.example.demo.service.TodoService;

@RestController
public class TodoController {

	@Autowired
	TodoService todoService;
	
	@GetMapping("/api/read")
	public List<TodoEntity> getAll() {
		return todoService.getList();
	}
	
	@PostMapping("/api/create") 
	public String createList( @RequestParam("title") String title,@RequestParam("detail") String detail) {
		todoService.createList(title, detail);
		return "success";
	}
	
	@PutMapping("/api/update/{id}")
	public String updateList(@PathVariable(value="id") Long id,@RequestBody TodoEntity  todoentity) {
		todoService.updateList(id,todoentity);
		return "update success";
	}

	  
	 @DeleteMapping("/api/delete/{id}")
	 public ResponseEntity<?> deleteList(@PathVariable(value="id") Long idList){ 	
		 todoService.deleleteList(idList);
		 return ResponseEntity.ok().build();
	  }
	
}
