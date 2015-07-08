package com.example.andrew.mariogame;

/**
 * Created by Anissa on 13-May-15.
 */
import android.graphics.Canvas;
import android.view.SurfaceHolder;
public class MarioThread extends Thread {
    private final MarioView mv;
    private static final int FRAME_LENGTH = 1; //in ms

    public MarioThread(MarioView mv){
        this.mv = mv;
    }
    public void run(){
        SurfaceHolder sh = mv.getHolder();
        //Main game loop .
        while (!Thread.interrupted()){
            Canvas c = sh.lockCanvas(null);
            try{
                synchronized (sh){
                    mv.tick(c);
                }
            } catch(Exception e) {
            } finally{
                if (c!=null){
                    sh.unlockCanvasAndPost(c);
                }
            }
//Set the frame rate by setting this delay
            try {
                Thread.sleep(FRAME_LENGTH);
            } catch(InterruptedException e){
//Thread was interrupted while sleeping .
                return;
            }
        }
    }
}
