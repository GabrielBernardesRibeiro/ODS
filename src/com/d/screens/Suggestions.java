package com.d.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.d.entities.Player;
import com.d.graficos.Window;
import com.d.main.Timer;

public class Suggestions {
	
	public static boolean draw= false, permissionToClick= false;
	
	public static void tick() {
		if(permissionToClick) {
			if(Player.level == Player.citzen) {
				if(Player.mx > (85*2) && Player.mx < ((85+96)*2) && Player.my > (430) && Player.my < (470)) {
					draw = false;
					//Menu.achievements = false;
					Timer.timing = true;
					draw= false;
					permissionToClick= false;
				}else if(Player.mx > (85*2) && Player.mx < ((85+96)*2) && Player.my > (430) && Player.my < (470)) {
					//FEIRA DO BAIRRO
				}else if(Player.mx > (85*2) && Player.mx < ((85+96)*2) && Player.my > (430) && Player.my < (470)) {
					//TROCA CULTURAL
				}else if(Player.mx > (85*2) && Player.mx < ((85+96)*2) && Player.my > (430) && Player.my < (470)) {
					//AUMENTAR ILUMINAÇÃO
				}else if(Player.mx > (85*2) && Player.mx < ((85+96)*2) && Player.my > (430) && Player.my < (470)) {
					//PAVIMENTAÇÃO DA RUA
				}else if(Player.mx > (85*2) && Player.mx < ((85+96)*2) && Player.my > (430) && Player.my < (470)) {
					//pRESERVAÇÃO DA NASCENTE
				}else if(Player.mx > (85*2) && Player.mx < ((85+96)*2) && Player.my > (430) && Player.my < (470)) {
					//PRESERVAÇÃO DA AREA AMBIENTAL
				}
				
			}
			
			
			
		}
	}
	
	public static void render(Graphics g) {
		if(draw) {
			if(Player.level == Player.citzen) {
				Window.render(g);
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 16));
				g.drawString("Sugestoes", 88, 76);
				g.setFont(new Font("arial", Font.PLAIN, 10));
				g.drawString("Feira no bairro", 60, 100);
				g.drawString("Troca cultural ( sarau )", 60, 120);
				g.drawString("Aumentar iluminação", 60, 140);
				g.drawString("Pavimentar a rua", 60, 160);
				g.drawString("Preservação da nascente", 60, 180);
				g.drawString("Preservação da área ambiental", 60, 200);
				
				g.drawRect(58, 90, 75, 12);
			}
		}
	}
	
	
}
