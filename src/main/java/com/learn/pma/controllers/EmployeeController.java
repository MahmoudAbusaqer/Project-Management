package com.learn.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learn.pma.dao.EmployeeRepository;
import com.learn.pma.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping
	public String displayProjects(Model model) {
		List<Employee> employees =  empRepo.findAll();
		model.addAttribute("employeesList", employees);
		return "employees/list-employees";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Employee anEmployee = new Employee();
		model.addAttribute("employee", anEmployee);
		return "employees/new-employee";
	}

	@PostMapping("/save")
	public String createProject(Employee employee, Model model) {
		empRepo.save(employee);
		//this redirect is to prevent duplicate submissions
		return "redirect:/employees/new";
	}
}
