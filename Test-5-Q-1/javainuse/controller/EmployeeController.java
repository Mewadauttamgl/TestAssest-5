package com.javainuse.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.model.Employee;
import com.javainuse.repository.EmpRepo;

@RestController
public class EmployeeController {

	@Autowired
	private EmpRepo repo;

	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> firstPage() {
		return repo.findAll();
	}

	@PostMapping(path = "/employees", produces = "application/json")
	public Employee create(@RequestBody Employee employee) {
		return repo.save(employee);
	}

	@DeleteMapping("/employees/{id}")
	public void delete(@PathVariable("id") int id) {
		repo.deleteById(id);
	}

	@GetMapping("/employees/{id}")
	public Optional<Employee> getData(@PathVariable("id") int id) {
		Optional<Employee> emp = repo.findById(id);
		return emp;
	}

	@PutMapping("/employee/{id}")
	public Employee update(@PathVariable("id") int id, @RequestBody Employee employee) {
		Optional<Employee> emp = repo.findById(id);
		return repo.save(employee);
	}
}
