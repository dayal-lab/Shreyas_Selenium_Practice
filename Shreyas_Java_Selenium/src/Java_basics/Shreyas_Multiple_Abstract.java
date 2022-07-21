package Java_basics;

	abstract class Shreyas_Multiple_Abstract

	{
		public abstract void Firstname1();
	
		public void Lastname()
		{
			System.out.println("DAYAL");
		}
	}
	
	class ABC extends Shreyas_Multiple_Abstract
	{
	@Override
	public void Firstname1() 
	{
		System.out.println("SHREYAS");
	}
	
	
	class Child2 extends Shreyas_Multiple_Abstract //another child extends parent class by calling same abstract method
	{
		@Override
		public void Firstname1() 
		{
			System.out.println("SHREYAS1");
		}
	}
	
	public static void main(String[] args) 
	{
		ABC call = new ABC ();
		call.Firstname1();
		call.Lastname();
	}
}
	





	





	




