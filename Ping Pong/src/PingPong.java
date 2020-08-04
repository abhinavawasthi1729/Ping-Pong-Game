import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.EventQueue;
public class PingPong extends JFrame implements KeyListener, Runnable
{

	private static final LayoutManager FlowLayout = null;
	final int WIDTH=700, HEIGHT=500;
	Thread thread;
	static JFrame frame;
	HumanPaddle p1;
	AIPaddle p2;
	Ball b1;

	boolean start;
	private boolean exit;
	public PingPong() {
		setTitle("Ping Pong");
		setSize(700 ,500);
		setVisible(true);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start=false;
		exit=false;
		
		
		addKeyListener(this);
		p1=new HumanPaddle(1);
		
		b1=new Ball();
		p2=new AIPaddle(2,b1);
		
		thread = new Thread(this);
		thread.start();
		
	}
	
	
	public static void main(String [] args) {
		
		PingPong obj=new PingPong();
		
		
		
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		if(!start) {
			g.setColor(Color.red);
			g.drawString("PRESS ENTER TO START THE GAME", 250, 250);
		}
		
		if(b1.getX()<10 || b1.getX()>710) {
			g.setColor(Color.red);
			g.drawString("GAME OVER", 350, 250);
			g.drawString("FINAL SCORE : "+b1.getScore(), 350, 280);
			stop();
		}
		else {
			p1.draw(g);
			p2.draw(g);
			b1.draw(g);
		}
		
		
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
	@Override
	public void run() {
		
		while(!exit) {
			if(start) {
			p1.move();
			p2.move();
			b1.move();
			b1.checkPaddleCollision(p1, p2);
			
			repaint();
			
			}
			try {
				Thread.sleep(10);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar()=='w') {
			p1.setUpAccel(true);
		}
		else if(e.getKeyChar()=='s') {
			p1.setDownAccel(true);
		}
		/*if(e.getKeyChar()=='8') {
			p2.setUpAccel(true);
		}
		else if(e.getKeyChar()=='2') {
			p2.setDownAccel(true);
		}*/
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyChar()=='w') {
			p1.setUpAccel(false);
		}
		else if(e.getKeyChar()=='s') {
			p1.setDownAccel(false);
		}
		else if(e.getKeyChar()==KeyEvent.VK_ENTER)
			start=true;
	/*	if(e.getKeyChar()=='8') {
			p2.setUpAccel(false);
		}
		else if(e.getKeyChar()=='2') {
			p2.setDownAccel(false);
		}*/
	}
	
	public void stop() {
		exit=true;
	}
	
}