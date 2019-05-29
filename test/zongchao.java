package test;

import java.awt.Graphics;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JPanel;

public class zongchao extends wanjia implements Runnable {

	boolean up = false, down = false, left = false, right = false;
    zidan xlzd;boolean xuli=false;
    int presstime=0;
	public zongchao() {
		// TODO Auto-generated constructor stub
		id=2;
		x = 400;
		y = 250;
		weight = 70;
		height = 50;
		shudu = 6;
		gongjili = 5;
		status = AStatus.ATTACK;
		life = 70;
		dead = false;
		att = false;
		zidans = new ArrayList();
		jns=new ArrayList<Jineng>();
		Jineng jn=new Jineng4();
		jns.add(jn);
		Thread jn1thread=new Thread(jn);
		jn1thread.start();
	}

	public void paint(Graphics g) {

		if (dead == false) {
			g.drawRect(x, y - 20, life, 10);
			
			g.drawRect(x, y, this.weight, this.height);
			if(xuli==false)
			{
			g.drawRect((int) (x + 0.7 * this.weight), (int) (y + 0.3 * this.height), 20, 20);
			}
			else {
				g.fillRect((int) (x + 0.7 * this.weight), (int) (y + 0.3 * this.height), 20, 20);
			}
			if (status == AStatus.DEFENT) {
				g.drawRect(x + this.weight + 5, y - 20, 10, this.height + 20);
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
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(xuli==true&&presstime==nowpress)
			{
				zidan z = new zidan(x+weight+10, (int) (y + 0.8 * height), 1);
			zidans.add(z);
			xlzd=z;
			Thread zdyd=new Thread(()->{
				while( status == AStatus.ATTACK&&xuli==true&&presstime==nowpress) {		
					
					z.x=x+5+weight;
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
			zidan z = new zidan(x + weight+10, (int) (y + 0.8 * height), 1);
			zidans.add(z);
			z.zdstatus=ZDstatus.feixing;
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
		zidan z  = new zidan(x + weight+10, (int) (y + 0.8 * height), 1);
		zidans.add(z);
		
		zidan z2  = new zidan(x + weight+10, (int) (y + 0.8 * height), 1);
		zidans.add(z2);
		z.zdstatus=ZDstatus.feixing;
		z2.zdstatus=ZDstatus.feixing;
		Thread t = new Thread(z);
		Thread t2 = new Thread(z2);
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
