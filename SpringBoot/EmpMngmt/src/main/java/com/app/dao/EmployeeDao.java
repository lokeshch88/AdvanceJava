package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long>{
	// derived finder method
	List<Employee> findByAssignedDeptId(Long deptId); //find emps by dept id(assignedDept : fk in emps table) i.e pojo proprty 

	Employee findByEmailAndPassword(String email1, String password1);
    
}
