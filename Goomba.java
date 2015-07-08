package com.example.andrew.mariogame;

import android.graphics.Rect;

/**
 * Created by Andrew on 5/27/2015.
 */
public class Goomba{
    int x, y;
    int size = 100;
    int direction;
    final int speed = 3;
    boolean isAerial = false;
    Goomba(int x, int y, int direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
    }


    public Rect getTopBounds(){
        Rect rect = new Rect();
        rect.top = this.y;
        rect.left = this.x;
        rect.bottom = this.y + 10;
        rect.right = this.x + this.size;
        return rect;
    }
    public Rect getBotBounds(){
        Rect rect = new Rect();
        rect.top = this.y + this.size - 10;
        rect.left = this.x;
        rect.bottom = this.y + this.size;
        rect.right = this.x + this.size;
        return rect;
    }
    public Rect getLeftBounds(){
        Rect rect = new Rect();
        rect.top = this.y;
        rect.left = this.x;
        rect.bottom = this.y + this.size;
        rect.right = this.x + 10;
        return rect;
    }
    public Rect getRightBounds(){
        Rect rect = new Rect();
        rect.top = this.y;
        rect.left = this.x + this.size - 10;
        rect.bottom = this.y + this.size;
        rect.right = this.x + this.size;
        return rect;
    }
    public void advanceFrame(){
        if (this.direction == 0){
            this.x -= speed;
        }
        if (this.direction == 1){
            this.x += speed;
        }
        this.y += 10;
    }
}
