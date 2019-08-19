package pages;

import org.openqa.selenium.By;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CommonPage extends PageObject{
	@FindBy(xpath = "//button[span='menu']")
	public WebElementFacade menu;
	
	@FindBy(xpath = "//span[text()='Analytics']/preceding-sibling::img")
	public WebElementFacade logo;
	
	@FindBy(xpath = "//div[div[button[span[text()='account_box']]]]")
	public WebElementFacade loginId;
	
	@FindBy(xpath = "//aside//span[text()='Grapevine']")
	public WebElementFacade grapevineLnk;
	
	@FindBy(xpath = "//aside//span[text()='ETF Fact Sheet']")
	public WebElementFacade etfFactSheetLnk;
	
	@FindBy(xpath = "//aside//span[text()='ETF Broker Dashboard']")
	public WebElementFacade etfBrokerDashboardLnk;
	
	@FindBy(xpath = "//aside//span[text()='Order Book Visualizer']")
	public WebElementFacade orderBookVisualizerLnk;
	
	@FindBy(xpath = "//aside//span[text()='User Guide']")
	public WebElementFacade userGuideLnk;
	
	public By loadingSpinner=By.id("loading-text");
	
	@FindBy(id="loading-text")
	public WebElementFacade loadingSpinnerEle;
	
	@FindBy(xpath="//div[contains(@class,'components-Footnote-footnote')]/p")
	public WebElementFacade copyrightMsg;
	
	public void navigateToGrapevine() {
		menu.click();
		grapevineLnk.waitUntilClickable().click();
	}
	
	public void navigateToETFFactSheet() {
		menu.waitUntilClickable().click();
		etfFactSheetLnk.click();
	}
	
	public void navigateToETFBrokerDashboard() {
		menu.click();
		etfBrokerDashboardLnk.waitUntilClickable().click();
	}
	
	public void navigateToOrderBookVisualizer() {
		menu.click();
		orderBookVisualizerLnk.waitUntilClickable().click();
	}
	public void navigateToUserGuide() {
		menu.click();
		userGuideLnk.waitUntilClickable().click();
	}
}
