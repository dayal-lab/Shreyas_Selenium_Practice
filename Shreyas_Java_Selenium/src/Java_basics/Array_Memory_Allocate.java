package Java_basics;

public class Array_Memory_Allocate 
{

	public static void main(String[] args)
	{
		int [] price ; 			//declared array "[]price" in variable "int"
	
		price = new int [4];	//allocated size of array "4"
		
		price[0] =  1000;		//added value "1000" into "price[0]" location
		price[1] =  2450;
		price[2] =  7800;
		price[3] =  6500;
	
		System.out.println("Value at price array location 2 is : "+price[2]);	//prints "price[2]" array value
		
	}

}

