package test;

import java.awt.Graphics;

public class Jineng1 extends Jineng  {

	Jineng1() {
		sudu = 10;
		jinengtime = 10;
		width = 50;
		height = 50;
		jnstatus=JNstatus.LENGQUEING;
		gongjili=20;
		

	}

	@Override
	public void usejineng(wanjia wj) {
		// TODO Auto-generated method stub
		if(jnstatus==JNstatus.USEABLE)	
		{
		  if (wj.id == 1) {
			this.x = wj.x - 10 - this.width;
			this.y = wj.y;
			this.direction = Direction.LEFT;
			this.jnstatus=JNstatus.USEING;
	     	}
		}
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub

		g.fillOval(x, y, width, height);

	}

	public void yundong() {
		if (direction == Direction.LEFT) {
			x -= sudu;
		
		    if(x<-300)
		    {
		    	jnstatus=JNstatus.LENGQUEING;
		    	
		    }
		
		
		}
		else if(direction == Direction.RIGHT)
		{
			x += sudu;
			
			 if(x>1000)
			    {
			    	jnstatus=JNstatus.LENGQUEING;
			    	
			    }
			
		}
		else {
			
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
	   if(jinengtime>0)
	   {
			jinengtime-=1;
	   }
	   else {
		   
		   if(jnstatus!=JNstatus.USEING)
		   {
		   jnstatus=JNstatus.USEABLE;
		   }
	   }
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
