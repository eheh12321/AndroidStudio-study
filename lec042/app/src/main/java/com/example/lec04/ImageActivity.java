package com.example.lec04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ImageActivity extends AppCompatActivity {

    TextView text1, text2;
    CheckBox chk;
    RadioGroup rGroup1;
    RadioButton radio_Dog, radio_Cat, radio_Fox;
    Button btnOK;
    ImageView imgPet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageview_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("애완동물 사진 보기");

        text1 = (TextView) findViewById(R.id.img_text_1);
        text2 = (TextView) findViewById(R.id.img_text_2);

        chk = (CheckBox) findViewById(R.id.checkBox);

        rGroup1 = (RadioGroup) findViewById(R.id.rRgroup);
        radio_Dog = (RadioButton) findViewById(R.id.radio_dog);
        radio_Cat = (RadioButton) findViewById(R.id.radio_cat);
        radio_Fox = (RadioButton) findViewById(R.id.radio_fox);

        btnOK = (Button) findViewById(R.id.btn_ok);
        imgPet = (ImageView) findViewById(R.id.imageView);

        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chk.isChecked()) {
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    btnOK.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                } else {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    btnOK.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                    // RadioButton 체크해제
                    radio_Dog.setChecked(false);
                    radio_Cat.setChecked(false);
                    radio_Fox.setChecked(false);
                    // ImageView 해제
                    imgPet.setImageResource(0);
                }
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (rGroup1.getCheckedRadioButtonId()) {
                    case R.id.radio_dog:
                        imgPet.setImageResource(R.drawable.dog);
                        break;
                    case R.id.radio_cat:
                        imgPet.setImageResource(R.drawable.cat);
                        break;
                    case R.id.radio_fox:
                        imgPet.setImageResource(R.drawable.fox);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물을 선택하세요",
                                Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
