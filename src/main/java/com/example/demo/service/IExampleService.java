package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Example;

public interface IExampleService {

	public abstract String create(Example model);
	
	public abstract String list();
	
	public abstract String detail(long id);
	
	public abstract String search(List<Example> list);
	
	public abstract String edit(Example model);
	
	public abstract String state(Example model);
	
	public abstract String delete(List<Example> list);
}
