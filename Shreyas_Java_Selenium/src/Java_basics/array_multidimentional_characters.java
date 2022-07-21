package Java_basics;

public class array_multidimentional_characters

{
	public static void main (String args[])
	{
	String [][] city = {{"Pune","Satara"},{"Mumbai","Delhi"},{"Kolkata","Satara"}}; 
	
	for (int i=0;i<3;i++)
	{
		//if wrote for rows as 3 then will show error, because defined only upto 2 rows {"Pune","Satara"}
		//if wrote {"Pune","Satara","Kolhapur"} and written 3 in loop of j then will show.
		for(int j=0;j<2;j++)	
		{
			//remember to write only "print" intead of "println", if wrote "println" then all elements displays on new line.
			System.out.print(city[i][j]+" ");	
		}
		System.out.println();
	}

}
}
