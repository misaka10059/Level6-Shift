package com.mn.level6shift.service;

import com.mn.level6shift.Level6ShiftApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * AUTHOR MisakaNetwork
 * DATE 2020/11/25 10:48
 * DESC
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Level6ShiftApplication.class)
@WebAppConfiguration
public class GsonUsageTest {

    @Autowired
    private GsonUsage gsonUsage;

    @Test
    public void mapToJson() {
        gsonUsage.mapToJson();
    }

    @Test
    public void jsonToMap() {
        gsonUsage.jsonToMap();
    }
}