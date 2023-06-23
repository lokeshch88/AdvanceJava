package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Employee;

public interface EmployeeService {
	
	
	//add a method to get list of emps, by dept id
	List<Employee> getAllEmpsByDeptId(Long deptId);

	Employee authenticateEmp(String email, String password);

}
