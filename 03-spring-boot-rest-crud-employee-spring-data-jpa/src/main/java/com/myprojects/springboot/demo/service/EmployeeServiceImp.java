package com.myprojects.springboot.demo.service;

import com.myprojects.springboot.demo.dao.EmployeeRepository;
import com.myprojects.springboot.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService{
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImp(EmployeeRepository theemployeeRepository) {
        employeeRepository = theemployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee theEmployee=null;
        if(result.isPresent()){
            theEmployee=result.get();
        }
        else{
            //didn't find employee id
            throw new RuntimeException("The id not found "+id);
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}



