package srssprojects.keximbank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BranchCreationPage{
	//branch name
	@FindBy(id="txtbName")
	private WebElement branchName;
	
	//address1
	@FindBy(id="txtAdd1")
	private WebElement address1;
	
	//zip code
	@FindBy(id="txtZip")
	private WebElement zipcode;
	
	//country
	@FindBy(id="lst_counrtyU")
	private WebElement country;
	
	//state
	@FindBy(id="lst_stateI")
	private WebElement state;
	
	//city
	@FindBy(id="lst_cityI")
	private WebElement city;
	
	//submit button
	@FindBy(id="btn_insert")
	private WebElement submit;
	
	//reset button
	@FindBy(id="Btn_Reset")
	private WebElement reset;
	
	//cancel button
	@FindBy(id="Btn_cancel")
	private WebElement cancel;
	
	//type branch name
	public void typeBranchName(String bname) {
		this.branchName.sendKeys(bname);
	}
	
	//type addrs1
	public void typeAddress1(String add1) {
		this.address1.sendKeys(add1);
	}
	
	//type zipcode
	public void typeZipcode(String zcode) {
		this.zipcode.sendKeys(zcode);
	}
	
	//select country
	public void selectCountry(String country_text) {
		new Select(this.country).selectByVisibleText(country_text);
	}
	
	//select state
	public void selectState(String state_text) {
		new Select(this.state).selectByVisibleText(state_text);
	}
	
	//select city
	public void selectCity(String city_text) {
		new Select(this.city).selectByVisibleText(city_text);
	}
	
	//click on submit
	public void clickSubmit() {
		this.submit.click();
	}
	//click on reset
	public void clickReset() {
		this.reset.click();
	}
	
	//click on cancel
	public void clickCancel() {
		this.cancel.click();
	}
	
	
	//get default country
	public String getCountryDefaultOption() {
		return new Select(this.country).getFirstSelectedOption().getText();
	}

}
