package com.amar.sbrest.service;

import java.util.List;

import com.amar.sbrest.entity.Student;

public interface IStudentService {
    
    public List<Student> getAllStudent();
    public List<Student> findByAge(Integer age);
    public List<Student> findByAgeQuery(Integer age);
}
