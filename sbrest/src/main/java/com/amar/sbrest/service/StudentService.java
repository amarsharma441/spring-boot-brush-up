package com.amar.sbrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amar.sbrest.entity.Student;
import com.amar.sbrest.repository.IStudentRepository;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository _studentRepository;

    StudentService(IStudentRepository studentRepository) {
        _studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudent() {
        return _studentRepository.findAll();
    }

    @Override
    public List<Student> findByAge(Integer age) {
        return _studentRepository.findByAgeOrderByFirstNameDesc(age);
    }

    @Override
    public List<Student> findByAgeQuery(Integer age) {
        return _studentRepository.findByAgeNativeQuery(age);
    }
    
}
