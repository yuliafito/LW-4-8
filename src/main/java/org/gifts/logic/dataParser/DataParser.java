package org.gifts.logic.dataParser;

import org.gifts.entity.item.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataParser {
  public ArrayList<Sweet> readData(String path){

    ArrayList<Sweet> data = new ArrayList<Sweet>();
    try {
      JSONParser jsonParser = new JSONParser();
      JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(path));

      JSONArray jsonArray = (JSONArray) jsonObject.get("sweets");

      Iterator<JSONObject> iterator = jsonArray.iterator();

      while(iterator.hasNext()) {
        Sweet temp;
        JSONObject tempObj = iterator.next();
        long id = ((Long) tempObj.get("id")).intValue();
        long manufacturerId = ((Long) tempObj.get("manufacturerId")).intValue();
        long categoryId = ((Long) tempObj.get("categoryId")).intValue();
        String title = (String) tempObj.get("title");
        String pri = (String) tempObj.get("price");
        float price = Float.parseFloat(pri);
        float weight = 0.0F;//
        String description = (String) tempObj.get("description");
        boolean isAvailable = (Boolean) tempObj.get("isAvailable");
        float sugarLevel = (float)((Number)tempObj.get("sugarLevel")).doubleValue();
        int calorieContent = ((Long) tempObj.get("calorieContent")).intValue();
        int type = ((Long) tempObj.get("type")).intValue();

        if(type == 1){// 1 - ChocolateCandy
          float cocoaCount = (float)((Number)tempObj.get("cocoaCount")).doubleValue();
          boolean waffle = (Boolean) tempObj.get("waffle");
          boolean nuts = (Boolean) tempObj.get("nuts");
          String fillerName = (String) tempObj.get("filler");
          ChocolateCandyFillers filler = ChocolateCandyFillers.valueOf(fillerName) ;
          temp = new ChocolateCandy( id,  manufacturerId,  categoryId,  title,  price,  description,
                  isAvailable,  sugarLevel,  weight,  calorieContent,  cocoaCount,  waffle,  nuts,  filler);
          data.add(temp);
        }
        else if(type == 2){// 2 - Lollipop
          String fillerName = (String) tempObj.get("filler");
          LollipopFiller filler = LollipopFiller.valueOf(fillerName) ;
          String flavorName = (String) tempObj.get("flavor");
          SweetsFlavors flavor = SweetsFlavors.valueOf(flavorName) ;
          temp = new Lollipop( id,  manufacturerId,  categoryId,  title,  price,  description,
                  isAvailable,  sugarLevel,  weight,  calorieContent, flavor, filler);
          data.add(temp);
        }
        else if(type == 3){// 3 - Marshmallow
          String flavorName = (String) tempObj.get("flavor");
          SweetsFlavors flavor = SweetsFlavors.valueOf(flavorName) ;
          temp = new Marshmallow( id,  manufacturerId,  categoryId,  title,  price,  description,
                  isAvailable,  sugarLevel,  weight,  calorieContent, flavor);
          data.add(temp);
        }
      }
    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }
    return data;
  }
}
