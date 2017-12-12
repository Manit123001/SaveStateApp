package com.manit.krungsri.savestateapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.manit.krungsri.savestateapp.R;
import com.manit.krungsri.savestateapp.bus.BusProvider;
import com.manit.krungsri.savestateapp.model.Profile;
import com.manit.krungsri.savestateapp.model.Teacher;
import com.manit.krungsri.savestateapp.network.NetworkConnectionManager;
import com.manit.krungsri.savestateapp.view.MyTextView;
import com.squareup.otto.Subscribe;

import org.parceler.Parcels;

public class DetailActivity extends AppCompatActivity {
    public static final String KEY_PROFILE = "key_profile";

    private LinearLayout layoutProgressLoading;
    private LinearLayout layoutUserProfile;
    private TextView tvUserLevel;
    private TextView tvUserName;
    private TextView tvUserJob;

    private Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        bindView();

        if (savedInstanceState == null) {
            callServer();
        } else {
            Toast.makeText(this, "instance State is doing", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        BusProvider.getInstance().register(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        BusProvider.getInstance().unregister(this);

    }

    private void bindView() {
        layoutProgressLoading = (LinearLayout) findViewById(R.id.layout_progress_loading);
        layoutUserProfile = (LinearLayout) findViewById(R.id.layout_user_profile);
        tvUserName = (TextView) findViewById(R.id.tv_user_name);
        tvUserJob = (TextView) findViewById(R.id.tv_user_job);
        tvUserLevel = (MyTextView) findViewById(R.id.tv_user_level);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(KEY_PROFILE, Parcels.wrap(profile));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        profile = Parcels.unwrap(savedInstanceState.getParcelable(KEY_PROFILE));
    }

    private void callServer() {
        showLoading();
        NetworkConnectionManager.getUserProfile();
    }

    @Subscribe
    public void onUserProfileCallback(Profile profile) {
        if (profile != null) {
            this.profile = profile;
            showUserProfile();
            setProfileDetail(profile);
        }
    }

    private void setProfileDetail(Profile profile) {
        Profile.Character character = profile.getCharacter();

        tvUserName.setText(character.getName());
        tvUserJob.setText(character.getJob());
        tvUserLevel.setText(String.valueOf(character.getLevel()));
        tvUserLevel.setBackgroundResource(getUserTribeColor(character));
    }

    private void showLoading() {
        layoutUserProfile.setVisibility(View.GONE);
        layoutProgressLoading.setVisibility(View.VISIBLE);
    }

    private void showUserProfile() {
        layoutUserProfile.setVisibility(View.VISIBLE);
        layoutProgressLoading.setVisibility(View.GONE);
    }

    private int getUserTribeColor(Profile.Character character) {
        if (character.getTribe().equalsIgnoreCase("DEVIL")) {
            return R.drawable.shape_oval_red;
        } else {
            Toast.makeText(this, "Text not devil", Toast.LENGTH_SHORT).show();
            return R.drawable.shape_oval_gray;
        }
    }
}
