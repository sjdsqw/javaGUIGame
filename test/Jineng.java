package test;

import java.awt.Graphics;

public abstract class Jineng implements Runnable  {
	int width,height;
	int jinengtime;	
	Enum direction;
	Enum jnstatus;
	int gongjili;
	int x,y;
	int sudu;
	public abstract void usejineng(wanjia wj);
	public abstract void paint(Graphics g);
	public abstract void yundong();
		
	}


