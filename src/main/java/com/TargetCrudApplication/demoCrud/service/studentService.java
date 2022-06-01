package com.TargetCrudApplication.demoCrud.service;


import com.TargetCrudApplication.demoCrud.entity.studentModel;
import com.TargetCrudApplication.demoCrud.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentService {
    @Autowired
    private studentRepository repository;

    //--------------------------------Create------------------------------------//
    //Take mentor as an argument and save it
    public studentModel saveNewStudent(studentModel newStudent) {
        return repository.save(newStudent);
    }

    //Take multiple mentors as argument and save them all
    public List<studentModel> saveAllNewStudents(List<studentModel> newStudents) {
        return repository.saveAll(newStudents);
    }


    //----------------------------------Read-----------------------------------//
    public List<studentModel> getDetails() {
        return repository.findAll();
    }

    //Find mentor by Id and if not found will return null
    public studentModel getDetailsById(int studentId) {
        return repository.findById(studentId).orElse(null);
    }


    //----------------------------------Delete---------------------------------//
    public String deleteStudent(int studentId) {
        repository.deleteById(studentId);
        return "Removed mentor details of mentor with id " + studentId + " successfully!!";
    }


    //-----------------------------------Update-------------------------------//
    //Id is a readable field ie cannot be modified
    //So we get existing mentor and modify it
    public studentModel updateStudent(studentModel student) {
    studentModel existingStudent = repository.findById(student.getStudentId()).orElse(null);
        //assert existingStudent != null;
        existingStudent.setStudentName(student.getStudentName());
        existingStudent.setStudentBranch(student.getStudentBranch());
        existingStudent.setCollege(student.getCollege());
        existingStudent.setInterest(student.getInterest());
        return repository.save(existingStudent);

    }


}
