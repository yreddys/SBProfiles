package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.model.EmployeeRequest;
import com.employee.model.EmployeeResponse;
import com.employee.repository.EmployeeRepository;

@Service
@Profile(value = { "local", "dev", "prod" })
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

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
}
