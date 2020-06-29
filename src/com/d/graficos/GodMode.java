package com.d.graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.d.entities.Player;
import com.d.main.Game;

public class GodMode {
	
	public static boolean setNormalGame= false, setGameOver= false, godMode= true, godModeOn= false, click= false;
	public static String normalGame= "NORMAL", gameOver= "GAME_OVER", naming= "NAMING", initi= "INITIALSCREEN", credits= "CREDITS";
	public static int mx,my;
	
	public static void tick() {
		if(godMode) {
			//System.out.println("Clicando, MX= "+Player.mx+" MY= "+Player.my);
			if(click) {
				//System.out.println("Clicando, MX= "+Player.mx+" MY= "+Player.my);
				click = false;
				if(Player.mx > (13) && Player.mx < (86) && Player.my > (613) && Player.my < (630) && !godModeOn) {
					godModeOn = true;
				}else if(Player.mx > (13) && Player.mx < (86) && Player.my > (613) && Player.my < (630) && godModeOn) {
					godModeOn = false;
				}		
				if(godModeOn) {
					if(mx > (51) && mx < (148) && my > (161) && my < (182)) {
						Game.gameState = normalGame;
					}else if(mx > (51) && mx < (148) && my > (201) && my < (222)) {
						Game.gameState = gameOver;
					}else if(mx > (51) && mx < (148) && my > (241) && my < (262)) {
						Game.gameState = naming;
					}else if(mx > (51) && mx < (148) && my > (281) && my < (302)) {
						Game.gameState = initi;
					}else if(mx > (51) && mx < (148) && my > (321) && my < (342)) {
						Game.gameState = credits;
					}
				}				
			}

		}

	}
	
	public static void render(Graphics g) {
		if(godMode) {
			if(godModeOn) {
				//JANELAS
					//GOD MODE
						g.setColor(new Color(119,112,109));
						g.fillRect(22, 107, 156, 300);
						g.setColor(new Color(233,204,177));
						g.fillRect(25, 110, 150, 294);
					//ON OR OF
						g.setColor(new Color(119,112,109));
						g.fillRect(11, 290+320, 78, 25);
						g.setColor(new Color(233,204,177));
						g.fillRect(13, 292+320, 74, 21);
				//RETANGULOS
					g.setColor(Color.green);
					g.fillRect(50, 160, 100, 25);
					g.setColor(Color.green);
					g.fillRect(50, 200, 100, 25);
					g.setColor(Color.green);
					g.fillRect(50, 240, 100, 25);
					g.setColor(Color.green);
					g.fillRect(50, 280, 100, 25);
					g.setColor(Color.green);
					g.fillRect(50, 320, 100, 25);
					g.setColor(Color.green);
					g.fillRect(50, 360, 100, 25);
				//CIRCULOS
					g.setColor(Color.green);
					g.fillOval(20, 293+320, 17, 17);
					g.setColor(Color.black);
					g.drawOval(20, 293+320, 17, 17);
				//TEXTOS
					//TITULO
						g.setColor(Color.black);
						g.setFont(new Font("arial", Font.BOLD, 16));
						g.drawString("God Mode",63,135);
					//NORMAL GAME
						g.setColor(Color.black);
						g.setFont(new Font("arial", Font.BOLD, 16));
						g.drawString("Game",78,178);
					//GAME OVER
						g.setColor(Color.black);
						g.setFont(new Font("arial", Font.BOLD, 16));
						g.drawString("Game Over",58,219);
					//NAMING
						g.setColor(Color.black);
						g.setFont(new Font("arial", Font.BOLD, 16));
						g.drawString("Nomear",70,259);
					//INICIO
						g.setColor(Color.black);
						g.setFont(new Font("arial", Font.BOLD, 16));
						g.drawString("Inicio",80,299);
					//INICIO
						g.setColor(Color.black);
						g.setFont(new Font("arial", Font.BOLD, 16));
						g.drawString("Créditos",70,339);
					//INICIO
						g.setColor(Color.black);
						g.setFont(new Font("arial", Font.BOLD, 16));
						g.drawString("Créditos",70,339);
					//ON OR OF
						g.setColor(Color.black);
						g.setFont(new Font("arial", Font.BOLD, 18));
						g.drawString("ON", 48, 308+320);
			}else {
				//JANELAS
					g.setColor(new Color(119,112,109));
					g.fillRect(11, 290+320, 78, 25);
					g.setColor(new Color(233,204,177));
					g.fillRect(13, 292+320, 74, 21);
				//CIRCULOS
					g.setColor(Color.red);
					g.fillOval(20, 293+320, 17, 17);
					g.setColor(Color.black);
					g.drawOval(20, 293+320, 17, 17);
				//TEXTO
					g.setColor(Color.black);
					g.setFont(new Font("arial", Font.BOLD, 18));
					g.drawString("OFF", 48, 308+320);
			}
		}
	}
}
