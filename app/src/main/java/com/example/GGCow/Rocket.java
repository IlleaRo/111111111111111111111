package com.example.GGCow;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.GGCow.MainActivity.APP_PREFERENCES_COUNTER;

public class Rocket extends SurfaceView implements SurfaceHolder.Callback {
        private ThirdThread thread;
        private RocketSprite rocketSprite;
        public MeteorSprite meteor1, meteor2, meteor3, meteor4, meteor5, meteor6, meteor7,meteor8,meteor9,meteor10;
        public static int speed = 10;
        public int counter = 0;
        SharedPreferences m1Settings;
        public boolean leftIsBlocked = false;
        public boolean firsttime = true;
        public boolean rightIsBlocked = false;
        private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
        private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        public Bitmap space = getResizedBitmap(BitmapFactory.decodeResource (getResources(), R.drawable.space), screenWidth, screenHeight);


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
        if(firsttime) {
            thread.setRunning(true);
            thread.start();
        }
    }





    private void makeLevel(){
        rocketSprite = new RocketSprite(getResizedBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.rocket), 100, 250));
        Bitmap bmp = getResizedBitmap(BitmapFactory.decodeResource (getResources(), R.drawable.meteor), 150, 150);
        meteor1 = new MeteorSprite(bmp, 350, 100);
        meteor2 = new MeteorSprite(bmp, 250, -100 );
        meteor3 = new MeteorSprite(bmp, 150, -500);
        meteor4 = new MeteorSprite(bmp, 200, -1000);
        meteor5 = new MeteorSprite(bmp, 400, -1250);
        meteor6 = new MeteorSprite(bmp, 500, -1500);
        meteor7 = new MeteorSprite(bmp, 50, -1600);
        meteor8 = new MeteorSprite(bmp, 350, -1800);
        meteor9 = new MeteorSprite(bmp, 250, -1900 );
        meteor10 = new MeteorSprite(bmp,150, -2500);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        resetLevel();
    }

    public void update(){
        logic();
        meteor1.update();
        meteor2.update();
        meteor3.update();
        meteor4.update();
        meteor5.update();
        meteor6.update();
        meteor7.update();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if (event.getX() >= screenWidth/2 && rocketSprite.x + 100 < screenWidth){
            rocketSprite.x += rocketSprite.speed * 10;
        }
        else if(event.getX() < screenWidth/2 && rocketSprite.x > 0) {
            rocketSprite.x -= rocketSprite.speed * 10;
        }
        return super.onTouchEvent(event);
    }

    public void logic(){
        List<MeteorSprite> meteors = new ArrayList<>();
        meteors.add(meteor1);
        meteors.add(meteor2);
        meteors.add(meteor3);
        meteors.add(meteor4);
        meteors.add(meteor5);
        meteors.add(meteor6);
        meteors.add(meteor7);
        meteors.add(meteor8);
        meteors.add(meteor9);
        meteors.add(meteor10);

        for (int i = 0; i < meteors.size(); i++) {
            // Проверка столкновений
            if ((rocketSprite.y-150 <= meteors.get(i).Y && rocketSprite.y >= meteors.get(i).Y-150)  && rocketSprite.x + 100 > meteors.get(i).X && rocketSprite.x < meteors.get(i).X + 150 ) {
                resetLevel();
            }

            if ((rocketSprite.x  >= screenWidth-100) && !rightIsBlocked) {
                rocketSprite.x = 100;
                rightIsBlocked = true;
            }

            if ((rocketSprite.x <= 0) && !leftIsBlocked) {
                rocketSprite.x = screenWidth - 200;
                leftIsBlocked = true;
            }



            if (meteors.get(i).Y + 150 > screenHeight+200){
                Random r = new Random();
                int value1 = r.nextInt(500);
                int value2 = r.nextInt(screenWidth);
                meteors.get(i).Y = -value1;
                meteors.get(i).X = 30 + value2;
                counter++;
            }
            SharedPreferences.Editor editor = m1Settings.edit();
            if(counter >= 20){

                editor.putInt(APP_PREFERENCES_COUNTER, 19);
                editor.apply();
                Context context = getContext();
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
            }
        }
    }
    @Override
    public void draw(Canvas canvas2)
    {
        super.draw(canvas2);
        if(canvas2!=null) {
            canvas2.drawBitmap(space, 0, 0, null);
            rocketSprite.draw(canvas2);
            meteor1.draw(canvas2);
            meteor2.draw(canvas2);
            meteor3.draw(canvas2);
            meteor4.draw(canvas2);
            meteor5.draw(canvas2);
            meteor6.draw(canvas2);
            meteor7.draw(canvas2);
            meteor8.draw(canvas2);
            meteor9.draw(canvas2);
            meteor10.draw(canvas2);
        }
    }

    public void resetLevel(){
        leftIsBlocked = false;
        rightIsBlocked = false;
        rocketSprite.y = 1350;
        rocketSprite.x = 100;
        meteor1.X = 350;
        meteor1.Y = 100;
        meteor2.X = 250;
        meteor2.Y = -100;
        meteor3.X = 150;
        meteor3.Y = -500;
        meteor4.X = 200;
        meteor4.Y = -1000;
        meteor5.X = 400;
        meteor5.Y = -1250;
        meteor6.X = 500;
        meteor6.Y = -1500;
        meteor7.X = 50;
        meteor7.Y = -1600;
        meteor8.X = 350;
        meteor8.Y = -1800;
        meteor9.X = 250;
        meteor9.Y = -2000;
        meteor10.X = 150;
        meteor10.Y = -2500;
        counter = 0;

    }
}
