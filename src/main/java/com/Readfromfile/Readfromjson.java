package com.Readfromfile;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Readfromjson {

    public String readFile(String attribute) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader read = new FileReader(System.getProperty("user.dir")+"/TestData/jsonData.json");
        Object obj = jsonParser.parse(read);

        JSONObject jsonObject =(JSONObject) obj;
        String value =jsonObject.get(attribute).toString();
        return value;
    }
}
