package Backend;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFactory {

    public static Map<String, Randomizer> readJson() {
        JSONParser jsonParser = new JSONParser();
        Map<String, Randomizer> randomizerMap = new HashMap<>();
        try (FileReader reader = new FileReader("src/main/resources/savedRandomizers.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray savedRandomizers = (JSONArray) obj;
            System.out.println(savedRandomizers);

            //Iterate over employee array
            savedRandomizers.forEach( randomizerJSON -> {
                Randomizer randomizer = parserRandomizer((JSONObject) randomizerJSON);
                randomizerMap.put(randomizer.getId(), randomizer);
            });


        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return randomizerMap;
    }

    private static Randomizer parserRandomizer(JSONObject randomizerJSON) {
        String name = (String) randomizerJSON.get("name");
        String id = (String) randomizerJSON.get("id");
        List<String> entries = (List<String>) randomizerJSON.get("entries");

        return new Randomizer.Builder()
                .withName(name)
                .withId(id)
                .withEntries(entries)
                .build();
    }

    public static void writeJson(Map<String, Randomizer> randomizerMap) {
        JSONArray jsonArray = new JSONArray();
        randomizerMap.forEach((id, randomizer) -> {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", id);
            jsonObject.put("name", randomizer.getName());
            jsonObject.put("entries", randomizer.getEntries());
            jsonArray.add(jsonObject);
        });

        //Write JSON file
        try (FileWriter file = new FileWriter("src/main/resources/savedRandomizers.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(jsonArray.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
