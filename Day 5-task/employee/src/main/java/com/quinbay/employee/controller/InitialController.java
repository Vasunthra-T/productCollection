package com.quinbay.employee.controller;

import com.quinbay.employee.model.Employee;
import com.quinbay.employee.service.EmployeeDetails;
import com.quinbay.employee.web.WebClientAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class InitialController {
    @Autowired
    WebClientAPI webClientAPI;
    @Autowired
    EmployeeDetails employee;

    @GetMapping("/employee/{employeeId}")
    public String getRating(@PathVariable int employeeId){
        return webClientAPI.getRating(employeeId);
    }

    @PostMapping("/addEmployee")
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee inputEmployee){
        return employee.addEmployee(inputEmployee);
    }

}
