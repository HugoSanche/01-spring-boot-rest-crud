package com.myprojects.springboot.demo.rest;

import com.myprojects.springboot.demo.entity.Employee;
import com.myprojects.springboot.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    // expose /employees and return all employees
    @GetMapping("/employees")
    public List<Employee> findAdd(){
        return employeeService.findAll();
    }

    // add mapping for GET /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeId(@PathVariable int employeeId){
            Employee theEmployee= employeeService.findById(employeeId);
            if (theEmployee==null){
               throw new RuntimeException("The employee not found "+employeeId);
            }
            return theEmployee;
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //also just in case pass an id in Json ... set id to 0
        //this is to force a save a new item ... instead of update
        theEmployee.setId(0);
        Employee dbEmployee =employeeService.save(theEmployee);
        return dbEmployee;
    }

    // add mapping for PUT / employees / update employees
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee=employeeService.save(theEmployee);
        return dbEmployee;
    }
    // add mapping for DELETE  / employees/{employeesId} delete employees
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee dbEmployee=employeeService.findById(employeeId);

        if (dbEmployee==null){
            throw new RuntimeException("The employee does not exists "+employeeId);
        }
        employeeService.deleteById(employeeId);

        return "Deleted employee id "+employeeId;

    }
}
