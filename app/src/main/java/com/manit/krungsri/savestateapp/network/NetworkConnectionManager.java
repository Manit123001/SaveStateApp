package com.manit.krungsri.savestateapp.network;

import android.os.Handler;

import com.manit.krungsri.savestateapp.bus.BusProvider;
import com.manit.krungsri.savestateapp.model.Profile;

public class NetworkConnectionManager {

    public static void getUserProfile() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Profile.Character character = new Profile.Character();
                character.setName("Anonymous Wizard");
                character.setJob("Wizard");
                character.setLevel(98);
                character.setExp(1234566);
                character.setTribe("DEVIL");

                Profile profile = new Profile();
                profile.setId("sleepingforless");
                profile.setCharacter(character);

                BusProvider.getInstance().post(profile);
            }
        }, 3000);
    }
}
