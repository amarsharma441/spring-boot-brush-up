package com.amar.sbrest.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

public class EntityWithId<T> {

    @Id
    @SequenceGenerator(
        name = "name",
        sequenceName = "seq_name",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "seq_name"
    )
    public Integer id;
}
