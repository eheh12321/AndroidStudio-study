package com.example.aftermidterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aftermidterm.week10.Week10_2_Activity;
import com.example.aftermidterm.week10.Week10_Activity;
import com.example.aftermidterm.week11.Week11_Activity;
import com.example.aftermidterm.week9.Week9_2_Activity;
import com.example.aftermidterm.week9.Week9_Activity;

public class MainActivity extends AppCompatActivity {

    private Button btn_week9, btn_week9_2, btn_week10, btn_week10_2, btn_week11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_week9 = (Button) findViewById(R.id.btn_week9);
        btn_week9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Week9_Activity.class);
                startActivity(intent);
            }
        });

        btn_week9_2 = (Button) findViewById(R.id.btn_week9_2);
        btn_week9_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Week9_2_Activity.class);
                startActivity(intent);
            }
        });

        btn_week10 = (Button) findViewById(R.id.btn_week10);
        btn_week10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Week10_Activity.class);
                startActivity(intent);
            }
        });

        btn_week10_2 = (Button) findViewById(R.id.btn_week10_2);
        btn_week10_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Week10_2_Activity.class);
                startActivity(intent);
            }
        });

        btn_week11 = (Button) findViewById(R.id.btn_week11);
        btn_week11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Week11_Activity.class);
                startActivity(intent);
            }
        });
    }
}