package org.gifts.logic.implementation;

import org.gifts.entity.item.Sweet;
import org.gifts.logic.Managers.SortManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortListOfSweets implements SortManager {

    @Override
    public void sortByPrice(ArrayList<Sweet>listOfSweets){
        Collections.sort(listOfSweets, new Comparator<Sweet>() {
            public int compare(Sweet o1, Sweet o2) {
                if (o1.getPrice() < o2.getPrice()) {
                    return -1;
                } else if (o1.getPrice() > o2.getPrice()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println("The list is sorted by price");
    }

    @Override
    public void SortByCalorie(ArrayList<Sweet> listOfSweets){
        Collections.sort(listOfSweets, ((o1, o2) -> o1.getCalorieContent() - o2.getCalorieContent()));
        System.out.println("The list is sorted by calorie");
    }

    @Override
    public void sortBySugarLevel(ArrayList<Sweet> listOfSweets){
        Collections.sort(listOfSweets, new Comparator<Sweet>() {
            public int compare(Sweet o1, Sweet o2) {
                if (o1.getSugarLevel() < o2.getSugarLevel()) {
                    return -1;
                } else if (o1.getSugarLevel() > o2.getSugarLevel()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println("The list is sorted by sugar");
    }

    @Override
    public void SortCriterion(){
        System.out.println("Choose a criterion for sorting");
        System.out.println("1 - by calorie content");
        System.out.println("2 - by sugar level");
        System.out.println("3 - by price");
    }
}

