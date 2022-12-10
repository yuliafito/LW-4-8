package org.gifts.logic.command;

import org.gifts.entity.item.PresentBox;

public class Show implements Command{

    PresentBox gift;
    public Show(PresentBox gift) {
        this.gift = gift;
    }

    @Override
    public void execute() {
        gift.showComponentsInfo();
    }

}
