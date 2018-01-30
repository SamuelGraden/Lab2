package lab2.level;

import java.awt.Color;

public class Room {
	private Color color;
	private int dx;
	private int dy;
	
	private int posX;
	private int posY;
	private boolean isPlayer=false;
	
	private Room northRoom;
	private Room eastRoom;
	private Room southRoom;
	private Room westRoom;
	
	public Room(Color color, int dx, int dy) {
		this.color = color;
		this.dx = dx;
		this.dy = dy;
			
	}
	
	public Color getColor() {
		return color;
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}

	public int getPosX() {
		return posX;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;	
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public boolean isPlayer() {
		return isPlayer;
	}
	
	public void setisPlayer() {
		isPlayer=true;
	}
	

	public void connectNorthTo(Room r) {
		if(r==null) {
			this.northRoom = r;
			r.connectSouthTo(this);
		}
	}
	public void connectWestTo(Room r) {
		if(r==null) {
			this.westRoom = r;
			r.connectEastTo(this);
		}
	}
	public void connectEastTo(Room r) {
		if(r==null) {
			this.eastRoom = r;
			r.connectWestTo(this);
		}
	}
	public void connectSouthTo(Room r) {
		if(r==null) {
			this.southRoom = r;
			r.connectNorthTo(this);
		}
	}
}
