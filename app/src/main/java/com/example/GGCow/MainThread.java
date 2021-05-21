package com.example.GGCow;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread {
    private Cow Cow;
    private final SurfaceHolder surfaceHolder;
    private boolean running;
    public static Canvas canvas;
    private int targetFPS = 30;


    public MainThread(SurfaceHolder surfaceHolder, com.example.GGCow.Cow gameView) {

        super();
        this.surfaceHolder = surfaceHolder;
        this.Cow = gameView;

    }

    @Override
    public void run()
    {

        long startTime;
        long timeMillis;
        long waitTime;
        long targetTime = 1000/targetFPS;


        while(running) {
            startTime = System.nanoTime();
            canvas = null;

            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.Cow.update();
                    this.Cow.draw(canvas);
                }
            } catch (Exception e) {
            }
            finally{
                if(canvas!=null)
                {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                    catch(Exception e){e.printStackTrace();}
                }
            }

            timeMillis = (System.nanoTime() - startTime) / 1000000;
            waitTime = targetTime-timeMillis;

            try{
                sleep(waitTime);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void setRunning(boolean isRunning) {
        running = isRunning;
    }
}
