package com.github.berdenson.lgbrqpflaggame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Flags {
    public static ArrayList<Flag> flags = new ArrayList<>();

    public static void setFlags(){
        addFlag("A-spec","https://static.wikia.nocookie.net/lgbtqia-sandbox/images/d/d8/A-spec_main_flag.svg/revision/latest?cb=20220217141655");

    }
    private static void addFlag(String name, String url) {
        flags.add(new Flag(name,HelloApplication.newURL(url)));
    }
    public static Flag getRandomFlag() {
        Random random = new Random();
        return flags.get(random.nextInt(flags.size()));
    }
}
