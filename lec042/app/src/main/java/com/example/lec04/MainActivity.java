package com.example.lec04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button calcButton, imgButton, layoutButton, clockButton, confirmButton;
    RadioButton male, female;
    TextView tv1, tv2, tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Hello, Android Studio!");

        calcButton = (Button) findViewById(R.id.btn_calc);
        imgButton = (Button) findViewById(R.id.btn_img);
        layoutButton = (Button) findViewById(R.id.btn_layout);
        clockButton = (Button) findViewById(R.id.btn_clock);
        confirmButton = (Button) findViewById(R.id.btn_confirm);

        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);

        clockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ClockActivity.class);
                startActivity(intent);
            }
        });

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CalculatorActivity.class);
                startActivity(intent);
            }
        });

        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ImageActivity.class);
                startActivity(intent);
            }
        });

        layoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LayoutActivity.class);
                startActivity(intent);
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(male.isChecked()) {
                    Intent intent = new Intent(getApplicationContext(), Page_Male_Activity.class);
                    startActivity(intent);
                } else if (female.isChecked()) {
                    Intent intent = new Intent(getApplicationContext(), Page_Female_Activity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "성별을 선택하세요",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        String[] items = {"CSI-뉴욕", "CSI-LA", "CSI-마이애미", "Friends", "Fringe", "Lost"};

        AutoCompleteTextView auto = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapter
                = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items);
        auto.setAdapter(adapter);

        MultiAutoCompleteTextView multi = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);
        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();
        multi.setTokenizer(token);
        multi.setAdapter(adapter);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);

        tv1.setText("안녕하세요");
        tv1.setTextColor(Color.RED);

        tv2.setTextSize(30);
        tv2.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC);

        tv3.setText("가나다라마바사아자차카타파하");
        tv3.setSingleLine();
    }
}