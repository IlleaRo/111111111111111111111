package com.example.a111111111111111111111;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class MeteorSprite {
    private Bitmap image;

    public int X, Y;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;




    public MeteorSprite (Bitmap bmp, Bitmap bmp2, int x, int y) {
        image = bmp;
        Y = y;
        X = x;
    }


    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, X, Y, null);

    }
    public void update() {
        Y += Rocket.speed;

    }
}
