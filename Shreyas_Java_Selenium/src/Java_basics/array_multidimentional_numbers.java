package Java_basics;

public class array_multidimentional_numbers 
{
	public static void main (String args[])
	{
		int arr[][]={{1,2,3},{2,4,5},{4,4,5}}; 	//can do only till 3 by 3 rows and columns , if wrote more than 4 for  rows and column then error displays "arrayoutof bound exception" 
		
/*		
 * 
 * ** For i-
 
		int arr[][]={{1,2,3},{2,4,5},{4,4,5}}
					   |	    |       |
		 where i   =   0        1       2		(index 0 is all {1,2,3}, same for index 1 is {2,4,5} and for index 2 is {4,4,5} )
	
	
		
 	** For j -
		
		int arr[][]={{1,2,3}
					  | | |
		 where j   =  0 1 2		(now j defines only one array's index, i.e j=0  is 1, for index 1 = 2, for index 2 = 3 from {1,2,3})
		
		
	when defined 
		for(int i=0;i<3;i++)	//now i=0 means it takes all index of array from 0 till i <3 means from {1,2,3} to {4,4,5}, but which indexes have to take from that array then it define by j
		{  
			and j=2 means it takes all array's 2nd index means from {1,2,3} where its index at 2 is "3" so it takes "3"
			same for other array, {2,4,5} from it takes 2nd index which is "5" and same for last array also .	
			Hence as i=0 and j=2 , ouput defines vertically as 3 	
															   5
															   5
			
			for(int j=2;j<3;j++)	
		{
			System.out.print(arr[i][j]+" ");  //prints i and j
		}
		}
		
		
		
		
		
		if set i=2 and j=0 then it will display only last array {4,4,5}
		
		
		
		
		
*/		
	
		
		//printing 2D array  
		
		//as i=0 means it starts from 0 index which is {1,2,3}
		//index 1 is {2,4,5}, and index 2 is {4,4,5}
		//if wrote int i=3, then it displays {4,4,5}.
		for(int i=0;i<3;i++)		//columns (vertically) - defined 3 means will shows only {1},{2} and {4} from arrat in 3 column.
		{  
			for(int j=2;j<3;j++)	//rows (horizontally) -  defined 2 means will show only 2 rows from {1,2,3} only {2} and from {2,4,5} only {4} and same for {4,4,5}.
			{  
				System.out.print(arr[i][j]+" ");  //prints i and j
			} 
			
			System.out.println();  	//prints on new line, if not wrote then all values display in one line horizontally
		}  
	}
}
