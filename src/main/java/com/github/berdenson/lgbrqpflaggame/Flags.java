package com.github.berdenson.lgbrqpflaggame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Flags {
    public static ArrayList<Flag> flags = new ArrayList<>();

    public static void setFlags(){
        addFlag("A-spec","https://static.wikia.nocookie.net/lgbtqia-sandbox/images/d/d8/A-spec_main_flag.svg/revision/latest?cb=20220217141655");
        addFlag("Abroromantic", "https://static.wikia.nocookie.net/lgbtqia-sandbox/images/9/9b/Abroromantic_flag.png/revision/latest/scale-to-width-down/1000?cb=20220220003743");
        addFlag("Aceflux", "https://static.wikia.nocookie.net/lgbtqia-sandbox/images/8/8f/Aceflux.png/revision/latest?cb=20220218164553");
        addFlag("Achillean", "https://static.wikia.nocookie.net/lgbtqia-sandbox/images/a/a9/Achillean_Flag.svg/revision/latest/scale-to-width-down/1000?cb=20220123044402");
        addFlag("Aegoromantic", "https://static.wikia.nocookie.net/lgbtqia-sandbox/images/8/8f/Aegoromantic.png/revision/latest/scale-to-width-down/1000?cb=20221020134710");
        addFlag("Aegosexual", "https://static.wikia.nocookie.net/lgbtqia-sandbox/images/8/86/Aegosexual.png/revision/latest?cb=20220206222719");
        addFlag("Agender", "https://static.wikia.nocookie.net/lgbtqia-sandbox/images/6/68/Agender_4-stripe_Flag.svg/revision/latest/scale-to-width-down/1000?cb=20220123020041");
        addFlag("Agender", "https://static.wikia.nocookie.net/lgbtqia-sandbox/images/0/04/Agender_Flag.svg/revision/latest/scale-to-width-down/1000?cb=20220123020312");
        addFlag("Agender Spectrum", "https://static.wikia.nocookie.net/lgbtqia-sandbox/images/d/d6/Agender_Spectrum_Flag.png/revision/latest?cb=20220227015427");

    }
    private static void addFlag(String name, String url) {
        flags.add(new Flag(name,url));
    }
    public static Flag getRandomFlag() {
        Random random = new Random();
        return flags.get(random.nextInt(flags.size()));
    }
}
