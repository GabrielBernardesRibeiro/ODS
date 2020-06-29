package com.d.graficos;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.d.entities.Player;
import com.d.main.Game;
import com.d.main.Timer;
import com.d.screens.Actions;

public class Maps {
	
	private static BufferedImage [] citzenMap;
	public static boolean draw = false;
	public static boolean citzenMapGet = false;
	
	public static void getMap(int level) {
		if(level == Player.citzen) {
			Player.getSpriteCitzen = Player.getSpriteNegative;
			citzenMap = new BufferedImage[9];
			for(int i= 0; i < 9; i++) {	
				citzenMap[i] = Game.spritesheet.getSprite(Game.bitUsed*i+(Game.bitUsed * 9), Game.bitUsed * 0, Game.bitUsed, Game.bitUsed);
			}
			//System.out.println("PEGUEI O SPRITE!!!!!!!!!!!!");
		}
		//System.out.println("NAO PEGUEI O SPRITE!!!!!!!!!!!!");
	}
	
	public static void tick() {
		if(Player.mx > (600) && Player.mx < (792) && Player.my > (430) && Player.my < (470)) {
			draw = false;
			//Menu.achievements = false;
			Timer.timing = true;
			Actions.draw= false;
		}
	}
	
	public static void render(Graphics g) {
		if(draw) {
			if(Player.level == Player.citzen) {
					Window.render(g);
					g.drawImage(citzenMap[0], 300+(32*0),100+(32*0),null); g.drawImage(citzenMap[1], 300+(32*1),100+(32*0),null); g.drawImage(citzenMap[2], 300+(32*2),100+(32*0),null);
					g.drawImage(citzenMap[3], 300+(32*0),100+(32*1),null); g.drawImage(citzenMap[4], 300+(32*1),100+(32*1),null); g.drawImage(citzenMap[5], 300+(32*2),100+(32*1),null);
					g.drawImage(citzenMap[6], 300+(32*0),100+(32*2),null); g.drawImage(citzenMap[7], 300+(32*1),100+(32*2),null); g.drawImage(citzenMap[8], 300+(32*2),100+(32*2),null);
					
				}
			}
		}
	

}
