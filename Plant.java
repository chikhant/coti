package com.example.andrew.mariogame;

import android.graphics.Rect;

/**
 * Created by Andrew on 5/27/2015.
 */
public class Plant {
    int x, y;
    int size = 100;
    Plant( int x , int y){
        this.x = x;
        this.y = y;
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
