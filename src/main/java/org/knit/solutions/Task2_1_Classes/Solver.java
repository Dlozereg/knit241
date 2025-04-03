package org.knit.solutions.Task2_1_Classes;

public abstract class Solver {
    protected Solver nextSolver;

    public void setNextSolver(Solver nextSolver) {
        this.nextSolver = nextSolver;
    }

    public void processRequest(Problem problem) {
        if (canSolve(problem)) {
            solve(problem);
        } else if (nextSolver != null) {
            nextSolver.processRequest(problem);
        } else {
            System.out.println("Извините, мы не смогли решить вашу проблему");
        }
    }

    protected abstract boolean canSolve(Problem problem);
    protected abstract void solve(Problem problem);
}
