package com.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {
@Id
@GeneratedValue
private int employeeId;
private String employeeName;
private int employeeAge;

}
