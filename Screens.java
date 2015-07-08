package com.example.andrew.mariogame;

/**
 * Created by Anissa on 13-May-15.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;


public class Screens {
    Bitmap start, back1, back2, back3, end, one, two, three, lives, oneshadow, twoshadow, threeshadow, livesshadow, ret, returnshadow; //These are based on level.
    Rect dst = new Rect(0, 0, 1920, 1080);
    static Rect oneRect = new Rect(800, 350, 1150, 450);
    static Rect twoRect = new Rect(800, 500, 1150, 600);
    static Rect threeRect = new Rect(800, 650, 1150, 750);
    static Rect livesRect = new Rect(800, 800, 1150, 900);
    static Rect retRect = new Rect (1500, 50, 1850, 150);
    static int shadowCheck = 0;
    static int score = 0; //SCORE
    static int life = 3; //generic life = 3. Max = 6, least = 1.
    Paint textpaint = new Paint();
    Paint paint = new Paint();
    Mario mario;

    Screens(Context context, Mario mario){
        //debugging note: The sizes of the images were too big so it caused our game to crash,
        //in the future, make images 50% smaller if they affect the game
        BitmapFactory.Options options = new BitmapFactory.Options();
        start = BitmapFactory.decodeResource(context.getResources(), R.drawable.start, options);
        back1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.back1, options);
        back2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.back2, options);
        back3 = BitmapFactory.decodeResource(context.getResources(), R.drawable.back3, options);
        end = BitmapFactory.decodeResource(context.getResources(), R.drawable.end, options);
        one = BitmapFactory.decodeResource(context.getResources(), R.drawable.one, options);
        two = BitmapFactory.decodeResource(context.getResources(), R.drawable.two, options);
        three = BitmapFactory.decodeResource(context.getResources(), R.drawable.three, options);
        lives = BitmapFactory.decodeResource(context.getResources(), R.drawable.lives, options);
        oneshadow = BitmapFactory.decodeResource(context.getResources(), R.drawable.oneshadow, options);
        twoshadow = BitmapFactory.decodeResource(context.getResources(), R.drawable.twoshadow, options);
        threeshadow = BitmapFactory.decodeResource(context.getResources(), R.drawable.threeshadow, options);
        livesshadow = BitmapFactory.decodeResource(context.getResources(), R.drawable.livesshadow, options);
        ret = BitmapFactory.decodeResource(context.getResources(), R.drawable.ret, options);
        returnshadow = BitmapFactory.decodeResource(context.getResources(), R.drawable.returnshadow, options);
        this.mario = mario;
    }

    public void start (Canvas c) {
        textpaint.setTextSize(70);
        textpaint.setColor(Color.LTGRAY);
        c.drawBitmap(start, null, dst, paint);
        if (shadowCheck == 1){
            c.drawBitmap(oneshadow, null, oneRect, paint);
        }
        else {c.drawBitmap(one, null, oneRect, paint);}
        if (shadowCheck == 2){
            c.drawBitmap(twoshadow, null, twoRect, paint);
        }
        else {c.drawBitmap(two, null, twoRect, paint);}
        if (shadowCheck == 3){
            c.drawBitmap(threeshadow, null, threeRect, paint);
        }
        else {c.drawBitmap(three, null, threeRect, paint);}
        if (shadowCheck == 4){
            c.drawBitmap(livesshadow, null, livesRect, paint);
            c.drawText(String.valueOf(life), 1050, 872, textpaint);
        }
        else {c.drawBitmap(lives, null, livesRect, paint);
            c.drawText(String.valueOf(life), 1050, 872, textpaint);
        }
    }


    public void tick (Canvas c){
        c.drawBitmap(back1, null, dst, paint);

        if (shadowCheck == 5){
            c.drawBitmap(returnshadow, null, retRect, paint);
        }
        else {c.drawBitmap(ret, null, retRect, paint);}

        textpaint.setTextSize(70);
        textpaint.setColor(Color.LTGRAY);
        c.drawText(String.valueOf(mario.lives) + " LIVES" + "  SCORE: " + String.valueOf(mario.score), 0, 72, textpaint);
    }

    public void tick2(Canvas c){
        c.drawBitmap(back2, null, dst, paint);
        c.drawText(String.valueOf(mario.lives) + " LIVES" + "  SCORE: " + String.valueOf(mario.score), 0, 72, textpaint);
        if (shadowCheck == 5){
            c.drawBitmap(returnshadow, null, retRect, paint);
        }
        else {c.drawBitmap(ret, null, retRect, paint);}
    }

    public void tick3(Canvas c){
        c.drawBitmap(back3, null, dst, paint);
        c.drawText(String.valueOf(mario.lives) + " LIVES" + "  SCORE: " + String.valueOf(mario.score), 0, 72, textpaint);
        if (shadowCheck == 5){
            c.drawBitmap(returnshadow, null, retRect, paint);
        }
        else {c.drawBitmap(ret, null, retRect, paint);}
    }

    public void gameOver(Canvas c){
        c.drawBitmap(end, null, dst, paint);
        c.drawText("SCORE: " + String.valueOf(mario.score), 800, 872, textpaint);
        if (shadowCheck == 5){
            c.drawBitmap(returnshadow, null, retRect, paint);
        }
        else {c.drawBitmap(ret, null, retRect, paint);}
    }
}
