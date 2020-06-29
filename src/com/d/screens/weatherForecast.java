package com.d.screens;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.d.main.Game;
import com.d.main.Timer;

public class weatherForecast {
	
	public static BufferedImage rainSprite = Game.spritesheet.getSprite(32 * 14, 32 * 4, 58, 29);
	public static BufferedImage sunSprite = Game.spritesheet.getSprite((32 * 14)+ 58, 32 * 4, 58, 29);
	public static BufferedImage odsNews= Game.spritesheet.getSprite(0, 32*4, 32*7, (32 * 4) + 10);
	public static BufferedImage weatherForecast= Game.spritesheet.getSprite(32*7, 32*4, 32*7, (32 * 4) + 10);
	public static boolean drawPermission= false;
	public static int week[]= new int[7];
	public static int permission= 1;
	
	public static void tick() {
		if(Timer.day == 1 && permission== 1) {
			permission= 0;
			//week= new int[7];
			for(int i= 0; i< 7; i++) {
				week[i]= Game.rand.nextInt(100);
				if(week[i] <= 70)
					System.out.println("O dia "+i+" esta ensolarado e o numero sorteado foi: "+week[i]);
				else
					System.out.println("O dia "+i+" esta chuvoso e o numero sorteado foi: "+week[i]);
			}
		}
		if(Timer.day != 1 && permission== 0)
			permission= 1;
	}
	
	public static void render(Graphics g) {
		g.drawImage(odsNews, 10, 10,null);
		g.drawImage(weatherForecast, 440, 175,null);
		//g.drawImage(rainSprite, 463, 196,null);
		//g.drawImage(sunSprite, 463+58+2, 196,null);
		//primeira linha
		for(int i=0; i<=2; i++) {
			if(week[i] <= 70) {
				g.drawImage(sunSprite, 463+(60 * i), 196,null);
			}else {
				g.drawImage(rainSprite, 463+(60 * i), 196,null);
			}
		}
		//segunda linha
		for(int i=0; i<=2; i++) {
			if(week[i] <= 70) {
				g.drawImage(sunSprite, 463+(60 * i), 234,null);
			}else {
				g.drawImage(rainSprite, 463+(60 * i), 234,null);
			}
		}
		//terceira linha
		if(week[6] <= 70) {
			g.drawImage(sunSprite, 463, 272,null);
		}else {
			g.drawImage(rainSprite, 463, 272,null);
		}
		if(drawPermission) {
			for(int i= 0; i<=2; i=i+2) {
				if(week[i] <= 70) {
					g.drawImage(sunSprite, 463+(58 * (i + 2)), 171+((i/2)*35),null);
				}else {
					g.drawImage(rainSprite, 581, 171+((i/2)*35),null);
				}
			}
			for(int i= 1; i<=5; i=i+2) {
				if(week[i] <= 70) {
					g.drawImage(sunSprite, 631, 171+(((int)(i/2))*35),null);
				}else {
					g.drawImage(rainSprite, 631, 171+(((int)(i/2))*35),null);
				}
			}
			if(week[6] <= 70) {
				g.drawImage(sunSprite, 606, 276,null);
			}else {
				g.drawImage(rainSprite, 606, 276,null);
			}
		}
	}
	
}
