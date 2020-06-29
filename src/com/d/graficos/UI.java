package com.d.graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.d.entities.Player;
import com.d.main.Game;
import com.d.main.Timer;

public class UI {
	
	public static BufferedImage mapSprite = Game.spritesheet.getSprite(32 * 7, 0, 32, 32);
	public static BufferedImage trophySprite = Game.spritesheet.getSprite(32 * 8, 0, 32, 32);
	public static BufferedImage gearSprite = Game.spritesheet.getSprite(32 * 7, 32, 32, 32);
	
	
	public static void  tick() {
		
	}
	
	public void render(Graphics g) {
		//JANELA PADRÃO
			/*g.setColor(new Color(119,112,109));
			g.fillRect(222, 57, 246, 206);
			g.setColor(new Color(233,204,177));
			g.fillRect(225, 60, 240, 200);*/
		//TEMPORIZADOR
			//JANELA
				g.setColor(new Color(119,112,109));
				g.fillRect(538, 04, 130, 45);
				g.setColor(new Color(233,204,177));
				g.fillRect(541, 07, 124, 39);
			//TEXTO
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 10));
				g.drawString("DIA   SEM   MÊS   ANO", 547, 18);
				g.setFont(new Font("arial", Font.BOLD, 14));
				g.drawString("    :       :       :", 552, 35);
				g.setFont(new Font("arial", Font.BOLD, 12));
				g.drawString("0"+(Timer.day), 550, 35);//ESSE É O DIA
				g.drawString("0"+(Timer.week), 580, 35);//ESSEÉ A SEMANA
				if(Timer.month < 9) {
					g.drawString("0"+(Timer.month), 610, 35);//MESES MENORES QUE 10
				}else {
					g.drawString(""+(Timer.month), 610, 35);//MESES MAIORES OU IGUAIS QUE 10
				}
				if(Timer.year < 9) {
					g.drawString("0"+(Timer.year), 640, 35);//ANOS MENORES QUE 10
				}else {
					g.drawString(""+(Timer.year), 640, 35);//ANOS MAIORES OU IGUAIS QUE 10
				}
		/*//DINHEIRO
			//JANELA
				g.setColor(new Color(119,112,109));
				g.fillRect(558, 54, 110, 31);
				g.fillRoundRect(540, 54, 110, 31, 30, 20);
				g.setColor(new Color(233,204,177));
				g.fillRect(561, 57, 104, 25);
			//TEXTO
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 22));
				g.drawString("$", 546, 78);
				g.setFont(new Font("arial", Font.BOLD, 16));
				g.drawString("123456789", 565, 76);*/
		/*//BOTÃO DE MAPA
			//JANELA
				g.setColor(new Color(119,112,109));
				g.fillOval(566, 88, 29, 29);
				g.setColor(new Color(233,204,177));
				g.fillOval(568, 90, 25, 25);
				g.drawImage(mapSprite, 565, 88, null);*/
		/*//BOTÃO DE MAPA
			//JANELA
				g.setColor(new Color(119,112,109));
				g.fillOval(628, 88, 29, 29);
				g.setColor(new Color(233,204,177));
				g.fillOval(630, 90, 25, 25);
				g.drawImage(trophySprite, 627, 88, null);*/
		/*//PAINEL DAS ODS
			//JANELA
				g.setColor(new Color(119,112,109));
				g.fillRect(144, 284, 384, 36);
				g.fillRoundRect(144, 260, 384, 40, 40, 40);
				g.setColor(new Color(233,204,177));
				g.fillRect(147, 287, 378, 30);
				g.fillRoundRect(147, 267, 377, 40, 40, 40);
			//RETANGULOS
				//AZUL
					g.setColor(Color.blue);
					g.fillRect(156, 287, 110, 15);
				//VERDE
					g.setColor(Color.green);
					g.fillRect(281, 287, 110, 15);
				//VERMELHO
					g.setColor(Color.red);
					g.fillRect(406, 287, 110, 15);
				//TEXTOS
					g.setColor(Color.black);
					g.setFont(new Font("arial", Font.BOLD, 14));
					g.drawString("Ambiental", 176, 285);
					g.setFont(new Font("arial", Font.BOLD, 14));
					g.drawString("Econômico", 301, 285);
					g.setFont(new Font("arial", Font.BOLD, 14));
					g.drawString("Social", 440, 285);*/
		/*//PAINEL DOS DIAS DA SEMANA
			//JANELA
					//JANELA GRANDE
						g.setColor(new Color(119,112,109));
						g.fillRect(568, 150, 100, 166);
						g.fillRoundRect(568, 130, 100, 40, 40, 40);
						g.setColor(new Color(233,204,177));
						g.fillRect(571, 153, 94, 160);
					//JANELA DOS DIAS DA SEMANA
						//DOM.
							g.setColor(Color.black);
							g.setFont(new Font("arial", Font.PLAIN, 10));
							g.drawString("Dom.", 579, 169);
							g.drawRect(580, 170, 22, 22);
						//Seg.
							g.setColor(Color.black);
							g.setFont(new Font("arial", Font.PLAIN, 10));
							g.drawString("Seg.", 630, 169);
							g.drawRect(630, 170, 22, 22);
						//ter.
							g.setColor(Color.black);
							g.setFont(new Font("arial", Font.PLAIN, 10));
							g.drawString("Ter.", 581, 204);
							g.drawRect(580, 205, 22, 22);
						//qua.
							g.setColor(Color.black);
							g.setFont(new Font("arial", Font.PLAIN, 10));
							g.drawString("Qua.", 630, 204);
							g.drawRect(630, 170+35, 22, 22);
						//qui.
							g.setColor(Color.black);
							g.setFont(new Font("arial", Font.PLAIN, 10));
							g.drawString("Qui.", 632, 239);
							g.drawRect(580, 170+70, 22, 22);
						//sex.
							g.setColor(Color.black);
							g.setFont(new Font("arial", Font.PLAIN, 10));
							g.drawString("Sex.", 581, 239);
							g.drawRect(630, 170+70, 22, 22);
						//Sab.
							g.setColor(Color.black);
							g.setFont(new Font("arial", Font.PLAIN, 10));
							g.drawString("Sab.", 605, 274);
							g.drawRect(605, 275, 22, 22);
			//TEXTOS
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 14));
				g.drawString("Semana", 592, 147);*/
		//PAINEL DO NOME
			//JANELA
				g.setColor(new Color(119,112,109));
				g.fillRect(04, 04, 91, 24);
				g.setColor(new Color(233,204,177));
				g.fillRect(07, 07, 85, 18);
			//TEXTOS
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 10));
				g.drawString("Nome:", 10, 20);	
				g.drawString(Game.name+"", 42, 20);
		//PAINEL DA INFLUENCIA
			//JANELA
				g.setColor(new Color(119,112,109));
				g.fillRect(100, 04, 91, 24);
				g.setColor(new Color(233,204,177));
				g.fillRect(103, 07, 85, 18);
			//TEXTOS
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 10));
				g.drawString("Influência:", 105, 20);	
				g.drawString(Player.influence+"", 160, 20);
		//ENGRENAGEM DE OPÇOES
				g.drawImage(gearSprite, 4, 30,null);
				//g.drawRect(6,32,26,26);
					
	}
	
	
}
