package com.employee.service;

import com.employee.model.EmployeeRequest;
import com.employee.model.EmployeeResponse;

public interface EmployeeService {

	EmployeeResponse saveEmployee(EmployeeRequest employeeRequest);

}
