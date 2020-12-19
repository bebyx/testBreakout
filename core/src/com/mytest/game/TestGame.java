package com.mytest.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector3;

public class TestGame extends ApplicationAdapter {
	private ShapeRenderer shape;
	private Ball ball;
	private Paddle paddle;
	private Vector3 touchPos;
	private OrthographicCamera camera;

	@Override
	public void create() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);

		shape = new ShapeRenderer();
		ball = new Ball(400, 100, 20, 5, 5);
		paddle = new Paddle(30, 10, 100, 10);
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();

		shape.begin(ShapeRenderer.ShapeType.Filled);
		ball.checkCollision(paddle);
		ball.update();
		ball.draw(shape);
		paddle.draw(shape);
		if(Gdx.input.isTouched()) {
			touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
			paddle.x = (touchPos.x - paddle.width / 2);
			camera.unproject(touchPos);
			paddle.y = (touchPos.y - paddle.height / 2);
		}
		shape.end();
	}
}