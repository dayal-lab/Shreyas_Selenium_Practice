package Java_basics;

public class Object_Create 
{
	
	public void character()
	{
		char c 	='S' ;	// "char" is a "variable" also called storage location of attribute "c", which stores "S" character in vairable "char" name "c".
		String s = "Shreyas"; //stores "Shreyas" name in variable "String" by name "s" attribute.
		
		//defining 
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
		//"Object_Create" is a main class and "datatype" is a obj. of class "Object_Create"
		//User should use same name of main class name otherwise error will generate.
		Object_Create datatype = new Object_Create();
		
		//now calling above methods by created object name "datatype"
		datatype.character();	//called method "character()" by object "datatype" , where dot(.) creates object.
		datatype.numbers();		//called method "numbers()"
		datatype.boolen();		//called method "boolean()"
	}

}
