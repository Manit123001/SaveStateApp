package com.manit.krungsri.savestateapp.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.manit.krungsri.savestateapp.R;
import com.manit.krungsri.savestateapp.model.Student;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHello = findViewById(R.id.btnHello);
        btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                //Parcelable
                Student c3 = new Student();
                c3.setId(1);
                c3.setDetail("hello");
                c3.setSubject("manit");
                intent.putExtra("cParcelable", c3);
                startActivity(intent);
            }
        });



    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_UP){
            startActivity(new Intent(this, DetailActivity.class));
        }
        return super.onTouchEvent(event);
    }
}
