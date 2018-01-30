package lab2.level;
import java.util.ArrayList;

import java.util.Observable;
import java.util.Observer;

public class Level extends Observable {
	private ArrayList<Room> roomList;
	private boolean placeactive=true;
	
	public Level() {
		roomList=new ArrayList<Room>();
	}
	public boolean place(Room r, int x, int y)  {
		if(!placeactive)return false;
		int dimX=r.getDx()/2;
		int dimY=r.getDy()/2;
		//Tests if the middle of the "to be placed room" is within the area of all of previous rooms + half of the placed room.
		boolean placement=true;
		for(int i=0;i<roomList.size();i++) {
			if(((roomList.get(i).getPosX()-dimX)<(x+dimX) && (roomList.get(i).getPosX()+roomList.get(i).getDx()+dimX)>(x+dimX))) {
				if(((roomList.get(i).getPosY()-dimY)<(y+dimY) && (roomList.get(i).getPosY()+roomList.get(i).getDy()+dimY)>(y+dimY))) {
					placement=false;
				}
			}
		}
		if(placement) {
			r.setPosX(x);
			r.setPosY(y);
			roomList.add(r);
			return true;
		}
		return false;
	}
	
	public void firstLocation(Room r) {
		
		placeactive=false;
	}
	
	public ArrayList<Room> getRoomList() {
		return this.roomList;
	}
	
	/*public void addObserver(Observer o) {
		
	}
	
	protected void setChanged(){
		
	}
	
	protected void notifyObserver() {
		
	}*/
	
}

