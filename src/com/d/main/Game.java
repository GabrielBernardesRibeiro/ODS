package com.d.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

import com.d.entities.Entity;
import com.d.entities.Player;
import com.d.graficos.Credits;
import com.d.graficos.GameOver;
import com.d.graficos.GodMode;
import com.d.graficos.InitialScreen;
import com.d.graficos.Maps;
import com.d.graficos.Options;
import com.d.graficos.Spritesheet;
import com.d.graficos.UI;
import com.d.screens.Actions;
import com.d.screens.Desk;
import com.d.screens.Naming;
import com.d.screens.Suggestions;
import com.d.screens.weatherForecast;
import com.d.world.Room;
import com.d.world.World;

public class Game extends Canvas implements Runnable, KeyListener, MouseListener, MouseMotionListener
{
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private Thread thread;
	private boolean isRunning = true;
	public static final int WIDTH = 672;
	public static final int HEIGHT = 320;
	public static final int SCALE = 2;
	public static final int bitUsed = 32;
	
	private BufferedImage image;
	

	public static List<Entity> entities;
	public static Spritesheet spritesheet;
	public static World world;
	public static Player player;
	
	public static String name = "";
	
	public static String gameState = "NORMAL";
	public static String godMode = "OFF";
	public static int level= 1;
	
	public UI ui;
	public Naming naming;
	
	public static Random rand;

	public Game(){
		//Sound.musicBackground.loop();
		rand = new Random();
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		initFrame();
		image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		
		
		//inicializando objetos		
		spritesheet = new Spritesheet("/spritesheet.png");
		player = new Player(322,82,32,32,1,spritesheet.getSprite(32 * 2, 0, 32, 32));
		world = new World("/mapa1.png");
		ui = new UI();
		entities = new ArrayList<Entity>();
		entities.add(player);		
	}
	
	public void initFrame() 
	{
		frame = new JFrame("ODS");
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public synchronized void start()
	{
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}
	
	public synchronized void stop()
	{
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		Game game = new Game();
		game.start();
	}
	
	public void tick()
	{
		if(gameState == "INITIALSCREEN") {
			InitialScreen.tick();
		}else if(gameState == "CREDITS") {
			Credits.tick();
		}
		else if(gameState == "NAMING") {
			Naming.tick();
		}else if(gameState == "OPTIONS") {
			Options.tick();
		}
		else if(gameState == "NORMAL") {
			for(int i =0; i < entities.size(); i++) 
			{
				Entity e = entities.get(i);
				e.tick();
				
			}
			Timer.tick();
			if(Player.level == Player.citzen) {
				//Suggestions.tick();
				//Actions.tick();
				//Maps.tick();
				weatherForecast.tick();
			}else if(Player.level == Player.mayor) {
				Maps.tick();
			}else if(Player.level == Player.president) {
				Maps.tick();
			}else if(Player.level == Player.representative) {
				Maps.tick();
			}else if(Player.level == Player.worldLeader) {
				Maps.tick();
			}
		}else if(gameState == "GAME_OVER") {
			GameOver.tick();
		}
		
		//ChangeStates.tick();
		GodMode.tick();
		

	}	
	public void render() 
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) 
		{
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = image.getGraphics();
		g.setColor(new Color(0,0,0));
		g.fillRect(0, 0, WIDTH,HEIGHT) ;
		world.render(g);
		Collections.sort(entities, Entity.nodeSorter);
		for(int i =0; i < entities.size(); i++) 
		{
			Entity e = entities.get(i);
			e.render(g);
			
		}
		
		ui.render(g);
		
		if(gameState == "NAMING") {
			Naming.render(g);
		}else if(gameState == "INITIALSCREEN") {
			InitialScreen.render(g);
		}else if(gameState == "CREDITS") {
			Credits.render(g);
		}else if(gameState == "OPTIONS") {
			Options.render(g);
		}else if(gameState == "NORMAL" && Player.level == Player.citzen) {
			Room.render(g);
			//Desk.render(g);
			//Maps.render(g);
			//Suggestions.render(g);
			//Actions.render(g);
			weatherForecast.render(g);
		}
		g.dispose();
		g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);
		
		if(gameState == "GAME_OVER") {
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(new Color(0,0,0,100));
			g2.fillRect(0, 0, Game.WIDTH*Game.SCALE, Game.HEIGHT*Game.SCALE);
			GameOver.render(g);
		}
		
		GodMode.render(g);
		
		bs.show();
	}
	
	public void run() 
	{
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();
		requestFocus();
		while(isRunning)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) /  ns;
			lastTime = now;
			if(delta >= 1)
			{
				tick();
				render();
				frames++;
				delta--;
				
			}
			if(System.currentTimeMillis() - timer >=1000) 
			{
				System.out.println("FPS:"+frames);
				frames = 0;
				timer += 1000;
				
			}
		}
		stop();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D )
		{
			player.right = true;
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A ) 
		{
			player.left = true;
			
		}
		if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W ) 
		{
			player.up = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S ) 
		{
			player.down = true;			
		}
		if(e.getKeyCode() == KeyEvent.VK_X) {
			
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
		}
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Player.click = true;
		Player.mx = e.getX();
		Player.my = e.getY();
		if(GodMode.godMode) {
			GodMode.click = true;
			GodMode.mx = e.getX();
			GodMode.my = e.getY();
		}
		if(gameState == "INITIALSCREEN") {
			InitialScreen.click= true;
		}else if(gameState == "CREDITS") {
			Credits.click = true;
		}else if(gameState == "NAMING") {
			Naming.click = true;
			Naming.mx = e.getX();
			Naming.my = e.getY();
		}else if(gameState == "OPTIONS") {
			Options.click = true;
			Options.mx = e.getX();
			Options.my = e.getY();
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(gameState == "INITIALSCREEN") {
			InitialScreen.mx = e.getX();
			InitialScreen.my = e.getY();
		}else if(gameState == "CREDITS") {
			Credits.mx = e.getX();
			Credits.my = e.getY();
		}

	}

	
}
