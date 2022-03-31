package com.maybank.trialokta.demoapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.maybank.trialokta.demoapp.entity.Employee;
import com.maybank.trialokta.demoapp.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController
{
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/")
	public String viewEmployeePage(Model model)
	{
		List<Employee> listEmployee = employeeService.listAllEmp();
		model.addAttribute("listEmployee", listEmployee);
		return"employeeform";
	}
	
	@RequestMapping("/addEmployee")
	public String addEmployee(Model model)
	{
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return"addEmployee";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee)
	{
		employeeService.save(employee);
		return "redirect:/employee/";
	}
	
	@RequestMapping("/edit/{id}")
	public String editEmployee(Model model, @PathVariable Long id)
	{
//		ModelAndView mavEmp = new ModelAndView("editEmployee");
		
		Employee employee = employeeService.get(id);
		model.addAttribute("employee",employee);
		return "editEmployee";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Long id)
	{
		employeeService.delete(id);
		return "redirect:/employee/";
	}
	

}
