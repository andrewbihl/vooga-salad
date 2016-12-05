package gameplayer.model.weapon;

import java.util.Observable;

import gameplayer.model.IDrawable;

public class Weapon extends Observable implements IDrawable{
	
	private int ID;
	private double damage;
	private double speedX;
	private double speedY;
	private String name;
	private String image;
	private double xCoordinate;
	private double yCoordinate;
	private double distanceTravelled;
	//private double initialX, initialY;
	private double range;
	
	
	public Weapon(String name, int ID, double demage, double speedX, double speedY, String image,  double range) {
		this.name = name;
		this.ID = ID;
		this.damage = demage;
		this.damage = 50; // later change this from collision clas
		this.speedX = speedX;
		this.speedY  = speedY;
		this.image = image;
		this.distanceTravelled = 0;
		this.range = range;
	}
	
	
	
	// add boolean method out of range
	
	public Boolean inRange(){
		return this.range >= this.distanceTravelled;
	}
	
	
	public String getName(){
		return this.name;
	}
	

	
	
	public void incrementDistanceTravelled(double x, double y) {
		this.distanceTravelled += Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	

	

	
	public double getSpeedX(){
		return this.speedX;
	}
	
	public double getSpeedY(){
		return this.speedY;
	}
	
	/*
	 * can factor out to a moving object class with enemy class
	 */
	public double getX() {
		return xCoordinate;
	}

	public void setX(double xCoordinate) {
		this.xCoordinate = xCoordinate;
		setChanged();
		notifyObservers();
	}

	public double getY() {
		return yCoordinate;
	}

	public void setY(double yCoordinate) {
		this.yCoordinate = yCoordinate;
		setChanged();
		notifyObservers();
	}
	
	public String getImage(){
		return this.image;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public double getDamage() {
		return damage;
	}

	public void setDamage(double damage) {
		this.damage = damage;
	}



	
	
}