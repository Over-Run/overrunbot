package org.overrun.over.run.bot;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ConfigInit {

    public static final File file = new File(System.getProperty("user.dir"), "config");
    public static final File path = new File(file, "config.json");
    public static final Gson gson = new Gson();

    public static final Type type = new TypeToken<Map<String, String>>(){}.getType();
    public Map<String, String> map = new HashMap<>();
    @SuppressWarnings("ResultOfMethodCallIgnored")
    protected ConfigInit() {
        if (!file.exists()) file.mkdirs();
        if (!path.exists()) try {
            path.createNewFile();
        } catch (IOException e) {
            System.err.println(path);
        }
        try {
            map.putAll(gson.fromJson(new FileReader(file), type));
        } catch (FileNotFoundException e) {
            System.err.println(path);
        }
    }
    //初始化配置
    public void init() {
        map.put("mode", "all");//用逗号分割分别为qq，频道，kook的可用性配置
        /*
        all   -->为所有通用
        qq 为只启用qq
        qq,guild 为启用qq和guild
        */
        map.put("qq.user", "user_name");
        map.put("qq.password", "password");
        map.put("guild.user", "user_name");
        map.put("guild.password", "password");
        map.put("kook.user", "user_name");
        map.put("kook.password", "password");
        try {
            save();
        } catch (IOException e) {
            System.err.println(this.getClass());
        }
    }

    public void save() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        bw.write(gson.toJson(map));
        bw.close();
    }

}
