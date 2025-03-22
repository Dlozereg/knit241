package org.knit.solutions.task2_1Classes;

public class CallCentre extends Solver{
    @Override
    protected boolean canSolve(Problem problem) {
        return problem.getDifficulty() < 20;
    }

    @Override
    protected void solve(Problem problem) {
        System.out.println("Problem solved by Call Centre");
    }
}
