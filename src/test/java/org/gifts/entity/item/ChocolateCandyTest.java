package org.gifts.entity.item;

import org.gifts.entity.item.ChocolateCandy;
import org.gifts.entity.item.ChocolateCandyFillers;
import org.gifts.entity.item.Sweet;
import org.gifts.logic.command.Add;
import org.gifts.logic.command.GiftController;
import org.gifts.logic.dataParser.DataParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChocolateCandyTest {
    private final String DATA_PATH = "D:/Yuliia/Java/NewYearGift/src/main/resources/data.json";
    DataParser parser = new DataParser();
    ArrayList<Sweet> listOfSweets = parser.readData(DATA_PATH);
    GiftController giftController = new GiftController();
    PresentBox gift = new PresentBox(1,PresentShape.SQUARE,"red",new ArrayList<>());
    @Test
    @DisplayName("Test getInfo method in ChocolateCandy class")
    void getInfoTest(){
        String str = "ChocolateCandy{" +
                "title=" + "MonblanGreen" +
                ",\tprice=" + "350.0" +
                ",\tsugar level per 100g=" + 46.9 +
                ",\tcalorie content per 100g=" + 559 +
                ",\tcocoaCount per 100g=" + 72.30 +
                ",\twaffle=" + false +
                ",\tnuts=" + true +
                ",\tfiller=" + "VANILLA_CREAM" +
                '}';

        assertEquals(str,listOfSweets.get(0).getInfo());

    }

    @Test
    @DisplayName("Test toString method in ChocolateCandy class")
    void toStringTest(){
        String str = "ChocolateCandy{" +
                "title=" + "MonblanGreen" +
                ",\tweight=" + 0.2 +
                ",\tcurrent price=" + "70.0" +
                ",\tsugar level=" + 93.8 +
                ",\tcalorie content=" + 1118.0 +
                ",\tcocoaCount=" + 144.60002 +
                ",\twaffle=" + false +
                ",\tnuts=" + true +
                ",\tfiller=" + "VANILLA_CREAM" +
                '}';
        float weight = 0.2F;
        Sweet sweet = listOfSweets.get(0);
        sweet.setWeight(weight);
        giftController.executeCommand(new Add(gift, sweet));
        assertEquals(str,sweet.toString());
    }

    @Test
    @DisplayName("Test equals method in ChocolateCandy class")
    void equalsTest(){
        Sweet sweet = new ChocolateCandy(1,  1,  1,  "MonblanGreen",  350.0F,  " ",  true,  46.9F,
         0.2F,  559,  72.3F,  false,  true, ChocolateCandyFillers.VANILLA_CREAM);
        assertEquals(sweet, listOfSweets.get(0));
    }
}
