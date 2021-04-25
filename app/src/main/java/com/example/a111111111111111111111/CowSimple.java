package com.example.a111111111111111111111;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.nfc.Tag;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.a111111111111111111111.MainActivity.APP_PREFERENCES;
import static com.example.a111111111111111111111.MainActivity.APP_PREFERENCES_COUNTER;

public class CowSimple extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    private CharacterSprite characterSprite;
    public FenceSprite fence1, fence2, fence3;
    public static int gapHeight = 500;
    public static int velocity = 10;
    public int counter = 0;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int mCs;
    SharedPreferences m1Settings;
    public CowSimple(Context context) {
        super(context);
        getHolder().addCallback(this);
        m1Settings = getContext().getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE);
        mCs = m1Settings.getInt(APP_PREFERENCES_COUNTER,0);
        Log.d("PREF", String.valueOf(mCs));
        thread = new MainThread(getHolder(), this);
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
    public boolean onTouchEvent(MotionEvent event)
    {
        characterSprite.y = characterSprite.y - (characterSprite.yVelocity * 10);
        return super.onTouchEvent(event);
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        makeLevel();
        thread.setRunning(true);
        thread.start();
    }

    private void makeLevel() {
        characterSprite = new CharacterSprite
                (getResizedBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.polish_dancing_cow_dancing), 300, 240));
        Bitmap bmp;
        Bitmap bmp2;
        int y;
        int x;
        bmp = getResizedBitmap(BitmapFactory.decodeResource
                (getResources(), R.drawable.fence), 500, Resources.getSystem().getDisplayMetrics().heightPixels / 2);
        bmp2 = getResizedBitmap
                (BitmapFactory.decodeResource(getResources(), R.drawable.fence), 500, Resources.getSystem().getDisplayMetrics().heightPixels / 2);

        fence1 = new FenceSprite(bmp, bmp2, 2000, 100);
        fence2 = new FenceSprite(bmp, bmp2, 4500, 100);
        fence3 = new FenceSprite(bmp, bmp2, 3200, 100);

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        SharedPreferences.Editor editor = m1Settings.edit();
        editor.putInt(APP_PREFERENCES_COUNTER, 7);
        editor.apply();
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
        Context context = getContext();
        Intent intent = new Intent(context, MainActivity.class); //а не new Intent(this, MyActivity.class)
        context.startActivity(intent);
    }

    public void update() {
        logic();
        characterSprite.update();
        fence1.update();
        fence2.update();
        fence3.update();
    }

    @Override
    public void draw(Canvas canvas)
    {

        super.draw(canvas);
        if(canvas!=null) {
            canvas.drawRGB(0, 100, 205);
            characterSprite.draw(canvas);
            fence1.draw(canvas);
            fence2.draw(canvas);
            fence3.draw(canvas);

        }
    }

    public void logic() {
        List<FenceSprite> pipes = new ArrayList<>();
        pipes.add(fence1);
        pipes.add(fence2);
        pipes.add(fence3);

        for (int i = 0; i < pipes.size(); i++) {
            //Detect if the character is touching one of the pipes
            if (characterSprite.y < pipes.get(i).yY + (screenHeight / 2) - (gapHeight / 2) && characterSprite.x + 300 > pipes.get(i).xX && characterSprite.x < pipes.get(i).xX + 500) {
                resetLevel();
            } else if (characterSprite.y + 240 > (screenHeight / 2) + (gapHeight / 2) + pipes.get(i).yY && characterSprite.x + 300 > pipes.get(i).xX && characterSprite.x < pipes.get(i).xX + 500) {
                resetLevel();
            }

            //Detect if the pipe has gone off the left of the screen and regenerate further ahead
            if (pipes.get(i).xX + 500 < 0) {
                Random r = new Random();
                int value1 = r.nextInt(500);
                int value2 = r.nextInt(500);
                pipes.get(i).xX = screenWidth + value1 + 2500;
                pipes.get(i).yY = value2 - 250;
                counter++;
                Log.d("НУЖНЫЙ","Counter: ="+ counter);
                if (counter >= 2){
                    Context context = getContext();
                    Intent intent = new Intent(context, MainActivity.class); //а не new Intent(this, MyActivity.class)
                    context.startActivity(intent);
                }
            }
        }

        //Detect if the character has gone off the bottom or top of the screen
        if (characterSprite.y + 240 < 0) {
            resetLevel(); }
        if (characterSprite.y > screenHeight) {
            resetLevel(); }
    }


    public void resetLevel() {
        characterSprite.y = 100;
        fence1.xX = 2000;
        fence1.yY = 0;
        fence2.xX = 4500;
        fence2.yY = 200;
        fence3.xX = 3200;
        fence3.yY = 250;
        counter = 0;

    }

}