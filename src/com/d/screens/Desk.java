package com.d.screens;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.d.main.Game;

public class Desk {
	
	public static BufferedImage mapSprite = Game.spritesheet.getSprite(32 * 9, 32, 32, 32);
	public static BufferedImage phoneSprite = Game.spritesheet.getSprite(32 * 8, 32, 32, 32);
	public static BufferedImage deskSprite_1 = Game.spritesheet.getSprite(32 * 10, 32, 32, 32);
	public static BufferedImage deskSprite_2 = Game.spritesheet.getSprite(32 * 11, 32, 32, 32);
	public static BufferedImage deskSprite_3 = Game.spritesheet.getSprite(32 * 12, 32, 32, 32);
	
	
	public static void tick() {
		
	}
	
	public static void render(Graphics g) {	
		/*g.drawImage(deskSprite_1, 218+70, 100, null);
		g.drawImage(deskSprite_2, 250+70, 100, null);
		g.drawImage(deskSprite_3, 282+70, 100, null);
		g.drawImage(mapSprite, 340, 99, null);
		g.drawImage(phoneSprite, 310, 93, null);*/
	}
}
