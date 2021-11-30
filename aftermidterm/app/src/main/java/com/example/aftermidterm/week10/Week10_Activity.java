package com.example.aftermidterm.week10;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aftermidterm.R;

public class Week10_Activity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4, btn5, webbtn;
    private EditText editUrl;
    private WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week10_main);
        setTitle("10주차 - 1 | 애니메이션");

        btn1 = (Button) findViewById(R.id.week10_btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
                v.startAnimation(anim);
            }
        });

        btn2 = (Button) findViewById(R.id.week10_btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
                v.startAnimation(anim);
            }
        });

        btn3 = (Button) findViewById(R.id.week10_btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                v.startAnimation(anim);
            }
        });

        btn4 = (Button) findViewById(R.id.week10_btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                v.startAnimation(anim);
            }
        });

        btn5 = (Button) findViewById(R.id.week10_btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale2);
                v.startAnimation(anim);

            }
        });

        /**
         * 웹뷰
         */
        webView = findViewById(R.id.week10_webview);
        editUrl = findViewById(R.id.week10_edtUrl);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new ViewClient());

        webbtn = findViewById(R.id.week10_webbtn);
        webbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(editUrl.getText().toString());
            }
        });
    }

    private class ViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
