package lab2.level;
import java.util.ArrayList;
import java.util.Observable;



public class Level extends Observable {
	ArrayList<Room> roomList;
	private Room r;
	private int x;
	private int y;
	
	public Level() {
		roomList=new ArrayList<Room>();
		
	}
	
	public boolean place(Room r, int x, int y)  {
		this.r = r;
		this.x = x;
		this.y = y;
		
	}
	
	public void firstLocation(Room r) {
			
	}
	
}

