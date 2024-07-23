package com.app.mod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {

	@Autowired
	Dao dao;

	@Autowired
	ModelAndView mv;

	@RequestMapping("/add_emp")
	public ModelAndView getEmployee()
	{
		mv.addObject("employee", new Emp());
		mv.setViewName("create_emp.jsp");
		return mv;
	}

	@RequestMapping("/save")
	public String saveEmployee(@ModelAttribute Emp employee)
	{
		dao.saveEmployee(employee);
		return "employee details added ";
	}

	@RequestMapping("/search_emp")
	public ModelAndView searchEmployee()
	{
		mv.addObject("employee", new Emp());
		mv.setViewName("get_emp.jsp");
		return mv;
	}

	@RequestMapping("view")
	public ModelAndView findEmp(@ModelAttribute Emp employee)
	{
		mv.addObject("employee", dao.getEmployeeById(employee.getId()));
		mv.setViewName("display_emp.jsp");
		return mv;
	}

	@RequestMapping("/update_emp")
	public ModelAndView updateEmployee() {
		mv.addObject("employee", new Emp());
		mv.setViewName("update_emp.jsp");
		return mv;
	}

	@RequestMapping("/edit")
	public String updateEmployee(@ModelAttribute Emp employee) {
		dao.updateEmployee(employee);
		return "Employee details updated";
	}

	@RequestMapping("/delete_emp")
	public ModelAndView deleteEmployee() {
		mv.addObject("employee",new Emp());
		mv.setViewName("delete_emp.jsp");
		return mv;
	}

	@RequestMapping("/delete")
	public String deleteEmployee(@ModelAttribute Emp employee) {
		dao.deleteEmployee(employee.getId());
		return "Employee details deleted";
	}

	@RequestMapping("/get_all")
	public ModelAndView getAllStudents() {
		mv.addObject("employee",dao.getAllEmployee());
		mv.setViewName("display_all.jsp");
		return mv;
	}
}