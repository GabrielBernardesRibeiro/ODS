package com.d.graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.d.main.Game;

public class Credits {
	
	private static int curAnimationBack= 0;
	private static boolean drawBack= true;
	private static double sec= 0.5;
	
	public static boolean click= false;
	public static int mx, my;
	
	public static void tick() {
		if(mx > 547*2 && mx < (547+50)*2 && my > 235*2 && my < (235+20)*2) {
			System.out.println("ESTOU QUERENDO VOLTAR");
			curAnimationBack++;
			if(curAnimationBack == 60 * sec && drawBack) {
				curAnimationBack= 0;
				drawBack= false;
			}else if(curAnimationBack == 60 * sec && !drawBack) {
				curAnimationBack= 0;
				drawBack= true;
			}
		}else {
			curAnimationBack= 0;
			drawBack= true;
		}
		
		if(click) {
			click= false;
			if(mx > 547*2 && mx < (547+50)*2 && my > 235*2 && my < (235+20)*2) {
				Game.gameState= "INITIALSCREEN";
			}			
		}
	}
	
	public static void render(Graphics g) {
		g.setColor(new Color(128,128,128));
		g.fillRect(0, 0, Game.WIDTH*Game.SCALE, Game.HEIGHT*Game.SCALE);
		
		
		g.setColor(Color.black);
		g.setFont(new Font("arial", Font.BOLD, 16));
		g.drawString("Todos os direitos reservados a                             RP", 160, 160);
		g.setColor(Color.green);
		g.setFont(new Font("arial", Font.BOLD, 16));
		g.drawString("Gaming Club", 405, 160);
		if(drawBack) {
			g.setColor(Color.black);
			g.setFont(new Font("arial", Font.BOLD, 16));
			g.drawString("voltar", 550, 250);
		}
		//g.drawRect(547, 235, 50, 20);
	}
}
