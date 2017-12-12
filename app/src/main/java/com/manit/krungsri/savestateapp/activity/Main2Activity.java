package com.manit.krungsri.savestateapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.manit.krungsri.savestateapp.R;
import com.manit.krungsri.savestateapp.model.Student;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        Student c3 = intent.getParcelableExtra("cParcelable");
        Log.d("main", String.valueOf(c3.getId()));
        Log.d("main", c3.getSubject());
        Log.d("main", c3.getDetail());

    }
}
