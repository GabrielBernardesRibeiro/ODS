package com.d.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.d.main.Game;

public class Room {
	
	
	public static BufferedImage citzenRoom= Game.spritesheet.getSprite(0, 32*9, (32*6) +10, (32*6)+3);
	
	
	public static void render(Graphics g) {
		g.drawImage(citzenRoom, 250, 50, null);
	}
}
