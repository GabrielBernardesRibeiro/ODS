package com.d.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.d.entities.Player;
import com.d.main.Game;

public class Naming {
	
	public static boolean click= false, draw= false;
	public static int mx, my;
	
	private static BufferedImage[] uppercaseAlphabet;
	private static BufferedImage[] lowercaseAlphabet;
	private static BufferedImage[] specialAlphabet;
	
	private static int uA= 26;
	private static int lA= 26;
	private static int sA= 6;
	private static int d1= 0;
	private static int maxSize= 9, curSize= 0;
	private static String lastWord = "";
	
	public static void getSprite() {
		uppercaseAlphabet = new BufferedImage[uA];
		lowercaseAlphabet = new BufferedImage[lA];
		specialAlphabet = new BufferedImage[sA];
		for(int i= 0; i< uA; i++) {
			uppercaseAlphabet[i] = Game.spritesheet.getSprite(Game.bitUsed* i, Game.bitUsed* 20, Game.bitUsed, Game.bitUsed);
		}
		for(int i= 0; i< lA; i++) {
			lowercaseAlphabet[i] = Game.spritesheet.getSprite(Game.bitUsed* i, Game.bitUsed* 21, Game.bitUsed, Game.bitUsed);
		}
		for(int i= 0; i< sA; i++) {
			specialAlphabet[i] = Game.spritesheet.getSprite(Game.bitUsed* i, Game.bitUsed* 22, Game.bitUsed, Game.bitUsed);
		}
		draw = true;
	}
	
