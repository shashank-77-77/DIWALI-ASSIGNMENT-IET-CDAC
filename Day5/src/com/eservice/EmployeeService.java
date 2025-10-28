package com.eservice;
import com.beans.Employee;
import java.util.List;


public interface EmployeeService {

	void addEmployee(Employee emp);


	boolean removeEmployeeById(int id);


	List<Employee> DisplayAllEmployee();


	List<Employee> getSortedEmployees();


	Employee findByName(String name);


	void saveEmployeesToFile();
 
}
