package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.book.Book;
import com.employee.model.EmployeeRequest;
import com.employee.model.EmployeeResponse;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest employeeRequest) {
		EmployeeResponse response = employeeService.saveEmployee(employeeRequest);

		return new ResponseEntity<>(response, HttpStatus.CREATED);

	}

	@PostMapping("/book")
	Book createBook(@RequestBody Book book) {
		return employeeService.createBook(book);

	}
}
