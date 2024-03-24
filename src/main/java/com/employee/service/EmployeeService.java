package com.employee.service;


import com.employee.entity.book.Book;
import com.employee.model.EmployeeRequest;
import com.employee.model.EmployeeResponse;

public interface EmployeeService {

	EmployeeResponse saveEmployee(EmployeeRequest employeeRequest);

	Book createBook(Book book);

}
