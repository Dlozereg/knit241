package org.knit.solutions.task2_1Classes;

public class LegalDep extends Solver{
    @Override
    protected boolean canSolve(Problem problem) {
        return problem.getDifficulty() < 50;
    }

    @Override
    protected void solve(Problem problem) {
        System.out.println("Problem solved by Legal Department");
    }
}
