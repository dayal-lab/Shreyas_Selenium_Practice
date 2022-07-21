package Java_basics;

/*
 **********To make difference between local and global variables "this" keyword uses, check below example ******************************** 
 * 
public class this_keyword 
{ 
	int rollno;  
	String name;  
	float fee;  
	
	public this_keyword(int rollno,String name,float fee)
	{  
		rollno=rollno;  
		name=name;  
		fee=fee;  
		
		System.out.println(25);			//rollno
		System.out.println("SHREYAS");	//String
		System.out.println(2.33);		//float
		
	}  
	 
 
		public static void main(String args[]){  
		this_keyword s1=new this_keyword(111,"DAYAL",5000f);  //this_keyword is a class name 
		System.out.println(obj.rollno);			// used global variable rollno for "111"
    	System.out.println(obj.name);			// used global variable name for "DAYAL"
    	System.out.println(obj.fee);			// used global variable fee for float "5.55"
	}
}  
*/


//In above code, created constuctor with same attributes/parameters used of global which are rollno, name, fee so its output will show NULL
//(rollno,name, fee are attributes/parameters of variables int, String, float respectively)
//Because java is not identifying global and local parameters because of same parameters defined.
//So to make difference between local and global parameters "this" keyword uses, check below example-

	public class this_keyword
	{  
		int rollno;  
		String name;  
		float fee;  
		
		//Now defined parametered constructor with different parameters than parameters.
		//In above commented code had defined same rollno =rollno, now here added "this.rollno = rollno", 
		//now java knows that "this.rollno" is a local variable and only "rollno" is a global variable , now it displays output.
		public this_keyword(int rollno,String name,float fee)
		{  
			this.rollno=rollno;  	//declared this keyword	
			this.name=name;  
			this.fee=fee;  
			
			System.out.println(25);			//rollno
			System.out.println("SHREYAS");	//String
			System.out.println(2555f);		//float
			
			System.out.println();   //space after above displaying
		}  
		
 
		public static void main(String args[])
		{  
			this_keyword obj = new this_keyword(111,"DAYAL",5000f);  //this_keyword is a class name
			
			System.out.println(obj.rollno);			// used global variable rollno for "111"
	    	System.out.println(obj.name);			// used global variable name for "DAYAL"
	    	System.out.println(obj.fee);			// used global variable fee for float "5.55"
		 
		}
}  



