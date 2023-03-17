package com.github.berdenson.lgbrqpflaggame;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;


public class Flags {
    public static ArrayList<Flag> flags = new ArrayList<>();

    public static void setFlags() throws IOException, ParseException {

        // parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(getRes("aro flags.json"));

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;

//        System.out.println(obj);
//        for (int i = 0; i < 5; i++) {
//            addFlag((String) jo.get("name"), (String) jo.get("flagIMG"));
//        }
        addFlag("example", "www.example.com");

    }
    private static void addFlag(String name, String url) {
        flags.add(new Flag(name,url));
    }
    public static Flag getRandomFlag() {
        Random random = new Random();
        int max = 1;
        if (flags.size() != 0) { max = flags.size(); }
        return flags.get(random.nextInt(max));
    }
    private static FileReader getRes(String name) throws FileNotFoundException {
        String path = URLDecoder.decode(String.valueOf(Flags.class.getResource(name)), StandardCharsets.UTF_8).split(":")[1];
        return new FileReader(path);

    }
}
