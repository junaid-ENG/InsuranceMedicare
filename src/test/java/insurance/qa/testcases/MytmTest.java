package insurance.qa.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import insurance.qa.base.Testbase;
import insurance.qa.pages.MyTM;

public class MytmTest extends Testbase {
	MyTM myTm;

	public MytmTest() {
	super();
	
	}
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		myTm = new MyTM();
		}
	/*
	 * @Test public void myTmtitleTest() { String
	 * titlepage=myTm.validatemytmtitle(); Assert.assertEquals(titlepage,
	 * "Travel Medicare Sign in");
	 * 
	 * }
	 */
	/*
	 * @Test public void TMlogoImagetest()	 *  {
	 *  boolean flag=myTm.Travelmedicarelogo();
	 * Assert.assertTrue(flag);
	 * 
	 * }
	 */

	/*
	 * @Test public void loginTest() {
	 * userprofilepage=myTm.login(prop.getProperty("Email"),
	 * prop.getProperty("Password")); }
	 */
	@Test
	public void MytMtest() {
		myTm.MyTmlink(prop.getProperty("Email"), prop.getProperty("Password"));
		
	}
	
	  @AfterMethod
	  public void tearDown() {
		  driver.quit();
	  
	  }
	 
	
	
}