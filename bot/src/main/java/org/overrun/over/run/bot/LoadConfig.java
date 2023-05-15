package org.overrun.over.run.bot;

import com.google.gson.Gson;

public class LoadConfig {
    public static final Gson gson = new Gson();
//    public static final  Config config;
    public LoadConfig() {
        System.out.println(SimBotImpl.class.getResourceAsStream("config.json"));
    }

}
