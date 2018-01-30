package lab2.level;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class LevelGUI implements Observer {

	private Level lv;
	private Display d;
	public LevelGUI(Level level, String name) {
		
		this.lv = level;
		this.lv.addObserver(this);
		
		JFrame frame = new JFrame(name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// TODO: You should change 200 to a value 
		// depending on the size of the level
		d = new Display(lv,400,400);
		
		frame.getContentPane().add(d);
		frame.pack();
		frame.setLocation(0,0);
		frame.setVisible(true);
	}
	
	
	public void update(Observable arg0, Object arg1) {
		d.repaint();
	}
	
	private class Display extends JPanel {
		
		
		public Display(Level fp, int x, int y) {
		
			
			addKeyListener(new Listener());
			
			setBackground(Color.GREEN);
			setPreferredSize(new Dimension(x+20,y+20));
			setFocusable(true);
		}
	
		
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			clearBackdrop(g);
			drawRoom(g);
		}
		
		private void drawRoom(Graphics g) {
			ArrayList<Room> roomlist=lv.getRoomList();
			for(int i=0;i<roomlist.size();i++) {
				if(roomlist.get(i).isPlayer()) {
					g.setColor(Color.blue);
				} else {
					g.setColor(Color.black);
				}
				g.fillRect(roomlist.get(i).getPosX(), roomlist.get(i).getPosY(), roomlist.get(i).getDx(), roomlist.get(i).getDy());
				g.setColor(roomlist.get(i).getColor());
				g.fillRect(roomlist.get(i).getPosX()+2, roomlist.get(i).getPosY()+2, roomlist.get(i).getDx()-4, roomlist.get(i).getDy()-4);
			}
		}
		private void clearBackdrop(Graphics g) {
			g.setColor(Color.decode("#FFAB00"));
			g.fillRect(0, 0, 1000, 640);
			
		}
		
	 	private class Listener implements KeyListener {

	 		
	 		public void keyPressed(KeyEvent arg0) {
	 		}

	 		public void keyReleased(KeyEvent arg0) {
	 		}

	 		public void keyTyped(KeyEvent event) {
	 		}
	 	}

	}
	
}