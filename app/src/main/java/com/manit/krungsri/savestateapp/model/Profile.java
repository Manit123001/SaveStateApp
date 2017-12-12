package com.manit.krungsri.savestateapp.model;

import org.parceler.Parcel;

/**
 * Created by Akexorcist on 10/4/15 AD.
 */
@Parcel
public class Profile {
    String id;
    Character character;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    @Parcel
    public static class Character {
        String name;
        String job;
        String tribe;
        int level;
        int exp;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getTribe() {
            return tribe;
        }

        public void setTribe(String tribe) {
            this.tribe = tribe;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getExp() {
            return exp;
        }

        public void setExp(int exp) {
            this.exp = exp;
        }
    }
}
