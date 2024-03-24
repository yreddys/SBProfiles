package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.entity.book.Book;
import com.employee.model.EmployeeRequest;
import com.employee.model.EmployeeResponse;
import com.employee.repository.EmployeeRepository;
import com.employee.repository.book.BookRepository;

@Service
//@Profile(value = { "local", "dev", "prod" })
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private BookRepository bookRepository;

	@Override
	public EmployeeResponse saveEmployee(EmployeeRequest employeeRequest) {
		Employee emp = new Employee();
		emp.setEmployeeName(employeeRequest.getEmployeeName());
		emp.setEmployeeAge(employeeRequest.getEmployeeAge());
		emp = employeeRepository.save(emp);
		EmployeeResponse eResponse = new EmployeeResponse();
		eResponse.setEmployeeAge(emp.getEmployeeAge());
		eResponse.setEmployeeId(emp.getEmployeeId());
		eResponse.setEmployeeName(emp.getEmployeeName());
		return eResponse;
	}

	@Override
	public Book createBook(Book book) {

		return bookRepository.save(book);
	}
}
