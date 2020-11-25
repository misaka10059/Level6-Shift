package com.mn.level6shift.controller;

import com.mn.level6shift.service.EarthmanService;
import com.mn.level6shift.service.SaiyanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * AUTHOR MisakaNetwork
 * DATE 2020/10/30 11:32
 * DESC
 */
@Api("测试")
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private EarthmanService earthmanService;

    @Autowired
    private SaiyanService saiyanService;

    @ApiOperation("earth")
    @RequestMapping(value = "/addEarthman", method = RequestMethod.GET)
    public Object addEarthman(@RequestParam String name) {
        return earthmanService.add(name);
    }

    @ApiOperation("earth")
    @RequestMapping(value = "/addSaiyan", method = RequestMethod.GET)
    public Object addSaiyan(@RequestParam String name) {
        return saiyanService.add(name);
    }

    @ApiOperation("earth")
    @RequestMapping(value = "/listEarthman", method = RequestMethod.GET)
    public Object listEarthman() {
        return earthmanService.list();
    }

    @ApiOperation("earth")
    @RequestMapping(value = "/listEarthmanByParameter", method = RequestMethod.GET)
    public Object listEarthmanByParameter(@RequestParam("name") String name) {
        return earthmanService.listSortedPattern1(name);
    }

    @ApiOperation("earth")
    @RequestMapping(value = "/listSaiyan", method = RequestMethod.GET)
    public Object listSaiyan() {
        return saiyanService.list();
    }
}
