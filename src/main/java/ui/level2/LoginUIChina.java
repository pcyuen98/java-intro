package ui.level2;

import ui.level2.factory.LoginUI;
import ui.level2.util.LoginStorage;


  public class LoginUIChina extends LoginUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void initFrame() {
		setTitle("pin yin here - #Login=" + LoginStorage.noOfLogin);
		setSize(300, 150);
		
	}
  
  }
 