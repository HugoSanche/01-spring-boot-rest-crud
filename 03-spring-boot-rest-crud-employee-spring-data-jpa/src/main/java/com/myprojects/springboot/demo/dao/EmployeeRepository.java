package com.myprojects.springboot.demo.dao;

import com.myprojects.springboot.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee,Integer>{
    // that's it not need to write any code
}
