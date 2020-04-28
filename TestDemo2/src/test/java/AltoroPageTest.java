package com.pom;


import org.junit.Test;

public class AltoroPageTest {
	

	@Test
	public void loginTest() {
		AltoroPage altoroPage = new AltoroPage();
		altoroPage.Altoropage();
		altoroPage.openUrl();
		altoroPage.login().checkKeyWord();
		//altoroPage.close();
	}
	
}
