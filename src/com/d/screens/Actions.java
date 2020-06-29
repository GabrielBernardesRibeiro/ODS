package com.d.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.d.entities.Player;

public class Actions {
	
	public static boolean draw= false;
	
	public static void tick() {
		
	}
	
	public static void render(Graphics g) {
		if(draw) {
			if(Player.level == Player.citzen) {
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 16));
				g.drawString("Ações", 107, 76);
				g.setFont(new Font("arial", Font.PLAIN, 10));
				g.drawString("Visitar asilo", 60, 100);
				g.drawString("Visitar orfanato", 60, 120);
				g.drawString("Volutariar como professor", 60, 140);
				g.drawString("Gravar video educativo", 60, 160);
				g.drawString("Cuidar da nascente", 60, 180);
				g.drawString("Tirar lixo", 60, 200);
			}
		}
	}
}
