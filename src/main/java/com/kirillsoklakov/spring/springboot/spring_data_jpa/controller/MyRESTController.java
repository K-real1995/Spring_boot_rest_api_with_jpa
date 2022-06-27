package com.kirillsoklakov.spring.springboot.spring_data_jpa.controller;

import com.kirillsoklakov.spring.springboot.spring_data_jpa.entity.Employee;
import com.kirillsoklakov.spring.springboot.spring_data_jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> ShowAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);

    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        if (employee != null){
            employeeService.deleteEmployee(id);
            return "Employee with ID = " + id + " was deleted";
        }
        else {
            return "There is no employee with id = " + id + " in database";
        }

    }
    @GetMapping("/employees/name/{name}")
    public List<Employee> showAllEmployeeByName(@PathVariable String name){
        return employeeService.findAllByName(name);
    }
}
