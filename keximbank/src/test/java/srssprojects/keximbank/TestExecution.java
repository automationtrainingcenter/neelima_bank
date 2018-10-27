package srssprojects.keximbank;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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

	@AfterMethod(groups = { "branch", "create", "valid", "invalid", "reset", "cancel" })
	public void logoutTest() throws InterruptedException {
		Thread.sleep(4000);
		adminHomePageObj.clickLoutOut();
	}

}
