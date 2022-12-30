package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepository {
    HashMap<String,Student> studentDb;
    HashMap<String,Teacher> teacherDb;
    HashMap<String, List<String>> pairDb;

    public StudentRepository() {
        this.studentDb = new HashMap<>();
        this.teacherDb = new HashMap<>();
        this.pairDb = new HashMap<>();
    }
    public void addStudent(Student student){
        studentDb.put(student.getName(),student);
    }
    public void addTeacher(Teacher teacher){
        teacherDb.put(teacher.getName(), teacher);
    }
    public void addPair(String student, String teacher){
        if(studentDb.containsKey(student) && teacherDb.containsKey(teacher)){
            List<String> students=new ArrayList<>();
            if(pairDb.containsKey(teacher)){
                students=pairDb.get(teacher);
            }
            students.add(student);
            pairDb.put(teacher,students);
        }
    }
    public Student getStudentByName(String name){
        return studentDb.get(name);
    }
    public Teacher getTeacherByName(String name){
        return teacherDb.get(name);
    }
    public List<String> getStudentsByTeacherName(String name){
        return pairDb.get(name);
    }
    public List<String> getAllStudents(){
        List<String> students=new ArrayList<>();
        for(Student student:studentDb.values()){
            students.add(student.getName());
        }
        return students;
    }
    public void deleteTeacherByName(String name){
        if(teacherDb.containsKey(name))
        teacherDb.remove(name);

        if(pairDb.containsKey(name)){
            for(String student:pairDb.get(name)){
                studentDb.remove(student);
            }
            pairDb.remove(name);
        }
    }
    public void deleteAllTeacher(){
        for(Map.Entry<String,List<String>> e:pairDb.entrySet()){
            for(String student:e.getValue()){
                studentDb.remove(student);
            }
            pairDb.remove(e.getKey());
        }
        teacherDb.clear();
    }
}
