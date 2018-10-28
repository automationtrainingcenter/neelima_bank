package srssprojects.keximbank;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestExecution extends BaseClass {

	@BeforeMethod(groups = { "branch", "create", "valid", "invalid", "reset", "cancel" })
	public void loginTest() {
		keximHomePageObj.typeUserName("Admin");
		keximHomePageObj.typePassword("Admin");
		keximHomePageObj.clickLogin();
	}

	@Test(priority = 2, groups = { "branch", "create", "valid" })
	public void createNewBranch() {
		// click on branches button in admin home page
		adminHomePageObj.clickBranches();
		// click new branch button in branch details page
		branchDetailsPageObj.clickNewBranchButton();
		// fill the form in branch creation page
		fillBranchCreationForm("beeramgudaBranchOne", "beeramguda", "51234", "INDIA", "GOA", "GOA");
		// click submit button in branch creation page
		branchCreationPageObj.clickSubmit();
		String alertText = driver.switchTo().alert().getText();
		Reporter.log(alertText, true);
		driver.switchTo().alert().accept();
		Assert.assertTrue(alertText.contains("New Branch with id"));
	}

	@Test(priority = 4, groups = { "branch", "create", "valid" }, dependsOnMethods= {"createNewBranch"})
	public void createNewBranchWithDuplicateData() {
		// click on branches button in admin home page
		adminHomePageObj.clickBranches();
		// click new branch button in branch details page
		branchDetailsPageObj.clickNewBranchButton();
		// fill the form in branch creation page
		fillBranchCreationForm("beeramgudaBranch", "beeramguda", "51234", "INDIA", "GOA", "GOA");
		// click submit button in branch creation page
		branchCreationPageObj.clickSubmit();
		String alertText = driver.switchTo().alert().getText();
		Reporter.log(alertText, true);
		driver.switchTo().alert().accept();
		Assert.assertTrue(alertText.contains("Branch name already Exist"));
	}

	@Test(priority = 5, groups = { "branch", "create", "invalid" })
	public void createNewBranchWithBlankData() {
		adminHomePageObj.clickBranches();
		branchDetailsPageObj.clickNewBranchButton();
		branchCreationPageObj.clickSubmit();
		String alertText = driver.switchTo().alert().getText();
		Reporter.log(alertText, true);
		driver.switchTo().alert().accept();
		Assert.assertTrue(alertText.contains("Please fill in the following"));

	}

	@Test(priority = 6, groups = { "branch", "reset", "valid" })
	public void branchCreationReset() {
		// click on branches button in admin home page
		adminHomePageObj.clickBranches();
		// click new branch button in branch details page
		branchDetailsPageObj.clickNewBranchButton();
		// fill the form in branch creation page
		fillBranchCreationForm("beeramgudaBranch", "beeramguda", "51234", "INDIA", "GOA", "GOA");
		// click submit button in branch creation page
		branchCreationPageObj.clickReset();
		Assert.assertEquals(branchCreationPageObj.getCountryDefaultOption(), "Select");
	}

	@Test(priority = 7, groups = { "branch", "cancel", "invalid" })
	public void branchCreationCancel() {
		adminHomePageObj.clickBranches();
		branchDetailsPageObj.clickNewBranchButton();
		branchCreationPageObj.clickCancel();
		Assert.assertTrue(branchDetailsPageObj.isNewBranchButtonVisible());
	}
	
	@Test(priority = 8, groups = {"branch"})
	public void branchCreationWithMultipleData() {
		Excel.setExcelToRead("TestData.xls", "BranchData");
		int nor = Excel.getRowCount();
		int noc = Excel.getColumnCount();
		for(int r = 1; r < nor; r++) {
			String bname = Excel.readData(r, 0);
			String address1 = Excel.readData(r, 1);
			String zipcode = Excel.readData(r, 2);
			String country = Excel.readData(r, 3);
			String state = Excel.readData(r, 4);
			String city = Excel.readData(r, 5);
			adminHomePageObj.clickBranches();
			// click new branch button in branch details page
			branchDetailsPageObj.clickNewBranchButton();
			// fill the form in branch creation page
			fillBranchCreationForm(bname, address1, zipcode, country, state, city);
			// click submit button in branch creation page
			branchCreationPageObj.clickSubmit();
			String alertText = driver.switchTo().alert().getText();
			Reporter.log(alertText, true);
			driver.switchTo().alert().accept();
			Assert.assertTrue(alertText.contains("New Branch with id"));
		}
		Excel.closeFile();
	}
	
	
	@Test(priority = 9, groups = {"branch"}, dataProvider="branch_data")
	public void branchCreationWithDP(String bname, String add1, String zcode, String country, String state, String city) {
		// click on branches button in admin home page
		adminHomePageObj.clickBranches();
		// click new branch button in branch details page
		branchDetailsPageObj.clickNewBranchButton();
		// fill the form in branch creation page
		fillBranchCreationForm(bname, add1, zcode, country, state, city);
		// click submit button in branch creation page
		branchCreationPageObj.clickSubmit();
		String alertText = driver.switchTo().alert().getText();
		Reporter.log(alertText, true);
		driver.switchTo().alert().accept();
		Assert.assertTrue(alertText.contains("New Branch with id"));
	}
	
	@Test(priority = 10, groups= {"valid"}, dataProvider="role_data")
	public void roleCreationWithDP(String roleName, String roleType) {
		//click on role button
		adminHomePageObj.clickRoles();
		//click new role button in role details page
		roleDetailsPage.clickNewRoleButton();
		//fill the role creation form in role creation page
		fillRoleCreationForm(roleName, "", roleType);
		//click on submit button
		roleCreationPage.clickSubmit();
		Reporter.log(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

	@AfterMethod(groups = { "branch", "create", "valid", "invalid", "reset", "cancel" })
	public void logoutTest() throws InterruptedException {
		Thread.sleep(4000);
		adminHomePageObj.clickLoutOut();
	}
	
	@DataProvider(name = "branch_data")
	public Object[][] branchData(){
		return Excel.getExcelData("TestData.xls", "BranchData");
	}
	
	@DataProvider(name = "role_data")
	public Object[][] roleData(){
		return Excel.getExcelData("TestData.xls", "RoleData");
	}

}
