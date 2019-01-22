package com.AAA.BBB.PracticeSSSSSS;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/")
public class ControllerClass {

	@Autowired
	EmployeeDAO employeeDAO;

	@RequestMapping(value = "/hello")

	public String demo() {
		return "hello java";
	}
//post method
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp)

	{
		return employeeDAO.save(emp);
	}

	@GetMapping("/employees")

	public List<Employee> getAllEmployees()

	{

		return employeeDAO.findAll();

	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmpByID(@PathVariable("id") Long empID)

	{
		Employee emp = employeeDAO.getOne(empID);

		if (emp == null) {
			ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(emp);

	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long empID,
			@Valid @RequestBody Employee empDetails)

	{
		Employee emp = employeeDAO.getOne(empID);

		if (emp == null) {
			ResponseEntity.notFound().build();
		} else {

			emp.setName(empDetails.getName());

		}
		Employee updateEmployee = employeeDAO.save(emp);

		return ResponseEntity.ok().body(updateEmployee);
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmp(@PathVariable("id") Long empID)

	{
		Employee emp = employeeDAO.getOne(empID);

		if (emp == null) {
			ResponseEntity.notFound().build();
		} else {

			employeeDAO.delete(emp);
		}
		return ResponseEntity.ok().build();

	}

}
