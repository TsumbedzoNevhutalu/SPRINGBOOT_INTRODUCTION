package com.employees.employee.system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employees.employee.system.models.Employee;
import com.employees.employee.system.repo.EmployeeRepo;

import io.micrometer.common.lang.NonNull;

//add rest since we calling this library to use in application
@RestController
@RequestMapping(value="/employees")//specify end point what u want to display

public class EmployeeController {
    //call the repo to connect the model and the controller
    @Autowired 
    private EmployeeRepo employeeRepo;


    //request a method  with all information including objects
    @GetMapping 
    public List<Employee> getEmployees()  {
        //call the model employee//
        return  employeeRepo.findAll(); //getting data from employee repo
    
}
//get employee calling by calling an employee specifically by id
@GetMapping(value="/{id}")
public Optional<Employee> findOne(Employee employee){
    return employeeRepo.findById(employee.getEmpId());


}


@PostMapping
//creating employee data and a body to request data. the method must return data from the input
public Employee save(@Validated @NonNull @RequestBody Employee employee){
    return employeeRepo.save(employee); //return data from the employee repo

}

//to update
@PutMapping("{empId}")
public Employee update(@Validated @NonNull @RequestBody Employee employee){
    return employeeRepo.save(employee);
}

}

