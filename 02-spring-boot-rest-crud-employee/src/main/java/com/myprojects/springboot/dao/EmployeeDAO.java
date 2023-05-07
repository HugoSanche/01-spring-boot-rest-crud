package com.myprojects.springboot.dao;

import com.myprojects.springboot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}

