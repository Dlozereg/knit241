package org.knit.solutions.Task2_13_Classes;

public class LightsOffCommand implements Command {
    private final Lamp lamp;
    private Command reverseCommand;

    public LightsOffCommand(Lamp lamp) {
        this.lamp = lamp;
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
        lamp.lightsOff();
    }
}
