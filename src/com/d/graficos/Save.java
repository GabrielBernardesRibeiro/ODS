package com.d.graficos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.d.entities.Player;
import com.d.main.Timer;
import com.d.screens.weatherForecast;
import com.d.world.World;

public class Save {
	
	public static boolean saveExists= false, nameExists= false;
	public static boolean sabeGame= false;
	
	public static void applySave(String str) {
		String[] spl = str.split("/");
		for(int i= 0; i< spl.length; i++) {
			String[] spl2 = spl[i].split(":");
			System.out.println("spl2 vale: "+spl2[0]);
			switch(spl2[0]) 
			{
				case "mapa":
					System.out.println("ESTOU DENTRO DO SAVE");
					System.out.println("O dia é "+Timer.day);
					World.restartGame("mapa"+spl2[1]+".png");
					break;
					
				case "day":
					Timer.day = Integer.parseInt(spl2[1]);
					System.out.println("ESTOU LENDO O DIA");
					break;
					
				case "month":
					Timer.month = Integer.parseInt(spl2[1]);
					System.out.println("ESTOU LENDO O MES");
					break;
					
				case "week":
					Timer.week = Integer.parseInt(spl2[1]);
					System.out.println("ESTOU LENDO A SEMANA");
					break;
					
				case "year":
					Timer.year = Integer.parseInt(spl2[1]);
					System.out.println("ESTOU LENDO O ANO");
					break;
					
				case "influence":
					Player.influence = Integer.parseInt(spl2[1]);
					System.out.println("ESTOU LENDO A INFLUENCIA");
					break;
					
				case "weatherDom":
					weatherForecast.week[0] = Integer.parseInt(spl2[1]);
					System.out.println("ESTOU LENDO O WEATHER DO DOMINGO");
					break;
					
				case "weatherSeg":
					weatherForecast.week[1] = Integer.parseInt(spl2[1]);
					System.out.println("ESTOU LENDO O WEATHER DO SEGUNDA");
					break;
					
				case "weatherTer":
					weatherForecast.week[2] = Integer.parseInt(spl2[1]);
					System.out.println("ESTOU LENDO O WEATHER DO TERCA");
					break;
				
				case "weatherQua":
					weatherForecast.week[3] = Integer.parseInt(spl2[1]);
					System.out.println("ESTOU LENDO O WEATHER DO QUARTA");
					break;
					
				case "weatherQui":
					weatherForecast.week[4] = Integer.parseInt(spl2[1]);
					System.out.println("ESTOU LENDO O WEATHER DO QUINTA");
					break;
					
				case "weatherSex":
					weatherForecast.week[5] = Integer.parseInt(spl2[1]);
					System.out.println("ESTOU LENDO O WEATHER DO SEXTA");
					break;
					
				case "weatherSab":
					weatherForecast.week[6] = Integer.parseInt(spl2[1]);
					System.out.println("ESTOU LENDO O WEATHER DO SABADO");
					break;
				
				case "weatherPermission":
					weatherForecast.permission = Integer.parseInt(spl2[1]);
					System.out.println("ESTOU LENDO O WEATHER DO SABADO");
					break;
			}
		}
	}
	
	public static String loadGame(int encode) {
		String line= "";
		File file = new File("save.txt");
		if(file.exists()) {
			try {
				String singleLine= null;
				BufferedReader reader= new BufferedReader(new FileReader("save.txt"));
				try {
					while((singleLine= reader.readLine()) != null) {
						String[] trans= singleLine.split(":");
						char[] val= trans[1].toCharArray();
						trans[1] = "";
						for(int i= 0; i< val.length; i++) {
							val[i]-=encode;
							trans[1]+=val[i];
						}
						line+=trans[0];
						line+=":";
						line+=trans[1];
						line+="/";
						
					}
				}catch(IOException e) {}
			}catch(FileNotFoundException e) {
				
			}
		}
		
		return line;
	}
	
	public static String loadName() {
		String line= "";
		try {
			BufferedReader buffRead = new BufferedReader(new FileReader("name.txt"));
			try {
				line = buffRead.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return line;
	}
	
	public static void saveName(String name) {
		BufferedWriter nome= null;
		try {
			nome = new BufferedWriter(new FileWriter("name.txt"));
		}catch(IOException e) {
			
		}
		/*for(int i=0; i <Game.name.length(); i++) {
			char c = Game.name.charAt(i);	
		}*/
		try {
			nome.write(name);
		}catch(IOException e) {}
		try {
			nome.flush();
			nome.close();
		}catch(IOException e) {
			
		}
		
	}
	
	public static void saveGame(String[] val1, int[] val2, int encode) {
		BufferedWriter write= null;
		try {
			write = new BufferedWriter(new FileWriter("save.txt"));
		}catch(IOException e) {
			
		}
		
		for(int i= 0; i< val1.length; i++) {
			String current= val1[i];
			current+=":";
			char[] value= Integer.toString(val2[i]).toCharArray();
			for(int ii= 0; ii< value.length; ii++) {
				value[ii]+=encode;
				current+=value[ii];
			}
			try {
				write.write(current);
				if(i < val1.length -1)
					write.newLine();
			}catch(IOException e) {}
		}
		try {
			write.flush();
			write.close();
		}catch(IOException e) {
			
		}
	}
	
	
	
	
	
}

