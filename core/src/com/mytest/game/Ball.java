package com.mytest.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    int x;
    int y;
    int size;
    int xSpeed;
    int ySpeed;
    Color color = Color.WHITE;

    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public void update() {
        x += xSpeed;
        y += ySpeed;
        if (x <= size || x >= Gdx.graphics.getWidth() - size) {
            xSpeed = -xSpeed;
        }
        if (y >= Gdx.graphics.getHeight() - size) {
            ySpeed = -ySpeed;
        }
    }
    public void draw(ShapeRenderer shape) {
        shape.setColor(color);
        shape.circle(x, y, size);
    }

    public void checkCollision(Paddle paddle) {
        if(collidesWith(paddle)) {
            color = Color.GREEN;
            ySpeed = -ySpeed;
        }
        else {
            color = Color.WHITE;
        }
    }

    private boolean collidesWith(Paddle paddle) {

        if (paddle.y + paddle.height >= y - size && paddle.y <= y + size &&
                paddle.x + paddle.width >= x - size && paddle.x <= x + size) {
            return true;
        } else {
            return false;
        }
    }

    public void checkCollisionSmash(Brick brick) {
        if(collidesWithBrick(brick)){
            ySpeed = - ySpeed;
            brick.destroyed = true;
        }
    }

    private boolean collidesWithBrick(Brick brick) {

        if (brick.y + brick.height >= y - size && brick.y <= y + size &&
                brick.x + brick.width >= x - size && brick.x <= x + size) {
            return true;
        } else {
            return false;
        }
    }

}
