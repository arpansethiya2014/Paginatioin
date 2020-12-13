package com.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.bean.*;
import com.dao.EmployeeDAO;

@Controller
public class TestController {
	
	@Autowired
	EmployeeDAO mydao;

	
	// search All
	@RequestMapping(value = "/SearchAll")
	public ModelAndView searchAll() {
		ModelAndView m = new ModelAndView("searchAlll");
		List<Employee> mylist = mydao.getEmployee();
		m.addObject("mylist", mylist);
		return m;
	}

	// pagination
	@RequestMapping(value = "/pagination/{pageid}")
	public ModelAndView paginationMethod(@PathVariable int pageid) {
		int total = 5;
		if (pageid == 1) {
		} else {
			pageid = (pageid - 1) * total + 1;
		}
		List<Employee> mylist = mydao.getEmployeesByPage(pageid, total);
		ModelAndView m = new ModelAndView("pagination", "mylist", mylist);
		return m;
	}

	
	@RequestMapping(value = "/pagination/first")
	public ModelAndView firstData() {
		//List<Employee> mylist = mydao.getEmployeeById(1);
		List<Employee> mylist = mydao.getEmployeeFirst();
		ModelAndView m = new ModelAndView("pagination", "mylist", mylist);
		return m;
	}
	
	@RequestMapping(value = "/pagination/last")
	public ModelAndView lastData() {
		//int id = mydao.getMaxId();
		//System.out.println(" Id : " + id);
		//List<Employee> mylist = mydao.getEmployeeById(id);
		List<Employee> mylist = mydao.getEmployeeLast();
		ModelAndView m = new ModelAndView("pagination", "mylist", mylist);
		return m;
	}
}
