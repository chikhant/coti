package com.example.andrew.mariogame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Andrew on 5/20/2015.
 */
public class Mario implements Player {
    int x, y, direction, animate, initialy, speed, jumpMultiplier;
    int size = 100;
    int score = 0;
    int lives;
    int jumpHeight = 150;
    static Rect dst = new Rect();
    boolean isRunning;
    boolean isJumping = false;
    boolean isAerial = true;
    boolean isAlive = true;
    Brick collisionBrick = new Brick();

    Bitmap MarioSpriteLeft, MarioSpriteRight;
    Bitmap RunningLeftMarioSprite1, RunningLeftMarioSprite2, RunningLeftMarioSprite3;
    Bitmap RunningRightMarioSprite1, RunningRightMarioSprite2, RunningRightMarioSprite3;
    Bitmap MarioJumpingRight, MarioJumpingLeft;
    ScreenObjects so;
    Rect brickRect = new Rect();
    Rect marioRect = new Rect();
    Rect coinRect = new Rect();
    Rect mushRect = new Rect();
    Rect plantRect = new Rect();
    Rect goombaRect = new Rect();
    Rect starRect = new Rect();
    Mario (){};
    Mario(int x, int y,Context context, ScreenObjects so){
        this.x = x;
        this.y = y;
        this.animate = 0;
        this.direction = 1;
        BitmapFactory.Options options = new BitmapFactory.Options();
        MarioSpriteRight = BitmapFactory.decodeResource(context.getResources(), R.drawable.marioretro, options);
        MarioSpriteLeft = BitmapFactory.decodeResource(context.getResources(), R.drawable.marioretro1, options);
        RunningRightMarioSprite1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.mariorunningright1, options);
        RunningRightMarioSprite2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.mariorunningright2, options);
        RunningRightMarioSprite3 = BitmapFactory.decodeResource(context.getResources(), R.drawable.mariorunningright3, options);
        RunningLeftMarioSprite1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.mariorunningleft1, options);
        RunningLeftMarioSprite2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.mariorunningleft2, options);
        RunningLeftMarioSprite3 = BitmapFactory.decodeResource(context.getResources(), R.drawable.mariorunningleft3, options);
        MarioJumpingRight = BitmapFactory.decodeResource(context.getResources(), R.drawable.mariojumpingright, options);
        MarioJumpingLeft = BitmapFactory.decodeResource(context.getResources(), R.drawable.mariojumpingleft, options);
        this.so = so;
        this.isJumping = false;
    }
    public void reset(){
        this.x = 100;
        this.y = 400;
        this.size = 100;
    }
    public void Run(boolean isRunning, int direction, int speed){                   // set mario to run
        this.isRunning = isRunning;
        switch (direction) {
            case 1:
                this.direction = 1;
                break;
            case 0:
                this.direction = 0;
                break;
        }
        this.speed = speed;
    }
    public void Jump(int jumpMultiplier){                       //set mario to jump
        this.jumpMultiplier = jumpMultiplier;
            isJumping = true;
            initialy = this.y;
    }
    public boolean isgoingUp(){                             // is mario going up, boolean used to break bricks and end jump
        if (isJumping && (initialy - this.y > (jumpHeight * jumpMultiplier))){
            isJumping = false;
            return false;
        }
        else
            return true;
    }
    public void advanceFrame(){                                     //advance mario's position for calculations and drawing
        if (isRunning && direction == 1 && this.x < 960){
            this.x += 5*speed;
        }
        else if (isRunning && direction == 0 && this.x > 0){
            this.x -= 5*speed;
        }
        if (isAerial && !isJumping){
                this.y += 10;
        }
        else if (isJumping && isgoingUp())
        {
            this.y -= 10;
        }
        if (this.x >= 945 && this.isRunning && this.direction == 1) {
            for (int i = 0; i < so.bricks.size(); i++){
                so.bricks.get(i).x -= 5*this.speed;
            }
            for (int i = 0; i < so.mushrooms.size(); i++){
                so.mushrooms.get(i).x -= 5*this.speed;
            }
            for (int i = 0; i < so.coins.size(); i++){
                so.coins.get(i).x -= 5*this.speed;
            }
            for (int i = 0; i < so.goombas.size(); i++){
                so.goombas.get(i).x -= 5*this.speed;
            }
            for (int i = 0; i < so.plants.size(); i++){
                so.plants.get(i).x -= 5*this.speed;
            }
            for (int i = 0; i < so.stars.size(); i++){
                so.stars.get(i).x -= 5*this.speed;
            }
        }
    }
    public void draw(Canvas canvas){                            //draw mario
        Paint paint = new Paint();
        dst.left = this.x;
        dst.right = this.x + this.size;
        dst.top = this.y;
        dst.bottom = this.y + this.size;
        if (!isRunning && !isAerial) {
            if (direction == 1)
                canvas.drawBitmap(MarioSpriteRight, null, dst, paint);
            else
                canvas.drawBitmap(MarioSpriteLeft, null, dst, paint);
            this.animate = 0;
        }
        else if(isAerial){
            if (direction == 1){
                canvas.drawBitmap(MarioJumpingRight, null, dst, paint);
            }
            else if(direction == 0){
                canvas.drawBitmap(MarioJumpingLeft, null, dst, paint);
            }
        }
        else if (!isJumping && isRunning && direction == 1) {
            if (animate == 0 || animate == 3) {
                canvas.drawBitmap(RunningRightMarioSprite1, null, dst, paint);
                animate++;
            }
            else if (animate == 1 || animate == 4){
                canvas.drawBitmap(RunningRightMarioSprite2, null, dst, paint);
                animate++;
            }
            else if (animate == 2 || animate == 5){
                canvas.drawBitmap(RunningRightMarioSprite3, null, dst, paint);
                animate = 0;
            }
        }
        else if (!isJumping && isRunning && direction == 0) {
            if (animate == 0 || animate == 3) {
                canvas.drawBitmap(RunningLeftMarioSprite1, null, dst, paint);
                animate++;
            }
            else if (animate == 1 || animate == 4){
                canvas.drawBitmap(RunningLeftMarioSprite2, null, dst, paint);
                animate++;
            }
            else if (animate == 2 || animate == 5){
                canvas.drawBitmap(RunningLeftMarioSprite3, null, dst, paint);
                animate = 0;
            }
        }
        else if (!isJumping && isRunning && direction == 1 && speed == 1){
            if (animate == 0 || animate == 1){
                canvas.drawBitmap(RunningRightMarioSprite1, null, dst, paint);
                animate++;
            }
            else if (animate == 2 || animate == 3){
                canvas.drawBitmap(RunningRightMarioSprite2, null, dst, paint);
                animate++;
            }
            else if (animate == 4 || animate == 5){
                canvas.drawBitmap(RunningRightMarioSprite3, null, dst, paint);
                animate = 0;
            }
        }
        else if (!isJumping && isRunning && direction == 0 && speed == 1){
            if (animate == 0 || animate == 1){
                canvas.drawBitmap(RunningLeftMarioSprite1, null, dst, paint);
                animate++;
            }
            else if (animate == 2 || animate == 3){
                canvas.drawBitmap(RunningLeftMarioSprite2, null, dst, paint);
                animate++;
            }
            else if (animate == 4 || animate == 5){
                canvas.drawBitmap(RunningLeftMarioSprite3, null, dst, paint);
                animate = 0;
            }
        }
    }
    public Rect getBounds(){                                    //collision detection
        Rect rect = new Rect();
        rect.top = this.y;
        rect.left = this.x;
        rect.bottom = this.y + this.size;
        rect.right = this.x + this.size;
        return rect;
    }
    public Rect getTopBounds(){                 //collision detection
        Rect rect = new Rect();
        rect.top = this.y;
        rect.left = this.x;
        rect.bottom = this.y + 10;
        rect.right = this.x + this.size;
        return rect;
    }
    public Rect getBotBounds(){                 //collision detection
        Rect rect = new Rect();
        rect.top = this.y + this.size - 10;
        rect.left = this.x;
        rect.bottom = this.y + this.size;
        rect.right = this.x + this.size;
        return rect;
    }
    public Rect getLeftBounds(){                //collision detection
        Rect rect = new Rect();
        rect.top = this.y;
        rect.left = this.x;
        rect.bottom = this.y + this.size;
        rect.right = this.x + 10;
        return rect;
    }
    public Rect getRightBounds(){                   //collision detection
        Rect rect = new Rect();
        rect.top = this.y;
        rect.left = this.x + this.size - 10;
        rect.bottom = this.y + this.size;
        rect.right = this.x + this.size;
        return rect;
    }
    public boolean checkGround(){               //collision detection
        boolean result = false;
        isAerial = true;
        marioRect = this.getBotBounds();
        for (int i = 0; i < so.bricks.size(); i++){
            brickRect = so.bricks.get(i).getTopBounds();
            if (marioRect.intersect(brickRect) || brickRect.contains(marioRect.left,marioRect.bottom + 1) || brickRect.contains(marioRect.right,marioRect.bottom + 1) || brickRect.contains(marioRect.left + size/2,marioRect.bottom+1)) {
                result = true;
                collisionBrick = so.bricks.get(i);
                isAerial = false;
            }
        }
        for (int i = 0; i < so.goombas.size(); i++){
            goombaRect = so.goombas.get(i).getTopBounds();
            if (marioRect.intersect(goombaRect) && !this.getRightBounds().intersect(so.goombas.get(i).getLeftBounds()) && !this.getLeftBounds().intersect(so.goombas.get(i).getRightBounds())) {
                Jump(2);
                score += 100;
                so.goombas.remove(i);
            }

        }
        return result;
    }
    public boolean checkRightSide(){                //collision detection
        boolean result = false;
        marioRect = this.getRightBounds();
        for (int i = 0; i < so.bricks.size(); i++){
            brickRect = so.bricks.get(i).getLeftBounds();
            if(direction == 1) {
                if (marioRect.intersect(brickRect)) {
                    result = true;
                    collisionBrick = so.bricks.get(i);
                }
            }
        }
        for (int i = 0; i < so.goombas.size(); i++){
            goombaRect = so.goombas.get(i).getLeftBounds();
            if (marioRect.intersect(goombaRect)&& !getBotBounds().intersect(so.goombas.get(i).getTopBounds())){
                lives--;
                isAlive = false;
            }
        }
        return result;
    }
    public boolean checkLeftSide(){                 //collision detection
        boolean result = false;
        marioRect = this.getLeftBounds();
        for (int i = 0; i < so.bricks.size(); i++){
            brickRect = so.bricks.get(i).getRightBounds();
            if(direction == 0) {
                if (marioRect.intersect(brickRect)) {
                    result = true;
                    collisionBrick = so.bricks.get(i);
                }
            }
        }
        for (int i = 0; i < so.goombas.size(); i++){
            goombaRect = so.goombas.get(i).getRightBounds();
            if(marioRect.intersect(goombaRect)&& !getBotBounds().intersect(so.goombas.get(i).getTopBounds())){
                lives--;
                isAlive = false;
            }
        }
        return result;
    }
    public boolean checkSky(){                  //collision detection
        boolean result = false;
        marioRect = this.getTopBounds();
        for (int i = 0; i < so.bricks.size(); i++){
            brickRect = so.bricks.get(i).getBotBounds();
            if (marioRect.intersect(brickRect))  { //
                result = true;
                collisionBrick = so.bricks.get(i);
                if (so.bricks.get(i).breakable && isgoingUp() && isJumping)
                so.bricks.remove(i);
            }
        }
        for (int i = 0; i < so.goombas.size(); i++){
            goombaRect = so.goombas.get(i).getBotBounds();
            if (marioRect.intersect(goombaRect)){
                lives--;
                isAlive = false;
            }
        }
        return result;
    }
    public void checkItems(){                   //collision item detection
        marioRect = getBounds();
        for (int i = 0; i < so.mushrooms.size(); i++){
            mushRect = so.mushrooms.get(i).getBounds();
            if (marioRect.intersect(mushRect)){                                             //grow mario
                if ((size == 50 || size == 100) && so.mushrooms.get(i).type == 1) {
                    this.y -= size;
                    this.size *= 2;
                }
                if ((size == 100 || size == 200) && so.mushrooms.get(i).type == 2){         //shrink mario
                    this.size /= 2;
                }
                so.mushrooms.remove(i);
            }
        }
        for (int i = 0; i < so.coins.size(); i++){                                          //increase score
            coinRect = so.coins.get(i).getBounds();
            if (marioRect.intersect(coinRect)){
                score += 100;
                so.coins.remove(i);
            }
        }
        for (int i = 0; i < so.plants.size(); i++){                                         //died
            plantRect = so.plants.get(i).getBounds();
            if (marioRect.intersect(plantRect)) {
                lives--;
                isAlive = false;
            }
        }
    }
    public void tick(Canvas canvas){                                // everything put together to make mario tick
        advanceFrame();
        if (isJumping) {
            if (checkSky()) {
                this.y = collisionBrick.y + collisionBrick.size + 1;
                isJumping = false;
            }
        }
        if (checkGround()){
            this.y = collisionBrick.y - this.size;
        }
        if (checkRightSide() && !checkSky()){                       //rightside collision
            this.x = collisionBrick.x - this.size - 1;
        }
        if (checkLeftSide() && !checkSky()){
            this.x = collisionBrick.x + collisionBrick.size + 1;    //leftside collision
        }
        if (this.y > 1200){
            this.lives--;
            isAlive = false;
        }
        checkItems();
        draw(canvas);
    }
}
