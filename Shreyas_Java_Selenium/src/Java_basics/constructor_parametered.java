package Java_basics;

public class constructor_parametered 
{	
	int i;
	String s ;
	
	 constructor_parametered(int num, String str)	//parametered constructor with different varibales for i and s
	{
		i = num;	//used variable "num" for "i" variable
		s = str;
		System.out.println(25);
		System.out.println("SHREYAS");
	}
	
    public static void main(String[] args)
    {
    	constructor_parametered obj = new constructor_parametered(55, "DAYAL");	//added data which we want to show	
    	System.out.println(obj.i);			// used global variable i for 55
    	System.out.println(obj.s);			// used global variable s for DAYAL
    	
    }
}



