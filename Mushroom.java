package com.example.andrew.mariogame;

import android.graphics.Rect;

import java.util.Random;

/**
 * Created by Andrew on 5/28/2015.
 */
public class Mushroom {
    int x, y, type;
    int size = 100;
    Mushroom ( int x, int y, int type ){
        this.x = x;
        this.y = y;
        this.type = type;
    }
    public Rect getBounds(){
        Rect rect = new Rect();
        rect.top = this.y;
        rect.left = this.x;
        rect.bottom = this.y + this.size;
        rect.right = this.x + this.size;
        return rect;
    }
}
