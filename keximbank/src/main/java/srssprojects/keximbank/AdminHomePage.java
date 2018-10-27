package srssprojects.keximbank;
//page factory

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminHomePage{
	
	//logout
	@FindBy(xpath = "//a[@href='home.aspx']")
	private WebElement logout;
	
	//branches
	@FindBy(xpath = "//a[@href = 'admin_banker_master.aspx']")
	private WebElement branches;
	
	//roles
	@FindBy(xpath = "//a[@href='Admin_Roles_details.aspx']")
	private WebElement roles;
	
	//employees
	@FindBy(xpath = "//a[@href='Admin_Emp_details.aspx']")
	private WebElement employees;
	
	//click branches button
	public void clickBranches() {
		this.branches.click();
	}
	//click logout button
	public void clickLoutOut() {
		this.logout.click();
	}
	
	//click roles button
	public void clickRoles() {
		this.roles.click();
	}
	
	//click employee button
	public void clickEmployee() {
		this.employees.click();
	}

}
