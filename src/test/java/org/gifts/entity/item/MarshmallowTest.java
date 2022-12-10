package org.gifts.entity.item;

import org.gifts.logic.command.Add;
import org.gifts.logic.command.GiftController;
import org.gifts.logic.dataParser.DataParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MarshmallowTest {
    private final String DATA_PATH = "D:/Yuliia/Java/NewYearGift/src/main/resources/data.json";
    DataParser parser = new DataParser();
    ArrayList<Sweet> listOfSweets = parser.readData(DATA_PATH);
    GiftController giftController = new GiftController();
    PresentBox gift = new PresentBox(1,PresentShape.SQUARE,"red",new ArrayList<>());

    @Test
    @DisplayName("Test Equals method in Marshmallow class")
    void testEquals() {
        Sweet sweet = new Marshmallow( 445635114,  771266545,  102333405,  "Marshmallow",  50.3F,
         " ",  true,  60.4F,  0.4F,  320, SweetsFlavors.CHERRY);
        assertEquals(sweet, listOfSweets.get(5));
    }

    @Test
    @DisplayName("Test getInfo method in Marshmallow class")
    void getInfo() {
        final String str = "Marshmallow{" +
                "title=" + "Marshmallow" +
                ",\tprice=" + "50.3" +
                ",\tsugar level per 100g=" + 60.4 +
                ",\tcalorie content per 100g=" + 320 +
                ",\tflavor=" + "CHERRY" +
                '}';
        assertEquals(str,listOfSweets.get(5).getInfo());
    }

    @Test
    @DisplayName("Test ToString method in Marshmallow class")
    void testToString() {
        final String str = "Marshmallow{" +
                "title=" + "Marshmallow" +
                ",\tweight=" + 0.2 +
                ",\tcurrent price=" + "10.06" +
                ",\tsugar level=" + 120.80001 +
                ",\tcalorie content=" + 640.0 +
                ",\tflavor=" + "CHERRY" +
                '}';
        float weight = 0.2F;
        Sweet sweet = listOfSweets.get(5);
        sweet.setWeight(weight);
        giftController.executeCommand(new Add(gift, sweet));
        assertEquals(str,sweet.toString());
    }
}