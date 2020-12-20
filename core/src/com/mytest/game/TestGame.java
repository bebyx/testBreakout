package com.mytest.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;

import java.util.ArrayList;

public class TestGame extends ApplicationAdapter {
	private ShapeRenderer shape;
	private Ball ball;
	private Paddle paddle;
	private OrthographicCamera camera;
	ArrayList<Brick> bricks = new ArrayList<>();

	@Override
	public void create() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);

		shape = new ShapeRenderer();
		ball = new Ball(400, 100, 10, 1, 1);
		paddle = new Paddle(30, 10, 100, 10);

		int brickWidth = 63;
		int brickHeight = 20;
		for (int y = Gdx.graphics.getHeight()/2; y < Gdx.graphics.getHeight(); y += brickHeight + 10) {
			for (int x = 0; x < Gdx.graphics.getWidth(); x += brickWidth + 10) {
				bricks.add(new Brick(x, y, brickWidth, brickHeight));
			}
		}
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();

		shape.begin(ShapeRenderer.ShapeType.Filled);
		for (Brick b : bricks) {
			b.draw(shape);
			ball.checkCollisionSmash(b);
		}
		for (int i = 0; i < bricks.size(); i++) {
			Brick b = bricks.get(i);
			if (b.destroyed) {
				bricks.remove(b);
				// we need to decrement i when a ball gets removed, otherwise we skip a ball!
				i--;
			}
		}
		ball.checkCollision(paddle);
		ball.update();
		ball.draw(shape);
		paddle.draw(shape);
		paddle.update();
		for (Brick brick : bricks) {
			brick.draw(shape);
		}
		shape.end();
	}
}