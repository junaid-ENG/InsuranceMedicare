package insurance.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import insurance.qa.base.Testbase;

public class PersonalDetailPage extends Testbase {
	
	
	@FindBy (xpath="//input[@class=\"form-control\"][@name=\"phone\"]")
	WebElement Phone;
	
	@FindBy (name="address")
	WebElement Address;
	
	@FindBy (name="driving_licence_no")
	WebElement DrivingLicenseNo;
	
	@FindBy (name="sin_no")
    WebElement SinNo;
	
	@FindBy (name="fax")
	WebElement FaxNo;
	
	@FindBy (name="copy_of_id_proof")
	WebElement ChooseFile;
	
	@FindBy (css="#personal > div:nth-child(7) > div > a")
	WebElement Savebutton;
	
	
	public PersonalDetailPage () {
		PageFactory.initElements(driver, this);
	}
	
	
	public Object Personaldetails(String phone, String adrs, String DrlcNum, String Sinno, String fx) {
		Select select = new Select (driver.findElement(By.name("Phone")));
		select.selectByVisibleText(phone);
		Phone.sendKeys(phone);
		Address.sendKeys(adrs);
		DrivingLicenseNo.sendKeys(DrlcNum);
		SinNo.sendKeys(Sinno);
		FaxNo.sendKeys(fx);
		return null;
		
//		public Object Personaldetails() {
//		Phone.sendKeys("6476161789");
//		Address.sendKeys("89 george town ont  l6R2S2");
//		DrivingLicenseNo.sendKeys("12345789");
//		FaxNo.sendKeys("12345677");
//        ChooseFile.sendKeys("C:\\Users\\Hammad\\Desktop\\Work this week.docx");
//        Savebutton.click();
//        return null;
//        
		
	}
	
	

}
