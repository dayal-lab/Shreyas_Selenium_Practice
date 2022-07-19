package Java_basics;

public class String_Methods 
	{
	
		
	
	
	public static void main(String[] args) throws Throwable 
	{	
		String s = "Shreyas";
		String d = "Dayal";
		
		System.out.println("Leangth of string Shreyas is : "+s.length());//checking length of string "Shreyas"
		
		System.out.println("String in upper case : "+s.toUpperCase()); //all strings set in capital letters
		
		System.out.println("At index 2 string is : "+s.indent(2));	//taking data if index [2]
		
		System.out.println(s + "    " +d); //concatenated,  placed space in between two string Shreyas and Dayal
	
	}
	}