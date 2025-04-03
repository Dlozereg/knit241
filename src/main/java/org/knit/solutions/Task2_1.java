package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task2_1_Classes.*;

/*
 * Задача 2.1 Chain of Responsibility (Цепочка обязанностей)
 * Описание:
 * Этот паттерн используется для передачи запроса по цепочке обработчиков,
 * пока один из них не обработает его. Каждый обработчик в цепочке может либо обработать запрос,
 * либо передать его дальше.
 *
 * Пример из жизни:
 * Рассмотрим систему поддержки пользователей. Запрос от клиента сначала поступает
 * к оператору первого уровня (обычный оператор), затем, если он не может решить проблему,
 * передается специалисту второго уровня (инженеру), а если и он не справляется – ведущему инженеру.
 *
 * Задача:
 * Реализуйте систему обработки жалоб клиентов в банке.
 *
 * 1) Жалоба сначала поступает в колл-центр.
 * 2) Если проблема сложная, запрос передается менеджеру.
 * 3) Если даже менеджер не может решить проблему, запрос уходит в юридический отдел.
 * 4) Каждый уровень обработки либо решает проблему, либо передает ее дальше.
 * (не менее 4х уровней поддержки)
 * 5) Представить проблему в виде объекта, с описанием, уровнем сложности.
 */

@TaskDescription(taskNumber = 1, taskDescription = "Chain of Responsibility (Цепочка обязанностей)")
public class Task2_1 implements Solution {
    @Override
    public void execute(){
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
