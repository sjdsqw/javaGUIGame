package test;

import java.awt.Graphics;

public class zidan implements Runnable{
int x,y;
int sudu=8;
int width=10,height=10;
int type;
int gongjili;
Enum zdstatus;

	public zidan(int i, int j,int type) {
	// TODO Auto-generated constructor stub
		this.x=i;
		this.y=j;
		this.type=type;
		zdstatus=ZDstatus.xuli;
		if(type==1)
		{
			gongjili=5;
		}
		else if(type==2)
		{
			gongjili=10;
		}
		else {
			
		}
		
		
}
	public synchronized void paint(Graphics g)
	{
		
		g.drawOval(x, y, width, height);
	}
	
	public void yundong()
	{
		if(type==1)
		{
		x+=sudu;
		}
		else{
			x-=sudu;
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			this.yundong();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	
}
