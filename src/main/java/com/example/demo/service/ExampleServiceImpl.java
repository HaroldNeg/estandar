package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Example;
import com.example.demo.repository.ExampleRepository;
import com.google.gson.Gson;

@Service
@Transactional
public class ExampleServiceImpl implements IExampleService{

	@Autowired
	private ExampleRepository repository;
	
	@Override
	public String create(Example model) {
		//logica de negocio
		String json = null;
		try {
			repository.save(model);
			json = new Gson().toJson("mensaje OK");
		} catch (Exception e) {
			json = new Gson().toJson("mensaje Error");
		}
		return "[" + json + "]";
	}

	@Override
	public String list() {
		//logica de negocio
		String json = null, json2 = null;
		try {
			json2 = new Gson().toJson(repository.findAll());
			json = new Gson().toJson("mensaje OK");
		} catch (Exception e) {
			json2 = new Gson().toJson("");
			json = new Gson().toJson("mensaje Error");
		}
		return "{" + json +","+ json2 +"}";
	}
	
	public String detail(long id) {
		String json = null, json2 = null;
		try {
			json2 = new Gson().toJson(repository.findById(id).orElse(null));
			json = new Gson().toJson("mensaje OK");
		} catch (Exception e) {
			json2 = new Gson().toJson("");
			json = new Gson().toJson("mensaje Error");
		}
		return "{" + json +","+ json2 +"}";
	}

	@Override
	public String search(List<Example> list) {
		String json = null, json2 = null;
		try {
			List<Example> result = new ArrayList<>();
			for (Example example : list) {
				result.add(repository.findById(example.getId()).orElse(null));
			}
			json2 = new Gson().toJson(result);
			json = new Gson().toJson("mensaje OK");
		} catch (Exception e) {
			json2 = new Gson().toJson("");
			json = new Gson().toJson("mensaje Error");
		}
		return "{" + json +","+ json2 +"}";
	}

	@Override
	public String edit(Example model) {
		String json = null;
		try {
			repository.save(model);
			json = new Gson().toJson("mensaje OK");
		} catch (Exception e) {
			json = new Gson().toJson("mensaje Error");
		}
		return "{" + json + "}";
	}

	@Override
	public String state(Example model) {
		String json = null;
		try {
			repository.save(model);
			json = new Gson().toJson("mensaje OK");
		} catch (Exception e) {
			json = new Gson().toJson("mensaje Error");
		}
		return "{" + json + "}";
	}

	@Override
	public String delete(List<Example> list) {
		String json = null;
		try {
			for (Example example : list) {
				repository.deleteById(example.getId());
			}
			json = new Gson().toJson("mensaje OK");
		} catch (Exception e) {
			json = new Gson().toJson("mensaje Error");
		}
		return "{" + json +"}";
	}

}
