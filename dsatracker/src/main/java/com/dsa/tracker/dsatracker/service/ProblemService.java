package com.dsa.tracker.dsatracker.service;

import com.dsa.tracker.dsatracker.model.Problem;
import java.util.List;

public interface ProblemService {
    List<Problem> getAllProblems();
    Problem createProblem(Problem problem);
    Problem getProblemById(String id);
    void deleteProblem(String id);
}
