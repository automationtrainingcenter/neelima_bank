package srssprojects.keximbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KeximHomPage{
	WebDriver driver;
	
	//user name
	public WebElement username() {
		WebElement ele = driver.findElement(By.id("txtuId"));
		return ele;
	}
	//password
	public WebElement password() {
		WebElement ele = driver.findElement(By.id("txtPword"));
		return ele;
	}
	
	//login
	public WebElement login() {
		return driver.findElement(By.id("login"));
	}
	
	public KeximHomPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//fillUserName()
	public void typeUserName(String uname) {
		username().sendKeys(uname);
	}
	
	//fill password
	public void typePassword(String pwd) {
		password().sendKeys(pwd);
	}
	
	//click login button
	public void clickLogin() {
		login().click();
	}

}
