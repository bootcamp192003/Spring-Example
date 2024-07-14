package com.laserants.spring_api.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laserants.spring_api.models.EmployeeModel;
import com.laserants.spring_api.repositories.IEmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	IEmployeeRepository employeeRepository;
	
	public ArrayList<EmployeeModel> getEmployees(){
		return (ArrayList<EmployeeModel>) employeeRepository.findAll();
	}
	
	public EmployeeModel saveEmployee(EmployeeModel employee) {
		// validaciones extra o logica va aca
		return employeeRepository.save(employee);
	}
	
	public Optional<EmployeeModel> getByid(Integer id){
		return employeeRepository.findById(id);
	}
	
	public EmployeeModel updateById(EmployeeModel request, Integer id) {
		EmployeeModel employee = employeeRepository.findById(id).get();
		
		employee.setName(request.getName());
		employee.setEmail(request.getEmail());
		
		return employeeRepository.save(employee);
	}
	
	public Boolean deleteEmployee(Integer id) {
		try {
			employeeRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
