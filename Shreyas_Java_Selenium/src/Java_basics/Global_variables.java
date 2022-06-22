package Java_basics;

public class Global_variables 

{
	int x = 5;    //these are non-static or global or instance variable
	int y = 10;		//as it is defined outside of method, then it not necessary to define inside of any method
	
	public void add()
	{
		int total = x+ y;
		
		System.out.println(+total);
	}
	
	public static void main(String[] args) 
	{
		Global_variables add = new Global_variables();
		
		add.add();

	}

}
