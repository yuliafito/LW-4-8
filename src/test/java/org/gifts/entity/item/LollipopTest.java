package org.gifts.entity.item;

import org.gifts.logic.command.Add;
import org.gifts.logic.command.GiftController;
import org.gifts.logic.dataParser.DataParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LollipopTest {
    private final String DATA_PATH = "D:/Yuliia/Java/NewYearGift/src/main/resources/data.json";
    DataParser parser = new DataParser();
    ArrayList<Sweet> listOfSweets = parser.readData(DATA_PATH);
    GiftController giftController = new GiftController();
    PresentBox gift = new PresentBox(1,PresentShape.SQUARE,"red",new ArrayList<>());

    @Test
    @DisplayName("Test Equals method in Lollipop class")
    void testEquals() {
        Sweet sweet = new Lollipop( 445635112,  771266543,  102333403,  "Lollipop",  80.6F,  " ",  true,
                40.7F,  0.3F,  320,  SweetsFlavors.YOGURT,  LollipopFiller.STRAWBERRY_JAM);
        assertEquals(sweet, listOfSweets.get(3));
    }

    @Test
    @DisplayName("Test getInfo method in Lollipop class")
    void getInfoTest() {
        final String str = "Lollipop{" +
                "title=" + "Lollipop" +
                ",\tprice=" + "80.6" +
                ",\tsugar level per 100g=" + 40.7 +
                ",\tcalorie content per 100g=" + 320 +
                ",\tflavor=" + "YOGURT" +
                ",\tfiller=" + "STRAWBERRY_JAM" +
                '}';

        assertEquals(str,listOfSweets.get(3).getInfo());
    }

    @Test
    @DisplayName("Test ToString method in Lollipop class")
    void testToString() {
        final String str = "Lollipop{" +
                "title=" + "Lollipop" +
                ",\tweight=" + 0.2 +
                ",\tcurrent price=" + "16.12" +
                ",\tsugar level=" + 81.4+
                ",\tcalorie content=" + 640.0+
                ",\tflavor=" + "YOGURT" +
                ",\tfiller=" + "STRAWBERRY_JAM" +
                '}';

        float weight = 0.2F;
        Sweet sweet = listOfSweets.get(3);
        sweet.setWeight(weight);
        giftController.executeCommand(new Add(gift, sweet));
        assertEquals(str,sweet.toString());
    }
}