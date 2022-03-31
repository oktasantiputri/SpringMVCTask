package com.maybank.trialokta.demoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maybank.trialokta.demoapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{


}
