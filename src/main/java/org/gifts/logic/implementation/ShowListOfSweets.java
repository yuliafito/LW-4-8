package org.gifts.logic.implementation;

import org.gifts.entity.item.Sweet;
import org.gifts.logic.Managers.ShowManager;

import java.util.ArrayList;

public class ShowListOfSweets implements ShowManager {
    public void ShowSweets(ArrayList<Sweet> listOfSweets){
        for(int i = 0; i < listOfSweets.size();i++){

            System.out.println(i+1 + " - " + listOfSweets.get(i).getInfo());
        }
    }
}

