package com.ayush.block;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import java.util.ArrayList;

public class MyGdxGame implements ApplicationListener
{
	ShapeRenderer shape;
	whiteBall ball;
	Paddle pad;
	ArrayList<Bricks> bricks = new ArrayList<>();

	@Override
	public void create()
	{
		shape = new ShapeRenderer();
		ball = new whiteBall(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2,18,10,16);
		pad = new Paddle(Gdx.graphics.getWidth()/2-100,10,25,200);
		
		int blockHeight = 30;
		int blockWidth = 100;
		for(int y = 2*Gdx.graphics.getHeight()/3; y < Gdx.graphics.getHeight(); y+=blockHeight+10){
			for(int x=0;x< Gdx.graphics.getWidth(); x+= blockWidth+10){
				if(y+ blockHeight < Gdx.graphics.getHeight()) bricks.add(new Bricks(x,y, blockWidth, blockHeight));
			}
		}
	}

	@Override
	public void render()
	{        
	    Gdx.gl.glClearColor(0, 0, 0, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shape.begin(ShapeRenderer.ShapeType.Filled);
		pad.move();
		pad.draw(shape);
		ball.update();
		ball.checkCollision(pad);
		
		ball.draw(shape);
		for(Bricks brick: bricks){
			brick.draw(shape);
			ball.checkCollision(brick);
		}
		for (int i=0; i< bricks.size(); i++){
			Bricks b = bricks.get(i);
			if(b.destroyed){
				bricks.remove(b);
				
				i--;
			}
				
		}
		shape.end();
	}

	@Override
	public void dispose()
	{
	}

	@Override
	public void resize(int width, int height)
	{
	}

	@Override
	public void pause()
	{
	}

	@Override
	public void resume()
	{
	}
}
