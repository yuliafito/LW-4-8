package org.gifts.logic.command;

import org.gifts.entity.item.PresentBox;

public class SortBySugar implements Command{
  PresentBox gift;

  public SortBySugar(PresentBox gift) {
    this.gift = gift;
  }

  @Override
  public void execute() {
    gift.sortPresentBySugarLevel();
  }
}
