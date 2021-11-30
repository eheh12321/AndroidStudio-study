package com.example.lec04;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Page_Male_Activity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5;
    TextView tvName, tvEmail;
    EditText digEdtName, digEdtEmail;
    TextView toastText;
    View dialogView, toastView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_male);
        setTitle("맨홀");
        
        btn1 = (Button) findViewById(R.id.pm_btn1);
        btn2 = (Button) findViewById(R.id.pm_bth2);
        btn3 = (Button) findViewById(R.id.pm_btn3);
        btn4 = (Button) findViewById(R.id.pm_btn4);
        btn5 = (Button) findViewById(R.id.pm_btn5);

        tvName = (TextView) findViewById(R.id.pm_tv1);
        tvEmail = (TextView) findViewById(R.id.pm_tv2);

        /**
         * 단순 대화상자 팝업
         */
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dig = new AlertDialog.Builder(Page_Male_Activity.this);
                dig.setTitle("제목입니다");
                dig.setMessage("내용입니다");
                dig.setIcon(R.mipmap.ic_launcher);
                dig.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    /**
                     * 확인버튼 클릭 시 Toast 메시지 출력
                     */
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Page_Male_Activity.this, "확인을 눌렀군요", Toast.LENGTH_SHORT).show();
                    }
                });
                dig.show();
            }
        });

        /**
         *  단순 리스트 대화상자
         */
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] versionArray = new String[] {"파이", "Q(10)", "R(11)"};
                AlertDialog.Builder dig = new AlertDialog.Builder(Page_Male_Activity.this);
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

        /**
         * 라디오버튼 대화상자
         */
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] versionArray = new String[] {"파이", "Q(10)", "R(11)"};
                AlertDialog.Builder dig = new AlertDialog.Builder(Page_Male_Activity.this);
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

        /**
         * 체크박스 대화상자 (중복선택 가능)
         */
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] versionArray = new String[] {"파이", "Q(10)", "R(11)"};
                final boolean[] checkArray = new boolean[] {false, false, false};
                AlertDialog.Builder dig = new AlertDialog.Builder(Page_Male_Activity.this);
                dig.setTitle("좋아하는 버전은?");
                dig.setIcon(R.mipmap.ic_launcher);
                dig.setMultiChoiceItems(versionArray, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        btn4.setText(versionArray[which]);
                    }
                });
                dig.setPositiveButton("닫기", null);
                dig.show();
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 다른 XML파일 뷰 가져오기
                dialogView = (View) View.inflate(Page_Male_Activity.this, R.layout.dialog1, null);
                // 대화상자 띄우기
                AlertDialog.Builder dig = new AlertDialog.Builder(Page_Male_Activity.this);
                dig.setTitle("사용자 정보 입력");
                dig.setIcon(R.mipmap.ic_launcher);
                dig.setView(dialogView);
                dig.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        digEdtName = (EditText) dialogView.findViewById(R.id.pm_dialog_edtName);
                        digEdtEmail = (EditText) dialogView.findViewById(R.id.pm_dialog_edtEmail);

                        tvName.setText(digEdtName.getText().toString());
                        tvEmail.setText(digEdtEmail.getText().toString());
                    }
                });
                dig.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = new Toast(Page_Male_Activity.this);
                        // 다른 XML파일 뷰 가져오기
                        toastView = (View) View.inflate(Page_Male_Activity.this, R.layout.toast1, null);
                        toastText = (TextView) toastView.findViewById(R.id.pm_toast_tv1);
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
