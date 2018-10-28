package srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RoleDetailsPage {
	WebDriver driver;
	//new role button

	@FindBy(how = How.ID_OR_NAME, using = "btnRoles")
	private WebElement newrolebutton;
	   
	//constructor
	public RoleDetailsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//click on new role button
	public void clickNewRoleButton() {
		this.newrolebutton.click();
	}
}
