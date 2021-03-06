package com.learn.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.learn.pma.dto.EmployeeProject;
import com.learn.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	@Override
	public List<Employee> findAll();
	
	@Query(nativeQuery=true, value="select e.first_name as firstName, e.last_name as lastName, COUNT(pe.employee_id) as projectCount "
			+ "from employee e left join project_employee pe ON pe.employee_id = e.employee_id "
			+ "group by e.first_name, e.last_name order by 3 desc")
	public List<EmployeeProject> employeeProjects();
}
