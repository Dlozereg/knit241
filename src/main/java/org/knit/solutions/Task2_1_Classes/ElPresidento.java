package org.knit.solutions.Task2_1_Classes;

public class ElPresidento extends Solver{
    @Override
    protected boolean canSolve(Problem problem) {
        return problem.getDifficulty() < 100;
    }

    @Override
    protected void solve(Problem problem) {
        System.out.println("Problem solved by El Presidento");
    }
}
