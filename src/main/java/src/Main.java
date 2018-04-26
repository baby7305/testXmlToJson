package src;

import src.com.mycompany.myapp.controller.ParseJsonToObjTest;
import src.com.mycompany.myapp.dto.Car;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
        Car carTest = new Car();
        new ParseJsonToObjTest().getJson(carJson, carTest);
        System.out.println(carTest);

        String carJson1=
                "[{ \"brand\" : \"Mercedes\", \"doors\" : 5 }, { \"brand\" : \"Mercedes\", \"doors\" : 5 }]";
        List<Car> carList=new ArrayList<Car>();
        new ParseJsonToObjTest().getJsonList(carJson,carList);
        for (int i = 0; i < carList.size(); i++) {
            System.out.println(carList.get(i));
        }
        String test="hello world";
    }
}
