package com.github.berdenson.lgbrqpflaggame;

import java.io.FileNotFoundException;
import java.io.IOException;
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
        Object obj = new JSONParser().parse(new FileReader("JSONExample.json"));

        for (int i = 0; i < 5; i++) {
            
        }
            
        }
    }
    private static void addFlag(String name, String url) {
        flags.add(new Flag(name,url));
    }
    public static Flag getRandomFlag() {
        Random random = new Random();
        return flags.get(random.nextInt(flags.size()));
    }
}
