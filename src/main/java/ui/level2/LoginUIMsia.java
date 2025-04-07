package ui.level2;

import ui.level2.factory.LoginUI;

public class LoginUIMsia extends LoginUI {

	@Override
	public void initFrame() {
		setTitle("Log Masuk - #Login=" + LoginStorage.noOfLogin);
		setSize(300, 150);
	}


}
