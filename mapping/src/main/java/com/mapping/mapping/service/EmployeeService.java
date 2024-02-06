package com.mapping.mapping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.mapping.mapping.entity.Employee;
import com.mapping.mapping.entity.Project;
import com.mapping.mapping.repository.EmployeeRepository;
import com.mapping.mapping.repository.ProjectRepository;
import java.util.*;
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ProjectRepository projectRepository;
	
	public void addEmployee() {
		Employee employee = new Employee();
        employee.setFirstName("Ramesh");
        employee.setLastName("Fadatare");
        Project project = new Project();
        project.setTitle("Employee Management System");

        // Create project2
        Project project1 = new Project();
       project1.setTitle("Content Management System");
       
       employee.getProjects().add(project);
       employee.getProjects().add(project1);

       // Add employee reference in the projects
//       project.getEmployees().add(employee);
//       project1.getEmployees().add(employee);

       // Use save method to persist both entities
       employeeRepository.save(employee);
//       projectRepository.saveAll(Set.of(project, project1));
       
	}
	 
	    public List<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	   }

		public void addEmployeeByPostMan(Employee employee) {
			
			 employeeRepository.save(employee);
		}

		public Employee getEmployees(String name) {
			return employeeRepository.findByFirstNameContaining(name);
		}

		public void deleteEmployee(Long empId) {
			employeeRepository.deleteById(empId);
			
		}

		public void assignProjectToEmployee(Long empId, Employee employee) {
		
			Employee employee1 = employeeRepository.findById(empId).get();
			employee1.setProjects(employee.getProjects());
			employeeRepository.save(employee1);
			
		}
		
		
}
