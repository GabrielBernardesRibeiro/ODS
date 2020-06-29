package com.d.graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;

import com.d.entities.Player;
import com.d.main.Game;
import com.d.main.Timer;
import com.d.screens.weatherForecast;

public class Options {
	
	public static boolean click= false, saveGame= false;
	public static int mx, my;
	public static int gameNameInt;
	
	
	public static void tick() {
		if(click) {
			click= false;
			if(mx > 305*2 && mx < 380*2 && my > 107*2 && my < 123*2 ) {
				Game.gameState= "NORMAL";
			}else if(mx > 313*2 && mx < 373*2 && my > 126*2 && my < 141*2 ) {
				//Game.gameState= "SAVE";
				File file = new File("save.txt");
				File file2 = new File("name.txt");
				file.delete();
				file2.delete();
				if(file.exists() || file2.exists()) {
					System.out.println("O arquivo existe....");
				}
				saveGame= true;
			}else if(mx > 265*2 && mx < (265+160)*2 && my > 147*2 && my < 163*2 ) {
				Game.gameState= "INITIALSCREEN";
			}
			
			if(saveGame) {
				saveGame= false;
				//gameNameInt = Integer.parseInt(Game.name);
				for(int i=0; i <Game.name.length(); i++) {
					char c = Game.name.charAt(i);
					int j = (int) c;
					System.out.println(j);
				}
				Save.saveName(Game.name);
				System.out.println("Name= "+Game.name+" e codificado fica= "+gameNameInt);
				String[] opt1 = {"mapa","day","week","month","year","influence",
						"weatherDom","weatherSeg","weatherTer","weatherQua","weatherQui","weatherSex","weatherSab","weatherPermission"};
				int[] opt2 = {Player.level,(int)Timer.day,(int)Timer.week,(int)Timer.month,(int)Timer.year,Player.influence,
						weatherForecast.week[0],weatherForecast.week[1],weatherForecast.week[2],weatherForecast.week[3],
						weatherForecast.week[4],weatherForecast.week[5],weatherForecast.week[6],weatherForecast.permission};
				Save.saveGame(opt1, opt2, 11);
				System.out.println("Jogo Salvo!!!!!");
				
			}
		}
	}
	
	public static void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(0,0,0,100));
		g2.fillRect(0, 0, Game.WIDTH*Game.SCALE, Game.HEIGHT*Game.SCALE);
		//JANELA
			g.setColor(new Color(119,112,109));
			g.fillRect(222, 57, 246, 206);
			g.setColor(new Color(233,204,177));
			g.fillRect(225, 60, 240, 200);
		//TEXTO
			//TEXTO DA JANELA
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 16));
				g.drawString("Options    XD",294,80);
			//TEXTO DE Continuar
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 14));
				g.drawString("Continuar",307,120);
			//TEXTO DE FECHAR
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 14));
				g.drawString("Salvar",320,140);
			//TEXTO DE FECHAR
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 14));
				g.drawString("Voltar ao menu inicial",270,160);
			
				//g.drawRect(305, 107, 75, 15);
				//g.drawRect(313, 126, 60, 15);
				//g.drawRect(265, 147, 160, 15);
				
				g.drawString("Fiquei sem ideia kkkj",280,200);
	}
}
