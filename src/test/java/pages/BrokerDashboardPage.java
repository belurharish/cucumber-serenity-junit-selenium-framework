package pages;

import java.util.List;

import org.openqa.selenium.By;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class BrokerDashboardPage extends PageObject{
	@FindBy(xpath="//h2[text()='ETF Broker Dashboard']")
	public WebElementFacade etfBrokerDashboard; 
	
	@FindBy(xpath="//div[label[text()='Filter Fund Families']]/input")
	public WebElementFacade filterFundFamilies;
	
	@FindBy(xpath="//div[label[text()='Filter Symbols']]/input")
	public WebElementFacade filterSymbols;
	
	@FindBy(xpath = "//label[text()='Start Date']/../input")
	public WebElementFacade startDate;
	
	@FindBy(xpath = "//label[text()='End Date']/../input")
	public WebElementFacade endDate;
	
	@FindBy(xpath = "//ul[li[text()='Broker']]/preceding-sibling::div/input")
	public WebElementFacade broker;
	
	@FindBy(xpath = "//div[ul[li[text()='Ticker']]]/div/input[@placeholder='Pivot']")
	public WebElementFacade pivot;
	
	@FindBy(xpath = "//div[input[@placeholder='Pivot']]/following-sibling::ul[li='Ticker']/li")
	public List<WebElementFacade> pivotItems;
	
	@FindBy(xpath = "//label[text()='Time Period']/../input")
	public WebElementFacade timePeriod;
	
	@FindBy(xpath = "//label[text()='Depth']/../input")
	public WebElementFacade depth;
	
	@FindBy(xpath = "//label[text()='Depth']/../following-sibling::ul/li")
	public List <WebElementFacade> depthItems;
	
	@FindBy(xpath = "//div[text()='BROKER']")
	public WebElementFacade pivotedBrokerHeader;
	
	@FindBy(xpath = "//div[text()='DATE']")
	public WebElementFacade pivotedDateHeader;
	
	@FindBy(xpath = "//div[text()='TICKER']")
	public WebElementFacade pivotedTickerHeader;
	
	@FindBy(xpath = "//div[text()='FAMILY']")
	public WebElementFacade pivotedFamilyHeader;
	
	@FindBy(xpath = "//div[contains(@class,'rt-thead')]//div[5]//div[text()='QUOTING']")
	public WebElementFacade bidQuotingHeader;
	
	@FindBy(xpath = "//div[contains(@class,'rt-thead')]//div[6]//div[text()='SHARES']")
	public WebElementFacade bidSharesHeader;
	
	@FindBy(xpath = "//div[contains(@class,'rt-thead')]//div[7]//div[text()='VALUE']")
	public WebElementFacade bidValueHeader;
	
	@FindBy(xpath = "//div[contains(@class,'rt-thead')]//div[8]//div[text()='QUOTING']")
	public WebElementFacade askQuotingHeader;
	
	@FindBy(xpath = "//div[contains(@class,'rt-thead')]//div[9]//div[text()='SHARES']")
	public WebElementFacade askSharesHeader;
	
	@FindBy(xpath = "//div[contains(@class,'rt-thead')]//div[10]//div[text()='VALUE']")
	public WebElementFacade askValueHeader;
	
	@FindBy(xpath = "//div[contains(text(),'$ VALUE')]")
	public WebElementFacade spreadValueHeader;
	
	@FindBy(xpath = "//div[contains(text(),'BPS')]")
	public WebElementFacade spreadBPSHeader;
	
	@FindBy(xpath="//ul[contains(@class,'autocomplete-theme---values')]/div/span[1]")
	public WebElementFacade firstFundFamilies;
	
	@FindBy(xpath="//div[label[text()='Filter Fund Families']]/../ul/li")
	public List<WebElementFacade> fundFamiliesList;
	
	@FindBy(xpath="//div[label[text()='Filter Symbols']]/../ul/li")
	public List<WebElementFacade> filterSymbolsList;
	
	@FindBy(xpath="//div[label[text()='Filter Symbols']]/../ul[2]/div/span")
	public WebElementFacade firstFilterSymbol;
	
	public By expand=By.className("rt-expander");
	
	@FindBy(xpath="//div[label='Time Period']/following-sibling::ul/li")
	public List<WebElementFacade> timePeriodItems;
	
	@FindBy(xpath="//div[contains(@class,'progress_bar')]")
	public WebElementFacade progressBar;
	
	@FindBy(xpath="//div[contains(@class,'ReactTable src-apps-etf-broker-components-BrokerTable')]/div[@class='rt-table']")
	public WebElementFacade pivotTable;
	
	public void waitUntillProgressBarDisappears() {
		try {
			for (int i = 0; i <= 30; i++) {
				if (progressBar.isCurrentlyVisible())
					Thread.sleep(2000);
				else
					break;
			}
		}catch(InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}
