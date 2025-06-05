package basic;

public class PassByValueOrReference {

	public LoginObj passByReference(LoginObj obj) {
		obj.address = "Modified Address";
		return obj;
	}

	public int passByPrimitiveValue(int aValue) {
		aValue = 100; // modify the passing value
		return aValue;
	}
	
	public Integer passByPrimitiveObject(Integer aValue) {
		aValue = 100; // modify the passing value
		return aValue;
	}
	
	public String passByImmutableString(String aString) {
		aString = "Modified string";
		return aString;
	}
	
	public static void main(String args[]) {

		PassByValueOrReference passByValueOrReference = new PassByValueOrReference();
		
		int aPrimitiveValue = 12; // i.e no of months in a year 
		passByValueOrReference.passByPrimitiveValue(aPrimitiveValue);
		System.out.println("Latest aPrimitiveValue int --> " + aPrimitiveValue);
		
		Integer aPrimitiveObject = 12; // i.e no of months in a year 
		passByValueOrReference.passByPrimitiveObject(aPrimitiveObject);
		System.out.println("Latest aPrimitiveObject int --> " + aPrimitiveObject);
		
		LoginObj loginObj = new LoginObj(); // something you may need to change
		loginObj.address = "New Address";
		passByValueOrReference.passByReference(loginObj);
		System.out.println("Latest Login --> " + loginObj.address);

		String aString = "a new String";
		passByValueOrReference.passByImmutableString(aString);
		System.out.println("Latest String --> " + aString);
		
	}
}
