package test;

import java.awt.Graphics;

public class daoju {
	
	int type=1;
	int x=0;
	int y=0;
	
	public daoju(int type,int x,int y) {
		// TODO Auto-generated constructor stub
	this.type=type;
	this.x=x;
	this.y=y;
	}
	
	
	public void paint(Graphics g)
	{	
		
		g.drawRect(x, y, 25, 25);
			
	}
	
	
	
	
	
	
	

}