	public static void tick() {
		if(!draw)	getSprite();
		if(click) {
			System.out.println("Clicando, MX= "+mx+" MY= "+my+" tick do Naming funcionando!!!!!!!!!!");
			click = false;
			//LINHA 1 COLUNAS DE 1 - 16 ------------------------------------------------------------------------------------------------------
				//COLUNAS A B C
					if(mx > (128+(64 * 0)) && mx < (194+(64 * 0)) && my > (200+(32* 0* 2)) && my < (264+(32* 0* 2)) && curSize < maxSize) {
						Game.name = Game.name + "A";
						lastWord = "A";
						curSize++;
					}else if(mx > (128+(64 * 1)) && mx < (194+(64 * 1)) && my > (200+(32* 2* 0)) && my < (264+(32* 2* 0)) && curSize < maxSize) {
						Game.name = Game.name + "B";
						lastWord = "B";
						curSize++;
					}else if(mx > (128+(64 * 2)) && mx < (194+(64 * 2)) && my > (200+(32* 2* 0)) && my < (264+(32* 2* 0)) && curSize < maxSize) {
						Game.name = Game.name + "C";
						lastWord = "C";
						curSize++;
					}
				//COLUNAS D E F
					else if(mx > (128+(64 * ( 1 + 3 ))) && mx < (194+(64 * ( 1 + 3 ))) && my > (200+(32* 2* 0)) && my < (264+(32* 2* 0)) && curSize < maxSize) {
						Game.name = Game.name + "D";
						lastWord = "D";
						curSize++;
					}else if(mx > (128+(64 * ( 1 + 4 ))) && mx < (194+(64 * ( 1 + 4 ))) && my > (200+(32* 2* 0)) && my < (264+(32* 2* 0)) && curSize < maxSize) {
						Game.name = Game.name + "E";
						lastWord = "E";
						curSize++;
					}else if(mx > (128+(64 * ( 1 + 5 ))) && mx < (194+64* ( 1 + 6 )) && my > (200+(32* 2* 0)) && my < (264+(32* 2* 0)) && curSize < maxSize) {
						Game.name = Game.name + "F";
						lastWord = "F";
						curSize++;
					}
				//COLUNAS a b c
					else if(mx > (128+(64 * ( 2 + 6 )))+64 && mx < (194+(64 * ( 2 + 6 )))+64 && my > (200+(32* 2* 0)) && my < (264+(32* 2* 0)) && curSize < maxSize) {
						Game.name = Game.name + "a";
						lastWord = "a";
						curSize++;
					}else if(mx > (128+(64 * ( 2 + 7 )))+64 && mx < (194+(64 * ( 2 + 7 )))+64 && my > (200+(32* 2* 0)) && my < (264+(32* 2* 0)) && curSize < maxSize) {
						Game.name = Game.name + "b";
						lastWord = "b";
						curSize++;
					}else if(mx > (128+(64 * ( 2 + 8 )))+64 && mx < (194+(64 * ( 2 + 8 )))+64 && my > (200+(32* 2* 0)) && my < (264+(32* 2* 0)) && curSize < maxSize) {
						Game.name = Game.name + "c";
						lastWord = "c";
						curSize++;
					}
				//COLUNAS d e f
					else if(mx > (128+(64 * ( 2 + 9 )))+128 && mx < (194+(64 * ( 2 + 9 )))+128 && my > (200+(32* 2* 0)) && my < (264+(32* 2* 0)) && curSize < maxSize) {
						Game.name = Game.name + "d";
						lastWord = "d";
						curSize++;
					}else if(mx > (128+(64 * ( 2 + 10 )))+128 && mx < (194+(64 * ( 2 + 10 )))+128 && my > (200+(32* 2* 0)) && my < (264+(32* 2* 0)) && curSize < maxSize) {
						Game.name = Game.name + "e";
						lastWord = "e";
						curSize++;
					}else if(mx > (128+(64 * ( 2 + 11 )))+128 && mx < (194+(64 * ( 2 + 11 )))+128 && my > (200+(32* 2* 0)) && my < (264+(32* 2* 0)) && curSize < maxSize) {
						Game.name = Game.name + "f";
						lastWord = "f";
						curSize++;
					}
			//LINHA 2 COLUNAS DE 1 - 16 -------------------------------------------------------------------------------------------------
				//COLUNAS G H I
					if(mx > (128+(64 * 0)) && mx < (194+(64 * 0)) && my > (200+(32* 0* 2))+(64 * 1) && my < (264+(32* 0* 2))+(64 * 1) && curSize < maxSize) {
						Game.name = Game.name + "G";
						lastWord = "A";
						curSize++;
					}else if(mx > (128+(64 * 1)) && mx < (194+(64 * 1)) && my > (200+(32* 2* 0))+(64 * 1) && my < (264+(32* 2* 0))+(64 * 1) && curSize < maxSize) {
						Game.name = Game.name + "H";
						lastWord = "B";
						curSize++;
					}else if(mx > (128+(64 * 2)) && mx < (194+(64 * 2)) && my > (200+(32* 2* 0))+(64 * 1) && my < (264+(32* 2* 0))+(64 * 1) && curSize < maxSize) {
						Game.name = Game.name + "I";
						lastWord = "C";
						curSize++;
						}
				//COLUNAS J K L
					else if(mx > (128+(64 * ( 1 + 3 ))) && mx < (194+(64 * ( 1 + 3 ))) && my > (200+(32* 2* 0))+(64 * 1) && my < (264+(32* 2* 0))+(64 * 1) && curSize < maxSize) {
					Game.name = Game.name + "J";
					lastWord = "D";
					curSize++;
					}else if(mx > (128+(64 * ( 1 + 4 ))) && mx < (194+(64 * ( 1 + 4 ))) && my > (200+(32* 2* 0))+(64 * 1) && my < (264+(32* 2* 0))+(64 * 1) && curSize < maxSize) {
						Game.name = Game.name + "K";
						lastWord = "E";
						curSize++;
					}else if(mx > (128+(64 * ( 1 + 5 ))) && mx < (194+64* ( 1 + 6 )) && my > (200+(32* 2* 0))+(64 * 1) && my < (264+(32* 2* 0))+(64 * 1) && curSize < maxSize) {
						Game.name = Game.name + "L";
						lastWord = "F";
						curSize++;
					}
				//COLUNAS g h i
					else if(mx > (128+(64 * ( 2 + 6 )))+64 && mx < (194+(64 * ( 2 + 6 )))+64 && my > (200+(32* 2* 0))+(64 * 1) && my < (264+(32* 2* 0))+(64 * 1) && curSize < maxSize) {
						Game.name = Game.name + "g";
						lastWord = "a";
						curSize++;
					}else if(mx > (128+(64 * ( 2 + 7 )))+64 && mx < (194+(64 * ( 2 + 7 )))+64 && my > (200+(32* 2* 0))+(64 * 1) && my < (264+(32* 2* 0))+(64 * 1) && curSize < maxSize) {
						Game.name = Game.name + "h";
						lastWord = "b";
							curSize++;
					}else if(mx > (128+(64 * ( 2 + 8 )))+64 && mx < (194+(64 * ( 2 + 8 )))+64 && my > (200+(32* 2* 0))+(64 * 1) && my < (264+(32* 2* 0))+(64 * 1) && curSize < maxSize) {
						Game.name = Game.name + "i";
						lastWord = "c";
						curSize++;
					}
				//COLUNAS j k l
					else if(mx > (128+(64 * ( 2 + 9 )))+128 && mx < (194+(64 * ( 2 + 9 )))+128 && my > (200+(32* 2* 0))+(64 * 1) && my < (264+(32* 2* 0))+(64 * 1) && curSize < maxSize) {
						Game.name = Game.name + "j";
						lastWord = "j";
						curSize++;
					}else if(mx > (128+(64 * ( 2 + 10 )))+128 && mx < (194+(64 * ( 2 + 10 )))+128 && my > (200+(32* 2* 0))+(64 * 1) && my < (264+(32* 2* 0))+(64 * 1) && curSize < maxSize) {
						Game.name = Game.name + "e";
						lastWord = "e";
						curSize++;
					}else if(mx > (128+(64 * ( 2 + 11 )))+128 && mx < (194+(64 * ( 2 + 11 )))+128 && my > (200+(32* 2* 0))+(64 * 1) && my < (264+(32* 2* 0))+(64 * 1) && curSize < maxSize) {
						Game.name = Game.name + "l";
						lastWord = "l";
						curSize++;
					}
			//LINHA 3 COLUNAS DE 1 - 16 -------------------------------------------------------------------------------------------------
				//COLUNAS M N O
					if(mx > (128+(64 * 0)) && mx < (194+(64 * 0)) && my > (200+(32* 0* 2))+(64 * 2) && my < (264+(32* 0* 2))+(64 * 2) && curSize < maxSize) {
						Game.name = Game.name + "M";
						
						lastWord = "M";
						curSize++;
					}else if(mx > (128+(64 * 1)) && mx < (194+(64 * 1)) && my > (200+(32* 2* 0))+(64 * 2) && my < (264+(32* 2* 0))+(64 * 2) && curSize < maxSize) {
						Game.name = Game.name + "N";
						lastWord = "N";
						curSize++;
					}else if(mx > (128+(64 * 2)) && mx < (194+(64 * 2)) && my > (200+(32* 2* 0))+(64 * 2) && my < (264+(32* 2* 0))+(64 * 2) && curSize < maxSize) {
						Game.name = Game.name + "O";
						lastWord = "O";
						curSize++;
						}
				//COLUNAS P Q R S
					else if(mx > (128+(64 * ( 1 + 3 ))) && mx < (194+(64 * ( 1 + 3 ))) && my > (200+(32* 2* 0))+(64 * 2) && my < (264+(32* 2* 0))+(64 * 2) && curSize < maxSize) {
						Game.name = Game.name + "P";
						lastWord = "P";
						curSize++;
					}else if(mx > (128+(64 * ( 1 + 4 ))) && mx < (194+(64 * ( 1 + 4 ))) && my > (200+(32* 2* 0))+(64 * 2) && my < (264+(32* 2* 0))+(64 * 2) && curSize < maxSize) {
						Game.name = Game.name + "Q";
						lastWord = "Q";
						curSize++;
					}else if(mx > (128+(64 * ( 1 + 5 ))) && mx < (194+64* ( 1 + 5 )) && my > (200+(32* 2* 0))+(64 * 2) && my < (264+(32* 2* 0))+(64 * 2) && curSize < maxSize) {
						Game.name = Game.name + "R";
						lastWord = "R";
						curSize++;
					}
					else if(mx > (128+(64 * ( 1 + 5 )))+64 && mx < (194+64* ( 1 + 5 ))+64 && my > (200+(32* 2* 0))+(64 * 2) && my < (264+(32* 2* 0))+(64 * 2) && curSize < maxSize) {
						Game.name = Game.name + "S";
						lastWord = "S";
						curSize++;
					}
				//COLUNAS m n o
					else if(mx > (128+(64 * ( 2 + 6 )))+64 && mx < (194+(64 * ( 2 + 6 )))+64 && my > (200+(32* 2* 0))+(64 * 2) && my < (264+(32* 2* 0))+(64 * 2) && curSize < maxSize) {
						Game.name = Game.name + "m";
						lastWord = "m";
						curSize++;
					}else if(mx > (128+(64 * ( 2 + 7 )))+64 && mx < (194+(64 * ( 2 + 7 )))+64 && my > (200+(32* 2* 0))+(64 * 2) && my < (264+(32* 2* 0))+(64 * 2) && curSize < maxSize) {
						Game.name = Game.name + "n";
						lastWord = "n";
							curSize++;
					}else if(mx > (128+(64 * ( 2 + 8 )))+64 && mx < (194+(64 * ( 2 + 8 )))+64 && my > (200+(32* 2* 0))+(64 * 2) && my < (264+(32* 2* 0))+(64 * 2) && curSize < maxSize) {
						Game.name = Game.name + "o";
						lastWord = "o";
						curSize++;
					}
				//COLUNAS p q r s
					else if(mx > (128+(64 * ( 2 + 9 )))+128 && mx < (194+(64 * ( 2 + 9 )))+128 && my > (200+(32* 2* 0))+(64 * 2) && my < (264+(32* 2* 0))+(64 * 2) && curSize < maxSize) {
						Game.name = Game.name + "p";
						lastWord = "j";
						curSize++;
					}else if(mx > (128+(64 * ( 2 + 10 )))+128 && mx < (194+(64 * ( 2 + 10 )))+128 && my > (200+(32* 2* 0))+(64 * 2) && my < (264+(32* 2* 0))+(64 * 2) && curSize < maxSize) {
						Game.name = Game.name + "q";
						lastWord = "e";
						curSize++;
					}else if(mx > (128+(64 * ( 2 + 11 )))+128 && mx < (194+(64 * ( 2 + 11 )))+128 && my > (200+(32* 2* 0))+(64 * 2) && my < (264+(32* 2* 0))+(64 * 2) && curSize < maxSize) {
						Game.name = Game.name + "r";
						lastWord = "l";
						curSize++;
					}else if(mx > (128+(64 * ( 2 + 11 )))+128+64 && mx < (194+(64 * ( 2 + 11 )))+128+64 && my > (200+(32* 2* 0))+(64 * 2) && my < (264+(32* 2* 0))+(64 * 2) && curSize < maxSize) {
						Game.name = Game.name + "s";
						lastWord = "l";
						curSize++;
					}
			//LINHA 4 COLUNAS DE 1 - 16 -------------------------------------------------------------------------------------------------
				//COLUNAS T U V
					if(mx > (128+(64 * 0)) && mx < (194+(64 * 0)) && my > (200+(32* 0* 2))+(64 * 3) && my < (264+(32* 0* 2))+(64 * 3) && curSize < maxSize) {
						Game.name = Game.name + "T";
						lastWord = "T";
						curSize++;
					}else if(mx > (128+(64 * 1)) && mx < (194+(64 * 1)) && my > (200+(32* 2* 0))+(64 * 3) && my < (264+(32* 2* 0))+(64 * 3) && curSize < maxSize) {
						Game.name = Game.name + "U";
						lastWord = "N";
						curSize++;
					}else if(mx > (128+(64 * 2)) && mx < (194+(64 * 2)) && my > (200+(32* 2* 0))+(64 * 3) && my < (264+(32* 2* 0))+(64 * 3) && curSize < maxSize) {
						Game.name = Game.name + "V";
						lastWord = "O";
						curSize++;
						}
				//COLUNAS W X Y Z 
					else if(mx > (128+(64 * ( 1 + 3 ))) && mx < (194+(64 * ( 1 + 3 ))) && my > (200+(32* 2* 0))+(64 * 3) && my < (264+(32* 2* 0))+(64 * 3) && curSize < maxSize) {
						Game.name = Game.name + "W";
						lastWord = "P";
						curSize++;
					}else if(mx > (128+(64 * ( 1 + 4 ))) && mx < (194+(64 * ( 1 + 4 ))) && my > (200+(32* 2* 0))+(64 * 3) && my < (264+(32* 2* 0))+(64 * 3) && curSize < maxSize) {
						Game.name = Game.name + "X";
						lastWord = "Q";
						curSize++;
					}else if(mx > (128+(64 * ( 6 ))) && mx < (190+64* ( 6 )) && my > (200+(32* 2* 0))+(64 * 3) && my < (264+(32* 2* 0))+(64 * 3) && curSize < maxSize) {
						Game.name = Game.name + "Y";
						lastWord = "R";
						curSize++;
					}
					else if(mx > (128+(64 * ( 6 )))+64 && mx < (194+64* ( 6 ))+64 && my > (200+(32* 2* 0))+(64 * 3) && my < (264+(32* 2* 0))+(64 * 3) && curSize < maxSize) {
						Game.name = Game.name + "Z";
						lastWord = "S";
						curSize++;
					}
				//COLUNAS t u v
					else if(mx > (128+(64 * ( 2 + 6 )))+64 && mx < (194+(64 * ( 2 + 6 )))+64 && my > (200+(32* 2* 0))+(64 * 3) && my < (264+(32* 2* 0))+(64 * 3) && curSize < maxSize) {
						Game.name = Game.name + "t";
						lastWord = "t";
						curSize++;
					}else if(mx > (128+(64 * ( 2 + 7 )))+64 && mx < (194+(64 * ( 2 + 7 )))+64 && my > (200+(32* 2* 0))+(64 * 3) && my < (264+(32* 2* 0))+(64 * 3) && curSize < maxSize) {
						Game.name = Game.name + "u";
						lastWord = "u";
							curSize++;
					}else if(mx > (128+(64 * ( 2 + 8 )))+64 && mx < (194+(64 * ( 2 + 8 )))+64 && my > (200+(32* 2* 0))+(64 * 3) && my < (264+(32* 2* 0))+(64 * 3) && curSize < maxSize) {
						Game.name = Game.name + "v";
						lastWord = "v";
						curSize++;
					}
				//COLUNAS w x y z
					else if(mx > (128+(64 * ( 2 + 9 )))+128 && mx < (194+(64 * ( 2 + 9 )))+128 && my > (200+(32* 2* 0))+(64 * 3) && my < (264+(32* 2* 0))+(64 * 3) && curSize < maxSize) {
						Game.name = Game.name + "w";
						lastWord = "w";
						curSize++;
					}else if(mx > (128+(64 * ( 2 + 10 )))+128 && mx < (194+(64 * ( 2 + 10 )))+128 && my > (200+(32* 2* 0))+(64 * 3) && my < (264+(32* 2* 0))+(64 * 3) && curSize < maxSize) {
						Game.name = Game.name + "x";
						lastWord = "x";
						curSize++;
					}else if(mx > (128+(64 * ( 2 + 11 )))+128 && mx < (194+(64 * ( 2 + 11 )))+128 && my > (200+(32* 2* 0))+(64 * 3) && my < (264+(32* 2* 0))+(64 * 3) && curSize < maxSize) {
						Game.name = Game.name + "y";
						lastWord = "y";
						curSize++;
					}else if(mx > (128+(64 * ( 2 + 11 )))+128+64 && mx < (194+(64 * ( 2 + 11 )))+128+64 && my > (200+(32* 2* 0))+(64 * 3) && my < (264+(32* 2* 0))+(64 * 3) && curSize < maxSize) {
						Game.name = Game.name + "z";
						lastWord = "z";
						curSize++;
					}
					
					else if(mx > (128+(64 * 0)) && mx < (194+(64 * 0)) && my > (200+(32* 0* 2))+(64 * 3) && my < (264+(32* 0* 2))+(64 * 4) && curSize < maxSize) {
						Game.name = Game.name + ",";
						lastWord = "T";
						curSize++;
					}else if(mx > (128+(64 * 1)) && mx < (194+(64 * 1)) && my > (200+(32* 2* 0))+(64 * 3) && my < (264+(32* 2* 0))+(64 * 4) && curSize < maxSize) {
						Game.name = Game.name + "'";
						lastWord = "N";
						curSize++;
					}else if(mx > (128+(64 * 2)) && mx < (194+(64 * 2)) && my > (200+(32* 2* 0))+(64 * 3) && my < (264+(32* 2* 0))+(64 * 4) && curSize < maxSize) {
						Game.name = Game.name + ".";
						lastWord = "O";
						curSize++;
					}else if(mx > (128+(64 * ( 2 + 6 )))+64 && mx < (194+(64 * ( 2 + 6 )))+64 && my > (200+(32* 2* 0))+(64 * 3) && my < (264+(32* 2* 0))+(64 * 4) && curSize < maxSize) {
						Game.name = Game.name + "-";
						lastWord = "t";
						curSize++;
					}else if(mx > (128+(64 * ( 2 + 7 )))+64 && mx < (194+(64 * ( 2 + 7 )))+64 && my > (200+(32* 2* 0))+(64 * 3) && my < (264+(32* 2* 0))+(64 * 4) && curSize <= maxSize && curSize > 0) {
						Game.name = Game.name.substring(0, Game.name.length() - 1);
						lastWord = "u";
						curSize--;
					}else if(mx > (128+(64 * ( 2 + 8 )))+64 && mx < (194+(64 * ( 2 + 8 )))+64 && my > (200+(32* 2* 0))+(64 * 3) && my < (264+(32* 2* 0))+(64 * 4) && curSize < maxSize) {
						Game.name = Game.name + " ";
						lastWord = "v";
						curSize++;
					}else if(mx > 526*2 && mx < (526+85)*2 && my > (238 * 2) && my < (238+18)*2) {
						Game.gameState = "NORMAL";
					}
			
		}
	}
	
