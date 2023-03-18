package com.github.berdenson.lgbrqpflaggame;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;

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

        JSONArray ja = (JSONArray) jo.get("flags");

//        for (int i = 0; i < ja.size(); i++) {
//            String name = jo.get(i).getString("name");
//            System.out.println(name);
//        }

        addFlag("example", "www.example.com");

        Iterator itr2 = ja.iterator();

        Iterator<Map.Entry> itr1;

        while (itr2.hasNext()) {

            itr1 = ((Map) itr2.next()).entrySet().iterator();
            ArrayList<String> identity = new ArrayList<String>();

            while (itr1.hasNext()) {
                Map.Entry pair = itr1.next();
                identity.add((String) pair.getValue());
            }

            if (identity.size() == 2) {
                if (!identity.get(1).equals("")) {
                    addFlag(identity.get(0), identity.get(1));
                    System.out.println(identity.get(0) + " " + identity.get(1));
                }
            }

        }

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
        String path = URLDecoder.decode(String.valueOf(Flags.class.getResource(name)), StandardCharsets.UTF_8).substring(5);
        return new FileReader(path);

    }
}
