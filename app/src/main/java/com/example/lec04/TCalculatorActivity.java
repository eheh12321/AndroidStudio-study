package com.example.lec04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TCalculatorActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button btnAdd, btnSub, btuMul, btnDiv, btnBack, btnEnter;
    TextView textResult;
    String num1, num2;
    Integer result;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {R.id.tc_btnNum0, R.id.tc_btnNum1, R.id.tc_btnNum2, R.id.tc_btnNum3,
    R.id.tc_btnNum4, R.id.tc_btnNum5, R.id.tc_btnNum6, R.id.tc_btnNum7, R.id.tc_btnNum8, R.id.tc_btnNum9};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_tablestyle_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("테이블 레이아웃 계산기");

        edit1 = (EditText) findViewById(R.id.editTextnumA);
        edit2 = (EditText) findViewById(R.id.editTextnumB);
        btnAdd = (Button) findViewById(R.id.tc_btnAdd);
        btnDiv = (Button) findViewById(R.id.tc_btnDiv);
        btnSub = (Button) findViewById(R.id.tc_btnSub);
        btuMul = (Button) findViewById(R.id.tc_btnMul);
        btnBack = (Button) findViewById(R.id.tc_btnBack);
        btnEnter = (Button) findViewById(R.id.tc_btnEnter);
        textResult = (TextView) findViewById(R.id.tc_textResult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result);
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result);
            }
        });

        btuMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result);
            }
        });

        for(int i = 0; i < numBtnIDs.length; i++) {
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);
        }

        for(int i = 0; i < numBtnIDs.length; i++) {

            final int index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(edit1.isFocused()) {
                        num1 = edit1.getText().toString()
                                + numButtons[index].getText().toString();
                        edit1.setText(num1);
                        edit1.setSelection(edit1.length());
                    } else if (edit2.isFocused()) {
                        num2 = edit2.getText().toString()
                                + numButtons[index].getText().toString();
                        edit2.setText(num2);
                        edit2.setSelection(edit2.length());
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "먼저 EditText를 선택하세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit1.isFocused()) {
                    num1 = edit1.getText().toString();
                    if(num1.length() >= 1) {
                        num1 = num1.substring(0, num1.length() - 1);
                    }
                    edit1.setText(num1);
                    edit1.setSelection(edit1.length());
                } else if (edit2.isFocused()) {
                    num2 = edit2.getText().toString();
                    if(num2.length() >= 1) {
                        num2 = num2.substring(0, num2.length() - 1);
                    }
                    edit2.setText(num2);
                    edit2.setSelection(num2.length());
                }
            }
        });

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit1.isFocused()) {
                    edit2.requestFocus();
                } else if (edit2.isFocused()) {
                    edit1.requestFocus();
                } else {
                    edit1.requestFocus();
                }
            }
        });
    }
}
