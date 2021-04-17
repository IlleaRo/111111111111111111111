package com.example.a111111111111111111111;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;


public class FenceSprite {

    private Bitmap image;
    private Bitmap image2;
    public int xX, yY;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;




    public FenceSprite (Bitmap bmp, Bitmap bmp2, int x, int y) {
        image = bmp;
        image2 = bmp2;
        yY = y;
        xX = x;
    }


    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, xX, -(CowSimple.gapHeight / 2) + yY, null);
        canvas.drawBitmap(image2,xX, ((screenHeight / 2) + (CowSimple.gapHeight / 2)) + yY, null);


    }
    public void update() {

        xX -= CowSimple.velocity;



    }

}
