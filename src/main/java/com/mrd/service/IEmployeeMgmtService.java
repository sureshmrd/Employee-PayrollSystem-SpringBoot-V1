//Service Interface

package com.mrd.service;

import java.util.List;

import com.mrd.model.Employee;

public interface IEmployeeMgmtService {
	public List<Employee> showEmployeesByDesgs(String desg1,String desg2,String desg3) throws Exception;
}
