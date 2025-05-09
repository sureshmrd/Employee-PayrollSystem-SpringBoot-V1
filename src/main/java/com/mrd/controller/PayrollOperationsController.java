//Controller

package com.mrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mrd.model.Employee;
import com.mrd.service.IEmployeeMgmtService;

@Controller("empController")
public class PayrollOperationsController {
	
	@Autowired
	private IEmployeeMgmtService empService;
	
	public List<Employee> fetchEmployeesByDesgs(String desg1,String desg2,String desg3) throws Exception{
		//user service
		List<Employee> list = empService.showEmployeesByDesgs(desg1, desg2, desg3);
		return list;
	}

}
