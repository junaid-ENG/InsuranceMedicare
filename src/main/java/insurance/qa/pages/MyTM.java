package insurance.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import insurance.qa.base.Testbase;

public class MyTM extends Testbase{
	
	//Pagefactory
	@FindBy(css="body > header > nav > div > div.collapse.navbar-collapse.navbar-main-collapse > ul > li:nth-child(2) > a")
	@CacheLookup  // Store in cache memory its good for scripting and its raise the standard of 
	//your framework but if the browser gets refresh its going to show you Staleelementexception
	WebElement Tmlink;
	
	
    @FindBy (xpath="//*[@id=\"hideDiv\"]/div[1]/input")
    WebElement Email;
    
    @FindBy (xpath="//*[@id=\"hideDiv\"]/div[2]/input")
    WebElement Password;
    
    @FindBy (xpath="//label[@class=\"label-checkbox100\"]")
    WebElement Checkbox;
    
    @FindBy (xpath="//div[@class=\"container-login100-form-btn\"]//button[@class=\"login100-form-btn\"]")
    WebElement loginbutton;

    @FindBy (css="body > header > nav > div > div.navbar-header > a > img")
    WebElement logo;
    
    
//Initialization of Page Objects:
public MyTM() {
	PageFactory.initElements(driver, this);
	
	
}
//Actions
public String validatemytmtitle() {
	return driver.getTitle();
	
}

public Boolean Travelmedicarelogo() {
	return logo.isDisplayed();
}
	/*
	 * public Signuppage login(String un,String pwd) { Email.sendKeys(un);
	 * Password.sendKeys(pwd); Checkbox.click(); loginbutton.click(); return new
	 * Signuppage();
	 */
	/*
	 * }
	 */

public PersonalDetailPage MyTmlink(String un, String pwd) {
	Tmlink.click();
	Email.sendKeys(un);
	Password.sendKeys(pwd);
	Checkbox.click();
	loginbutton.click();
	return new PersonalDetailPage();
}
}

