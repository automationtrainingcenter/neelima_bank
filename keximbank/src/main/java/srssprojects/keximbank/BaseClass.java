package srssprojects.keximbank;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	KeximHomPage keximHomePageObj;
	AdminHomePage adminHomePageObj;
	BranchDetailsPage branchDetailsPageObj;
	BranchCreationPage branchCreationPageObj;
	RoleDetailsPage roleDetailsPage;
	RoleCreationPage roleCreationPage;
	WebDriver driver;
	
	//launch browser
	public void launchBrowser(String browserName, String url) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else {
			System.out.println("please provide valid browser name");
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void launchBrowser(String browserName, String url, String nodeUrl, String os) {
		DesiredCapabilities caps = new DesiredCapabilities();
		
		if(browserName.equalsIgnoreCase("chrome")) {
			caps.setBrowserName(BrowserType.CHROME);
		}else if(browserName.equalsIgnoreCase("firefox")) {
			caps.setBrowserName(BrowserType.FIREFOX);
		}else {
			System.out.println("please provide valid browser name");
		}
		
		if(os.equalsIgnoreCase("windows")) {
			caps.setPlatform(Platform.WINDOWS);
		}else if(os.equalsIgnoreCase("mac")) {
			caps.setPlatform(Platform.MAC);
		}else if(os.equalsIgnoreCase("linux")) {
			caps.setPlatform(Platform.LINUX);
		}
		
		try {
			driver = new RemoteWebDriver(new URL(nodeUrl), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	//closer browser 
	public void closeBrowser() {
		driver.close();
	}
	
	//fill branch creation from method
	public void fillBranchCreationForm(String bname, String add1,String zcode, String country, String state,String city) {
		branchCreationPageObj.typeBranchName(bname);
		branchCreationPageObj.typeAddress1(add1);
		branchCreationPageObj.typeZipcode(zcode);
		branchCreationPageObj.selectCountry(country);
		branchCreationPageObj.selectState(state);
		branchCreationPageObj.selectCity(city);
	}
	
	public void fillRoleCreationForm(String roleName, String roleDescription, String roleType) {
		// call fill and select methods of RoleCreationPage
		roleCreationPage.fillRoleName(roleName);
		roleCreationPage.fillRoleDescription(roleDescription);
		roleCreationPage.selectRoleType(roleType);
	}
	
	

}
