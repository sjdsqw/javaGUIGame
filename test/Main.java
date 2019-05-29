package test;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	JFrame jf;
	Mypanel jp;
    int width,height;
    int presstime1=0;
    int presstime2=0;
   
   
	public Main() {
		jf = new JFrame();
	    width=800;height=600;
		jf.setBounds(200, 50, width,height );
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp = new Mypanel();
		jf.add(jp);
		Thread t2 = new Thread(jp.zc);
		Thread t3 = new Thread(jp.gyj);
		Thread t1 = new Thread(jp);
		t1.start();
		t2.start();
		t3.start();
		jf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
				if (e.getKeyCode() == e.VK_UP) {

					jp.zc.up = true;
				}
				if (e.getKeyCode() == e.VK_DOWN) {
					jp.zc.down = true;
				}
				if (e.getKeyCode() == e.VK_LEFT) {
					jp.zc.left = true;
				}
				if (e.getKeyCode() == e.VK_RIGHT) {
					jp.zc.right = true;
				}

				if (e.getKeyCode() == e.VK_W) {

					jp.gyj.up = true;
					
				}
				if (e.getKeyCode() == e.VK_S) {
					jp.gyj.down = true;
				}
				if (e.getKeyCode() == e.VK_A) {
					jp.gyj.left = true;
				}
				if (e.getKeyCode() == e.VK_D) {
					jp.gyj.right = true;
				}

				if (e.getKeyCode() == e.VK_NUMPAD1) {
					if(jp.zc.att==false)
					{
					jp.zc.att=true;
					jp.zc.presstime+=1;
					jp.zc.xuli();
					}
				  

				}
				if (e.getKeyCode() == e.VK_J) {
			
					
					if(jp.gyj.att==false)
						{
								 
						jp.gyj.att=true;
						jp.gyj.presstime+=1;
						jp.gyj.xuli();
						
						
						
						}
					  
					  

				}
				
				if (e.getKeyCode() == e.VK_K) {
					
					if(jp.gyj.xuli==false)
					{
					jp.gyj.status=AStatus.DEFENT;		
					}

				}
				
				
				if(e.getKeyCode()==e.VK_U)
				{
					
					Jineng jn=jp.gyj.jns.get(0);
					if(jn.jnstatus==JNstatus.USEABLE)
					{
					jn.usejineng(jp.gyj);
					jn.jinengtime=10;
					jn.jnstatus=JNstatus.USEING;				
					Thread jn1yundong =new Thread(()->{
						while(jn.jnstatus==JNstatus.USEING)
						{
						jn.yundong();
						try {
							Thread.sleep(40);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						}
					
					});
					
					jn1yundong.start();
					}
				}
				
				
				if(e.getKeyCode()==e.VK_NUMPAD4)
				{
					
					Jineng jn=jp.zc.jns.get(0);
					if(jn.jnstatus==JNstatus.USEABLE)
					{
					jn.usejineng(jp.zc);
					jn.jinengtime=10;
					jn.jnstatus=JNstatus.USEING;				
					Thread jn1yundong =new Thread(()->{
						while(jn.jnstatus==JNstatus.USEING)
						{
						jn.yundong();
						try {
							Thread.sleep(40);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						}
					
					});
					
					jn1yundong.start();
					}
				}
				
				
				
				
				if (e.getKeyCode() == e.VK_NUMPAD2) {
					if(jp.zc.xuli==false)
					{
					jp.zc.status=AStatus.DEFENT;					
					}
				}
				
				

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
				if (e.getKeyCode() == e.VK_UP) {
					jp.zc.up = false;
				}
				if (e.getKeyCode() == e.VK_DOWN) {
					jp.zc.down = false;
				}
				if (e.getKeyCode() == e.VK_LEFT) {
					jp.zc.left = false;
				}
				if (e.getKeyCode() == e.VK_RIGHT) {
					jp.zc.right = false;
				}
				if (e.getKeyCode() == e.VK_W) {

					jp.gyj.up = false;
				}
				if (e.getKeyCode() == e.VK_S) {
					jp.gyj.down = false;
				}
				if (e.getKeyCode() == e.VK_A) {
					jp.gyj.left = false;
				}
				if (e.getKeyCode() == e.VK_D) {
					jp.gyj.right = false;
				}

				if (e.getKeyCode() == e.VK_NUMPAD1) {

					 jp.zc.att=false;
						jp.zc.attach();

				}

				if (e.getKeyCode() == e.VK_J) {

					   jp.gyj.att=false;
						jp.gyj.attach();
					
					
					 

				}
				if (e.getKeyCode() == e.VK_K) {
					jp.gyj.status=AStatus.ATTACK;		

				}
				if (e.getKeyCode() == e.VK_NUMPAD2) {
					if(jp.zc.status==AStatus.DEFENT)
					{
					jp.zc.status=AStatus.ATTACK;	
					}
				}

			}

		});

		Timer t = new Timer();
		t.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("1");
				Random r = new Random();
				int x = r.nextInt(700);
				int y = r.nextInt(700);
				daoju dj = new daoju(1, x, y);
				System.out.println(dj.x + " " + dj.y);
				jp.djs.add(dj);

			}
		}, 15000);

		t.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("2");
				Random r = new Random();
				int x = r.nextInt(700);
				int y = r.nextInt(700);
				daoju dj = new daoju(2, x, y);
				System.out.println(dj.x + " " + dj.y);
				jp.djs.add(dj);

			}
		}, 30000);

		jf.setVisible(true);
	}

	public static void main(String[] args) {
		Main m = new Main();

	}
}
