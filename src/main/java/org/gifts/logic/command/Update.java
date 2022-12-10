package org.gifts.logic.command;

import org.gifts.entity.item.PresentBox;
import org.gifts.entity.item.Sweet;

public class Update implements Command{
  PresentBox gift;
  Sweet sweet;

  public Update(PresentBox gift, Sweet sweet) {
    this.gift = gift;
    this.sweet = sweet;
  }

  @Override
  public void execute() {
    gift.updateSweet(sweet);
  }
}
