package com.amar.sbrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amar.sbrest.entity.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {
    
    public List<Student> findByAgeOrderByFirstNameDesc(Integer age);

    @Query("from Student where age=:studentAge order by firstName desc")
    public List<Student> findByAgeQuery(@Param("studentAge") Integer age);

    @Query(value = "SELECT * FROM Student where age=:studentAge order by first_name desc", nativeQuery = true)
    public List<Student> findByAgeNativeQuery(@Param("studentAge") Integer age);
}
