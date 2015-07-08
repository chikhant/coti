package com.example.andrew.mariogame;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;

/**
 * Created by Anissa on 13-May-15.
 */
public class ScreenObjects {                                                                                // data structure for making game
    ArrayList<Brick> bricks = new ArrayList<>();
    ArrayList<Coin> coins = new ArrayList<>();
    ArrayList<Goomba> goombas = new ArrayList<>();
    ArrayList<Plant> plants = new ArrayList<>();
    ArrayList<Mushroom> mushrooms = new ArrayList<>();
    ArrayList<Star> stars = new ArrayList<>();
    Bitmap brickSprite, brickSprite2, goombaSprite, coinSprite, plantSprite, mushroomSprite, mushroomSprite2, starSprite;
    Paint paint = new Paint();
    Rect mushRect = new Rect();
    Rect coinRect = new Rect();
    Rect brickRect = new Rect();
    Rect goombaRect = new Rect();
    Rect plantRect = new Rect();
    Rect starRect = new Rect();

    ScreenObjects(Context context){
        BitmapFactory.Options options = new BitmapFactory.Options();
        brickSprite = BitmapFactory.decodeResource(context.getResources(), R.drawable.brick, options);
        brickSprite2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.brick2, options);
        goombaSprite = BitmapFactory.decodeResource(context.getResources(), R.drawable.goomba, options);
        coinSprite = BitmapFactory.decodeResource(context.getResources(), R.drawable.coin, options);
        plantSprite = BitmapFactory.decodeResource(context.getResources(), R.drawable.plant, options);
        mushroomSprite = BitmapFactory.decodeResource(context.getResources(), R.drawable.mushsuper, options);
        mushroomSprite2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.greenmush, options);
        starSprite = BitmapFactory.decodeResource(context.getResources(), R.drawable.star, options);
    }

    public void reset(){                                                                            // reset map
        bricks.clear();
        coins.clear();
        goombas.clear();
        plants.clear();
        mushrooms.clear();
        stars.clear();
    }
    public void floorLay(int gameState){                                                            // This method constructs the different levels 1-3
        /*-------------------------------------------LEVEL 1-------------------------------------------*/
        if(bricks.size() == 0 && coins.size() == 0 && goombas.size() == 0 && plants.size() == 0 && mushrooms.size() == 0 && stars.size() == 0 && gameState == 1){  //laying out the bottom floor
            for (int i = 0; i < 71; i++){
                if(i == 50 || i == 53 || i == 54 || i == 55 || i == 27 || i == 28 || i == 40 || i == 41 || i == 42 || i == 43)
                    continue;
                Brick brick = new Brick(100*i, 950, true);
                bricks.add(brick);
            }
            for (int i = 6; i < 10; i++){
                Brick brick = new Brick(100 * i + 50, 700, true);
                bricks.add(brick);
                if (i == 6 || i == 9) {
                    Brick brick1 = new Brick(100 * i + 50, 600, true);
                    bricks.add(brick1);
                }
            }
            for (int i = 29; i < 40; i ++){
                Brick brick = new Brick (100*i, 550, true);
                bricks.add(brick);
            }
            for (int i = 53; i < 56; i++){
                if ( i == 53 ){
                    Brick brick = new Brick (5300, 450, true);
                    bricks.add(brick);
                }
                if (i == 55){
                    Brick brick = new Brick (5500, 650, true);
                    Brick brick1 = new Brick ( 5500, 250, true);
                    bricks.add(brick);
                    bricks.add(brick1);
                }
            }
            for (int i = 3; i < 5; i++){
                Brick brick = new Brick (100*i, 850, false);
                bricks.add(brick);
                if (i == 4){
                    Brick brick1 = new Brick (100*i, 750, false);
                    bricks.add(brick1);
                }
            }
            for (int i = 5; i < 9; i++){
                Brick brick = new Brick (1200, 100*i + 50, false);
                bricks.add(brick);
            }
            for ( int i = 17; i < 20; i ++){
                Brick brick = new Brick ( 100 * i, 850, false);
                Brick brick1 = new Brick ( 100 * i, 750, false);
                Brick brick2 = new Brick ( 100 * i, 650, false);
                Brick brick3 = new Brick ( 100 * i, 550, false);
                if (i == 17) {
                    bricks.add(brick);
                    bricks.add(brick1);
                    bricks.add(brick2);
                    bricks.add(brick3);
                }
                if (i == 18){
                    bricks.add(brick);
                    bricks.add(brick1);
                    bricks.add(brick2);
                }
                if (i == 19){
                    bricks.add(brick);
                    bricks.add(brick1);
                }
            }
            for (int i = 23; i < 27; i ++){
                Brick brick = new Brick ( 100 * i, 850, false);
                Brick brick1 = new Brick ( 100 * i, 750, false);
                Brick brick2 = new Brick ( 100 * i, 650, false);
                Brick brick3 = new Brick ( 100 * i, 550, false);
                if (i == 23)
                    bricks.add(brick);
                if (i == 24){
                    bricks.add(brick);
                    bricks.add(brick1);
                }
                if (i == 25){
                    bricks.add(brick);
                    bricks.add(brick1);
                    bricks.add(brick2);
                }
                if (i == 26){
                    bricks.add(brick);
                    bricks.add(brick1);
                    bricks.add(brick2);
                    bricks.add(brick3);
                }
            }
            for ( int i = 48; i < 51; i++){
                Brick brick = new Brick ( 100 * i, 850, false);
                Brick brick1 = new Brick ( 100 * i, 750, false);
                Brick brick2 = new Brick ( 100 * i, 450, false);
                if (i == 48)
                    bricks.add(brick);
                    bricks.add(brick2);
                if (i == 49){
                    bricks.add(brick);
                    bricks.add(brick1);
                }
            }
            for (int i = 45; i < 47; i++){
                Brick brick = new Brick ( 100 * i, 650, false);
                Brick brick1 = new Brick ( 100 * i, 550, false);
                Brick brick2 = new Brick ( 100 * i, 250, false);
                Brick brick3 = new Brick ( 100 * i, 150, false);
                if (i == 45){
                    bricks.add(brick);
                    bricks.add(brick1);
                    bricks.add(brick2);
                    bricks.add(brick3);
                }
                if (i == 46) {
                    bricks.add(brick);
                    bricks.add(brick2);
                }
            }
            for (int i = 2; i < 9; i++){
                Brick brick = new Brick (5100, 100*i + 50, false);
                bricks.add(brick);
            }
            for (int i = 0; i < 4; i++){
                Brick brick = new Brick (5800, 100*i + 50, false);
                bricks.add(brick);
            }
            for (int i = 63; i < 66; i++){
                Brick brick = new Brick (i * 100, 50, true);
                bricks.add(brick);
            }
            for (int i = 63; i < 66; i++){
                Coin coin = new Coin( i * 100, -50);
                coins.add(coin);
            }
            for (int i = 61; i < 66; i ++){
                Brick brick = new Brick ( 100 * i, 850, false);
                Brick brick1 = new Brick ( 100 * i, 750, false);
                Brick brick2 = new Brick ( 100 * i, 650, false);
                Brick brick3 = new Brick ( 100 * i, 550, false);
                if (i == 61)
                    bricks.add(brick);
                if (i == 62){
                    bricks.add(brick);
                    bricks.add(brick1);
                }
                if (i == 63){
                    bricks.add(brick);
                    bricks.add(brick1);
                    bricks.add(brick2);
                }
                if (i == 64 || i==65){
                    bricks.add(brick);
                    bricks.add(brick1);
                    bricks.add(brick2);
                    bricks.add(brick3);
                }
            }
            for ( int i = 13; i < 17; i ++){
                Plant plant = new Plant(i*100, 850);
                plants.add(plant);
            }
            Plant plant1 = new Plant(3100, 850);
            Plant plant2 = new Plant(3600, 850);
            Plant plant3 = new Plant(5000, 950);
            Plant plant4 = new Plant(6650, 850);
            Plant plant5 = new Plant(6950, 850);
            plants.add(plant1);
            plants.add(plant2);
            plants.add(plant3);
            plants.add(plant4);
            plants.add(plant5);
            for (int i = 53; i < 56; i++){
                Plant plant = new Plant(i*100, 950);
                plants.add(plant);
            }
            Goomba goomba = new Goomba(800, 550, 1);
            Goomba goomba1 = new Goomba(2150, 800, 1);
            Goomba goomba2 = new Goomba(3300, 400, 1);
            Goomba goomba3 = new Goomba(3700, 400, 0);
            Goomba goomba4 = new Goomba(4400, 0, 1);
            goombas.add(goomba);
            goombas.add(goomba1);
            goombas.add(goomba2);
            goombas.add(goomba3);
            goombas.add(goomba4);
            Mushroom mushroom = new Mushroom(1900, 650, 1);
            Mushroom mushroom1 = new Mushroom(4100, 450, 2);
            Mushroom mushroom2 = new Mushroom(5200, 850, 1);
            mushrooms.add(mushroom);
            mushrooms.add(mushroom1);
            mushrooms.add(mushroom2);
            Coin coin1 = new Coin(400, 650);
            Coin coin2 = new Coin(650, 500);
            Coin coin3 = new Coin(950, 500);
            Coin coin4 = new Coin(1700, 450);
            Coin coin5 = new Coin(2600, 450);
            coins.add(coin1);
            coins.add(coin2);
            coins.add(coin3);
            coins.add(coin4);
            coins.add(coin5);
            for (int i = 32; i < 36; i++){
                Coin coin = new Coin (i * 100, 850);
                coins.add(coin);
            }
            Star star = new Star(6800, 850);
            stars.add(star);
        }
        /*----------------------------------LEVEL 2-------------------------------------*/
        if(bricks.size() == 0 && coins.size() == 0 && goombas.size() == 0 && plants.size() == 0 && mushrooms.size() == 0 && gameState == 2){
            for (int i = 0; i < 30; i++){
                Brick brick = new Brick (i*100, 950, true);
                bricks.add(brick);
            }
            for (int i = 3; i < 30; i++) {
                Brick brick = new Brick(100 * i, 850, false);
                Brick brick_1 = new Brick(100 * i, 750, false);
                Brick brick_2 = new Brick(100 * i, 650, false);
                Brick brick_3 = new Brick(100 * i, 550, false);
                if (i == 3)
                    bricks.add(brick);
                if (i == 4) {
                    bricks.add(brick);
                    bricks.add(brick_1);
                }
                if (i == 5) {
                    bricks.add(brick);
                    bricks.add(brick_1);
                    bricks.add(brick_2);
                }

                if (i == 6 || i == 26 || i == 29){
                    bricks.add(brick);
                    bricks.add(brick_1);
                    bricks.add(brick_2);
                    bricks.add(brick_3);
                }
            }
            Plant plant = new Plant (1100, 850);
            Plant plant1 = new Plant ( 1500, 850);
            Plant plant2 = new Plant ( 2200, 850);
            plants.add(plant);
            plants.add(plant1);
            plants.add(plant2);
            Goomba goomba = new Goomba(800, 550, 1);
            Goomba goomba1 = new Goomba(1250, 800, 0);
            Goomba goomba2 = new Goomba(1600, 650, 1);
            Goomba goomba3 = new Goomba(1900, 500, 0);
            Goomba goomba4 = new Goomba(2300, 700, 1);
            goombas.add(goomba);
            goombas.add(goomba1);
            goombas.add(goomba2);
            goombas.add(goomba3);
            goombas.add(goomba4);
            Star star = new Star (2750, 850);
            stars.add(star);
        }
        /*-----------------------------------LEVEL 3-------------------------------------*/
        if(bricks.size() == 0 && coins.size() == 0 && goombas.size() == 0 && plants.size() == 0 && mushrooms.size() == 0 && gameState == 3){
            for (int i = 0; i < 4; i++){
                Brick brick = new Brick(i * 100, 950, true);
                bricks.add(brick);
            }
            Brick brick1 = new Brick (500, 850, true);
            Brick brick2 = new Brick (700, 750, true);
            Brick brick3 = new Brick (800, 550, true);
            Brick brick4 = new Brick (900, 350, true);
            Brick brick5 = new Brick (1200, 450, true);
            Brick brick6 = new Brick (1500, 350, true);
            Brick brick7 = new Brick (1800, 450, true);
            Brick brick8 = new Brick (1900, 250, true);
            bricks.add(brick1);
            bricks.add(brick2);
            bricks.add(brick3);
            bricks.add(brick4);
            bricks.add(brick5);
            bricks.add(brick6);
            bricks.add(brick7);
            bricks.add(brick8);
            for (int i = 21; i < 26; i++){
                Brick brick = new Brick ( i * 100, 550, false);
                bricks.add (brick);
                if (i == 21){
                    Brick brick01 = new Brick (i*100, 450, false);
                    bricks.add(brick01);
                }
            }
            for (int i = 27; i < 34; i++){
                Brick brick = new Brick ( i* 100, 150, true);
                bricks.add(brick);
            }
            Brick brick9 = new Brick ( 2700, 750, true);
            Brick brick10 = new Brick ( 3000, 850, true);
            Brick brick11 = new Brick ( 3300, 750, true);
            bricks.add(brick9);
            bricks.add(brick10);
            bricks.add(brick11);
            for (int i = 41; i < 67; i++){
                Brick brick = new Brick(i * 100, 950, true);
                bricks.add(brick);
            }
            for (int i = 60; i < 67; i++) {
                Brick brick = new Brick(100 * i, 850, false);
                Brick brick_1 = new Brick(100 * i, 750, false);
                Brick brick_2 = new Brick(100 * i, 650, false);
                Brick brick_3 = new Brick(100 * i, 550, false);
                if (i == 60)
                    bricks.add(brick);
                if (i == 61) {
                    bricks.add(brick);
                    bricks.add(brick_1);
                }
                if (i == 62) {
                    bricks.add(brick);
                    bricks.add(brick_1);
                    bricks.add(brick_2);
                }
                if (i == 63) {
                    bricks.add(brick);
                    bricks.add(brick_1);
                    bricks.add(brick_2);
                    bricks.add(brick_3);
                }
                if (i == 66){
                    bricks.add(brick);
                    bricks.add(brick_1);
                    bricks.add(brick_2);
                    bricks.add(brick_3);
                }
            }
            for (int i = 28; i < 34; i +=2){
                Coin coin = new Coin ( i * 100, 50);
                coins.add(coin);
            }
            Goomba goomba = new Goomba(2500, 350, 0);
            Goomba goomba1 = new Goomba(4500, 750, 0);
            Goomba goomba2 = new Goomba(5000, 750, 0);
            Goomba goomba3 = new Goomba(5500, 750, 0);
            goombas.add(goomba);
            goombas.add(goomba1);
            goombas.add(goomba2);
            goombas.add(goomba3);
        }
        Star star = new Star ( 6450, 850);
        stars.add(star);
    }
    public void drawBrick(Brick b, Canvas canvas){                  // draw bricks
        brickRect.top = b.y;
        brickRect.left = b.x;
        brickRect.bottom = b.y + b.size;
        brickRect.right = b.x + b.size;
        if(b.breakable)
        canvas.drawBitmap(brickSprite, null, brickRect, paint);
        else
        canvas.drawBitmap(brickSprite2, null, brickRect, paint);
    }
    public void drawCoin(Coin coin, Canvas c){                      //draw coins
        coinRect.top = coin.y;
        coinRect.left = coin.x;
        coinRect.bottom = coin.y + coin.size;
        coinRect.right = coin.x + coin.size;
        c.drawBitmap(coinSprite, null, coinRect, paint);
    }
    public void drawMushroom(Mushroom mush, Canvas c){              // draw mushrooms
        mushRect.top = mush.y;
        mushRect.left = mush.x;
        mushRect.bottom = mush.y + mush.size;
        mushRect.right = mush.x + mush.size;
        if (mush.type == 1)
        c.drawBitmap(mushroomSprite, null, mushRect, paint);
        if (mush.type == 2)
        c.drawBitmap(mushroomSprite2, null, mushRect, paint);
    }
    public void drawPlant(Plant p, Canvas c){
        plantRect.top = p.y;
        plantRect.left = p.x;
        plantRect.bottom = p.y + p.size;
        plantRect.right = p.x + p.size;
        c.drawBitmap(plantSprite, null, plantRect, paint);
    }
    public void drawGoomba(Goomba g, Canvas c){             // draw goombas
        goombaRect.top = g.y;
        goombaRect.left = g.x;
        goombaRect.bottom = g.y + g.size;
        goombaRect.right = g.x + g.size;
        c.drawBitmap(goombaSprite, null, goombaRect, paint);
    }
    public void drawStar(Star s, Canvas c){             // draw star(s)
        starRect.left = s.x;
        starRect.right = s.x + s.size;
        starRect.top = s.y;
        starRect.bottom = s.y + s.size;
        c.drawBitmap(starSprite, null, starRect, paint);
    }
    public void tick(Canvas c){
        boolean loop;
        for (int i = 0; i < bricks.size(); i++){            //draw bricks
            if (bricks.get(i).x < 1920)
            drawBrick(bricks.get(i), c);
        }
        loop = true;
        while (loop){
            loop = false;
            for ( int i = 0; i < bricks.size(); i++ ) {     //remove bricks past screen
                if (bricks.get(i).x < -100) {
                    bricks.remove(i);
                    loop = true;
                }
            }
        }
        for (int i = 0; i < coins.size(); i++){                 //draw coins
            if(coins.get(i).x < 1920)
                drawCoin(coins.get(i), c);
        }
        loop = true;
        while (loop){
            loop = false;
            for (int i = 0; i < coins.size(); i++) {            //delete coins off screen
                if (coins.get(i).x < -100) {
                    coins.remove(i);
                    loop = true;
                }
            }
        }
        for (int i = 0; i < mushrooms.size(); i++){         //draw mushrooms
            if(mushrooms.get(i).x < 1920)
                drawMushroom(mushrooms.get(i), c);
        }
        loop = true;
        while(loop){
            loop = false;
            for (int i = 0; i < mushrooms.size(); i++){     //remove mushrooms past screen
                if (mushrooms.get(i).x < -100){
                    mushrooms.remove(i);
                    loop = true;
                }
            }
        }
        for (int i = 0; i < plants.size(); i++){                //draw plants
            if (plants.get(i).x < 1920)
                drawPlant(plants.get(i), c);
        }
        loop = true;
        while (loop){
            loop = false;
            for (int i = 0; i < plants.size(); i++){            //remove plants past screen
                if (plants.get(i).x < -100){
                    plants.remove(i);
                    loop = true;
                }
            }
        }
        for (int i = 0; i < goombas.size(); i++){
            if (goombas.get(i).x < 1920) {                                                            // only render if on screen
                goombas.get(i).advanceFrame();
                for (int j = 0; j < bricks.size(); j++) {
                    if (goombas.get(i).getBotBounds().intersect(bricks.get(j).getTopBounds())){
                        goombas.get(i).y = bricks.get(j).y - goombas.get(i).size - 1;
                    }
                    if (goombas.get(i).getLeftBounds().intersect(bricks.get(j).getRightBounds())) {   // goomba left collision
                        goombas.get(i).x = bricks.get(j).x + bricks.get(j).size + 1;
                        goombas.get(i).direction = 1;
                    }
                    else if (goombas.get(i).getRightBounds().intersect(bricks.get(j).getLeftBounds())){ //goomba right collision
                        goombas.get(i).direction = 0;
                        goombas.get(i).x = bricks.get(j).x - goombas.get(i).size - 1;
                    }
                }
            }
        }
        for (int i = 0; i < goombas.size(); i++){
            if (goombas.get(i).x < 1920){
                drawGoomba(goombas.get(i), c);
            }
        }
        loop = true;
        while (loop){
            loop = false;
            for (int i = 0; i < goombas.size(); i++){            //remove goombas past screen
                if (goombas.get(i).x < -100 || goombas.get(i).y > 1200){
                    goombas.remove(i);
                    loop = true;
                }
            }
        }
        if(stars.get(0).x < 1920){                                                                  //draw the stars
            drawStar(stars.get(0), c);
        }
    }
}