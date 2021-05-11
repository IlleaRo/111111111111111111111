package com.example.a111111111111111111111;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rocket extends SurfaceView implements SurfaceHolder.Callback {
        private ThirdThread thread;
        private RocketSprite rocketSprite;
        public MeteorSprite meteor1, meteor2;
        public static int speed = 10;
        public int counter = 0;
        private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
        private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;

    public Rocket(Context context) {
        super(context);
        getHolder().addCallback(this);
        thread = new ThirdThread(getHolder(), this);
        setFocusable(true);
    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    public Bitmap getResizedBitmap(Bitmap bm, int newWidth, int newHeight) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight);

        // "RECREATE" THE NEW BITMAP
        Bitmap resizedBitmap = Bitmap.createBitmap(
                bm, 0, 0, width, height, matrix, false);
        bm.recycle();
        return resizedBitmap;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        makeLevel();
        thread.setRunning(true);
        thread.start();
    }

    private void makeLevel(){
        rocketSprite = new RocketSprite(getResizedBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.rocket), 300, 450));
        Bitmap bmp = getResizedBitmap(BitmapFactory.decodeResource (getResources(), R.drawable.meteor), 150, 150);
        meteor1 = new MeteorSprite(bmp, bmp, 150, 1000);
        meteor2 = new MeteorSprite(bmp, bmp, 150, 100);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();

            } catch(InterruptedException e){
                e.printStackTrace();
            }
            retry = false;
        }
    }

    public void update(){
        logic();
        //rocketSprite.update();
        meteor1.update();
        meteor2.update();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if (event.getX() >= screenWidth/2){
            rocketSprite.x += rocketSprite.speed * 10;
        } else if(event.getX() < screenWidth/2) {
            rocketSprite.x -= rocketSprite.speed * 10;
        }
        return super.onTouchEvent(event);
    }

    public void logic(){
        List<MeteorSprite> meteors = new ArrayList<>();
        meteors.add(meteor1);
        meteors.add(meteor2);

        for (int i = 0; i < meteors.size(); i++) {
            // Проверка столкновений
            if (rocketSprite.y-450 <= meteors.get(i).Y   && rocketSprite.x + 300 > meteors.get(i).X && rocketSprite.x < meteors.get(i).X + 500 ) {
                resetLevel();
            }

            // Переходы
            if (rocketSprite.x < -300) {
                rocketSprite.x =screenWidth-50;
            }

            if (rocketSprite.x > screenWidth+100){
                rocketSprite.x = -250;
            }

            if (meteors.get(i).Y + 450 > screenHeight){
                Random r = new Random();
                int value1 = r.nextInt(500);
                int value2 = r.nextInt(500);
                meteors.get(i).Y = -value1;
                meteors.get(i).X = 30 + value2;

            }
        }
    }

    @Override
    public void draw(Canvas canvas2)
    {
        super.draw(canvas2);
        if(canvas2!=null) {
            canvas2.drawRGB(150, 0, 0);
            rocketSprite.draw(canvas2);
            meteor1.draw(canvas2);
            meteor2.draw(canvas2);
        }
    }

    public void resetLevel(){
        rocketSprite.y = 1350;
        rocketSprite.x = 100;
        meteor1.X = 250;
        meteor1.Y = 0;
        meteor2.X = 325;
        meteor2.Y = -1000;
        counter = 0;
    }
}
