package src.com.mycompany.myapp.controller;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import src.com.mycompany.myapp.dto.Car;

import java.io.IOException;
import java.util.List;

public class ParseJsonToObjTest {
    public Car getJson(String carJson, Car car) {
        String brandName = "brand";
        String doorsName = "doors";

        String brandValue = "brand";
        int doorsValue = 0;

        JsonFactory factory = new JsonFactory();
        JsonParser parser = null;
        try {
            parser = factory.createParser(carJson);
            while (!parser.isClosed()) {
                JsonToken jsonToken = parser.nextToken();

                if (JsonToken.FIELD_NAME.equals(jsonToken)) {
                    String fieldName = parser.getCurrentName();
                    jsonToken = parser.nextToken();

                    if (brandName.equals(fieldName)) {
                        brandValue = parser.getValueAsString();
                    }
                    if (doorsName.equals(fieldName)) {
                        doorsValue = parser.getValueAsInt();

                        car.setBrand(brandValue);
                        car.setDoors(doorsValue);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return car;
    }

    public void getJsonList(String carJson, List<Car> carList) {

        String brandName = "brand";
        String doorsName = "doors";

        String brandValue = "brand";
        int doorsValue = 0;

        JsonFactory factory = new JsonFactory();
        JsonParser parser = null;
        try {
            parser = factory.createParser(carJson);
            while (!parser.isClosed()) {
                JsonToken jsonToken = parser.nextToken();

                if (JsonToken.FIELD_NAME.equals(jsonToken)) {
                    String fieldName = parser.getCurrentName();
                    System.out.println(fieldName);
                    jsonToken = parser.nextToken();

                    if (brandName.equals(fieldName)) {
                        brandValue = parser.getValueAsString();
                    }
                    if (doorsName.equals(fieldName)) {
                        doorsValue = parser.getValueAsInt();

                        Car car = new Car(brandValue, doorsValue);
                        carList.add(car);

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}