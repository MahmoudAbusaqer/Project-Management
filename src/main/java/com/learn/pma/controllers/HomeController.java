package com.learn.pma.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.pma.dao.EmployeeRepository;
import com.learn.pma.dao.ProjectRepository;
import com.learn.pma.dto.ChartData;
import com.learn.pma.dto.EmployeeProject;
import com.learn.pma.entities.Employee;
import com.learn.pma.entities.Project;
import com.learn.pma.springExample.Car;

@Controller
public class HomeController {

	@Value("${version}")
	private String ver;
	
	@Autowired
	Car car;
	@Autowired
	ProjectRepository proRepo;
	@Autowired
	EmployeeRepository empRepo;

	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
//		Map<String, Object> map = new HashMap<>();
		model.addAttribute("versionNumber", ver);
		// get the records from database form the project table
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectsList", projects);

		List<ChartData> projectData = proRepo.getProjectStatus();
		// convert projectData object into a json structure for use in javascript
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		model.addAttribute("projectsStatusCnt", jsonString);

		// get the records from database form the employee table
//		List<Employee> employees = empRepo.findAll();
//		model.addAttribute("employeesList", employees);

		// get the records from database form the PROJECT_EMPLOYEE table
		List<EmployeeProject> employeeProjectCnt = empRepo.employeeProjects();
		model.addAttribute("employeeListProjectCnt", employeeProjectCnt);
		return "main/home";
	}
}
