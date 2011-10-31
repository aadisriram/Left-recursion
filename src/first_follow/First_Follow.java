package first_follow;

//import java.util.ArrayList;

public class First_Follow {
	String NT_symbol=new String();						//Stores a Non-terminal say X
	String First=new String();	//Stores the First(x) - its does not NEED to be an ArrayList, I just made it like tat :P
	String Follow=new String();	//Stores the Follow(x)
	
	
	
	public First_Follow(String sym,String frst,String follow)	//Not too sure which constructor we will be using
	{
		NT_symbol=sym;
		First=frst;
		Follow=follow;
	}
	
	public First_Follow()
	{
		//First.clear();
		//Follow.clear();
	}
}
