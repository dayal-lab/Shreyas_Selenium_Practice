package Java_basics;

public class array_length 
{
	public static void main (String args[])
	{
		int [] age = new int [4];
		
		age[0]	= 1;
		age[1]	= 2;
		age[2]	= 3;
		age[3]	= 4; 
	
		
// or can write in this simple way also-
//		int [] age = {1,2,3,4}; and use for loop.
		
		for (int i=0; i<age.length; i ++)	//continues for loop till age[] array length is less than 0
		{
			System.out.println(age[i]);
		}
		
		
		
	}

}
