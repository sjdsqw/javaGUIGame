package test;

import java.util.List;

public class pengzhuang {
guoyongjia gyj;
zongchao zc;
List<daoju> djs;
Mypanel mp;
	
	
	public pengzhuang(guoyongjia gyj,zongchao zc,List<daoju> djs,Mypanel mp) {
		// TODO Auto-generated constructor stub
	
		this.gyj=gyj;
		this.zc=zc;
		this.djs=djs;
		this.mp=mp;
	   	
	}
	 
	public void ispengzhuang()
	{
	for(int i=0;i<gyj.zidans.size();i++)
	{
		zidan zd=gyj.zidans.get(i);
		if(zd.x+zd.width>=zc.x&&zd.x<zc.x+zc.weight&&zd.y+zd.height>=zc.y&&zd.y<=zc.y+zc.height&&zd.zdstatus==ZDstatus.feixing)
		{
			
			if(zc.status==AStatus.ATTACK)
			{
			
			  
			gyj.zidans.remove(zd);
			
			zc.life=zc.life-zd.gongjili;
			if(zc.life<0)
			{
		      zc.dead=true;
			}
			}
			else {
				gyj.zidans.remove(zd);
				zc.reattach();
				
			}
			return;
			
		}
		
	
		for(int j=0;j<zc.zidans.size();j++)
		{
			try {
				zidan zd2=zc.zidans.get(i);
			if(zd.x+zd.width>=zd2.x&&zd.x<zd2.x+zd2.width&&zd.y+zd.height>=zd2.y&&zd.y<zd2.y+zd2.height&&zd.zdstatus==ZDstatus.feixing)
			{
				zd.gongjili=zd.gongjili-zd2.gongjili;
				zd2.gongjili=zd2.gongjili-zd.gongjili;
				
				if(zd.gongjili<=0)
				{
				gyj.zidans.remove(zd);
				}
				if(zd2.gongjili<=0)
				{
				zc.zidans.remove(zd2);
				}
				return;
			}
			} catch (Exception e) {
			// TODO: handle exception
			   			
			}
			
			
		}
		
		
		
		
		
	}
	
	
	for(int i=0;i<zc.zidans.size();i++)
	{
		zidan zd=zc.zidans.get(i);
		if(zd.x+zd.width>=gyj.x&&zd.x<gyj.x+gyj.weight&&zd.y+zd.height>=gyj.y&&zd.y<=gyj.y+gyj.height&&zd.zdstatus==ZDstatus.feixing)
		{
			
			if(gyj.status==AStatus.ATTACK)
			{
			zc.zidans.remove(zd);
			
			gyj.life=gyj.life-zd.gongjili;
			if(gyj.life<0)
			{
			gyj.dead=true;
			}
			}
			else {
				zc.zidans.remove(zd);
				gyj.reattach();
				
			}
			return;
		}
		
			
		
	}
	
		for(int i=0;i<djs.size();i++)
		{
			daoju dj=djs.get(i);
			if(dj.x+10>=gyj.x&&dj.x<gyj.x+gyj.weight&&dj.y+10>=gyj.y&&dj.y<=gyj.y+gyj.height)
			{
				if(dj.type==1)
				{
					System.out.println("sasa");
					gyj.shudu+=5;
					mp.djs.remove(dj);
					
				}
				if(dj.type==2)
				{
				
					gyj.gongjili+=5;
					
					mp.djs.remove(dj);
					
				}
				return;
	
			}
			
			
			if(dj.x>=zc.x&&dj.x<zc.x+35&&dj.y+25>=zc.y&&dj.y<=zc.y+80)
			{
				if(dj.type==1)
				{
					System.out.println("sasa");
					zc.shudu+=5;
					mp.djs.remove(dj);
					
				}
				
				if(dj.type==2)
				{
				
					zc.gongjili+=5;
					
					mp.djs.remove(dj);
					
				}
				
				
				
			}
			
			
		}
	
	
		for(int i=0;i<gyj.jns.size();i++)
		{
			Jineng jn=gyj.jns.get(i);
			if(jn.jnstatus==JNstatus.USEING)
			{
				if(zc.x+zc.weight>jn.x&&zc.x<jn.x+jn.width&&zc.y+zc.height>jn.y&&zc.y<jn.y+jn.height)
				{
					jn.jnstatus=JNstatus.LENGQUEING;
					zc.life-=jn.gongjili;
					
					
				}
				
			}
			
			
			
		}
		
		for(int i=0;i<zc.jns.size();i++)
		{
			Jineng jn=zc.jns.get(i);
			if(jn.jnstatus==JNstatus.USEING)
			{
				if(gyj.x+gyj.weight>jn.x&&gyj.x<jn.x+jn.width&&gyj.y+gyj.height>jn.y&&gyj.y<jn.y+jn.height)
				{
					jn.jnstatus=JNstatus.LENGQUEING;
					gyj.life-=jn.gongjili;
					
					
				}
				
			}
			
			
			
		}
		
		
		
		
	}
		
	
	
	
}
