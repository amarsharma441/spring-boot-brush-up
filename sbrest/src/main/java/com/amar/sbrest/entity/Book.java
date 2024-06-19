package com.amar.sbrest.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="book")
public class Book {
    
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToMany
    @JoinTable(
        name = "course_book",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    List<Course> courses;

}
