package com.manit.krungsri.savestateapp.model;

import android.os.Parcelable;

import org.parceler.Parcel;

/**
 * Created by Akexorcist on 10/4/15 AD.
 */
public class Teacher implements Parcelable{
    String id;
    Character character;

    public Teacher() {
    }

    public Teacher(android.os.Parcel in) {
        id = in.readString();
        character = in.readParcelable(Character.class.getClassLoader());
    }

    public static final Creator<Teacher> CREATOR = new Creator<Teacher>() {
        @Override
        public Teacher createFromParcel(android.os.Parcel in) {
            return new Teacher(in);
        }

        @Override
        public Teacher[] newArray(int size) {
            return new Teacher[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeParcelable(character, i);
    }


    public static class Character implements Parcelable{
        String name;
        String job;
        String tribe;
        int level;
        int exp;

        public Character() {
        }

        public Character(android.os.Parcel in) {
            name = in.readString();
            job = in.readString();
            tribe = in.readString();
            level = in.readInt();
            exp = in.readInt();
        }

        public static final Creator<Character> CREATOR = new Creator<Character>() {
            @Override
            public Character createFromParcel(android.os.Parcel in) {
                return new Character(in);
            }

            @Override
            public Character[] newArray(int size) {
                return new Character[size];
            }
        };

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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeString(name);
            parcel.writeString(job);
            parcel.writeString(tribe);
            parcel.writeInt(level);
            parcel.writeInt(exp);
        }
    }
}
