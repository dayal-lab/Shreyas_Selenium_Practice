package Java_basics;

public class Shreyas_Constructor 
{
	char c;		//"c" is a attribute which stores in variable "char"
	String s ; // "s" is a attribute which stores in variable "String"
	String [] age;
	
	
	//created Constructor with same name as class name "Shreyas_Constructor"
	//"Constructor" use to set values for attributes.
	public Shreyas_Constructor ()	
	{
		//here "c" is a attribute which is defined globally in "public class Shreyas_Constructor" i.e it is a non-static, instance, global variable/global attribute.
		//That is here, now "c" had not values, so in this constructor method, we have set values for attribute "c" as 'S', same for "s" and array age[] attribute also.
		c= 'S';
		
		s = "Shreyas";
		
		age = new String [2];
		
		age[0] = "34";
		age[1] = "55";
	}

	public static void main(String[] args) 
	{
		Shreyas_Constructor obj = new Shreyas_Constructor(); //object created and called constructor
		
		System.out.println(obj.c);
		System.out.println(obj.s);
		System.out.println(obj.age[1]);
	}

}
