package com.mrd;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.mrd.controller.PayrollOperationsController;
import com.mrd.model.Employee;

@SpringBootApplication
public class MainClass {

	public static void main(String[] args) {
		//get access to IOCContainer
		ApplicationContext ctx = SpringApplication.run(MainClass.class, args);
		
		//controller class obj reference
		PayrollOperationsController controller = ctx.getBean("empController",PayrollOperationsController.class);
		
		//read inputs from enduser
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee desg1 :: ");
		String desg1 = sc.next();
		System.out.println("Enter employee desg2 :: ");
		String desg2 = sc.next();
		System.out.println("Enter employee desg3 :: ");
		String desg3 = sc.next();
		
		//invoke b.method
		try {
			
			List<Employee> list = controller.fetchEmployeesByDesgs(desg1, desg2, desg3);
			
			list.forEach(emp ->{
				System.out.println(emp);
			});
		}catch(Exception e) {
			System.out.println("Internal Problem try again .....");
			e.printStackTrace();
		}
		
		//close the IOC Container
		((ConfigurableApplicationContext) ctx).close();
	}

}
