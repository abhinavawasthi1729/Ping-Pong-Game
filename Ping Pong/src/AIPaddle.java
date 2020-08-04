
import java.awt.Color;
import java.awt.Graphics;

public class AIPaddle implements Paddle{

	double y, yVel;
	final double GRAVITY=0.94;
	boolean upAccel, downAccel;
	int player,x;
	Ball b;
	public AIPaddle(int player,Ball b1) {
		upAccel=false;
		downAccel=false;
		y=210;
		yVel=0;
		b=b1;
		if(player==1)
			x=20;
		else 
			x=660;
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, (int) y, 20, 80);
		
	}
	@Override
	public void move() {
	/*	if(upAccel)
			yVel-=2;
		else if(downAccel)
			yVel+=2;
		else if(!upAccel && !downAccel)
			yVel*=GRAVITY;
		
		if(yVel>=5)
			yVel=5;
		else if(yVel<=-5)
			yVel=-5;		
		y+=yVel;
		if(y<=0)
			y=0;
		else if(y>=420)
			y=420;*/
		y=b.getY()-40;
		if(y<=0)
			y=0;
		else if(y>=420)
			y=420;
		
	}
	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return (int)y;
	}
/*	public void setUpAccel(boolean input) {
		upAccel=input;
	}
	public void setDownAccel(boolean input) {
		downAccel=input;
	}*/
	
	
}

