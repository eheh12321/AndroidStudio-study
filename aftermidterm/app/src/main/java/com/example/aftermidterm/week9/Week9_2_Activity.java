package com.example.aftermidterm.week9;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Week9_2_Activity extends AppCompatActivity {

    static final int LINE = 1, CIRCLE = 2;
    static int curShape = LINE;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        setTitle("9주차 - 2 | 그래픽");
    }

    private static class MyGraphicView extends View {

        int startX = -1, startY = -1, stopX = -1, stopY = -1;

        public MyGraphicView(Context context) {
            super(context);
        }

        /**
         * 그리기 관련
         */
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);

            /**
             * 녹색선 긋기
             */
            paint.setColor(Color.GREEN);
            canvas.drawLine(10, 10, 300, 10, paint);

            /**
             * 굵은 선 긋기
             */
            paint.setColor(Color.BLUE);
            paint.setStrokeWidth(10);
            canvas.drawLine(10, 30, 300, 30, paint);

            paint.setColor(Color.RED);
            paint.setStrokeWidth(0);

            /**
             * 사각형 그리기
             */
            paint.setStyle(Paint.Style.FILL); // 내부 채우기
            Rect rect1 = new Rect(10, 50, 10+100, 50+100);
            canvas.drawRect(rect1, paint);

            paint.setStyle(Paint.Style.STROKE); // 내부 비우기
            Rect rect2 = new Rect(130, 50, 130+100, 50+100);
            canvas.drawRect(rect2, paint);

            /**
             * 모서리가 둥근 사각형 그리기
             */
            RectF rect3 = new RectF(250, 50, 250+100, 50+100);
            canvas.drawRoundRect(rect3, 20, 20, paint);

            /**
             * 원 그리기
             */
            canvas.drawCircle(60, 220, 50, paint);

            /**
             * 경로 그리기
             */
            paint.setStrokeWidth(5);
            Path path1 = new Path();
            path1.moveTo(10, 290);
            path1.lineTo(10+50, 290+50);
            path1.lineTo(10+100, 290);
            path1.lineTo(10+150, 290+50);
            path1.lineTo(10+200, 290);
            canvas.drawPath(path1, paint);

            /**
             * 문자 그리기
             */
            paint.setStrokeWidth(2);
            paint.setTextSize(30);
            canvas.drawText("안드로이드", 10, 390, paint);

            /**
             * 터치 이벤트 그리기
             */
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.RED);

            switch (curShape) {
                case LINE:
                    canvas.drawLine(startX, startY, stopX, stopY, paint);
                    break;
                case CIRCLE:
                    int radius = (int) Math.sqrt(Math.pow(stopX - startX, 2) + Math.pow(stopY - startY, 2));
                    canvas.drawCircle(startX, startY, radius, paint);
                    break;
            }
        }

        /**
         * 터치 이벤트
         */
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    startX = (int) event.getX();
                    startY = (int) event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                case MotionEvent.ACTION_UP:
                    stopX = (int) event.getX();
                    stopY = (int) event.getY();
                    this.invalidate();
                    break;
            }
            return true;
        }
    }

    /**
     * 메뉴 선택 관련 메서드
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "선 그리기");
        menu.add(0, 2, 0, "원 그리기");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                curShape = LINE;
                return true;
            case 2:
                curShape = CIRCLE;
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
