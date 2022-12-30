package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public ResponseEntity<String> addStudent(Student student){
        studentRepository.addStudent(student);
        return new ResponseEntity<>("New student added successfully", HttpStatus.CREATED);
    }
    public ResponseEntity<String> addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
        return new ResponseEntity<>("New teacher added successfully",HttpStatus.CREATED);
    }
    public ResponseEntity<String> addStudentTeacherPair(String student,String teacher){
         studentRepository.addPair(student,teacher);
        return new ResponseEntity<>("New student-teacher pair added successfully", HttpStatus.CREATED);
    }
    public Student getStudentByName(String name){
        return studentRepository.getStudentByName(name);
    }
    public Teacher getTeacherByName(String name){
        return studentRepository.getTeacherByName(name);
    }
    public List<String> getStudentsByTeacherName(String name){
        return studentRepository.getStudentsByTeacherName(name);
    }
    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }
    public void deleteTeacherByName(String name){
        studentRepository.deleteTeacherByName(name);
    }
    public void deleteAllTeacher(){
        studentRepository.deleteAllTeacher();
    }
}
