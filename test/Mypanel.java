package test;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Mypanel extends JPanel implements Runnable {
	zongchao zc;
	guoyongjia gyj;
	pengzhuang pz;
	List<daoju> djs;

	public Mypanel() {
		// TODO Auto-generated constructor stub
		zc = new zongchao();
		gyj = new guoyongjia();
		djs = new ArrayList<daoju>();
		pz = new pengzhuang(gyj, zc, djs, this);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		for(int i=0;i<gyj.jns.size();i++)
		{
			Jineng jn=gyj.jns.get(i);
			g.drawString("技能"+(i+1)+":", 5, 15+i*10);g.drawRect(50, 5+i*10, jn.jinengtime*10, 10);
			
		
		    if(jn.jnstatus==JNstatus.USEING)
		    {
		    	jn.paint(g);
		    	
		    }
		
		
		
		
		}
		
		for(int i=0;i<zc.jns.size();i++)
		{
			Jineng jn=zc.jns.get(i);
			g.drawString("技能"+(i+1+3)+":", 600, 15+i*10);g.drawRect(650, 5+i*10, jn.jinengtime*10, 10);
			
		
		    if(jn.jnstatus==JNstatus.USEING)
		    {
		    	jn.paint(g);
		    	
		    }
		
		
		
		
		}
		
		
		
		
		zc.paint(g);
		gyj.paint(g);
		
		if (zc.dead == true || gyj.dead == true) {
			return;
		}

		for (daoju dj : djs) {
			dj.paint(g);

		}

		if (zc.zidans.size() > 0) {

			for (int i = 0; i < zc.zidans.size(); i++) {
				zidan m = zc.zidans.get(i);
				m.paint(g);
				if (m.x > 1000) {
					zc.zidans.remove(m);

				}
			}
		}
		if (gyj.zidans.size() > 0) {
			for (int i = 0; i < gyj.zidans.size(); i++) {
				zidan z = gyj.zidans.get(i);
				z.paint(g);
				if (z.x < 0) {
					gyj.zidans.remove(z);

				}
			}
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			this.repaint();

			pz.ispengzhuang();
            
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
