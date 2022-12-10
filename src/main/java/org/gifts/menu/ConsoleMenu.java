package org.gifts.menu;

import org.gifts.entity.item.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.gifts.logic.command.*;
import org.gifts.logic.dataParser.DataParser;
import org.gifts.logic.implementation.FilterListOfSweets;
import org.gifts.logic.implementation.ShowListOfSweets;
import org.gifts.logic.implementation.SortListOfSweets;


public  class ConsoleMenu {
    private final String DATA_PATH = "D:/Yuliia/Java/NewYearGift/src/main/resources/data.json";
    Scanner keyboard = new Scanner(System.in);
    public void mainMenu(){
        PresentBox gift = new PresentBox(1,PresentShape.SQUARE,"red",new ArrayList<>());
        GiftController giftController = new GiftController();
        DataParser parser = new DataParser();
        ArrayList<Sweet> listOfSweets = parser.readData(DATA_PATH);
        System.out.println("Welcome!");
        boolean var = true;
        while (var) {
            System.out.println("\nWhat do you want to do? Please choose one option:");
            System.out.println("1 - Show the content of gift");
            System.out.println("2 - Add sweet ");
            System.out.println("3 - Delete sweet");
            System.out.println("4 - Update sweet amount");
            System.out.println("5 - Sort sweets in the gift");
            System.out.println("6 - Find sweets by range of sugar level");
            System.out.println("7 - Show the list of sweets");
            System.out.println("0 - Exit");
            int choose = keyboard.nextInt();
            switch(choose){
                case 1 -> {
                    giftController.executeCommand(new Show(gift));
                }
                case 2 -> {
                    addSweetToGift(gift, listOfSweets, giftController);
                }
                case 3 -> {
                    deleteSweetFromGift(gift, giftController);
                }
                case 4 -> {
                    updateSweetInGift(gift, giftController);
                }
                case 5 ->{
                    sortSweetsInTheGift(gift, giftController);
                }
                case 6 ->{
                    findSweetsBySugarLevel(giftController, gift);
                }
                case 7 ->{
                    ShowListOfSweets s = new ShowListOfSweets();
                    sortSweets(listOfSweets);
                    s.ShowSweets(listOfSweets);
                }
                case 0 -> {
                    System.out.println("Good bye!");
                    keyboard.close();
                    return;
                }
            }
        }
    }


    public void sortSweets(ArrayList<Sweet> listOfSweets){
        SortListOfSweets s = new SortListOfSweets();
        s.SortCriterion();
        int num = keyboard.nextInt();
        if(num == 1){
            s.SortByCalorie(listOfSweets);
        }
        else if(num == 2){
            s.sortBySugarLevel(listOfSweets);
        }
        else if(num == 3){
            s.sortByPrice(listOfSweets);
        }
    }

    public void addSweetToGift(PresentBox gift, ArrayList<Sweet> listOfSweets, GiftController giftController){

        System.out.println("Enter title of candy which you want to add: ");
        String name = keyboard.next();
        FilterListOfSweets f = new FilterListOfSweets();
        if (f.filterSweetsByName(listOfSweets, name)) {
            System.out.println("Choose a candy which you want to add: ");
            int num = keyboard.nextInt();
            System.out.println("How much candies should weight?");
            float weight = keyboard.nextFloat();
            if (gift.getPresentWeight() + weight >= 2.0) {
                System.out.println("Candies aren`t added. The weight of the gift is more than 2kg");
            } else {
                Sweet sweet = listOfSweets.get(num - 1);
                sweet.setWeight(weight);
                giftController.executeCommand(new Add(gift, sweet));
            }
        }
    }

    public void deleteSweetFromGift(PresentBox gift, GiftController giftController){
        System.out.println("Choose a candy which you want to delete: ");
        for(int i = 0; i < gift.getComponents().size(); i++){

            System.out.println(i+1 + " - " + gift.getComponents().get(i).getInfo());
        }
        int num = keyboard.nextInt();
        Sweet sweet = gift.getComponents().get(num-1);
        giftController.executeCommand(new Delete(gift, sweet));
    }

    public void updateSweetInGift(PresentBox gift, GiftController giftController){
        System.out.println("Choose a candy which weight you want to update : ");
        giftController.executeCommand(new Show(gift));
        int num = keyboard.nextInt();
        System.out.println("how much candies should weight?");
        float weight = keyboard.nextFloat();
        if (gift.getPresentWeight() - gift.getComponents().get(num - 1).getWeight()  + weight >= 2.0) {
            System.out.println("Candies aren`t added. The weight of the gift is more than 2kg");
        } else {
            Sweet sweet = gift.getComponents().get(num - 1);
            sweet.setWeight(weight);
            giftController.executeCommand(new Update(gift, sweet));
        }
    }

    public void sortSweetsInTheGift(PresentBox gift, GiftController giftController){
        SortCriterion();
        int num = keyboard.nextInt();
        if(num == 1){
            giftController.executeCommand(new SortByCalorie(gift));
        }
        else if(num == 2){
            giftController.executeCommand(new SortBySugar(gift));
        }
        else if(num == 3){
            giftController.executeCommand(new SortByWeight(gift));
        }
    }
    public void SortCriterion(){
        System.out.println("Choose a criterion for sorting");
        System.out.println("1 - by calorie content");
        System.out.println("2 - by sugar level");
        System.out.println("3 - by weight");
    }
    public void findSweetsBySugarLevel(GiftController giftController, PresentBox gift){
        System.out.println("Enter min level of sugar");
        int min = keyboard.nextInt();
        System.out.println("Enter max level of sugar");
        int max = keyboard.nextInt();
        giftController.executeCommand(new FilterSweetsBySugar(gift, min, max));

    }
}

