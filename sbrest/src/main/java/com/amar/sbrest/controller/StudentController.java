package com.amar.sbrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.amar.sbrest.entity.Student;
import com.amar.sbrest.service.IStudentService;
import com.amar.sbrest.service.StudentService;

@RestController()
@RequestMapping("api/student")
public class StudentController {
    
    @Autowired
    IStudentService _studentService;
    
    public StudentController(StudentService _studentService) {
        this._studentService = _studentService;
    }

    @GetMapping("/")
    public List<Student> getAllStudent() {
        return _studentService.getAllStudent();
    }

    @GetMapping("/byAge")
    public List<Student> getStudentByAge(Integer age) {
        return _studentService.findByAge(age);
    }
}
