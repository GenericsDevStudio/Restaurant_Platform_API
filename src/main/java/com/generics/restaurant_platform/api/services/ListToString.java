package com.generics.restaurant_platform.api.services;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.persistence.AttributeConverter;
import java.util.ArrayList;
import java.util.Map;

@Service("listToString")
public class ListToString implements AttributeConverter<ArrayList<Map<String, Object>>, String> {
    @Override
    public String convertToDatabaseColumn(ArrayList<Map<String, Object>> maps) {
        JSONArray array = new JSONArray();
        maps.forEach(mp -> {
            array.put(mp);
        });
        return array.toString();
    }

    @Override
    public ArrayList<Map<String, Object>> convertToEntityAttribute(String s) {
        System.out.println(s);
        JSONArray array = new JSONArray(s);
        ArrayList<Map<String, Object>> list = new ArrayList<>();

        array.forEach(o -> {
            JSONObject jsonObject = (JSONObject)o;
            Map<String, Object> map = jsonObject.toMap();
            list.add(map);
        });

        return list;
    }

}