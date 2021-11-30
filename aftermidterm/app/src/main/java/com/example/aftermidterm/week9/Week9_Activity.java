package com.example.aftermidterm.week9;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aftermidterm.R;

public class Week9_Activity extends AppCompatActivity {



    // 실습
    private Button btn1, btn2, btn3, btn4, button;

    // 실습예제
    private TextView tvName, tvEmail, toastText;
    private EditText digEdtName, digEdtEmail;
    private View dialogView, toastView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week9_main);
        setTitle("9주차 - 대화상자");

        /**
         * 대화상자 만들어보기
         */
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dig = new AlertDialog.Builder(Week9_Activity.this);
                dig.setTitle("제목입니다");
                dig.setMessage("이곳이 내용입니다");
                dig.setIcon(R.mipmap.ic_launcher);
                dig.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Week9_Activity.this, "확인을 눌렀어요", Toast.LENGTH_SHORT).show();
                    }
                });
                dig.show();
            }
        });

        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] versionArray = new String[] {"파이", "Q(10)", "R(11)"};
                AlertDialog.Builder dig = new AlertDialog.Builder(Week9_Activity.this);
                dig.setTitle("좋아하는 버전은?");
                dig.setIcon(R.mipmap.ic_launcher);
                dig.setItems(versionArray, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        btn2.setText(versionArray[which]);
                    }
                });
                dig.setPositiveButton("닫기", null);
                dig.show();
            }
        });

        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] versionArray = new String[] {"파이", "Q(10)", "R(11)"};
                AlertDialog.Builder dig = new AlertDialog.Builder(Week9_Activity.this);
                dig.setTitle("좋아하는 버전은?");
                dig.setIcon(R.mipmap.ic_launcher);
                dig.setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        btn3.setText(versionArray[which]);
                    }
                });
                dig.setPositiveButton("닫기", null);
                dig.show();
            }
        });

        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] versionArray = new String[] {"파이", "Q(10)", "R(11)"};
                final boolean[] chechArray = new boolean[] {true, false, false};
                AlertDialog.Builder dig = new AlertDialog.Builder(Week9_Activity.this);
                dig.setTitle("좋아하는 버전은?");
                dig.setIcon(R.mipmap.ic_launcher);
                dig.setMultiChoiceItems(versionArray, chechArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        btn4.setText(versionArray[which]);
                    }
                });
                dig.setPositiveButton("닫기", null);
                dig.show();
            }
        });

        /**
         * 실습 예제
         */
        tvName = (TextView) findViewById(R.id.tvName);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = (View) View.inflate(Week9_Activity.this, R.layout.dialog, null);
                AlertDialog.Builder dig = new AlertDialog.Builder(Week9_Activity.this);
                dig.setTitle("사용자 정보 입력");
                dig.setIcon(R.drawable.ic_menu_allfriends);
                dig.setView(dialogView);
                dig.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        digEdtName = (EditText) dialogView.findViewById(R.id.digEdtName);
                        digEdtEmail = (EditText) dialogView.findViewById(R.id.digEdtEmail);

                        tvName.setText(digEdtName.getText().toString());
                        tvEmail.setText(digEdtEmail.getText().toString());
                    }
                });
                dig.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = new Toast(Week9_Activity.this);
                        toastView = (View) View.inflate(Week9_Activity.this, R.layout.toast1, null);
                        toastText = (TextView) toastView.findViewById(R.id.toastText);
                        toastText.setText("취소했습니다");
                        toast.setView(toastView);
                        toast.show();
                    }
                });
                dig.show();
            }
        });
    }
}
