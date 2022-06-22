package Java_basics;

abstract class Parent_Abstract 
{
		public abstract void Price();	//created abstract method without body
		
		public void Color()				//created regular method with body, variables, attibutes
		{
			String s = "Red";
			
			System.out.println("Color of Toyota car is 		: "+s);
		}
		
}
	
	   class Child extends Parent_Abstract	//now create "Child" subclass which will inherit from "Parent_Abstract" by "extends" keyword
	 {
		 
		  public void Price()		//now created body of "Price" class which is inherited or extended from "Parent_Abstract" class
		  {
			  double d = 45.36000;
			  
			  System.out.println("Price of Toyota car is (in lacs): "+d);
		  }
		  
	 
	 //Now create object of class and call methods
	 //public method define in same "Child" subclass method, it should not be outside of "Child" subclass.
		  
	  public static void main(String[] args)
	  	{
		  Child call = new Child();		//created object "call" of subclass "Child",
		  								//we cannot create object of "Parent_Abstract", because we have taken properties from that class.
		  
		  call.Price();	//called method from subclass 
		  call.Color();
	  	}
	 }
