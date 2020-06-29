package com.d.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

//import com.d.main.Game;
import com.d.world.Camera;
import com.d.world.Node;
import com.d.world.Vector2i;

public class Entity 
{	
	protected double x;
	protected double y;
	protected int width;
	protected int height;
	protected double speed;
	
	public int depth;	
	
	private BufferedImage sprite;
	
	protected List<Node> path;
	
	public static Random rand = new Random();
	
	public Entity(double x , double y , int width , int height, double speed, BufferedImage sprite) 
	{
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.width = width;
		this.height = height;
		this.sprite = sprite;
	}
	
	public static Comparator<Entity> nodeSorter = new Comparator<Entity>() {		
		@Override
		public int compare(Entity n0, Entity n1) {
			if(n1.depth < n0.depth)
				return + 1;
			if(n1.depth > n0.depth)
				return - 1;
			return 0;
		}
	};
	
	
		
	public void setX(int newX) {
		this.x = newX;
		
	}
	
	public void sety(int newY) {
		this.y = newY;
	}
	
	
	public int getX(){	return (int)this.x;		}
	public int getY(){	return (int)this.y;		}
	public int getWidth(){	return this.width;		}
	public int getHeight(){	return this.height;		}
	
	public void tick() {}
	
	public double calculatedDistance(int x1, int y1, int x2, int y2) {
		
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
	
	
	public void followPath(List<Node> path) {
		if(path != null) {
			if(path.size() > 0) {
				Vector2i target = path.get(path.size()-1).tile;
				//xprev = x;
				//yprev = y;
				if(		x < target.x * 16 ) x++;
				else if(x > target.x * 16 ) x--;
				if(		y < target.y * 16 ) y++;
				else if(y > target.y * 16 ) y--;
				
				if( x == target.x * 16 && y == target.y * 16) path.remove(path.size() - 1);
			}
		}
	}
	
	public static boolean isColidding(Entity e1, Entity e2) {
		Rectangle e1Mask = new Rectangle(e1.getX(), e1.getY(), e1.getWidth(), e1.getHeight());
		Rectangle e2Mask = new Rectangle(e2.getX(), e2.getY(), e2.getWidth(), e2.getHeight());
		
		return e1Mask.intersects(e2Mask);
		}
	
	
	public void render(Graphics g) 
	{
		g.drawImage(sprite,this.getX() - Camera.x,this.getY() - Camera.y,null);
		//g.setColor(Color.red);
		//g.fillRect(this.getX() + maskx - Camera.x,this.getY()+masky - Camera.y, mwidth, mheight);
	
	
	}
	
	
	
	
}
