package com.project.Employee.Repository;

import com.project.Employee.Model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface employeerepository extends MongoRepository<Employee,String>
{

}
