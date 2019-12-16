package insurance.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import insurance.qa.base.Testbase;
import insurance.qa.pages.MyTM;
import insurance.qa.pages.PersonalDetailPage;
import insurance.qa.util.Test_util;

public class PersonalDetailTest extends Testbase {
	MyTM myTM;
	PersonalDetailPage personaldetailpage;
    Test_util testutil;
	String sheetname = "contacts";
	
	public PersonalDetailTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
			
			myTM = new MyTM();
			myTM.MyTmlink(prop.getProperty("Email"), prop.getProperty("Password"));	
		
		 
	}
	
	@DataProvider
        public Object[][] getTestData() {
		Object data [][] =testutil.getTestData(sheetname);
		return data;
	}
		
	@Test(priority=1 , dataProvider="getTestData")
	    public void Personaldetailtest(String Phone, String Address, String DrivinglicenseNumber, String SinNO, String Fax) {
	    myTM.MyTmlink(prop.getProperty("Email"), prop.getProperty("Password"));
	    		personaldetailpage.Personaldetails(Phone, Address, DrivinglicenseNumber, SinNO, Fax);
//		Assert.assertTrue(true, "User personal details updated successfully !");
//		System.out.println("Successfully File Saved");
}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
