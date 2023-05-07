package com.myprojects.springboot.rest;

import com.myprojects.springboot.dao.EmployeeDAO;
import com.myprojects.springboot.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    EmployeeDAO employeeDAO;

    public EmployeeRestController(EmployeeDAO theEmployeeDAO){
        this.employeeDAO=theEmployeeDAO;
    }
    @GetMapping("/employee")
    public List<Employee> findAdd(){
        return employeeDAO.findAll();
    }
}
