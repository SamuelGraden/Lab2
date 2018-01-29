package lab2.level;

import java.awt.Color;

public class Room {
	private Color color;
	private int dx;
	private int dy;
	
	private int posX;
	private int posY;
	
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

	public void connectNorthTo(Room r) {
		this.northRoom = r;
	}
	public void connectWestTo(Room r) {
		this.westRoom = r;
	}
	public void connectEastTo(Room r) {
		this.eastRoom = r;
	}
	public void connectSouthTo(Room r) {
		this.southRoom = r;
	}
}
