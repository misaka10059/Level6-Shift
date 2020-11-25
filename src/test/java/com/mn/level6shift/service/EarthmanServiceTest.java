package com.mn.level6shift.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mn.level6shift.Level6ShiftApplication;
import com.mn.level6shift.domain.entity.primary.Earthman;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * AUTHOR MisakaNetwork
 * DATE 2020/11/25 9:38
 * DESC
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Level6ShiftApplication.class)
@WebAppConfiguration
public class EarthmanServiceTest {

    @Autowired
    private EarthmanService earthmanService;

    @Autowired
    private Gson gson;

    @Test
    public void listSortedPattern1() {
        List<Earthman> list = earthmanService.listSortedPattern1("人造人");
        System.out.println("listSortedPattern1:");
        printList(list);
    }

    @Test
    public void listSortedPattern2() {
        List<Earthman> list = earthmanService.listSortedPattern2("人造人");
        System.out.println("listSortedPattern2:");
        printList(list);
    }

    @Test
    public void listSortedPattern3() {
        List<Earthman> list = earthmanService.listSortedPattern3("人造人");
        System.out.println("listSortedPattern3:");
        printList(list);
    }

    @Test
    public void listSortedPattern4() {
        List<Earthman> list = earthmanService.listSortedPattern4("人造人");
        System.out.println("listSortedPattern4:");
        printList(list);
    }

    private void printList(List<Earthman> list) {
        for (Earthman earthman : list) {
            String json = gson.toJson(earthman);
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = jsonParser.parse(json).getAsJsonObject();
            JsonElement jsonElement = jsonParser.parse(json);
            System.out.println(gson.toJson(jsonElement));
        }
    }
}