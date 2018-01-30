package lab2;

import java.awt.Color;

import lab2.level.Level;
import lab2.level.LevelGUI;
import lab2.level.Room;

public class Driver{
	
	public void run() {
		Level lv=new Level();
		int scaling = 20;
		Room r1 = new Room(Color.green,8*scaling,8*scaling);
		lv.place(r1, 1*scaling,21*scaling );
		
		Room r2 = new Room(Color.green,10*scaling, 7*scaling);
		lv.place(r2, 12*scaling, 22*scaling);
		
		Room r3 = new Room(Color.green,4*scaling, 3*scaling);
		lv.place(r3, 15*scaling, 31*scaling);
		
		Room r4 = new Room(Color.green, 10*scaling,9*scaling);
		lv.place(r4, 26*scaling, 25*scaling);
		
		Room r5 = new Room(Color.green, 9*scaling,9*scaling);
		lv.place(r5, 12*scaling, 16*scaling);
		
		Room r6 = new Room(Color.green, 19*scaling, 12*scaling);
		lv.place(r6, 10*scaling, 2*scaling);
		
	/*	while(true) {
			Room tempRoom = new Room( Color.blue, (int)(Math.random()*15),(int)(Math.random()*15) );
			if( lv.place(tempRoom, (int)(Math.random()*100),(int)(Math.random()*100)) ){
						
			}
		}*/
		
	}
}