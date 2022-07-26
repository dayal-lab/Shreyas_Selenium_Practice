package Java_basics;

public class overloading_main_method 
{
	public static void main (boolean args)
	{
		{
			System.out.println("Boolean main method");
		}
	}
	
	public static void main (int args)
	{
		System.out.println("int main method");
	}
	
	public static void main (String args[])
	{
		System.out.println("Main method");
		
		//called all main method in main Dtring args[] method , bcz java only executes this String args[] main method.
		
		
		//Java overloads main method that is overload only non-static methods with different parameters, but java not overides same method with same
		//parameters because static methods not overides in java.
		
		overloading_main_method.main(true);	//called boolean's main method by definignits true or false value in bracket.
		overloading_main_method.main(12345);//called int main method by defining integer value in bracket.
		
	}

}
