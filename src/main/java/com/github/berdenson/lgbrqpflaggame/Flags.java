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
    public static ArrayList<Flag> countryFlags = new ArrayList<>();

    /**
     * Adds the flags to a list, should only be run once.
     * @throws IOException
     * @throws ParseException
     */
    public static void setFlags() throws IOException, ParseException {
        addFile("aro flags.json");
        addFile("aroace flags.json");
        addFile("lgbtqia flags.json");
        addFile("xenogender flags.json");
        addCountryFile();
    }

    /**
     * Adds a flag to the list.
     * @param name name of the identity/flag
     * @param url url linking to a picture of the flag
     */
    private static void addFlag(String name, String url) {
        flags.add(new Flag(name,url));
    }

    /**
     * Adds an entire file of flags to the list.
     * @param file - .json file
     * @throws IOException
     * @throws ParseException
     */
    public static void addFile(String file) throws IOException, ParseException {
        // parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(getRes(file));

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;

        JSONArray ja = (JSONArray) jo.get("flags");

        Iterator itr2 = ja.iterator();

        Iterator<Map.Entry> itr1;

        while (itr2.hasNext()) {

            itr1 = ((Map) itr2.next()).entrySet().iterator();
            ArrayList<String> identity = new ArrayList<String>();

            /* adds each attribute sequentially to a small arraylist */
            while (itr1.hasNext()) {
                Map.Entry pair = itr1.next();
                identity.add((String) pair.getValue());
            }

            /*
             * makes sure that the identity is a full one (contains both a name and a url)
             * if so, it adds the identity to the list
             */
            if (identity.size() == 2) {
                if (!identity.get(1).equals("")) {
                    addFlag(identity.get(0), identity.get(1));
//                    System.out.println(identity.get(0) + " " + identity.get(1)); // prints out the identities
                }
            }

        }
    }

    /**
     * Adds the country file.
     * @throws IOException
     * @throws ParseException
     */
    public static void addCountryFile() throws IOException, ParseException {
        // parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(getRes("countries.json"));

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;

        JSONArray ja = (JSONArray) jo.get("flags");

        Iterator itr2 = ja.iterator();

        Iterator<Map.Entry> itr1;

        while (itr2.hasNext()) {

            itr1 = ((Map) itr2.next()).entrySet().iterator();
            ArrayList<String> identity = new ArrayList<String>();

            /* adds each attribute sequentially to a small arraylist */
            while (itr1.hasNext()) {
                Map.Entry pair = itr1.next();
                identity.add((String) pair.getValue());
            }

            countryFlags.add(new Flag(identity.get(2),identity.get(0)));
        }
    }

    /**
     * Gets a random flag
     * @return a random flag
     */
    public static Flag getRandomFlag() {
        Random random = new Random();

        /* random chance to generate a country flag (1 in 100) */
        if(random.nextInt(100) == 1) {
            int max = 1;
            if (countryFlags.size() != 0) { max = countryFlags.size(); }
            return countryFlags.get(random.nextInt(max));
        }

        int max = 1;
        if (flags.size() != 0) { max = flags.size(); }
        return flags.get(random.nextInt(max));
    }
    private static FileReader getRes(String name) throws FileNotFoundException {
        String path = URLDecoder.decode(String.valueOf(Flags.class.getResource(name)), StandardCharsets.UTF_8).substring(5);
        return new FileReader(path);

    }
}