	public static void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(211,196,139));
		g2.fillRect(0, 0, Game.WIDTH*Game.SCALE, Game.HEIGHT*Game.SCALE);
		if(draw) {
			//System.out.println("POSSO DESENHAR AGR");
			//DESENHANDO O ALFABETO
				for(int i= 0; i< 4; i++) {
					for(int j=0; j< 8; j++) {
						if(j == 3 || j == 7 && d1 != 18 && d1 != 25) {
							g.drawImage(specialAlphabet[5], 2*32+(32*j),100+(32*i),null);
							g.drawImage(specialAlphabet[5], 256+102+(32*j),100+(32*i),null);
							
						}else if(d1 == 18) {
							g.drawImage(uppercaseAlphabet[d1], 2*32+(32*j),100+(32*i),null);
							g.drawImage(lowercaseAlphabet[d1], 256+102+(32*j),100+(32*i),null);
							d1++;
						}else if(d1 == 25) {
							g.drawImage(uppercaseAlphabet[d1], 2*32+(32*j),100+(32*i),null);
							g.drawImage(lowercaseAlphabet[d1], 256+102+(32*j),100+(32*i),null);
							d1++;
						}else if(d1 != 18 || d1 != 25)  {
							g.drawImage(uppercaseAlphabet[d1], 2*32+(32*j),100+(32*i),null);
							g.drawImage(lowercaseAlphabet[d1], 256+102+(32*j),100+(32*i),null);
							d1++;
						}
					}
				}d1= 0;
				for(int i=0; i< 6; i++) {
					if(i< 3)
						g.drawImage(specialAlphabet[i], 2*32+(32*i),100+(32*4),null);
					else
						g.drawImage(specialAlphabet[i], 256+6+(32*i),100+(32*4),null);
				}
			//DESENHANDO O RETANGULO DO NOME
				g.setColor(new Color(119,112,109));
				g.fillRect(290, 64, 91, 24);
				g.setColor(new Color(233,204,177));
				g.fillRect(293, 67, 85, 18);
			//DESENHANDO O NOME
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 10));
				g.drawString("Nome:", 296, 80);	//+3
				g.drawString(Game.name+"", 331, 80);//331 80
				
				g.drawString("Last Word: "+lastWord, 400, 80);	//+3
				g.drawString("Tamanho do nome: "+curSize, 500, 80);	//+3
			//DESENHANDO RETANDO DE CONFIRMAR
				g.setColor(new Color(119,112,109));
				g.fillRect(523, 235, 91, 24);
				g.setColor(new Color(233,204,177));
				g.fillRect(526, 238, 85, 18);
			//DESENHANDO O  CONTINUAR
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.BOLD, 14));
				g.drawString("Continuar", 533, 251);
				
				
		}
	
	}
}
