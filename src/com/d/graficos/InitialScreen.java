package com.d.graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;

import com.d.entities.Player;
import com.d.main.Game;
import com.d.main.Timer;

public class InitialScreen {
	
	public static int mx, my;
	private static int curAnimationDrawNewGame= 0, curAnimationDrawContinue= 0, curAnimationDrawCredits= 0;
	private static double sec= 0.5;
	private static boolean drawNewGame= true, drawContinue= true, drawCredits= true;
	public static boolean click= false, yes= false, deleteGame= false;
	
	public static void tick() {
		File file = new File("save.txt"), file2 = new File("name.txt");
		if(file.exists() && file2.exists()) {
			Save.saveExists= true;
			Save.nameExists= true;
		}else {
			Save.saveExists= false;
			Save.nameExists= false;
		}
		
		if(mx > (268)*2 && mx < (268+80)*2 && my > 146*2 && my < (146+18)*2 && !deleteGame) {
			//System.out.println("NOVO JOGO");
			curAnimationDrawNewGame++;
			if(curAnimationDrawNewGame == 60 * sec && drawNewGame) {
				curAnimationDrawNewGame= 0;
				drawNewGame = false;
			}else if(curAnimationDrawNewGame == 60 * sec && !drawNewGame) {
				curAnimationDrawNewGame= 0;
				drawNewGame = true;
			}
			
		}else if(mx > (268)*2 && mx < (268+80)*2 && my > 185*2 && my < (185+18)*2 && !deleteGame) {
			curAnimationDrawContinue++;
			if(curAnimationDrawContinue == 60 * sec && drawContinue) {
				curAnimationDrawContinue= 0;
				drawContinue = false;
			}else if(curAnimationDrawContinue == 60 * sec && !drawContinue) {
				curAnimationDrawContinue= 0;
				drawContinue = true;
			}
			
		}else if(mx > (268)*2 && mx < (268+80)*2 && my > 225*2 && my < (225+18)*2 && !deleteGame) {
			curAnimationDrawCredits++;
			if(curAnimationDrawCredits == 60 * sec && drawCredits) {
				curAnimationDrawCredits= 0;
				drawCredits = false;
			}else if(curAnimationDrawCredits == 60 * sec && !drawCredits) {
				curAnimationDrawCredits= 0;
				drawCredits = true;
			}
			
		}else {
			curAnimationDrawNewGame= 0;
			drawNewGame= true;
			curAnimationDrawContinue= 0;
			drawContinue= true;
			curAnimationDrawCredits= 0;
			drawCredits= true;
		}
		
		if(click) {
			click= false;
			if(mx > (268)*2 && mx < (268+80)*2 && my > 146*2 && my < (146+18)*2 && !deleteGame) {				
				deleteGame= true;			
			}else if(mx > (268)*2 && mx < (268+80)*2 && my > 185*2 && my < (185+18)*2 && !deleteGame) {
				//Game.gameState= "";		
				file = new File("save.txt");
				file2 = new File("name.txt");
				if(file.exists() && file2.exists()) {
					Game.name = Save.loadName();
					String saver= Save.loadGame(11);
					Save.applySave(saver);
				}else {
					Save.saveExists= false;
				}
			}else if(mx > (268)*2 && mx < (268+80)*2 && my > 225*2 && my < (225+18)*2 && !deleteGame) {
				Game.gameState= "CREDITS";
			}else if(mx > (303)*2 && mx < (303+80)*2 && my > 185*2 && my < (185+18)*2 && deleteGame) {
				file = new File("save.txt");
				file2 = new File("name.txt");
				file.delete();
				file2.delete();
				Timer.day= Timer.startDay;
				Timer.week= Timer.startWeek;
				Timer.year= Timer.startYear;
				Timer.month= Timer.startMonth;
				Game.name= "";
				deleteGame= false;
				Game.gameState= "NAMING";
			}else if(mx > (318)*2 && mx < (318+50)*2 && my > 215*2 && my < (215+17)*2 && deleteGame) {
				deleteGame= false;
			}
			
		}
	}
	
	public static void render(Graphics g) {
		g.setColor(new Color(128,128,128));
		g.fillRect(0, 0, Game.WIDTH*Game.SCALE, Game.HEIGHT*Game.SCALE);
		
		g.setColor(Color.black);
		g.setFont(new Font("arial", Font.BOLD, 50));
		g.drawString("ODS", 210, 100);
		g.setFont(new Font("arial", Font.BOLD, 16));
		g.drawString(".adventure", 315, 100);
		
		if(drawNewGame) {
			g.setFont(new Font("arial", Font.BOLD, 16));
			g.drawString("Novo jogo", 268, 160);
		}
		
		if(drawContinue) {
			g.setFont(new Font("arial", Font.BOLD, 16));
			g.drawString("continuar", 270, 200);
		}
		
		if(drawCredits) {
			g.setFont(new Font("arial", Font.BOLD, 16));
			g.drawString("créditos", 273, 240);
		}
		
		if(deleteGame) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(new Color(0,0,0,100));
			g2.fillRect(0, 0, Game.WIDTH*Game.SCALE, Game.HEIGHT*Game.SCALE);
			//JANELA
				g.setColor(new Color(119,112,109));
				g.fillRect(222, 57, 246, 206);
				g.setColor(new Color(233,204,177));
				g.fillRect(225, 60, 240, 200);
			//TEXTOS
				//SIM
					g.setColor(Color.black);
					g.setFont(new Font("arial", Font.BOLD, 16));
					g.drawString("Continuar vai apagar", 265, 100);
					g.drawString("qualquer progresso existente", 235, 120);
					g.drawString("Deseja continuar?", 280, 170);
					g.drawString("Continuar", 305, 200);
					g.drawString("Voltar", 320, 230);
					
					g.drawRect(303, 185, 80, 18);
					g.drawRect(318, 215, 50, 17);
		}
		
		
	}
}
