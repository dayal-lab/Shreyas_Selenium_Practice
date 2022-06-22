package Java_basics;

public class Arrays 
{
	public static void main(String[] args)
	{
		String [] laptops 	= 	{"Acer","Leneovo","HP","Dell"}; 
		int [] price		=	{23500,50000,64000,34000};
		
		//displaying arrys[2] laptop
		System.out.println("Latest laptop is		: "+laptops[2]);
		System.out.println("Price of laptop is		: "+price[2]);
		System.out.printf("Total no. of laptops are	: "+laptops.length);
	}
}
