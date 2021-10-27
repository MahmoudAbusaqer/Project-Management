package com.learn.pma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.learn.pma.dao.EmployeeRepository;

@Service
public class EmployeeService {
	//Field Injection
//	@Qualifier("staffRepositoryImpl1")
//	@Autowired
	IStaffRepository empRepo;

	//Constructor Injection
//	public EmployeeService(@Qualifier("staffRepositoryImpl1") IStaffRepository empRepo) {
//		super();
//		this.empRepo = empRepo;
//	}

	//Setter Injection
//	@Autowired
//	@Qualifier("staffRepositoryImpl1")
//	public void setEmpRepo(IStaffRepository empRepo) {
//		this.empRepo = empRepo;
//	}
	
	
	
	
//	//Field Injection
////	@Autowired
//	EmployeeRepository empRepo;
//
//	//Constructor Injection
//	public EmployeeService(EmployeeRepository empRepo) {
//		super();
//		this.empRepo = empRepo;
//	}
//
//	//Setter Injection
////	@Autowired
////	public void setEmpRepo(EmployeeRepository empRepo) {
////		this.empRepo = empRepo;
////	}
//	
	
}
