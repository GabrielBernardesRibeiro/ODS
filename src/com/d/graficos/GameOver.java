package com.d.graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.d.entities.Player;
import com.d.main.Game;
import com.d.main.Timer;

public class GameOver {
		
	public static int curTime =0;
	public static int curIndex =0, maxIndex =2;
	public static boolean drawGameOver = true;
	public static boolean drawTestNewGame = false, drawTestClose = false;
	
	
	public static void tick() {
		curTime++;
		if(curTime == 60) {
			curTime = 0;
			if(drawGameOver) drawGameOver = false;
			else drawGameOver = true;
		}
		if(Player.click) {
			//System.out.println("Clicando, MX= "+Player.mx+" MY= "+Player.my);
			Player.click = false;
			if(Player.mx > (606) && Player.mx < (780) && Player.my > (217) && Player.my < (242) && !drawTestNewGame) {
				drawTestNewGame = true;
			}else if(Player.mx > (260) && Player.mx < (425) && Player.my > (202) && Player.my < (225) && drawTestNewGame){
				drawTestNewGame = false;
			}
			else if(Player.mx > (632) && Player.mx < (739) && Player.my > (261) && Player.my < (280) && !drawTestClose) {
				drawTestClose = true;
			}else if(Player.mx > (260) && Player.mx < (425) && Player.my > (202) && Player.my < (225) && drawTestClose){
				drawTestClose = false;
			}
		}
	}
	
	
	public static void render(Graphics g) {
		//JANELA
			g.setColor(new Color(119,112,109));
			g.fillRect(222*2, 57*2, 246*2, 206*2);
			g.setColor(new Color(233,204,177));
			g.fillRect(225*2, 60*2, 240*2, 200*2);
		//TEXTO
			//TEXTO DA JANELA
				if(drawGameOver) {
					g.setColor(Color.black);
					g.setFont(new Font("arial", Font.BOLD, 16*2));
					g.drawString("GAME-OVER    :(",294*2,80*2);
				}
			//TEXTO DE NOVO JOGO
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 12*2));
				g.drawString("NOVO JOGO",307*2,120*2);
			//TEXTO DE FECHAR
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 12*2));
				g.drawString("FECHAR",318*2,140*2);
			//TEMPO DE JOGO
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 13));
				g.drawString("DIA   SEM   MÊS   ANO", 500, 320);
				g.setFont(new Font("arial", Font.BOLD, 17));
				g.drawString("    :       :       :", 505, 340);
				g.setFont(new Font("arial", Font.BOLD, 12));
				g.drawString("0"+(Timer.day+1), 506, 339);//ESSE É O DIA
				g.drawString("0"+(Timer.week+1), 543, 339);//ESSEÉ A SEMANA
				if(Timer.month < 9) {
					g.drawString("0"+(Timer.month+1), 583, 339);//MESES MENORES QUE 10
				}else {
					g.drawString(""+(Timer.month+1), 583, 339);//MESES MAIORES OU IGUAIS QUE 10
				}
				if(Timer.year < 9) {
					g.drawString("0"+(Timer.year+1), 620, 339);//ANOS MENORES QUE 10
				}else {
					g.drawString(""+(Timer.year+1), 620, 339);//ANOS MAIORES OU IGUAIS QUE 10
				}
			//CONQUISTAS
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 16));
				g.drawString("Conquistas totais:", 680, 330);
				g.setFont(new Font("arial", Font.BOLD, 20));
				g.drawString("00", 825, 332);
			//ODS CONCLUIDAS
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 16));
				g.drawString("ODS completas:", 696, 360);
				g.setFont(new Font("arial", Font.BOLD, 20));
				g.drawString("00", 825, 362);
			//NIVEL DE INFLUENCIA
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 16));
				g.drawString("Nivel de influencia:", 675, 390);
				g.setFont(new Font("arial", Font.BOLD, 20));
				g.drawString("00", 825, 392);
			//NIVEL ATINGIDO
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 16));
				g.drawString("Nivel atingindo:", 675, 420);
				g.setFont(new Font("arial", Font.BOLD, 20));
				if(Player.level == Player.citzen)	g.drawString("Cidadão", 800, 420);
				else if(Player.level == Player.mayor)	g.drawString("Prefeito", 800, 420);
				else if(Player.level == Player.president)	g.drawString("Presidente", 800, 420);
				else if(Player.level == Player.representative) {
					g.setFont(new Font("arial", Font.BOLD, 18));
					g.drawString("Representante", 795, 420);
				
				}
				else if(Player.level == Player.worldLeader) {
					g.setFont(new Font("arial", Font.BOLD, 18));
					g.drawString("Lider Mundial", 800, 420);
				}
			//DINHEIRO
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 22));
				g.drawString("$", 500, 381);
				g.setFont(new Font("arial", Font.BOLD, 16));
				g.drawString("123456789", 515, 380);
		//AREA RESERVADA A TESTE	
			if(drawTestNewGame) {
				g.setColor(new Color(119,112,109));
				g.fillRect(222, 57, 246, 206);
				g.setColor(new Color(233,204,177));
				g.fillRect(225, 60, 240, 200);
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 14));
				g.drawString("INICIAR UM NOVO JOGO", 260, 150);
				g.setColor(Color.green);
				g.fillRect(260, 200, 170, 30);
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 14));
				g.drawString("FECHAR", 315, 220);
			}else if(drawTestClose) {
				g.setColor(new Color(119,112,109));
				g.fillRect(222, 57, 246, 206);
				g.setColor(new Color(233,204,177));
				g.fillRect(225, 60, 240, 200);
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 14));
				g.drawString("FECHAR JOGO", 260, 150);
				g.setColor(Color.green);
				g.fillRect(260, 200, 170, 30);
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 14));
				g.drawString("FECHAR", 315, 220);
			}
	}
}
