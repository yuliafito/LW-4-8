package org.gifts.logic.Managers;

import org.gifts.entity.item.Sweet;

import java.util.ArrayList;

public interface FilterManager {
    boolean filterSweetsByName(ArrayList<Sweet> listOfSweets, String name);
}
