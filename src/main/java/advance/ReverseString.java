package advance;

public class ReverseString {

	public static void main(String[] args) {
		String aString = "abcd";
		System.out.println("Mutable, Non Thread Safe, Faster -->" + new StringBuilder(aString).reverse().toString());
		
		System.out.println("Mutable, Thread Safe, Slower -->" + new StringBuffer(aString).reverse().toString());

	}

}
