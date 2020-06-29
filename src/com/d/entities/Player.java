package com.d.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.d.graficos.Maps;
import com.d.main.Game;
import com.d.main.Timer;
import com.d.screens.Actions;
import com.d.screens.Suggestions;
import com.d.world.Camera;
import com.d.world.World;

public class Player extends Entity
{
	public boolean right, left, up, down;
	
	public int right_dir = 0, left_dir = 1, down_dir = 2, up_dir = 3;
	public int dir = down_dir;
	private int frames = 0, maxFrames = 5 , index = 0, maxIndex = 3;
	private boolean moved = false;
	private static final int GOLD_NUMBER = 32;
	//private static final int X_NUMBER_RIGHT = 32 * 2;
	//private static final int X_NUMBER_LEFT = 32;
	private static final int Y_NUMBER_RIGHT = 0;
	private static final int Y_NUMBER_LEFT = 32;
	private static final int Y_NUMBER_UP = 32 * 2;
	private static final int Y_NUMBER_DOWN = 32 * 3;
	
	private BufferedImage[] rightPlayer;
	private BufferedImage[] leftPlayer;
	private BufferedImage[] downPlayer;
	private BufferedImage[] upPlayer;	
	
	public static int level= 1;
	public static int influence= 1;
	public static int citzen = 1, mayor = 2, president = 3, representative = 4, worldLeader = 5;
	public static int getSpriteCitzen = 0, getSpriteMayor = 0, getSpritePresident = 0, getSpriteRepresentative = 0, getSpriteWorldLeader = 0;
	public static int getSpritePermission = 0, getSpriteNegative = 1;
	
	public static boolean permissionToClickPhone= true;
	
	public static boolean click = false;
	public static int mx;
	public static int my;

	public Player(int x, int y, int width, int height,int speed, BufferedImage sprite) {
		super(x, y, width, height, speed ,sprite);
		
		rightPlayer = new BufferedImage[4];
		leftPlayer = new BufferedImage[4];
		downPlayer = new BufferedImage[4];
		upPlayer = new BufferedImage[4];
		
		for(int i = 0; i < 4 ; i++) {
			rightPlayer[i] = Game.spritesheet.getSprite(96 + ( i * GOLD_NUMBER) , Y_NUMBER_RIGHT , GOLD_NUMBER, GOLD_NUMBER);
		}
		
		for(int i = 0; i < 4 ; i++) {
			leftPlayer[i] = Game.spritesheet.getSprite(96 + ( i * GOLD_NUMBER) , Y_NUMBER_LEFT , GOLD_NUMBER, GOLD_NUMBER);
		}
		
		for(int i = 0; i < 4 ; i++) {
			downPlayer[i] = Game.spritesheet.getSprite(96 + ( i * GOLD_NUMBER) , Y_NUMBER_DOWN , GOLD_NUMBER, GOLD_NUMBER);
		}
		
		for(int i = 0; i < 4 ; i++) {
			upPlayer[i] = Game.spritesheet.getSprite(96 + ( i * GOLD_NUMBER) , Y_NUMBER_UP , GOLD_NUMBER, GOLD_NUMBER);
		}

	}
	
	public void tick() {
		depth = 1;
		
		
		if(click) {
			System.out.println("Clicando, MX= "+mx+" MY= "+my);
			click = false;
			
			if(Player.mx > (695) && Player.mx < (723) && Player.my > (214) && Player.my < (259)) {
				//Clicando no mapa para fazer açoes
					if(getSpriteCitzen == getSpritePermission) {
						Maps.getMap(level);
					}
					Maps.draw= true;
					Actions.draw= true;
					Timer.timing = false;
			}if(Player.mx > (640) && Player.mx < (665) && Player.my > (220) && Player.my < (238) && permissionToClickPhone) {
				//Clicando no telefone para fazer sugestoes
					Suggestions.draw= true;
					Timer.timing = false;
					Suggestions.permissionToClick= true;
			}else if(Player.mx > (12) && Player.mx < (12+52) && Player.my > (64) && Player.my < (64+52)) {
				//System.out.println("ESTOU CLICANDO NA ENGRENAGEM");
				Game.gameState= "OPTIONS";
			}
		}
		
		
		
	}
	
	public void render(Graphics g) {
		if(dir == right_dir) {
			g.drawImage(rightPlayer[index], this.getX()- Camera.x, this.getY()- Camera.y, null);
		}
		else if(dir == left_dir) {
			g.drawImage(leftPlayer[index], this.getX()- Camera.x, this.getY()- Camera.y, null);
		}
		else if(dir == up_dir) {
			g.drawImage(upPlayer[index], this.getX()- Camera.x, this.getY()- Camera.y, null);
		}
		else if(dir == down_dir) {
			g.drawImage(downPlayer[index], this.getX()- Camera.x, this.getY()- Camera.y, null);
		}
	}
	
}
