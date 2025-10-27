package com.project.Employee.Controller;
import com.project.Employee.Model.Employee;
import com.project.Employee.Service.employeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/EmployeeDetail")
public class EmployeeController
{
    private final employeeService service;

    public EmployeeController(employeeService service)
    {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAll()
    {
        return  service.getAllEmployee();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable String id)
    {
        return  service.getEmployeeById(id)
                .map(ResponseEntity :: ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public  Employee create(@RequestBody Employee employee)
    {
        return service.saveEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id)
    {
        service.deleteEmployee(id);
        return  ResponseEntity.noContent().build();
    }

}
