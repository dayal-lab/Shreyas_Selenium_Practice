package Java_basics;

public class Obj_Create 
{
	public void character()
		{
			char c 	 ='S' ;	
			String s = "Shreyas";
	
			System.out.println("First letter of a candidate	:"+c);
			System.out.println("Full Name of a candidate	:"+s);
		}

	public void numbers()
		{
			int i 		= 180;
			float f 	= 1.22f;
			double d 	= 12.55d;
			long l 		= 3456767L;
	
			System.out.println("Days of internship (days):"+i);
			System.out.println("Float values			 :"+f);
			System.out.println("Double values			 :"+d);
			System.out.println("Long value				 :"+l);
		}
	

	public void boolen()
	{
		Boolean b = true ;
	
		System.out.println("Boolean condition		 :"+b);
	}	
	

	public static void main(String[] args)
	{
		//object created of class "Object_Create" class by "datatype" object name
		Object_Create datatype = new Object_Create();
	
		datatype.character(); //called method "character()"	
		datatype.numbers();		
		datatype.boolen();		
	}

}
