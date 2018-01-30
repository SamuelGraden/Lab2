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

	void setisPlayer() {
		isPlayer=true;
	}
	
	void moveNorth() {
		if(this.northRoom!=null) {
			this.northRoom.setisPlayer();
			this.isPlayer=false;
		}
	}
	
	void moveWest() {
		if(this.westRoom!=null) {
			this.westRoom.setisPlayer();
			this.isPlayer=false;
		}
	}
	
	void moveSouth() {
		if(this.southRoom!=null) {
			this.southRoom.setisPlayer();
			this.isPlayer=false;
		}
	}
	
	void moveEast() {
		if(this.eastRoom!=null) {
			this.eastRoom.setisPlayer();
			this.isPlayer=false;
		}
	}

	public void connectNorthTo(Room r) {
		if(this.northRoom==null) {
			this.northRoom = r;
			r.connectSouthTo(this);
		}
	}
	public void connectWestTo(Room r) {
		if(this.westRoom==null) {
			this.westRoom = r;
			r.connectEastTo(this);
		}
	}
	public void connectEastTo(Room r) {
		if(this.eastRoom==null) {
			this.eastRoom = r;
			r.connectWestTo(this);
		}
	}
	public void connectSouthTo(Room r) {
		if(this.southRoom==null) {
			this.southRoom = r;
			r.connectNorthTo(this);
		}
	}
	
	Room getConnected(int dir) {
		switch(dir) {
		case 1:
			return northRoom;
		case 2:
			return westRoom;
		case 3:
			return southRoom;
		case 4:
			return eastRoom;
		default:
			return null;
		}
	}
	
	public boolean isConnected(int dir) {
		switch(dir) {
		case 1:
			return northRoom!=null?true:false;
		case 2:
			return westRoom!=null?true:false;
		case 3:
			return southRoom!=null?true:false;
		case 4:
			return eastRoom!=null?true:false;
		default:
			return false;
		}
	}
}
