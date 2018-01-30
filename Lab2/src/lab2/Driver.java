package lab2;

import java.awt.Color;

import lab2.level.Level;
import lab2.level.LevelGUI;
import lab2.level.Room;

public class Driver{
	
	public void run() {
		Level lv=new Level();
		Room testRoom =  new Room(Color.black, 10, 10);
		System.out.print(lv.place(testRoom, 0,0));
		Room test2Room = new Room(Color.blue, 10,10);
		System.out.print(lv.place(test2Room, 2, 2));
		
	}
}