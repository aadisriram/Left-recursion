package first_follow;

import java.util.ArrayList;

public class First {
	
	public static ArrayList<Productions> clean_pr=new ArrayList<Productions>();
	public static ArrayList<First_Follow> solution=new ArrayList<First_Follow>();
	
	public static void main(String[] args) 
	{
		clean_pr=LeftRecR.Read_Clean();
		read_first();
	}
	
	public static  void  read_first()
	{
		
		ArrayList<String> NT_list=new ArrayList<String>();
		ArrayList<String> clean=new ArrayList<String>();
		
		for(Productions pr:clean_pr)			//Make a list of all the Non-Terminals
		{
			NT_list.add(pr.lhs);
		}
		
		
		for(Productions pr:clean_pr)			
		{		
			First_Follow tmp=new First_Follow();
			tmp.NT_symbol=pr.lhs;
			
			for(String S:pr.rhs)
			{
				if(!NT_list.contains(S.charAt(0)))
					tmp.First=tmp.First.concat(S.charAt(0)+"|");
				else
					clean.add(S);
			}
			
		}

	}
	
	public static void find_first()
	{
		
	
	}
}
