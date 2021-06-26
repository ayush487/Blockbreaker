package com.ayush.block;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;

public class whiteBall
{
	int x;
	int y;
	int size;
	int xSpeed;
	int ySpeed;
	//Color color = Color.WHITE;

	public whiteBall(int x, int y, int size, int xSpeed, int ySpeed){
		this.x = x;
		this.y = y;
		this.size = size;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	public void update(){
		x += xSpeed;
		y += ySpeed;

		if(x > Gdx.graphics.getWidth() - size || x<0 + size){
			xSpeed = -xSpeed;
		}
		if(y > Gdx.graphics.getHeight() - size || y<0 + size){
			ySpeed = -ySpeed;
		}
	}
	
	public void checkCollision(Paddle paddle) {
        if(collidesWith(paddle)){
			ySpeed = -ySpeed;
        }
    }
	
	public void checkCollision(Bricks brick){
		if(collidesWith(brick)){
			ySpeed = -ySpeed;
			brick.destroyed = true;
		}
	}
	
	private boolean collidesWith(Paddle paddle) {
		if(this.y-this.size <= paddle.y + paddle.height && (this.x - this.size>= paddle.x && this.x + this.size <= paddle.x + paddle.width)) return true;
		else return false;
    }
	
	private boolean collidesWith(Bricks brick){
		if((this.x-this.size >= brick.x && this.x + this.size <= brick.x + brick.width) && (this.y - this.size <= brick.y + brick.height && this.y + this.size >= brick.y ))
			return true;
		else return false;
	}

	public void draw(ShapeRenderer shape){
		shape.circle(x,y,size);
	}

}
