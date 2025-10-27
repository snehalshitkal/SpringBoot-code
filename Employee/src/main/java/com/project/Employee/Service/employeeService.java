package com.project.Employee.Service;

import com.project.Employee.Model.Employee;
import com.project.Employee.Repository.employeerepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class employeeService
{
    private final employeerepository repo;

    public employeeService(employeerepository repo)
    {
        this.repo = repo;
    }

    public List<Employee> getAllEmployee()
    {
        return repo.findAll();
    }

    public Optional<Employee> getEmployeeById(String id)
    {
        return repo.findById(id);
    }

    public Employee saveEmployee(Employee employee)
    {
        return repo.save(employee);
    }

    public void deleteEmployee(String id)
    {
        repo.deleteById(id);
    }

}
