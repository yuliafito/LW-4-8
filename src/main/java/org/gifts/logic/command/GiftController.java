package org.gifts.logic.command;

public class GiftController {
    public void executeCommand(Command command){
        command.execute();
    }
}
