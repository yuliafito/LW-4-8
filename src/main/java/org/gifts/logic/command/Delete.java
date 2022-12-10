package org.gifts.logic.command;

import org.gifts.entity.item.PresentBox;
import org.gifts.entity.item.Sweet;

public class Delete implements Command{
    PresentBox gift;
    Sweet sweet;
    public Delete(PresentBox gift, Sweet sweet) {
        this.gift = gift;
        this.sweet = sweet;
    }

    @Override
    public void execute() {
        gift.deleteSweet(sweet);
    }

}
