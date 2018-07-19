package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")

public class hellocontroller {
	private final static  Logger log =  LoggerFactory.getLogger(hellocontroller.class);
    @RequestMapping
    public String hello() {
        return "Hello Spring-Boot";
    }

    @RequestMapping("/info")
    public Map<String, String> getInfo(@RequestParam String name) {
    	log.debug(name);
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        return map;
    }

    @RequestMapping("/list")
    public List<Map<String, String>> getList() {
    	log.debug("list读取");
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = null;
        for (int i = 1; i <= 5; i++) {
            map = new HashMap<>();
            map.put("name", "Shanhy-" + i);
            list.add(map);
            log.debug(map.get("name"));
        }
        
        return list;
    }
    @RequestMapping("/log")
    public String log_test() {
    	log.debug("debug");
    	log.error("error");
    	log.info("info");
    	
    	return "ok";
    	
    }
    
	@Value("${jp.evni.stationId}")
	private String statinid;
	
    @RequestMapping("/test")
    public String getStationID() {

    	return statinid;
    }

}
