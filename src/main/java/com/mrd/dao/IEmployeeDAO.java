//DAO Interface

package com.mrd.dao;

import java.util.List;

import com.mrd.model.Employee;

public interface IEmployeeDAO {
	
	public List<Employee> getEmployeesByDesgs(String desg1,String desg2,String desg3) throws Exception;

}
