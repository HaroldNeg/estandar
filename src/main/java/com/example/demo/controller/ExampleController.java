package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Example;
import com.example.demo.service.IExampleService;

/*
 * Error login: 401
 * Error role: 403
 * Other error: 500
 */
@RestController
@RequestMapping("/example")
public class ExampleController {
	
	@Autowired
	private IExampleService service;

	/*
	 * Success: 201
	 * Error Valid Model: 400
	 * Error DB: 409
	 */
	@PostMapping
	public String create(@RequestBody Example model){
		return service.create(model);
	}
	
	/*
	 * Success: 200
	 * Error DB: 404
	 */
	@GetMapping
	public String list(){
		return service.list();
	}
	
	/*
	 * Success: 200
	 * Error DB: 404
	 */
	@GetMapping("/{id}")
	public String detail(@PathVariable long id){
		return service.detail(id);
	}
	
	/*
	 * Success: 200
	 * Error DB: 404
	 */
	@GetMapping("/search")
	public String search(@RequestBody List<Example> list){
		return service.search(list);
	}
	
	/*
	 * Success: 204
	 * Error Valid Model: 400
	 * Error DB: 409
	 */
	@PutMapping
	public String edit(@RequestBody Example model){
		return service.edit(model);
	}
	
	/*
	 * Success: 204
	 * Error DB: 409
	 */
	@PatchMapping
	public String state(@RequestBody Example model){
		return service.state(model);
	}
	
	/*
	 * Success: 204
	 * Error DB: 404
	 */
	@DeleteMapping()
	public String delete(@RequestBody List<Example> list){
		return service.delete(list);
	}
}
