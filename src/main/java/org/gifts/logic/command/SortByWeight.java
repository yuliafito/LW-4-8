package org.gifts.logic.command;

import org.gifts.entity.item.PresentBox;

public class SortByWeight implements Command{
  PresentBox gift;

  public SortByWeight(PresentBox gift) {
    this.gift = gift;
  }

  @Override
  public void execute() {
    gift.sortPresentByWeight();
  }
}
