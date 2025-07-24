package com.dsa.tracker.dsatracker.service;

import com.dsa.tracker.dsatracker.model.Problem;
import com.dsa.tracker.dsatracker.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private ProblemRepository problemRepository;

    @Override
    public List<Problem> getAllProblems() {
        return problemRepository.findAll();
    }

    @Override
    public Problem createProblem(Problem problem) {
        return problemRepository.save(problem);
    }

    @Override
    public Problem getProblemById(String id) {
        Optional<Problem> optional = problemRepository.findById(id);
        return optional.orElse(null); // return null if not found
    }

    @Override
    public void deleteProblem(String id) {
        problemRepository.deleteById(id);
    }
}
