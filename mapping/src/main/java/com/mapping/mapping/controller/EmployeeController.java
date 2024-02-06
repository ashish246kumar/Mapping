package com.mapping.mapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.mapping.entity.Employee;
import com.mapping.mapping.entity.Project;
import com.mapping.mapping.repository.EmployeeRepository;
import com.mapping.mapping.repository.ProjectRepository;
import com.mapping.mapping.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private EmployeeRepository  employeeRepository; 
	
	@PostMapping("/add")
	public void addEmployee() {
		employeeService.addEmployee();
	}
	
	@PostMapping("/addByPostMan")
	public void addEmployeeByPostMan(@RequestBody Employee employee) {
		employeeService.addEmployeeByPostMan(employee);
	}
	
	@GetMapping("/get")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
	@GetMapping("/find/{name}")
    public Employee getEmployeeByName(@PathVariable String name) {
        return employeeService.getEmployees(name);
		
    }
	@GetMapping("/get/{id}")
	public Project findByProjectId(@PathVariable String id) {
		return projectRepository.findById(Long.parseLong(id)).get();
	}
	
	
	@PutMapping("/update/{empId}")
    public void assignProjectToEmployee(
            @PathVariable Long empId,
            @RequestBody Employee employee
    ){
        employeeService.assignProjectToEmployee(empId, employee);
    }
	
	 @DeleteMapping("/delete/{empId}")
	    public void removeEmployee(@PathVariable Long empId){
	        employeeService.deleteEmployee(empId);
	        
	    }
}
