package com.myprojects.springboot.demo.dao;

import com.myprojects.springboot.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//el nombre del recurso http://localhost:8080/magic-api/members?sort=firstName,desc
@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository <Employee,Integer>{
    // that's it not need to write any code
}
