import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseJsonToObjTest {
    public void getJson() {
        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";

        JsonFactory factory = new JsonFactory();
        JsonParser parser = null;
        try {
            parser = factory.createParser(carJson);

            Car car = new Car();
            while (!parser.isClosed()) {
                JsonToken jsonToken = parser.nextToken();

                if (JsonToken.FIELD_NAME.equals(jsonToken)) {
                    String fieldName = parser.getCurrentName();
                    System.out.println(fieldName);

                    jsonToken = parser.nextToken();

                    if ("brand".equals(fieldName)) {
                        car.setBrand(parser.getValueAsString());
                    } else if ("doors".equals(fieldName)) {
                        car.setDoors(parser.getValueAsInt());
                    }
                }
            }

            System.out.println("car.brand = " + car.getBrand());
            System.out.println("car.doors = " + car.getDoors());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void getJson1(String carJson) {
//        String carJson =
//                "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";

        JsonFactory factory = new JsonFactory();
        JsonParser parser = null;

        List<FetureDTO> fetureDTOList = new ArrayList<FetureDTO>();
        String fetureCode = "fetureCode";
        String fetureDesc = "fetureDesc";
        String familyDesc = "familyDesc";
        String familyCode = "familyCode";

        try {
            parser = factory.createParser(carJson);
            while (!parser.isClosed()) {
                JsonToken jsonToken = parser.nextToken();

                if (JsonToken.FIELD_NAME.equals(jsonToken)) {
                    String fieldName = parser.getCurrentName();
//                    System.out.println(fieldName);
                    jsonToken = parser.nextToken();

                    if ("FEATURECODE".equals(fieldName)) {
                        fetureCode = parser.getValueAsString();
                    }
                    if ("FEATUREDESC".equals(fieldName)) {
                        fetureDesc = parser.getValueAsString();
                    }
                    if ("FAMILYDESC".equals(fieldName)) {
                        familyDesc = parser.getValueAsString();
                    }
                    if ("FAMILYCODE".equals(fieldName)) {
                        familyCode = parser.getValueAsString();

                        FetureDTO fetureDTO = new FetureDTO(fetureCode, fetureDesc, familyDesc, familyCode);
                        fetureDTOList.add(fetureDTO);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < fetureDTOList.size(); i++) {
            System.out.println(fetureDTOList.get(i));
        }
    }
}
