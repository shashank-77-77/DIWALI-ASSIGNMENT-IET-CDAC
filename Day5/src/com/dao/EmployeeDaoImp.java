package com.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.beans.Employee;

public class EmployeeDaoImp implements EmployeeDao {
	static List<Employee> list= new ArrayList<>();
    
	static {
        list.add(new Employee(101, "Siddharth", "Developer"));
        list.add(new Employee(104, "Raj", "Tester"));
        list.add(new Employee(105, "Sneha", "Manager"));
        list.add(new Employee(102, "Amit", "HR"));
        list.add(new Employee(103, "Priya", "Designer"));
    }

	
	@Override
	public void addEmployee(Employee emp) {
		
		
		list.add(emp);
		
	}

	@Override
	public boolean removeEmployee(int id) {
		return list.removeIf(e -> e.getEmpID() == id);
		
	}

	@Override
	public List<Employee> DisplayAllEmp() {
	
		return new ArrayList<>(list);
	}

	@Override
	  public List<Employee> getSortedEmployees() {
        List<Employee> sorted = new ArrayList<>(list);
        Collections.sort(sorted);
        return sorted;
    }

	@Override
    public Employee findByName(String name) {
        for (Employee e : list) {
            if (e.getEmpName().equalsIgnoreCase(name))
                return e;
        }
        return null;
    }

	@Override
	  public List<Employee> getAllEmployees() {
        return list;
    }
}
