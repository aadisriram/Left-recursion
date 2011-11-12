package remove.left.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LeftRecR 
{
	static int count=0;
	static public ArrayList<Productions> prodL=new ArrayList<Productions>();
	
	
	public static void main(String[] args) 
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("\nEnter the production with one line per symbol on the LHS: ");
		
		System.out.println("How many productions:");
		count=Integer.parseInt(getStrings(br));
		
		while(count>0)
		{
			try 
			{
				String input = getStrings(br);
				String[] lp = input.split("->");
				prodL.add(new Productions(lp[0],lp[1]));
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			count--;
		}
		
		System.out.println("Eliminating left recursion: ");
		
		try 
		{
			eliminator();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		for(Productions p:prodL)
		{
			System.out.print("\n"+p.lhs+"->");
			
			for(String k:p.rhs)
			{
				System.out.print(k+"/");
			}
		}
		
		System.out.println(" Evalutating the first set: ");
		
		
	}
	
	private static void eliminator()
	{	
		
		ArrayList<Productions> tmpProdL=new ArrayList<Productions>();
		
		for(Productions ppr:prodL)
		{
			int flag=0;
			
			for(String k:ppr.rhs)
			{
				if(k.charAt(0)==ppr.lhs.charAt(0))
				{
					flag=1;
				}
			}
			
			if(flag==1)
			{
				ArrayList<String> tmp=new ArrayList<String>();
				
				for(String t:ppr.rhs)
				{
					if(t.charAt(0)!=ppr.lhs.charAt(0))
					{
						tmp.add(t);
					}
				}
				
				String ltp=ppr.lhs+"'";
				
				String tmpl=ppr.lhs.toString();
				ArrayList<String> tmpr=new ArrayList<String>();
				
				for(String y:tmp)
				{
					tmpr.add(y+ltp);
				}
				
				ArrayList<String> lop=new ArrayList<String>(); 
				
				for(String lk:ppr.rhs)
				{
					if(!tmp.contains(lk))
					{
						if(lk.length()>1)
						{
							lop.add(lk.substring(1)+ltp);
						}
					}
				}
				
				lop.add("epsilon");
				
				tmpProdL.add(new Productions(ltp,lop));
				
				ppr.rhs=tmpr;
			}
		}
		
		prodL.addAll(tmpProdL);
	}
		
	
	private static String getStrings(BufferedReader br) 
	{
		try
		{
			return br.readLine();
		}
		
		catch (Exception e)
		{
			System.out.println("oops");
			return null;	
		}
	}
}