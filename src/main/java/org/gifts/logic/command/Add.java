package org.gifts.logic.command;

import org.gifts.entity.item.PresentBox;
import org.gifts.entity.item.Sweet;


public class Add implements Command{
    PresentBox gift;
    Sweet sweet;
    public Add(PresentBox gift, Sweet sweet) {
        this.gift = gift;
        this.sweet = sweet;
    }

    @Override
    public void execute() {
        gift.addSweet(sweet);
    }
}
