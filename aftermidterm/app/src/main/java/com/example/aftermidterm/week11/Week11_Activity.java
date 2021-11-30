package com.example.aftermidterm.week11;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aftermidterm.R;

public class Week11_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        setTitle("11주차 | 이미지");
    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            /**
             * 비트맵 기본 출력
             */
            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.jeju14);
            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;
            canvas.drawBitmap(picture, picX, picY, null);
            picture.recycle();

            /**
             * 기하학적 메서드
             */
            picture = BitmapFactory.decodeResource(getResources(), R.drawable.small);
            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() / 2;
            picX = (this.getWidth() - picture.getWidth()) / 2;
            picY = (this.getHeight() - picture.getHeight()) / 2;

            canvas.rotate(45, cenX, cenY);
            canvas.drawBitmap(picture, picX, picY, null);

            canvas.translate(-150, 200);
            canvas.drawBitmap(picture, picX, picY, null);

            canvas.scale(2, 2, cenX, cenY);
            canvas.drawBitmap(picture, picX, picY, null);

            canvas.skew(0.3f, 0.3f);
            canvas.drawBitmap(picture, picX, picY, null);

            picture.recycle();

            /**
             * 블러링
             */
            canvas.rotate(-45); // 회전
            canvas.scale(0.5f, 0.5f); // 스케일링
            canvas.translate(-500, 500); // 이동

            picture = BitmapFactory.decodeResource(getResources(), R.drawable.lena256);
            picX = (this.getWidth() - picture.getWidth()) / 2;
            picY = (this.getHeight() - picture.getHeight()) / 2;

            Paint paint = new Paint();
            BlurMaskFilter bMask;

            // NORMAL / INNER / OUTER / SOLID
            bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
            paint.setMaskFilter(bMask);
            canvas.drawBitmap(picture, picX, picY, paint);
            picture.recycle();


            /**
             * 엠보싱
             */
            paint.setColor(Color.GRAY);
            EmbossMaskFilter eMask =
                    new EmbossMaskFilter(new float[] {3, 3, 10}, 0.5f, 5, 5);
            paint.setMaskFilter(eMask);
            canvas.drawCircle(cenX, cenY, 150, paint);

            /**
             * RGB 뽀샤시
             */
            canvas.translate(-500, 500); // 이동

            picture = BitmapFactory.decodeResource(getResources(), R.drawable.lena256);
            picX = (this.getWidth() - picture.getWidth()) / 2;
            picY = (this.getHeight() - picture.getHeight()) / 2;

            paint = new Paint();
            float[] array = {2, 0, 0, 0,
                            -25, 0, 2, 0, 0,
                            -25, 0, 0, 2, 0,
                            -25, 0, 0, 0, 1, 0};

            ColorMatrix cm = new ColorMatrix(array);
            paint.setColorFilter(new ColorMatrixColorFilter(cm));
            canvas.drawBitmap(picture, picX, picY, paint);
            picture.recycle();
        }

    }
}
