//Service Impl Class

package com.mrd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrd.dao.IEmployeeDAO;
import com.mrd.model.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	@Autowired
	public IEmployeeDAO empDao;//Interface Type HAS-A Property :: DAO

	@Override
	public List<Employee> showEmployeesByDesgs(String desg1, String desg2, String desg3) throws Exception {
		
		//convert designations to uppercase
		desg1 = desg1.toUpperCase();
		desg2 = desg2.toUpperCase();
		desg3 = desg3.toUpperCase();
		
		//use service
		List<Employee> list = empDao.getEmployeesByDesgs(desg1, desg2, desg3);
		
		//process the list collection
		list.forEach(emp ->{
			//calculates emps gross and net salary
			emp.setGrossSalary(emp.getSalary() + (emp.getSalary() * 0.4)); // 40% hike
			emp.setNetSalary(emp.getGrossSalary() - (emp.getGrossSalary() * 0.2)); // 20% deducted from gross salary == net salary
		});
		
		return list;
	}

}
