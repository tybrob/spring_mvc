package com.oreilly.mvc_example.repositories;

import com.oreilly.mvc_example.entities.Officer;

import java.util.List;
import java.util.Optional;

public interface OfficerDAO {
    Officer save(Officer officer);

    Optional<Officer> findById(Integer id);

    List<Officer> findAll();

    long count();

    void delete(Officer officer);

    boolean existsById(Integer id);
}
