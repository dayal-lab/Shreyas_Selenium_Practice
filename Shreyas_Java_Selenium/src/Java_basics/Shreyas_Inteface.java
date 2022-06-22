package Java_basics;

  interface Shreyas_Interface 
  	{
	public void abc();

	}
  
  class XYZ implements Shreyas_Interface
  
  {
	  
	  @Override
		public void abc() 
	  {
		  System.out.println("SHREYAS");
			
			
	  }
	  
	  public static void main(String[] args) 
	{
		
		XYZ call = new XYZ();
		
		call.abc();
	}
}
