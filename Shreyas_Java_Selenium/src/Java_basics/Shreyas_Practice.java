package Java_basics;

public class Shreyas_Practice 
{
	public void main(String[] args)
	{
		
	}

	public void Premitive_Numeric()
	{
		int i		= 40;
		float f		= 3.4455f;
		double d	= 34.22233d;
		long l		= 7485783843838L;
		
		System.out.println("Called below methods from Shreyas_Practice class-->");
		
		System.out.println("***************************************************");
		
		System.out.println("Employee's age			: "+i);
		System.out.println("Employee's working period	: "+f);
		System.out.println("Employee's package		: "+d);
		System.out.println("Employee's Regi No		: "+l);
		
	}
	
	public void Premitive_NonNumeric()
	{
		char c 		= 'D';
		String s 	= "Dayal";
		Boolean b	= false;
		
		System.out.println("Employee's surname		: "+s);
		System.out.println("Employee's nickname 		: "+c);
		System.out.println("Employee's record		: "+b);
	}
	
	public void Non_Permitive()
	{
		//create array memory name "roll_no"
		int [] roll_no ; //array name "roll_no" stored in variable "int" 
		
		roll_no = new int[4];	//created memory of 4 locations
		
		roll_no[0] = 34;	//added "34" in roll_no[0] location
		roll_no[1] = 44;
		roll_no[2] = 23;
		roll_no[3] = 10;
		
		System.out.println("Employee's present days		: "+roll_no[3]);

	}

}
