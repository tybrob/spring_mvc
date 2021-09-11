package com.oreilly.mvc_example.repositories;

import com.oreilly.mvc_example.entities.Officer;
import com.oreilly.mvc_example.entities.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfficerRepository extends JpaRepository<Officer, Integer> {
    List<Officer> findByRank(Rank rank);
    List<Officer> findByLastNameLikeAndRank(String like, Rank rank);
}