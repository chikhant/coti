package com.example.andrew.mariogame;

/**
 * Created by Anissa on 13-May-15.
 */
import android.view.MotionEvent;
import android.graphics.Paint;
import android.graphics.Color;
import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Anissa on 08-May-15.
 */
public class MarioView extends SurfaceView
        implements SurfaceHolder.Callback {
    MarioThread mv = new MarioThread(this);
    ScreenObjects so = new ScreenObjects(getContext());
    Mario mario = new Mario(935, 0, getContext(), so);
    Screens sc = new Screens(getContext(), mario);

    int gameState = 0;

    //Initialize all objects here.

    public MarioView(Context context) {
        super(context);
        getHolder().addCallback(this);
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
//Construct game initial state(blocks, marios. etc)
        mv.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder,
                               int format, int width, int height) {
// Respond to surface changes , e . g . , aspect ratio changes .
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
// The cleanest way to stop a thread is by interrupting it .
// BubbleShooterThread regularly checks its interrupt flag .
        mv.interrupt();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
// Update game state in response to events :
// touch - down , touch - up , and touch - move .
// Current finger position .
        int curX = (int) e.getX();
        int curY = (int) e.getY();

        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (gameState != 0 && Screens.retRect.contains(curX,curY)){
                    Screens.shadowCheck = 5;
                    break;
                }
                if (gameState == 0 && Screens.oneRect.contains(curX, curY)) {//test for level 1
                    Screens.shadowCheck = 1;
                }

                if (gameState == 0 && Screens.twoRect.contains(curX, curY)){
                    Screens.shadowCheck = 2;
                }

                if (gameState == 0 && Screens.threeRect.contains(curX, curY)){
                    Screens.shadowCheck = 3;
                }

                if (gameState == 0 && Screens.livesRect.contains(curX, curY)){
                    Screens.shadowCheck = 4;
                    if (Screens.life != 6){Screens.life += 1;}
                    else {Screens.life = 1;}
                }
                if (curX > 1600){
                    mario.Run(true, 1, 2);
                }
                if (curX > 1280 && curX <= 1600){
                    mario.Run(true, 1, 1);
                }
                if (curX < 320){
                    mario.Run(true, 0, 2);
                }
                if (curX >= 320 && curX < 640){
                    mario.Run(true, 0, 1);
                }
                if (curY < 540 && !mario.isAerial)
                {
                    mario.Jump(2);
                }
                if (curY < 720 && curY >= 540 && !mario.isAerial){
                    mario.Jump(1);
                }
                break;

            case MotionEvent.ACTION_UP:
                if (gameState != 0 && Screens.retRect.contains(curX, curY)) {//test for level 1
                    gameState = 0;
                    break;
                }
                if (gameState == 0 && Screens.oneRect.contains(curX, curY)) {//test for level 1
                    gameState = 1;
                }
                if (gameState == 0 && Screens.twoRect.contains(curX, curY)){
                    gameState = 2;
                }
                if (gameState == 0 && Screens.threeRect.contains(curX, curY)){
                    gameState = 3;
                }
                if (gameState == 0 && Screens.livesRect.contains(curX, curY)){
                    //lives = lives + 1
                }
                Screens.shadowCheck = 0;

                if (curX > 960){
                    mario.Run(false, 1, 0);
                }
                if (curX < 960){
                    mario.Run(false, 0, 0);
                }
                break;

            case MotionEvent.ACTION_MOVE:                                                           // Move as normal. Lift finger and press again if you want to jump
                if (curX > 1600){
                    mario.Run(true, 1, 2);
                }
                if (curX > 1280 && curX <= 1600){
                    mario.Run(true, 1, 1);
                }
                if (curX < 320){
                    mario.Run(true, 0, 2);
                }
                if (curX >= 320 && curX < 640){
                    mario.Run(true, 0, 1);
                }
                /*if (curY < 540 && !mario.isAerial)
                {
                    mario.Jump(2);
                }
                if (curY < 720 && curY >= 540 && !mario.isAerial){
                    mario.Jump(1);
                }*/
                break;

        }
        return true;
    }

    @Override
    public void onDraw(Canvas c) {
        super.onDraw(c);
    }

    public void tick(Canvas c) {
// Render the game elements: bubbles ( fixed , moving , exploding )
// and aiming arrow
        switch (gameState) {
            case 0:
                mario.reset();
                mario.score = 0;
                sc.start(c);
                mario.lives = sc.life;
                so.reset();
                break;
            case 1:                                     // level 1
                so.floorLay(gameState);
                sc.tick(c);
                so.tick(c);
                mario.tick(c);
                if(!mario.isAlive){                                 //mario has died, reset
                    mario.reset();
                    so.reset();
                    so.floorLay(gameState);
                    mario.isAlive = true;
                }
                if (mario.lives == 0)                                // game over
                    gameState = 4;
                if (mario.getBounds().intersect(so.stars.get(0).getBounds())) {             //win
                    so.reset();
                    gameState++;
                    mario.reset();
                }
                break;
            case 2:                                     //level  2
                so.floorLay(gameState);
                sc.tick2(c);
                so.tick(c);
                mario.tick(c);
                if(!mario.isAlive){
                    mario.reset();
                    so.reset();
                    so.floorLay(gameState);
                    mario.isAlive = true;
                }
                if (mario.lives == 0)
                    gameState = 4;
                if (mario.getBounds().intersect(so.stars.get(0).getBounds())) {
                    so.reset();
                    gameState++;
                    mario.reset();
                }
                break;
            case 3:                                                          //level 3
                so.floorLay(gameState);
                sc.tick3(c);
                so.tick(c);
                mario.tick(c);
                if(!mario.isAlive){                             //mario has died, reset
                    mario.reset();
                    so.reset();
                    so.floorLay(gameState);
                    mario.isAlive = true;
                }
                if (mario.lives == 0)
                    gameState = 4;
                if (mario.getBounds().intersect(so.stars.get(0).getBounds())) {
                    so.reset();
                    gameState++;
                    mario.reset();
                }
                break;
            case 4: //GAMEOVER STATE
                sc.gameOver(c);
                break;
            default:
                break;

        }

    }
}

