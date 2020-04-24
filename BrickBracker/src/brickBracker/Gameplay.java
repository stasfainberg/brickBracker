package brickBracker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener{

	private boolean play = false;
	private int score = 0;
	
	private int totalBricks = 21;
	
	private Timer timer;
	private int delay = 8;
	
	private int playerX = 310;
	
	private int ballPosX = 120;
	private int ballPosY = 350;
	private int ballXdir = -1;
	private int ballYdir = -2;
	
	private MapGenerator map;
	
	
	public Gameplay () {
		map = new MapGenerator(3, 7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
		
	}
	
	public void paint(Graphics g) {
		
		//background
		g.setColor(Color.black);
		g.fillRect(1, 1, 692, 592);
		
		//map drawing
		map.draw((Graphics2D)g);
		
		//borders
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		
		//paddle
		g.setColor(Color.green);
		g.fillRect(playerX, 550, 100, 8);
		
		//Ball
		g.setColor(Color.yellow);
		g.fillOval(ballPosX, ballPosY, 20, 20);
		
		g.dispose();

		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
				
		timer.start();
		if(play) {
			if(new Rectangle(ballPosX, ballPosY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
				ballYdir = -ballYdir;
			}
			
			ballPosX += ballXdir;
			ballPosY += ballYdir;
			if(ballPosX < 0) {
				ballXdir = -ballXdir;
			}
			if(ballPosY < 0) {
				ballYdir = -ballYdir;
			}
			if(ballPosX > 670) {
				ballXdir = -ballXdir;
			}
			
			
		}
		
		
		
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(playerX >= 600) {
				playerX = 600;
			}else {
				moveRight();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(playerX < 10) {
				playerX = 10;
			}else {
				moveLeft();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	private void moveLeft() {
		play = true;
		playerX -= 20;
	}

	private void moveRight() {
		play = true;
		playerX += 20;
	}

	
	
	
	
	
	
}
