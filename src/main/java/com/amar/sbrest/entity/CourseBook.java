package com.amar.sbrest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="course_book")
public class CourseBook {
    
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="course_id")
    private Integer courseId;

    
    @Column(name="book_id")
    private Integer bookId;
}
