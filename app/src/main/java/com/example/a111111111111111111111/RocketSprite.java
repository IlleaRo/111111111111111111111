package com.example.a111111111111111111111;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class RocketSprite {
    private Bitmap image;
    public int x, y;
    public int speed = 10;

    public RocketSprite (Bitmap bmp) {
        image = bmp;
        x = 100;
        y = 1250;
    }

    public void draw(Canvas canvas) { canvas.drawBitmap(image, x, 1350, null); }

    //public void update() {  y = speed; }
}
