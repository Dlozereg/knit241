package org.knit.solutions.Task2_13_Classes;

public class TVOnCommand implements Command{
    private final TV tv;
    private Command reverseCommand;

    public TVOnCommand(TV tv) {
        this.tv = tv;
    }

    public void setReverseCommand(Command reverseCommand) {
        this.reverseCommand = reverseCommand;
    }

    @Override
    public void reverseCommand() {
        if (reverseCommand == null){
            System.out.println("No reverseCommand set");
        }
        else {
            reverseCommand.execute();
        }
    }

    @Override
    public void execute() {
        tv.turnOn();
    }
}
