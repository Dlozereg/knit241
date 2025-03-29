package org.knit.solutions.Task2_13_Classes;

public class RemoteControl {
    Command lastCommand;

    public RemoteControl() {

    }

    public void executeCommand(Command command) {
        lastCommand = command;
        command.execute();
    }

    public void undo() {
        if (lastCommand == null) {
            System.out.println("No commands have been executed");
        }
        else {
            lastCommand.reverseCommand();
            lastCommand = null;
        }
    }
}
