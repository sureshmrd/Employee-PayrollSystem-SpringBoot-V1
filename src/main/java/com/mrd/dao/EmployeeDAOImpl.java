//DAO Impl Class

package com.mrd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrd.model.Employee;

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO {
	
	private static final String GET_EMPS_BY_DESGS = "SELECT EMPNO,ENAME,JOB,SALARY,DEPTNO FROM EMP WHERE UPPER(JOB) IN(?,?,?) ORDER BY JOB";
	
	@Autowired
	private DataSource ds;

	@Override
	public List<Employee> getEmployeesByDesgs(String desg1, String desg2, String desg3) throws Exception {
		
		List<Employee> list= null;
		
		try( //getting pooled jdbc con object
			Connection con = ds.getConnection();
				
			PreparedStatement ps = con.prepareStatement(GET_EMPS_BY_DESGS);
			){
			
			//set values to QUERY parameters
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			
			//execute the QUERY
			try(ResultSet rs = ps.executeQuery();){
				//process the ResultSet Object and store them in List
				list = new ArrayList<>();
				while(rs.next()) {
					//copy each record of ResultSet obj to Java Bean Class Obj(Model Class Obj)
					Employee emp = new Employee();
					emp.setEmpno(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setJob(rs.getString(3));
					emp.setSalary(rs.getDouble(4));
					emp.setDeptno(rs.getInt(5));
					
					//add Emp Obj to List
					list.add(emp);
				}//while
			}//try2
			
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}

}
