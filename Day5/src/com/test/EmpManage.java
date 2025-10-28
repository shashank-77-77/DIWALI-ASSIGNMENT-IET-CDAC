package com.test;


import java.util.List;
import java.util.Scanner;

import com.beans.Employee;
import com.eservice.EmployeeService;
import com.eservice.EmployeeServiceImp;

public class EmpManage {

	public static void main(String[] args) {
	
        Scanner sc = new Scanner(System.in);
        
        EmployeeService eservice= new EmployeeServiceImp();
        
        
        
        
        while(true) {
        System.out.println("Choice list: \n1. Add Employee to list\n2. Remove Employee list\n3. Show all Employee\r\n4. Show all Employee in sorted order by id\r\n5. Find a Employee with empName\r\n6. Save all Employees into file\r\n7. Quit		");
		System.out.println("Enter the choice as per abow list: ");
		int choice = sc.nextInt();
		switch(choice) {
		case 1->{
			 System.out.print("Enter Employee ID: ");
             int id = sc.nextInt();
             System.out.print("Enter Employee Name: ");
             String name = sc.next();
             System.out.print("Do you want to enter role? (y/n): ");
             String ch = sc.next();
             Employee emp;
             if (ch.equalsIgnoreCase("y")) {
                 System.out.print("Enter Role: ");
                 String role = sc.next();
                 emp = new Employee(id, name, role);
             } else {
                 emp = new Employee(id, name);
             }
             eservice.addEmployee(emp);
             System.out.println("Employee added.");
		}
		case 2->{
			System.out.println("Enter the employee id which you want to delete: ");
			int id=sc.nextInt();
			boolean status =eservice.removeEmployeeById(id);
			if(status) {
				System.out.println("Deleted successfully");
			}else {
				System.out.println("Having trouble while deleting employee ");
			}
		}
		case 3->{
			List<Employee> Data=eservice.DisplayAllEmployee();
			Data.forEach(System.out::println);
		}
		 case 4 -> {
             List<Employee> sorted = eservice.getSortedEmployees();
             System.out.println("Sorted Employees:");
             sorted.forEach(System.out::println);
         }

         case 5 -> {
             System.out.print("Enter Employee Name to find: ");
             String name = sc.next();
             Employee e = eservice.findByName(name);
             if (e != null) System.out.println(" Found: " + e);
             else System.out.println("Employee not found.");
         }

         case 6 -> {
             eservice.saveEmployeesToFile();
         }

         case 7 -> {
             System.out.println("Exiting Employee Management System. Goodbye");
             sc.close();
             System.exit(0);
         }

         default -> System.out.println("Invalid choice Try again.");
     }
		
		}
        }
		
	}


