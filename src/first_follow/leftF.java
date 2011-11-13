package first_follow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class leftF 
{
	static ArrayList<String> l1=new ArrayList<String>();
	static ArrayList<String> pr =new ArrayList<String>();
	
	public static ArrayList<String> leftFactorer()
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int gc=0;
		
		printLin(" Enter the number of productions ");
		
		int n=Integer.parseInt(inRe(br));
		
		printLin("Enter the production one per line in the form L->P ");
		
		while(n>0)
		{
			String k=inRe(br);
			
			pr.add(k);
			
			String []lol=k.split("->");
			String []l=lol[1].split("/");
			
			int flag=0,c=0;
			String tmp=new String();
			
			if(l.length==0)
			{
				l1.add(l[0]);
				n--;
				continue;
			}
			
			while(flag==0)
			{
				if(l[0].charAt(c)==l[1].charAt(c))
					c++;
				
				else
				{
					flag=1;
				}
				
				if(c>l[0].length()-1||c>l[1].length()-1)
				{
					flag=1;
				}
			}
			
			
			if(c>0)
			{	
				String tmm=new String();
				int i=0;
				for(;i<c;i++)
				{
					tmm=tmm+l[0].charAt(i);
				}
				
				l1.add(lol[0]+"->"+tmm+lol[0]+"'");
				
				tmm=new String();
				
				if(l[0].substring(c, l[0].length()).length()>0)
					l1.add(lol[0]+"'->"+l[0].substring(c, l[0].length()));
				else
					l1.add(lol[0]+"'->$");
				
				if(l[1].substring(c, l[1].length()).length()>0)
					l1.add(lol[0]+"'->"+l[1].substring(c, l[1].length()));
				else
					l1.add(lol[0]+"'->$");
			}	
			
			else
			{
				for(String k1:l)
				{
					l1.add(lol[0]+"->"+k1);
				}
			}
			
			n--;
		}
		
		for(String k:l1)
		{
			printLin(k);
			/*String ts=new String();
			String[] tmp=k.split("->");
			ts=tmp[0]+"->";
			
			int flag=0;
			
			for(String l:l1)
			{
				String[] ttt=l.split("->");
				if (ttt[0].equals(tmp[0]))
				{
					ts=ts+"/"+ttt[1];
						
					flag=1;
				}
			}
		
			String kl=new String();
			
			for(int i=0;i<ts.length();i++)
			{
				kl=kl+ts.charAt(i);
				char ch=ts.charAt(i);
				
				if(ch=='>')
					++i;
			}
			
			
			/*
			if(flag==1)
				if(!pr.contains(kl))
				{
					printLin(kl+"   left fact output      "+k);
					pr.add(kl);
				}
			*/
			
		}
		
		
		
		return pr;
	}
	
	public static void printLin(String k)
	{
		System.out.println(k);
	}
	
	public static String inRe(BufferedReader br)
	{
		try
		{
			return br.readLine();
		}
		
		catch(Exception e)
		{
			return null;
		}
	}
}
