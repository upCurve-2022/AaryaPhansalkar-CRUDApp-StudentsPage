package com.TargetCrudApplication.demoCrud.controller;

import com.TargetCrudApplication.demoCrud.entity.studentModel;
import com.TargetCrudApplication.demoCrud.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
@RestController
public class studentController
{
    @Autowired
    private studentService service;


    //----------------------------POST(Create)-------------------------------------//
    //PostMappings written for API
    //This is for Adding new mentor API
    @PostMapping("/addstudent")
    public studentModel addStudent(@RequestBody studentModel mentor)
    {
        return service.saveNewStudent(mentor);
    }
    @PostMapping("/addstudents")
    public List<studentModel> addStudents(@RequestBody List<studentModel> mentors)
    {
        return service.saveAllNewStudents(mentors);
    }



    //---------------------------GET(Read)-------------------------------------//
    @GetMapping("/getstudents")
    public List<studentModel> findAllStudents()
    {
        return service.getDetails();
    }
    @GetMapping("/getstudent/{studentId}")   //If id not mentioned as part of request url, 404 error occurs
    public  studentModel findStudentById(@PathVariable int studentId)
    {
        return service.getDetailsById(studentId);

    }

    //@GetMapping("/mentor/{mentorName}")       //If name not mentioned as part of request url, 404 error occurs
    //public  mentorDetails findMentorByName(@PathVariable String mentorName)
    //{
    //To use any input as part of url request @path variable annotation is used
    //    return service.getDetailsByName(mentorName);
    //}


    //-------------------------------PUT(Update)-----------------------------------//
    @PutMapping("/updatestudent")
    public studentModel updateStudent(@RequestBody studentModel mentor)
    {
        return service.saveNewStudent(mentor);
    }



    //------------------------------DELETE-------------------------------------//
    @DeleteMapping("/deletestudent/{studentId}")
    public String deleteStudentDetails(@PathVariable int studentId)
    {
        return service.deleteStudent(studentId);
    }
}
