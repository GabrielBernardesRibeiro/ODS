package com.d.main;

public class Timer {
	
	public static boolean timing = true;
	private static int curTime = 0;
	public static int startDay= 1, startWeek= 1, startMonth= 1, startYear= 1;
	public static int day = 1, maxDay = 8, curDay = 0;
	public static int week = 1, maxWeek = 5, curWeek = 0;
	public static int month = 1, maxMonth = 13, curMonth = 0;
	public static int year = 1;
	public static int maxYear;
	public int curYear = 0; 
	
	public static void tick() {
		
		if(timing ) {
			curTime++;
			if(curTime == 5*60) {
				day++;
				curTime = 0;
				if(day == maxDay) {
					day = 1;
					week++;
				}
				if(week == maxWeek) {
					week = 1;
					month++;
				}
				if(month == maxMonth) {
					month = 1;
					year++;
				}
				if(year == maxYear) {
					year = 1;
					
				}
			}
			
		}
		
		//System.out.println("TEMPORIZADOR: sec:"+curTime+" Dia:"+day+" Semana:"+week+" Mês:"+month+" Ano:"+year);
		
	}
}
