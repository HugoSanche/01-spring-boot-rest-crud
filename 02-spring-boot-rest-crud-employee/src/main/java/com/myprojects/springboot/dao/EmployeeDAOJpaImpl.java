package com.myprojects.springboot.dao;

import com.myprojects.springboot.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeDAOJpaImpl implements EmployeeDAO{
    //define field for entity manager
    private EntityManager entityManager;

    //define constructor

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        //create query
        TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee",Employee.class);

        //execute the query and get results
        List<Employee> employees= theQuery.getResultList();

        //return results
        return  employees;
    }


}
