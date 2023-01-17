package com.quinbay.employee.service;

import com.quinbay.employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class EmployeeDetails {
    public static ArrayList<Employee> employee= new ArrayList<>();
    public Employee addEmployee(Employee inputEmployee){
        employee.add(inputEmployee);
        return inputEmployee;
    }
//    public ArrayList<Employee> addEmployee(ArrayList<Employee> inputEmployee) {
//        for (Employee emp : inputEmployee) {
//            employee.add(emp);
//        }
//        return employee;
//    }

//    public String addEmployee(ArrayList<Employee> inputEmployee) {
//        for (Employee input : inputEmployee) {
//            int flag = 0;
//            for (Employee pr : employee) {
//                if (input.getId() == pr.getId()) {
//                    flag = 1;
//                }
//            }
//            if (flag == 0) {
//                Employee newEmployee = new Employee(input.getId(), input.getName(), input.getSalary(), input.getRating());
//                employee.add(newEmployee);
//            }
//        }
//        String str = "";
//        for (Employee p : employee) {
//            str += p.getId() + " " + p.getName() + " " + p.getSalary() + " " + p.getRating() + "\n";
//        }
//        return str;
//    }


}
