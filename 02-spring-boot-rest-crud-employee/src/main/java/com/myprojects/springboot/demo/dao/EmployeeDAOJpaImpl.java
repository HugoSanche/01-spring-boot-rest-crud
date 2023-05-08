package com.myprojects.springboot.demo.dao;

import com.myprojects.springboot.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
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

    @Override
    public Employee findById(int id) {

        Employee findEmployee=entityManager.find(Employee.class, id);
        return findEmployee;
    }
    //Note.- don't use the @Transactional at DAO layer It will be handled at service layer
    @Override
    public Employee save(Employee employee) {
        Employee theEmployee=entityManager.merge(employee);
        return theEmployee;
    }
    //Note.- don't use the @Transactional at DAO layer It will be handled at service layer
    @Override
    public void deleteById(int id) {
            Employee theEmployee=entityManager.find(Employee.class, id);
    }

}
