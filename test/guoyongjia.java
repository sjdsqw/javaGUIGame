package test;

import java.awt.Graphics;
import java.util.ArrayList;

public class guoyongjia extends wanjia implements Runnable {

	
	boolean up = false, down = false, left = false, right = false;
     zidan xlzd;boolean xuli=false;
     int presstime=0;

	public guoyongjia() {
		// TODO Auto-generated constructor stub
		id=1;
		x = 300;
		weight = 70;
		height = 50;
		y = 250;
		shudu = 3;
		gongjili = 10;
		status = AStatus.ATTACK;
		life = 70;
		dead = false;
		att = false;
		zidans = new ArrayList();
		jns=new ArrayList<Jineng>();
		Jineng jn=new Jineng1();
		jns.add(jn);
		Thread jn1thread=new Thread(jn);
		jn1thread.start();
		
		
		
		
	}

	public void paint(Graphics g) {
		// TODO Auto-generated method stub

		if (!dead) {
			g.drawRect(x, y - 20, life, 10);
			g.drawOval(x, y, weight, height);
			if(!xuli)
			{
			g.drawOval((int) (x + weight * 0.2), (int) (y + height * 0.2), 20, 20);
			
			}
			else {
				g.fillOval((int) (x + weight * 0.2), (int) (y + height * 0.2), 20, 20);
			}
			
			if (status == AStatus.DEFENT) {
				g.drawOval(x - 15, y - 20, 10, height + 20);
			}
		}

	}

	public void xuli() {
		// TODO Auto-generated method stub          
		
		Thread xlthread=new Thread(()->{
			xuli=true;
			int nowpress=presstime;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			if(xuli==true&&presstime==nowpress)
			{
			zidan z = new zidan(x - 30, y + 35, 2);
			zidans.add(z);
			xlzd=z;
			Thread zdyd=new Thread(()->{
				while( status == AStatus.ATTACK&&xuli==true&&presstime==nowpress) {		
					
					z.x=x-20-z.width;
					z.y=(int)(y+25-0.5*z.height);
					
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			      
				}
				
			});
			zdyd.start();
			
			Thread zdup=new Thread(()->{
				while( status == AStatus.ATTACK&&xuli==true) {
				if(xlzd.gongjili<30)
				{
				xlzd.width+=20;
				xlzd.height+=20;
				xlzd.gongjili+=5;
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			});
			zdup.start();
			
			
		
			}
			
		});
	    xlthread.start();
	}
	
	public void attach() {
		// TODO Auto-generated method stub

		if(xlzd==null)
		{
		
		
		if ( status == AStatus.ATTACK) {			
			zidan z = new zidan(x - 30, y + 35, 2);
			z.zdstatus=ZDstatus.feixing;
			zidans.add(z);
			Thread t = new Thread(z);
			z = null;
			t.start();
			xuli=false;
		}
		
		}
		else {
			
			Thread t=new Thread(xlzd);
			t.start();
			xlzd.zdstatus=ZDstatus.feixing;
			xuli=false;
			xlzd=null;
			
			
		}

	}

	public void reattach() {
		// TODO Auto-generated method stub
		zidan z = new zidan(x - 5, (int) (y + 0.8 * height), 2);
		zidans.add(z);
		zidan z2 = new zidan(x - 25, (int) (y + 0.8 * height), 2);
		zidans.add(z2);
		Thread t = new Thread(z);
		Thread t2 = new Thread(z2);
		z.zdstatus=ZDstatus.feixing;
		z2.zdstatus=ZDstatus.feixing;
		t.start();
		t2.start();
	}

	

	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			if (up == true) {				
				if(y>40)
				{
				y -= shudu;
				}
			}
			if (down == true) {
				
				if(y<550-height)
				{
				y += shudu;
				}
			}
			if (left == true) {
				if(x>10)
				{
				x -= shudu;
				}
			}
			if (right == true) {
				if(x<750-weight)
				{
				x += shudu;
				}
			}

			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
