package com.eservice;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.beans.Employee;
import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImp;

public class EmployeeServiceImp implements EmployeeService {
	EmployeeDao edao= new EmployeeDaoImp();
	@Override
	public void addEmployee(Employee emp) {
		edao.addEmployee(emp);
	}

	@Override
	public boolean removeEmployeeById(int id) {
		return edao.removeEmployee(id);
		
	}

	@Override
	public List<Employee> DisplayAllEmployee() {
		return edao.DisplayAllEmp();
		
		
	}

	@Override
	public List<Employee> getSortedEmployees() {

		return edao.getSortedEmployees();
	}

	@Override
	public Employee findByName(String name) {
	
		return edao.findByName(name);
	}

	@Override
	public void saveEmployeesToFile() {
		 try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("TestFile.txt"))) {
	            oos.writeObject(edao.getAllEmployees());
	            System.out.println(" Employees saved successfully into file employees.dat");
	        } catch (Exception e) {
	            System.out.println(" Error saving file: " + e.getMessage());
	        }
		
	}


}
