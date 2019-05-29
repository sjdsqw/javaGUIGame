package test;

import java.awt.Graphics;
import java.awt.List;
import java.util.ArrayList;

public abstract class wanjia {
	
	int id;
	int x,y;
	int weight,height;
	int shudu ;
	int gongjili;
	ArrayList<Jineng> jns;
	Enum status;
	int life = 70;
	boolean dead = false;
	boolean att = false;
	ArrayList<zidan> zidans ;
	public abstract void paint(Graphics g) ;
	public abstract void attach();
	public abstract void reattach();
}
