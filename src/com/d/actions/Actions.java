package com.d.actions;

import java.awt.Graphics;

public class Actions {
	
	protected double moneyCost;
	protected int influenceCost;
	protected int timeCost;
	protected double moneyEarned;
	protected int influenceEarned;
	protected int odsPointsEarned;
	
	public Actions(double moneyCost, int influenceCost, int timeCost, double moneyEarned, int influenceEarned, int odsPointsEarned) 
	{
		this.moneyCost= moneyCost;
		this.influenceCost= influenceCost;
		this.timeCost= timeCost;
		this.moneyEarned= moneyEarned;
		this.influenceEarned= influenceEarned;
		this.odsPointsEarned= odsPointsEarned;
	}
	
	public void setMoneyCost(int newMoneyCost) {
		this.moneyCost= newMoneyCost;
	}
	
	public void setInfluenceCost(int newInfluenceCost) {
		this.influenceCost= newInfluenceCost;
	}
	
	public void setTimeCost(int newTimeCost) {
		this.timeCost= newTimeCost;
	}
	
	public void setMoneyEarned(int newMoneyEarned) {
		this.moneyEarned= newMoneyEarned;
	}
	
	public void setInfluenceEarned(int newInfluenceEarned) {
		this.influenceEarned= newInfluenceEarned;
	}
	
	public void setOdsPointsEarned(int newOdsPointsEarned) {
		this.odsPointsEarned= newOdsPointsEarned;
	}
	
	public int getMoneyCost() {
		return (int)this.moneyCost;
	}
	
	public int getInfluenceCost() {
		return (int)this.influenceCost;
	}
	
	public int getTimeCost() {
		return (int)this.timeCost;
	}
	
	public int getMoneyEarned() {
		return (int)this.moneyEarned;
	}
	
	public int getInfluenceEarned() {
		return (int)this.influenceEarned;
	}
	
	public int getPointsEarned() {
		return (int)this.odsPointsEarned;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
	}
	
	
	
	
	
}
