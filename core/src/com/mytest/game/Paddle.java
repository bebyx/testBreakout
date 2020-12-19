package com.mytest.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
    float x;
    float y;
    int width;
    int height;

    public Paddle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update() {

    }

    public void draw(ShapeRenderer shape) {
        shape.rect(x, y, width, height);
    }
}