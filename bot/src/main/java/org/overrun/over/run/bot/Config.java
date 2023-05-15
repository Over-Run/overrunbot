package org.overrun.over.run.bot;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Config {
    @SerializedName("qq") public final ArrayList<Qq> qqs;
    @SerializedName("guild") public final ArrayList<Guild> guilds;
    @SerializedName("kook") public final ArrayList<Kook> kooks;

    public Config(ArrayList<Qq> qqs, ArrayList<Guild> guilds, ArrayList<Kook> kooks) {
        this.qqs = qqs;
        this.guilds = guilds;
        this.kooks = kooks;
    }

    public static class Qq {
        @SerializedName("user") private final long user;
        @SerializedName("password") private final String password;

        public Qq(long user, String password) {
            this.user = user;
            this.password = password;
        }
    }

    public static class Guild {
        @SerializedName("user") private final long user;
        @SerializedName("password") private final String password;

        public Guild(long user, String password) {
            this.user = user;
            this.password = password;
        }
    }

    public static class Kook {
        @SerializedName("user") private final long user;
        @SerializedName("password") private final String password;

        public Kook(long user, String password) {
            this.user = user;
            this.password = password;
        }
    }
}
