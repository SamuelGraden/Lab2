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
				for(int j=1;j<=4;j++) {
					if(roomlist.get(i).isConnected(j)) {
						if(j==1) {
							int startX=roomlist.get(i).getPosX()+(roomlist.get(i).getDx()/2);
							int startY=roomlist.get(i).getPosY();
							int endX=roomlist.get(i).getConnected(j).getPosX()+(roomlist.get(i).getConnected(j).getDx()/2);
							int endY=roomlist.get(i).getConnected(j).getPosY()+roomlist.get(i).getConnected(j).getDy();
						
							for(int k=5;k>=-5;k--) {
								if(k==5||k==-5) {
									g.setColor(Color.black);
								} else {
									g.setColor(Color.blue);
								}
								g.drawLine(startX+k, startY+2, endX+k, endY-2);
							}
						}
						if(j==2) {
							int startX=roomlist.get(i).getPosX();
							int startY=roomlist.get(i).getPosY()+roomlist.get(i).getDy()/2;
							int endX=roomlist.get(i).getConnected(j).getPosX()+roomlist.get(i).getConnected(j).getDx();
							int endY=roomlist.get(i).getConnected(j).getPosY()+roomlist.get(i).getConnected(j).getDy()/2;
						
							for(int k=5;k>=-5;k--) {
								if(k==5||k==-5) {
									g.setColor(Color.black);
								} else {
									g.setColor(Color.blue);
								}
								g.drawLine(startX+2, startY+k, endX-2, endY+k);
							}
						}
						if(j==3) {
							int startX=roomlist.get(i).getPosX()+(roomlist.get(i).getDx()/2);
							int startY=roomlist.get(i).getPosY()+roomlist.get(i).getDy();
							int endX=roomlist.get(i).getConnected(j).getPosX()+(roomlist.get(i).getConnected(j).getDx()/2);
							int endY=roomlist.get(i).getConnected(j).getPosY();
							
							for(int k=5;k>=-5;k--) {
								if(k==5||k==-5) {
									g.setColor(Color.black);
								} else {
									g.setColor(Color.blue);
								}
								g.drawLine(startX+k, startY-2, endX+k, endY+2);
							}
						}
						if(j==4) {
							int startX=roomlist.get(i).getPosX()+roomlist.get(i).getDx();
							int startY=roomlist.get(i).getPosY()+(roomlist.get(i).getDy()/2);
							int endX=roomlist.get(i).getConnected(j).getPosX();
							int endY=roomlist.get(i).getConnected(j).getPosY()+roomlist.get(i).getConnected(j).getDy()/2;
							
							for(int k=5;k>=-5;k--) {
								if(k==5||k==-5) {
									g.setColor(Color.black);
								} else {
									g.setColor(Color.blue);
								}
								g.drawLine(startX-2, startY+k, endX+2, endY+k);
							}
							
							
							
						}
					}
				}
			}
		}
		private void clearBackdrop(Graphics g) {
			g.setColor(Color.decode("#FFAB00"));
			g.fillRect(0, 0, 8000, 8000);		
		}

		private class Listener implements KeyListener {


			public void keyPressed(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}

			public void keyTyped(KeyEvent event) {
				switch(event.getKeyChar()) {
				case 'w':{
					lv.move(1);
					break;
				}
				case 'a':{
					lv.move(2);
					break;
				}
				case 's':{
					lv.move(3);
					break;
				}
				case 'd':{
					lv.move(4);
					break;
				}
				default:{
					break;
				}
				
				}
			}
		}

	}

}