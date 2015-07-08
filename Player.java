package com.example.andrew.mariogame;

import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by Andrew on 5/20/2015.
 */
public interface Player {
    public void Jump(int jumpMultiplier);
    public void Run(boolean isRunning, int direction, int speed);
    public void draw(Canvas canvas);
    public void advanceFrame();
    public boolean isgoingUp();
    public boolean checkGround();
    public boolean checkSky();
    public boolean checkRightSide();
    public boolean checkLeftSide();
    public Rect getTopBounds();
    public Rect getBotBounds();
    public Rect getLeftBounds();
    public Rect getRightBounds();
    public void reset();
}
