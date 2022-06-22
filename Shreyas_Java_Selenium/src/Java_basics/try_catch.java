package Java_basics;

public class try_catch {

	public static void main(String[] args) 
	
	{
		try //try test code or takes code where is error
		{
		int [] age;
		
		age = new int [2];
		
		age[0] = 20 ;
		age[1] =50;
		
		System.out.println("My age is  : "+age[0]);

		//above +age[4]  not defined in array, so it will give error
		
		//"Exception in thread \"main\" java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 2\r\n"
		//+ "	at Shreyas_Java_Practice.try_catch.main(try_catch.java:15)"
		
		//so to avoid this "try-catch" uses, if we by mistakenly added more or wrong values than defined then it will not show error in red, we can customize as we want.
		}
		
		catch(Exception e) //catch , catches or takes above error of try and executes and give outout whichever written in this method.
		{
			System.out.println("oops....something went wrong !!");
		}

}
}
