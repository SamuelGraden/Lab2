package lab2.level;

import java.util.Observable;

public class Level extends Observable {
	private Room r;
	private int x;
	private int y;
	
	public boolean place(Room r, int x, int y)  {
		this.r = r;
		this.x = x;
		this.y = y;
	}
	
	public void firstLocation(Room r) {
			
	}
	
}

