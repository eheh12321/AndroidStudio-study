package com.example.aftermidterm.week11;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aftermidterm.R;

public class Week11_2_Activity extends AppCompatActivity {

    ImageButton ibZoomin, ibZoomout, ibRotate, ibBright, ibDark, ibGray;
    MyGraphicView graphicView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week11_2_main);
        setTitle("11주차 - 2 | 포토샵");

        LinearLayout pictureLayout = (LinearLayout) findViewById(R.id.pictureLayout);
        graphicView = (MyGraphicView) new MyGraphicView(this);
        pictureLayout.addView(graphicView);

        clickIcons();
    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() / 2;

            canvas.scale(scaleX, scaleY, cenX, cenY);
            canvas.rotate(angle, cenX, cenY);

            Paint paint = new Paint();
            float[] array =
                    {color, 0, 0, 0, 0,
                    0, color, 0, 0, 0,
                    0, 0, color, 0, 0,
                    0, 0, 0, 1, 0};
            ColorMatrix cm = new ColorMatrix(array);
            if(satur == 0) {
                cm.setSaturation(satur);
            }
            paint.setColorFilter(new ColorMatrixColorFilter(cm));

            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.lena256);
            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;
            canvas.drawBitmap(picture, picX, picY, paint);

            picture.recycle();
        }
    }

    static float scaleX = 1, scaleY = 1;
    static float angle = 0;
    static float color = 1;
    static float satur = 1;

    private void clickIcons() {
        /**
         * Scale
         */
        ibZoomin = (ImageButton) findViewById(R.id.ibZoomin);
        ibZoomin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleX = scaleX + 0.2f;
                scaleY = scaleY + 0.2f;
                graphicView.invalidate();
            }
        });

        ibZoomout = findViewById(R.id.ibZoomout);
        ibZoomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleX = scaleX - 0.2f;
                scaleY = scaleY - 0.2f;
                if(scaleX <= 0) {
                    scaleX = scaleY = 0;
                }
                graphicView.invalidate();
            }
        });

        /**
         * angle
         */
        ibRotate = findViewById(R.id.ibRotate);
        ibRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angle = (angle + 20) % 360;

                graphicView.invalidate();
            }
        });

        /**
         * Color
         */
        ibBright = findViewById(R.id.ibBright);
        ibBright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color += 0.2f;
                graphicView.invalidate();
            }
        });

        ibDark = findViewById(R.id.ibDark);
        ibDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color -= 0.2f;
                graphicView.invalidate();
            }
        });

        ibGray = findViewById(R.id.ibGray);
        ibGray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(satur == 0) satur = 1;
                else satur = 0;
                graphicView.invalidate();
            }
        });
    }
}
