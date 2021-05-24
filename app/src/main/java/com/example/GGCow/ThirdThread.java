package com.example.GGCow;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class ThirdThread extends Thread {
    private Rocket Rocket;
    private final SurfaceHolder surfaceHolder;
    private boolean running;
    public static Canvas canvas2;
    private int targetFPS = 30;
    private int counterLeft = 0;
    private int counterRight = 0;


    public ThirdThread(SurfaceHolder surfaceHolder, com.example.GGCow.Rocket gameView) {

        super();
        this.surfaceHolder = surfaceHolder;
        this.Rocket = gameView;

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
            canvas2 = null;

            try {
                canvas2 = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.Rocket.update();
                    this.Rocket.draw(canvas2);

                }
            } catch (Exception e) {
            }
            finally{
                if(canvas2 !=null)
                {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas2);
                    }
                    catch(Exception e){e.printStackTrace();}
                }
            }

            timeMillis = (System.nanoTime() - startTime) / 1000000;
            waitTime = targetTime-timeMillis;
            try{
                if (Rocket.leftIsBlocked){
                    counterLeft++;
                    if (counterLeft >= 450){
                        Rocket.leftIsBlocked = false;
                        counterLeft = 0;
                    }
                }
                if (Rocket.rightIsBlocked){
                    counterRight++;
                    if (counterRight >= 450){
                        Rocket.rightIsBlocked = false;
                        counterRight = 0;
                    }
                }
                this.sleep(waitTime);
            }catch(Exception e){}
        }

    }

    public void setRunning(boolean isRunning) {
        running = isRunning;
    }
}
