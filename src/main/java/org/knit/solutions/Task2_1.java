package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.task2_1Classes.*;

/*
* Задача 2.1 Chain of Responsibility (Цепочка обязанностей)
* Задача:
* Реализуйте систему обработки жалоб клиентов в банке.
* 1. Жалоба сначала поступает в колл-центр.
* 2. Если проблема сложная, запрос передается менеджеру.
* 3. Если даже менеджер не может решить проблему, запрос уходит в юридический отдел.
* 4. Каждый уровень обработки либо решает проблему, либо передает ее дальше. (не менее 4х уровней поддержки)
* 5. Представить проблему в виде объекта, с описанием, уровнем сложности.
* */

@TaskDescription(taskNumber = 1, taskDescription = "Задача 2.1 Chain of Responsibility (Цепочка обязанностей)", href = "org/knit/solutions/task2_1Classes/")
public class Task2_1 implements Solution{

    @Override
    public void execute() {
        Solver callCentre = new CallCentre();
        Solver manager = new Manager();
        Solver legalDep = new LegalDep();
        Solver elPresidento = new ElPresidento();


        callCentre.setNextSolver(manager);
        manager.setNextSolver(legalDep);
        legalDep.setNextSolver(elPresidento);


        callCentre.processRequest(new Problem(10, "easy"));
        callCentre.processRequest(new Problem(22, "medium"));
        callCentre.processRequest(new Problem(33, "hard"));
        callCentre.processRequest(new Problem(55, "very hard"));
        callCentre.processRequest(new Problem(100, "too hard"));
    }
}
