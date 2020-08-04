import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball {
	
	double x,y,xVel,yVel;
	Random rand;
	int score=0;
	public Ball() {
		x=350;
		y=250;
		rand=new Random();
		int value=rand.nextInt(2);
		if(value==0)
			xVel=-2;
		else
			xVel=2;
		yVel=1;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval((int)x-10,(int)y-10,20,20);
	}
	

	
	public void move() {
		x+=xVel;
		y+=yVel;
		
		if(y<40)
			yVel=-yVel;
		if(y>490)
			yVel=-yVel;
		
		
	}
	
	public void checkPaddleCollision(Paddle p1, Paddle p2) {
		
		if(x<=50) {
			if(y>=p1.getY() && y<=p1.getY()+80) {
				xVel=-xVel;
				xVel*=1.5;
				yVel*=1.5;
				score+=10;
				
				
			}
		}
		else if(x>=650) {
			if(y>=p2.getY() && y<=p2.getY()+80)
				xVel=-xVel;
		}
		
	}
	public int getX() {
		return (int)x;
	}
	public int getY() {
		return (int)y;
	}
	
	public int getScore() {
		return score;
	}

}
