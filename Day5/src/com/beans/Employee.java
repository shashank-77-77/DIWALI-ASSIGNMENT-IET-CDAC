package com.beans;

import java.io.Serializable;

public class Employee implements Serializable, Comparable<Employee>{
    private int empID;
    private String empName;
    private String empRole;

    public Employee() {
        this.empID = 0;
        this.empName = "Unknown";
        this.empRole = "Not Assigned";
    }

    public Employee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.empRole = "Employee";
    }

    public Employee(int empID, String empName, String role) {
        this.empID = empID;
        this.empName = empName;
        this.empRole = role;
    }

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}
   
	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empName=" + empName + ", empRole=" + empRole + "]";
	}
	@Override
    public int compareTo(Employee other) {
        return Integer.compare(this.empID, other.empID);
    }
}
