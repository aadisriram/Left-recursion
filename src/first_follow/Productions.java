package first_follow;

import java.util.ArrayList;

public class Productions 
{
	
	public String lhs;
	public ArrayList<String> rhs;
	
	public Productions()
	{
		lhs=new String();
		rhs.clear();
	}
	
	public Productions(String l,String r)
	{
		lhs=new String(l);
		
		String[] s=r.split("/");
		rhs=new ArrayList<String>();
		
		int k=s.length;
		
		for(int i=0;i<k;i++)
		{
			rhs.add(s[i]);
		}
	}
	
	public Productions(String l,ArrayList<String> r)
	{
		lhs=new String(l);
		rhs=new ArrayList<String>(r);
	}
}