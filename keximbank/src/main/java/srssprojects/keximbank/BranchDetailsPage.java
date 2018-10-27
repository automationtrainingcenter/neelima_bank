package srssprojects.keximbank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BranchDetailsPage{
	//new branch
	@FindBy(id = "BtnNewBR")
	private WebElement newBranch;
	
	//country
	
	//state
	
	//city
	
	//search
	
	//clear
	
	//click on new branch button
	public void clickNewBranchButton() {
		this.newBranch.click();
	}
	
	//select country
	
	//select state
	
	//select city
	
	//click search
	
	//click clear
	
	public boolean isNewBranchButtonVisible() {
		return this.newBranch.isDisplayed();
	}
}
