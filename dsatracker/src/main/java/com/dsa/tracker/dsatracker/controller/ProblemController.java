package com.dsa.tracker.dsatracker.controller;

import com.dsa.tracker.dsatracker.model.Problem;
import com.dsa.tracker.dsatracker.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this class as a REST controller
@RequestMapping("/api/problems") // Base URL for all endpoints in this controller
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    // GET /api/problems → get all problems
    @GetMapping
    public List<Problem> getAllProblems() {
        return problemService.getAllProblems();
    }

    // GET /api/problems/{id} → get problem by ID
    @GetMapping("/{id}")
    public Problem getProblemById(@PathVariable String id) {
        return problemService.getProblemById(id);
    }

    // POST /api/problems → create a new problem
    @PostMapping
    public Problem createProblem(@RequestBody Problem problem) {
        return problemService.createProblem(problem);
    }

    // DELETE /api/problems/{id} → delete a problem
    @DeleteMapping("/{id}")
    public void deleteProblem(@PathVariable String id) {
        problemService.deleteProblem(id);
    }
}
