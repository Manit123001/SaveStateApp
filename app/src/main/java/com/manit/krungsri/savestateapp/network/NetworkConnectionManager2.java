package com.manit.krungsri.savestateapp.network;

import android.os.Handler;

import com.manit.krungsri.savestateapp.bus.BusProvider;
import com.manit.krungsri.savestateapp.model.Profile;
import com.manit.krungsri.savestateapp.model.Teacher;

public class NetworkConnectionManager2 {

    public static void getUserProfile() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Teacher.Character character = new Teacher.Character();
                character.setName("Anonymous Wizard");
                character.setJob("Wizard");
                character.setLevel(98);
                character.setExp(1234566);
                character.setTribe("DEVIL");

                Teacher profile = new Teacher();
                profile.setId("sleepingforless");
                profile.setCharacter(character);

                BusProvider.getInstance().post(profile);
            }
        }, 3000);
    }
}
