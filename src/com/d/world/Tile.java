package com.d.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.d.main.Game;

public class Tile {
	
	public static BufferedImage TILE_FLOOR = Game.spritesheet.getSprite(0, 0, 16  * 2, 16  * 2);
	public static BufferedImage TILE_WALL = Game.spritesheet.getSprite(32, 0, 16  * 2, 16  * 2);
	public static BufferedImage ROOM_CITZEN= Game.spritesheet.getSprite(0, 32 * 9, 16, (32*6));
	public static BufferedImage TILE_BLANC  = Game.spritesheet.getSprite(0, 0, 32, 32);
	
	private BufferedImage sprite;
	private int x, y;
	
	public Tile(int x, int y, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
	
	public void render(Graphics g) {
		g.drawImage(sprite, x - Camera.x , y - Camera.y, null);
	}
	
}
