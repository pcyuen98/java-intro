package basic;

public class PassByValueOrReference {

	public LoginObj passByReference(LoginObj obj) {
		obj.address = "Modified Address";
		return obj;
	}

	public int passByValue(int aValue) {
		aValue = 100; // modify the passing value
		return aValue;
	}
	
	public static void main(String args[]) {

		PassByValueOrReference passByValueOrReference = new PassByValueOrReference();
		
		int aPrimitiveValue = 12; // i.e no of months in a year 
		passByValueOrReference.passByValue(aPrimitiveValue);
		System.out.println("Latest int --> " + aPrimitiveValue);
		
		LoginObj loginObj = new LoginObj(); // something you may need to change
		loginObj.address = "New Address";
		passByValueOrReference.passByReference(loginObj);
		System.out.println("Latest Login --> " + loginObj.address);

	}
}
