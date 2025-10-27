package com.project.Employee.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "EmployeeDetail")
public class Employee
{
    @Id
    private String id;
    private String Name;
    private String Department;
    private double Salary;

    public Employee()
    {

    }

    public Employee(String name,String department,double salary)
    {
        this.Name = name;
        this.Department = department;
        this.Salary = salary;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        id = id;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        Name = name;
    }

    public String getDepartment()
    {
        return Department;
    }

    public void setDepartment(String department)
    {
        Department = department;
    }

    public double getSalary()
    {
        return Salary;
    }

    public void setSalary(double salary)

    {
        Salary = salary;
    }
}
