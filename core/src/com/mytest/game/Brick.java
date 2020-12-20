package com.mytest.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Brick {
    int x,y,width,height;
    Boolean destroyed;

    public Brick(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.destroyed = false;
    }

    public void draw(ShapeRenderer shape){
        shape.rect(x, y, width, height);
    }
}