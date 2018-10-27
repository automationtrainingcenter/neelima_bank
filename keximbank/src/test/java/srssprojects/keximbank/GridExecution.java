package srssprojects.keximbank;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class GridExecution extends TestExecution{
	@BeforeClass(groups = { "branch", "create", "valid", "invalid", "reset", "cancel" })
	@Parameters({"url", "brName", "nodeUrl", "os"})
	public void browserLaunch(String u, String browser, String nodeUrl, String os) {
		launchBrowser(browser, u, nodeUrl, os);
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
