package org.gifts.entity.item;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PresentBoxTest {
    PresentBox gift = new PresentBox(1,PresentShape.SQUARE,"red",new ArrayList<>());
    Sweet sweet = new ChocolateCandy(1,  1,  1,  "MonblanGreen",  350.0F,
            " ",  true,  46.9F, 0.2F,  559,  72.3F,
            false,  true, ChocolateCandyFillers.VANILLA_CREAM);

    Sweet sweet2 = new ChocolateCandy(445635110,  771266541,  102333401,  "Snickers",
            100.2F,  " ",  true,  30.1F, 0.3F,  400,  50.4F,
            false,  true, ChocolateCandyFillers.CARAMEL);

    @BeforeEach
    void addSweets(){
        gift.addSweet(sweet);
        gift.addSweet(sweet2);
    }

    @AfterEach
    void deleteSweets(){
        gift.deleteSweet(sweet);
        gift.deleteSweet(sweet2);
    }

    @Test
    @DisplayName("Test getSugarLevel method in PresentBox class")
    void getSugarLevelTest() {
        assertEquals(184.1F, gift.getSugarLevel());
    }

    @Test
    @DisplayName("Test getCalorieContent method in PresentBox class")
    void getCalorieContentTest() {
        assertEquals(2318, gift.getCalorieContent());
    }

    @Test
    @DisplayName("Test getPresentWeight method in PresentBox class")
    void getPresentWeightTest() {
        gift.addSweet(sweet);
        gift.addSweet(sweet2);
        assertEquals(0.5F, gift.getPresentWeight());
    }

    @Test
    @DisplayName("Test getPrice method in PresentBox class")
    void getPriceTest() {
        assertEquals(100.06F, gift.getPrice());
    }

    @Test
    @DisplayName("Test deleteSweet method in PresentBox class")
    void deleteSweetTest() {
        gift.deleteSweet(sweet);
        assertEquals(1, gift.getComponents().size());
    }

    @Test
    @DisplayName("Test addSweet method in PresentBox class")
    void addSweetTest() {
        assertEquals(2,gift.getComponents().size());
    }

    @Test
    @DisplayName("Test updateSweet method in PresentBox class")
    void updateSweetTest() {
        final float weight = 0.5F;
        sweet.setWeight(weight);
        gift.updateSweet(sweet);
        assertEquals(weight, gift.getComponents().get(gift.getComponents().indexOf(sweet)).getWeight());
    }

    @Test
    @DisplayName("Test sortPresentByCalorie method in PresentBox class")
    void sortPresentByCalorieTest() {
        gift.sortPresentByCalorie();
        assertEquals(0,gift.getComponents().indexOf(sweet2));
    }

    @Test
    @DisplayName("Test getComponents method in PresentBox class")
    void getComponentsTest() {
        List<Sweet> sweets = new ArrayList<Sweet>();
        sweets.add(sweet);
        sweets.add(sweet2);
        assertEquals(sweets, gift.getComponents());
    }


    @Test
    @DisplayName("Test sortPresentByWeight method in PresentBox class")
    void sortPresentByWeightTest() {
        gift.sortPresentByWeight();
        assertEquals(0,gift.getComponents().indexOf(sweet));
    }

    @Test
    @DisplayName("Test sortPresentBySugarLevel method in PresentBox class")
    void sortPresentBySugarLevelTest() {
        gift.sortPresentBySugarLevel();
        assertEquals(0,gift.getComponents().indexOf(sweet2));
    }


    @Test
    @DisplayName("Test ToString method in PresentBox class")
    void testToString() {
        final String str = "PresentBox{" +
                "id=" + 2 +
                ", shape=" + "SQUARE" +
                ", color='" + "red" + '\'' +
                ", components=" + gift.getComponents() +
                '}';
        assertNotEquals(str,gift);
    }
}