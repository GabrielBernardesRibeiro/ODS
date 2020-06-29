package com.d.graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.d.screens.Actions;
import com.d.screens.Suggestions;

public class Window {
	
	public static void render(Graphics g){
		
		if(Maps.draw && Actions.draw) {
		//JANELA
			g.setColor(new Color(119,112,109));
			g.fillRect(222, 57, 246, 206);
			g.setColor(new Color(233,204,177));
			g.fillRect(225, 60, 240, 200);
		//BOTOES DA JANELA
			//botão 1
				g.setColor(Color.green);
				g.fillRect(300, 215, 96, 20);
		//TEXTO DO BOTÂO DA JANELA
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 10));
				g.drawString("FECHAR JANELA",305,228);
		//TEXTO DA JANELA
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 16));
				g.drawString("Mapa",322,80);
		//JANELA
			g.setColor(new Color(119,112,109));
			g.fillRect(50, 57, 163, 206);
			g.setColor(new Color(233,204,177));
			g.fillRect(53, 60, 157, 200);
		}else if(Suggestions.draw) {
		
		//JANELA
			g.setColor(new Color(119,112,109));
			g.fillRect(50, 57, 163, 206);
			g.setColor(new Color(233,204,177));
			g.fillRect(53, 60, 157, 200);
		//BOTOES DA JANELA
			//botão 1
				g.setColor(Color.green);
				g.fillRect(85, 215, 96, 20);
				g.setColor(Color.black);
				g.drawRect(85, 215, 96, 20);
		//TEXTO DO BOTÂO DA JANELA
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 10));
				g.drawString("FECHAR JANELA",90,228);
		}
	}
}
