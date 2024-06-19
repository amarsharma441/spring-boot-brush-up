package com.amar.sbrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amar.sbrest.entity.Student;

@Service
public interface IStudentService {
    
    public List<Student> getAllStudent();
    public List<Student> findByAge(Integer age);
    public List<Student> findByAgeQuery(Integer age);
}
