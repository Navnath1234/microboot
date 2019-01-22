package com.AAA.BBB.PracticeSSSSSS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDAO {

	@Autowired
	EmployeeRepository employeeRepository;

	public Employee save(Employee emp) {

		return employeeRepository.save(emp);

	}

	public List<Employee> findAll() {

		return employeeRepository.findAll();
	}

	public void delete(Employee emp)

	{

		employeeRepository.delete(emp);
	}

	public Employee getOne(Long empID) {

		return employeeRepository.getOne(empID);
	}

}
