package Java_basics;

public class Shreyas_Destructor 
{

	public static void main(String[] args) throws Throwable
	{
		Shreyas_Destructor de = new Shreyas_Destructor();
		de.finalize();
		System.gc();
	}
	
	protected void finalize()
	{
		System.out.println("Object is destroyed by Garbage Collector (gc)");
	}

}
