package com.amar.sbrest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.amar.sbrest.entity.Student;
import com.amar.sbrest.repository.IStudentRepository;

@SpringBootTest
public class TestStudentService {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private IStudentRepository studentRepository;

    private List<Student> students;
    private List<Student> studentsAge22;

    @BeforeEach
    public void setUp() {
        students = new ArrayList<>();
        students.add(new Student(1, "Amar", "Sharma", 12));
        
        studentsAge22 = new ArrayList<>();
        studentsAge22.add(new Student(3, "John", "Doe", 22));
        studentsAge22.add(new Student(3, "Money", "Singh", 22));
    }

    @Test
    public void testGetAllStudents() {
        when(studentRepository.findAll()).thenReturn(students);

        List<Student> actualResults = studentService.getAllStudent();

        assertEquals(students.size(), actualResults.size());
        assertEquals(students.get(0).getFullName(), actualResults.get(0).getFullName());
    }

    @Test
    public void testFindByAge() {
        when(studentRepository.findByAgeOrderByFirstNameDesc(12)).thenReturn(students);

        List<Student> actualResults = studentService.findByAge(12);

        assertEquals(students.size(), actualResults.size());
        assertEquals(students.get(0).getFullName(), actualResults.get(0).getFullName());
    }

    @ParameterizedTest
    @CsvSource({
        "12, Amar Sharma",
        "22, John Doe"
    })
    public void testFindByAge(int age, String expectedFullName) {
        List<Student> students = null;
        switch (age) {
            case 12:
                students = this.students;
                break;
            case 22:
                students = this.studentsAge22;
                break;
            default:
                students = new ArrayList<>();
                break;
        }

        when(studentRepository.findByAgeOrderByFirstNameDesc(age)).thenReturn(students);

        List<Student> actualResults = studentService.findByAge(age);

        assertEquals(students.size(), actualResults.size());
        assertEquals(expectedFullName, actualResults.get(0).getFullName());
    }

    @ParameterizedTest
    @CsvSource({
        "100"
    })
    public void testFindByAge(int age) {
        when(studentRepository.findByAgeOrderByFirstNameDesc(age)).thenReturn(new ArrayList<>());

        List<Student> actualResults = studentService.findByAge(age);

        assertEquals(0, actualResults.size());
    }
}
