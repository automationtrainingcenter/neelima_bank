package srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class RoleCreationPage {
	WebDriver driver;
	
	//role name
	@FindBy(how = How.ID_OR_NAME, using = "txtRname")
	private WebElement roleName;

	//role description
	@FindBy(how = How.ID_OR_NAME, using = "txtRDesc")
	private WebElement roledescription;
	
	//role type
	@FindBy(how = How.ID_OR_NAME, using = "lstRtypeN")
	private WebElement roletype;
	
	//submit button
	@FindBy(how = How.ID_OR_NAME, using = "btninsert")
	private WebElement submit;
	
	//reset button
	@FindBy(how = How.ID_OR_NAME, using = "Btn_Reset")
	private WebElement reset;
	
	//cancel button
	@FindBy(how = How.ID_OR_NAME, using = "Btn_cancel")
	private WebElement cancel;
	
	//constructor
	public RoleCreationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//fill role name
	public void fillRoleName(String RoleName) {
		this.roleName.sendKeys(RoleName);
	}
	
	//fill role description
	public void fillRoleDescription(String RoleDescription) {
		this.roledescription.sendKeys(RoleDescription);
	}
	
	//select role type
	public void selectRoleType(String RoleType) {
		new Select(this.roletype).selectByVisibleText(RoleType);
	}
	//click on submit button
	public void clickSubmit() {
		this.submit.click();
	}
	
	//click on reset button
	public void clickReset() {
		this.reset.click();
	}
	
	//click on cancel button
	public void clickCancel() {
		this.cancel.click();
	}

}
