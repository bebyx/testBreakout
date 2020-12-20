package com.mytest.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;

public class Paddle {
    float x;
    float y;
    int width;
    int height;
    private Vector3 touchPos;

    public Paddle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update() {
        touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        x = (touchPos.x - width / 2);
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(x, y, width, height);
    }
}