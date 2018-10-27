package srssprojects.keximbank;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasicExecution extends TestExecution{
	@BeforeClass(groups = { "branch", "create", "valid", "invalid", "reset", "cancel" })
	public void browserLaunch() {
		launchBrowser("chrome", "http://srssprojects.in");
		keximHomePageObj = new KeximHomPage(driver);
		adminHomePageObj = PageFactory.initElements(driver, AdminHomePage.class);
		branchDetailsPageObj = PageFactory.initElements(driver, BranchDetailsPage.class);
		branchCreationPageObj = PageFactory.initElements(driver, BranchCreationPage.class);
	}

	@AfterClass(groups = { "branch", "create", "valid", "invalid", "reset", "cancel" })
	public void tearDown() {
		closeBrowser();
	}
}
