package com.example.lec04;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class ClockActivity extends AppCompatActivity {

    Chronometer chrono;
    Button btnStart, btnEnd;
    RadioButton rdoCal, rdoTime;
    DatePicker datePicker;
    TimePicker timePicker;
    TextView tv;
    int selectYear, selectMonth, selectDay, selectHour, selectMin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clock_main);
        getSupportActionBar().hide(); // 액션바 숨기기

        btnStart = (Button) findViewById(R.id.clo_btnStart);
        btnEnd = (Button) findViewById(R.id.clo_btnEnd);
        chrono = (Chronometer) findViewById(R.id.clo_chronometer);
        rdoCal = (RadioButton) findViewById(R.id.clo_rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.clo_rdoTime);
        timePicker = (TimePicker) findViewById(R.id.clo_timePicker);
        datePicker = (DatePicker) findViewById(R.id.clo_calenderView);
        tv = (TextView) findViewById(R.id.clo_textView);

        timePicker.setVisibility(View.INVISIBLE);
        datePicker.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker.setVisibility(View.INVISIBLE);
                datePicker.setVisibility(View.VISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker.setVisibility(View.VISIBLE);
                datePicker.setVisibility(View.INVISIBLE);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);
                selectHour = timePicker.getHour();
                selectMin = timePicker.getMinute();
                tv.setText(selectYear + "년 " + selectMonth + "월 " + selectDay + "일 " + selectHour + "시 "
                        + selectMin + "분\n 정상적으로 예약되었습니다.");
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    selectYear = year;
                    selectMonth = monthOfYear + 1;
                    selectDay = dayOfMonth + 1;
                }
            });

        }
        tv.setText("현재 날짜: " + 2021 + "년 " + 10 + "월 " + 8 +"일");

   }
}
