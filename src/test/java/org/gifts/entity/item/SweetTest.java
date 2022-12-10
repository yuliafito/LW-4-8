package org.gifts.entity.item;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SweetTest {

    Sweet sweet = new ChocolateCandy(1,  1,  1,  "MonblanGreen",  350.0F,  " ",  true,  46.9F,
            0.2F,  559,  72.3F,  false,  true, ChocolateCandyFillers.VANILLA_CREAM);
    @Test
    @DisplayName("Test getId method in Sweet class")
    void getIdTest() {
        assertEquals(1, sweet.getId());
    }

    @Test
    @DisplayName("Test getTitle method in Sweet class")
    void getTitleTest() {
        assertEquals("MonblanGreen", sweet.getTitle());
    }

    @Test
    @DisplayName("Test getPrice method in Sweet class")
    void getPriceTest() {
        assertEquals(350.0F, sweet.getPrice());
    }

    @Test
    @DisplayName("Test getSugarLevel method in Sweet class")
    void getSugarLevelTest() {
        assertEquals(46.9F, sweet.getSugarLevel());
    }

    @Test
    @DisplayName("Test getWeight method in Sweet class")
    void getWeightTest() {
        assertEquals(0.2F, sweet.getWeight());
    }

    @Test
    @DisplayName("Test getCalorieContent method in Sweet class")
    void getCalorieContentTest() {
        assertEquals(559, sweet.getCalorieContent());
    }

    @Test
    @DisplayName("Test getCurrentPrice method in Sweet class")
    void getCurrentPriceTest() {
        assertEquals(70, sweet.getCurrentPrice());
    }

    @Test
    @DisplayName("Test setPrice method in Sweet class")
    void setSugarLevelTest() {
        float sugarLevel = 10.3F;
        sweet.setSugarLevel(sugarLevel);
        assertEquals(10.3F, sweet.getSugarLevel());
    }
    @Test
    @DisplayName("Test setPrice method in Sweet class")
    void setWeightTest() {
        float weight = 0.3F;
        sweet.setWeight(weight);
        assertEquals(0.3F, sweet.getWeight());
    }

    @Test
    @DisplayName("Test setCalorieContent method in Sweet class")
    void setCalorieContentTest() {
        int calorieContent = 300;
        sweet.setCalorieContent(calorieContent);
        assertEquals(300, sweet.getCalorieContent());
    }

    @Test
    @DisplayName("Test setPrice method in Sweet class")
    void setPriceTest() {
        float price = 20.3F;
        sweet.setPrice(price);
        assertEquals(20.3F, sweet.getPrice());
    }

    @Test
    @DisplayName("Test setId method in Sweet class")
    void setIdTest() {
        int id = 1;
        sweet.setId(id);
        assertEquals(1, sweet.getId());
    }

    @Test
    @DisplayName("Test setManufacturerId method in Sweet class")
    void setManufacturerIdTest() {
        int id = 1;
        sweet.setManufacturerId(id);
        assertEquals(1, sweet.getManufacturerId());
    }

    @Test
    @DisplayName("Test setCategoryId method in Sweet class")
    void setCategoryIdTest() {
        int id = 1;
        sweet.setCategoryId(id);
        assertEquals(1, sweet.getCategoryId());
    }
    @Test
    @DisplayName("Test setTitle method in Sweet class")
    void setTitleTest() {
        String str = "Snikers";
        sweet.setTitle(str);
        assertEquals("Snikers", sweet.getTitle());
    }
    @Test
    @DisplayName("Test setDescription method in Sweet class")
    void setDescriptionTest() {
        String str = "Very tasty candy";
        sweet.setDescription(str);
        assertEquals("Very tasty candy", sweet.getDescription());
    }
    @Test
    @DisplayName("Test setAvailable method in Sweet class")
    void setAvailableTest() {
        boolean isAvailable = true;
        sweet.setAvailable(isAvailable);
        assertEquals(true, sweet.isAvailable());
    }
}