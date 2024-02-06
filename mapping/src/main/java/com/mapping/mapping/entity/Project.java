package com.mapping.mapping.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class Project {

	@Id
    @Column(name = "project_id")
    @GeneratedValue
    private Long projectId;

    public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(Long projectId, String title, Set<Employee> employees) {
		super();
		this.projectId = projectId;
		this.title = title;
		this.employees = employees;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "projects")
//    @JsonBackReference
    @JsonIgnore
    private Set<Employee> employees = new HashSet<Employee>();
    
}
