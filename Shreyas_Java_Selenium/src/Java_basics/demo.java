package Java_basics;

public class demo 
{
	
	
	public static void main(String[] args)
	{
		String [][] name = {{"a","b","c"}, {"d","e","f"},{"g","h","i"}};
		
		for(int i=1; i<3;i++)
		{
			for(int j=2;j<3;j++)
			{
				System.out.print(name[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
	}

}
