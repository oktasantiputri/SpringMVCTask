package com.maybank.trialokta.demoapp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.maybank.trialokta.demoapp.entity.Employee;
import com.maybank.trialokta.demoapp.repository.EmployeeRepository;

@Service
public class EmployeeService 
{
	 @Autowired
	    private EmployeeRepository employeeRepository;

	    public List<Employee> listAllEmp()
	    {
	    	return employeeRepository.findAll();
	    }
	    
	    public void save(Employee employee)
	    {
	    	employeeRepository.save(employee);
	    }
	    
	    public Employee get(Long id)
	    {
	    	return employeeRepository.findById(id).orElse(null);
	    }
	    
	    public String delete(Long id)
	    {
	    	employeeRepository.deleteById(id);
	    	return "Deleted Successfully";
	    }
	    

}
