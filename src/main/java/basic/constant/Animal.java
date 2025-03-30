package basic.constant;

public class Animal {
	public static final String TYPE = "Carnivor";
	
	public static String FLEXI_TYPE  = "flexible";
	
	private String for_object_only = "object only";
	
	public static void aStaticMethod() {
		
		//System.out.println ("for_object_only -->" + for_object_only );		
		System.out.println ("TYPE -->" + Animal.TYPE);
		System.out.println ("FLEXI_TYPE -->" + Animal.FLEXI_TYPE );
		
	}
	
	public void aMethod() {		
		System.out.println ("for_object_only -->" + for_object_only );				
	}
	
	public static void main (String args[]) {
		
		// Quiz: Why can't be change the constant below?
		// Animal.TYPE = "others";
		
		Animal.FLEXI_TYPE = "Others";
		
		System.out.println("TYPE is" + Animal.TYPE);
		
		Animal animal = new Animal();
		animal.aMethod();
	}
}
