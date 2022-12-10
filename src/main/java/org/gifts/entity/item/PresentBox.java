package org.gifts.entity.item;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class PresentBox {
    private long id;
    private PresentShape shape;
    private String color;
    private List<Sweet> components;

    public PresentBox(long id, PresentShape shape, String color, List<Sweet> components) {
        this.id = id;
        this.shape = shape;
        this.color = color;
        this.components = components;
    }

    public void showComponentsInfo(){
        if(getComponents().isEmpty()){
            System.out.println("The gift is empty");
        }
        else{
            System.out.println("List of sweets in gift: ");
            for(int i = 0; i<getComponents().size();i++){
                System.out.println(i+1 + " - " + getComponents().get(i));
            }
            System.out.println("Amount of sugar: "+ getSugarLevel());
            System.out.println("Amount of calorie: "+ getCalorieContent());
            System.out.println("Weight of gift: "+ getPresentWeight());
            System.out.println("Price of gift: "+ getPrice());

        }
    }

    public float getSugarLevel(){
        float sugar = 0.0F;
        for (Sweet sweets : components) sugar += sweets.getCurrentSugarLevel();
        return sugar;
    }

    public int getCalorieContent(){
        int CalorieContent = 0;
        for (Sweet sweets : components) CalorieContent += sweets.getCurrentCalorieContent();
        return CalorieContent;
    }

    public float getPresentWeight() {
        float weight = 0.0F;
        for (Sweet sweets : components) weight += sweets.getWeight();
        return weight;
    }

    public float getPrice(){
        float price = 0.0F;
        for (Sweet sweets : components) price += sweets.getCurrentPrice();
        return price;
    }

    public List<Sweet> getComponents() {
        return components;
    }

    public void addSweet(Sweet sweet){
        if(!components.contains(sweet)){
            components.add(sweet);
            System.out.println("The sweet is added to the gift");
        }
        else {
            System.out.println("The sweet already is in the gift.\nIf you want to delete or update this sweet choose this action in menu");
        }
    }

    public void deleteSweet(Sweet sweet){
        if(getComponents().contains(sweet)){
            getComponents().removeIf(n -> (n.getId() == sweet.getId()));
            System.out.println("The sweet is deleted from the gift");
        }
        else {
            System.out.println("There is not this sweet in the gift");
        }
    }

    public void updateSweet(Sweet sweet){
        if(getComponents().contains(sweet)){
            components.set(components.indexOf(sweet),sweet);
            System.out.println("The sweet is updated");
        }
        else {
            System.out.println("There is not this sweet in the gift");
        }
    }

    public void sortPresentByCalorie(){
        Collections.sort(components, ((o1, o2) -> o1.getCalorieContent() - o2.getCalorieContent()));
        System.out.println("The gift is sorted by calorie");
    }

    public void sortPresentByWeight(){
        Collections.sort(components, new Comparator<Sweet>() {
            public int compare(Sweet o1, Sweet o2) {
                if (o1.getWeight() < o2.getWeight())
                    return -1;
                else if (o1.getWeight() > o2.getWeight())
                    return 1;
                else
                    return 0;
            }
        });
        System.out.println("The gift is sorted by weight");
    }

    public void sortPresentBySugarLevel(){
        Collections.sort(components, new Comparator<Sweet>() {
            public int compare(Sweet o1, Sweet o2) {
                if (o1.getSugarLevel() < o2.getSugarLevel())
                    return -1;
                else if (o1.getSugarLevel() > o2.getSugarLevel())
                    return 1;
                else
                    return 0;
            }
        });
        System.out.println("The gift is sorted by sugar level");
    }

    public void filterSweetsBySugarLevel(int min, int max) {
            int k = 0;
            for (Sweet sweet : components) {
                if (sweet.getSugarLevel() >= min && sweet.getSugarLevel() <= max) {
                    System.out.println(sweet);
                    k++;
                }
            }
            if (k == 0){
                System.out.println("Sweets with sugar content range ("+ min + " - " + max +") not found");
            }
    }

    @Override
    public String toString() {
        return "PresentBox{" +
                "id=" + id +
                ", shape=" + shape +
                ", color='" + color + '\'' +
                ", components=" + components +
                '}';
    }
}

