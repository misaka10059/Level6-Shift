package com.mn.level6shift.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * AUTHOR MisakaNetwork
 * DATE 2020/11/25 10:22
 * DESC
 */
@Service
public class GsonUsage {

    @Autowired
    private Gson gson;

    public void mapToJson() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "一方通行");
        map.put(2, "桓根帝督");
        map.put(3, "御坂美琴");
        String json = gson.toJson(map);
        System.out.println("json:" + json);
    }

    public void jsonToMap() {
        String str = "{1:\"一方通行\",2:\"桓根帝督\",3:\"御坂美琴\"}";
        Map map = gson.fromJson(str, Map.class);
        System.out.println("map:" + map);
    }
}
