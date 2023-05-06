package com.myprojects.demo.rest;

import com.myprojects.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> theStudents=new ArrayList<>();
    @PostConstruct
    public void loadData(){
        theStudents.add(new Student("Veronica", "Perez"));
        theStudents.add(new Student("Rocio", "Rivera"));
        theStudents.add(new Student("Ernesto", "Rojas"));
        theStudents.add(new Student("Camilo", "Cesto"));
    }
    @RequestMapping("/student")
    public List<Student> getStudent(){
        return theStudents;
    }
    @RequestMapping("/student/{idstudent}")
    public Student getStudentById(@PathVariable int idstudent){
        //check the idstudent againt the list size
        if (idstudent>theStudents.size() || idstudent<0){
            throw new StudentNotFoundException("The student id not found "+idstudent);
        }
        return theStudents.get(idstudent);
    }
    //Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException (StudentNotFoundException exc){
        // Create a studentErrorResponse
        StudentErrorResponse error=new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessange(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException (Exception exc){
        // Create a studentErrorResponse
        StudentErrorResponse error=new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessange(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
