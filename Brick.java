package com.example.andrew.mariogame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Anissa on 19-May-15.
 */
public class Brick {
    int x, y;
    int size = 100;
    boolean breakable;
    Brick (){

    }
    Brick(int x, int y, boolean breakable)
    {
        this.x = x;
        this.y = y;
        this.breakable = breakable;
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
        rect.right = this.x + 11;
        return rect;
    }
    public Rect getRightBounds(){
        Rect rect = new Rect();
        rect.top = this.y;
        rect.left = this.x + this.size - 11;
        rect.bottom = this.y + this.size;
        rect.right = this.x + this.size;
        return rect;
    }
}
