package com.dsa.tracker.dsatracker.repository;

import com.dsa.tracker.dsatracker.model.Problem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

// This interface handles MongoDB operations like save(), findAll(), deleteById()
@Repository
public interface ProblemRepository extends MongoRepository<Problem, String> {
    // You can also define custom queries here later if needed
}
