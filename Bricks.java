package com.ayush.block;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Bricks
{
	int x,y,width,height;
	Boolean destroyed = false;
	
	public Bricks(int x,int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void draw(ShapeRenderer shape){
		shape.rect(x,y,width,height);
	}
}
