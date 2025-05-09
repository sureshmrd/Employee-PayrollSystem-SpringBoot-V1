//Employee.java (Java Bean)

package com.mrd.model;

import lombok.Data;

@Data
public class Employee {
	
	private Integer empno;
	private String ename;
	private String job;
	private Double salary;
	private Integer deptno;
	
	private Double grossSalary;
	private Double netSalary;

}
