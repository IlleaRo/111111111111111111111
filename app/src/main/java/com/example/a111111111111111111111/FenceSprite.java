package com.example.a111111111111111111111;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;


public class FenceSprite {

    private Bitmap image;
    private Bitmap image2;

    public int X, Y;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;




    public FenceSprite (Bitmap bmp, Bitmap bmp2, int x, int y) {
        image = bmp;
        image2 = bmp2;
        Y = y;
        X = x;
    }


    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, X, -(Cow.gapHeight / 2) + Y, null);
        canvas.drawBitmap(image2, X, ((screenHeight / 2) + (Cow.gapHeight / 2)) + Y, null);


    }
    public void update() {
        X -= Cow.speed;

    }

}
