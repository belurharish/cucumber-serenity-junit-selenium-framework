package stepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import commonUtil.Util;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.WebElementFacade;
import pages.CommonPage;
import pages.BrokerDashboardPage;

public class BrokerDashboardStepDef {
	CommonPage commonPage;
	BrokerDashboardPage etfBrokerDashboardPage;

	@Then("Verify ETF broker dashboard screen will open")
	public void verify_ETF_broker_dashboard_screen_will_open() throws InterruptedException {
		commonPage.menu.click();
		commonPage.etfBrokerDashboardLnk.waitUntilClickable().click();
		etfBrokerDashboardPage.waitFor(etfBrokerDashboardPage.pivotTable);
		assertThat(etfBrokerDashboardPage.etfBrokerDashboard.waitUntilVisible().isDisplayed()).isEqualTo(true);
	}

	@Then("Verify Filter Fund Families, Filter Symbols, Start Date, End Date, Broker, Pivot, Time Period and depth filters are present in ETF broker dashboard Page")
	public void verify_Filter_Fund_Families_Filter_Symbols_Start_Date_End_Date_Broker_Pivot_Time_Period_and_depth_filters_are_present_in_ETF_broker_dashboard_Page() {
		assertThat(etfBrokerDashboardPage.filterFundFamilies.waitUntilVisible().isDisplayed()).isEqualTo(true);
		assertThat(etfBrokerDashboardPage.filterSymbols.isDisplayed()).isEqualTo(true);
		assertThat(etfBrokerDashboardPage.startDate.isDisplayed()).isEqualTo(true);
		assertThat(etfBrokerDashboardPage.endDate.isDisplayed()).isEqualTo(true);
		assertThat(etfBrokerDashboardPage.broker.isDisplayed()).isEqualTo(true);
		assertThat(etfBrokerDashboardPage.pivot.isDisplayed()).isEqualTo(true);
		assertThat(etfBrokerDashboardPage.timePeriod.isDisplayed()).isEqualTo(true);
		assertThat(etfBrokerDashboardPage.depth.isDisplayed()).isEqualTo(true);
	}

	@Then("Verify Broker, Family, Date and Ticker names are available under Pivoted tab")
	public void verify_Broker_Family_Date_and_Ticker_names_are_available_under_Pivoted_tab() {
		assertThat(etfBrokerDashboardPage.pivotedBrokerHeader.waitUntilVisible().isDisplayed()).isEqualTo(true);
		assertThat(etfBrokerDashboardPage.pivotedDateHeader.isDisplayed()).isEqualTo(true);
		assertThat(etfBrokerDashboardPage.pivotedTickerHeader.isDisplayed()).isEqualTo(true);
	}

	@Then("Verify Quoting, Shares and Value names are available under Bid tab")
	public void verify_Quoting_Shares_and_Value_names_are_available_under_Bid_tab() {
		assertThat(etfBrokerDashboardPage.bidQuotingHeader.waitUntilVisible().isDisplayed()).isEqualTo(true);
		assertThat(etfBrokerDashboardPage.bidSharesHeader.isDisplayed()).isEqualTo(true);
		assertThat(etfBrokerDashboardPage.bidValueHeader.isDisplayed()).isEqualTo(true);
	}

	@Then("Verify Quoting, Shares and Value names are available under Ask tab")
	public void verify_Quoting_Shares_and_Value_names_are_available_under_Ask_tab() {
		assertThat(etfBrokerDashboardPage.askQuotingHeader.waitUntilVisible().isDisplayed()).isEqualTo(true);
		assertThat(etfBrokerDashboardPage.askSharesHeader.isDisplayed()).isEqualTo(true);
		assertThat(etfBrokerDashboardPage.askValueHeader.isDisplayed()).isEqualTo(true);
	}

	@Then("Verify $values and BPS names are available under Spread tab")
	public void verify_$values_and_BPS_names_are_available_under_Spread_tab() {
		assertThat(etfBrokerDashboardPage.spreadValueHeader.waitUntilVisible().isDisplayed()).isEqualTo(true);
		assertThat(etfBrokerDashboardPage.spreadBPSHeader.isDisplayed()).isEqualTo(true);
	}

	@Then("Verify by default date is previous day in Start date field under ETF broker dashboard page")
	public void verify_by_default_date_is_previous_day_current_date_in_Start_date_field_under_ETF_broker_dashboard_page() {
		assertThat(etfBrokerDashboardPage.startDate.getValue())
				.isEqualTo(Util.getGrapevineDate(Util.getPreviousWorkingDay(Util.dateNow)));
	}

	@Then("Verify by default date is previous day in End date field under ETF broker dashboard page")
	public void verify_by_default_date_is_previous_day_current_date_in_End_date_field_under_ETF_broker_dashboard_page() {
		assertThat(etfBrokerDashboardPage.endDate.getValue())
				.isEqualTo(Util.getGrapevineDate(Util.getPreviousWorkingDay(Util.dateNow)));
	}

	@Then("Verify by default {string} value will display in Time Period field under ETF broker dashboard page")
	public void verify_by_default_Regular_Market_value_will_display_in_Time_Period_field(String defaultVal) {
		assertThat(etfBrokerDashboardPage.timePeriod.getValue()).contains(defaultVal);
	}

	@Then("Verify by default Top of Book value will display in Depth field under ETF broker dashboard page")
	public void verify_by_default_Top_of_Book_value_will_display_in_Depth_field_under_ETF_broker_dashboard_page() {
		assertThat(etfBrokerDashboardPage.depth.getValue()).contains("Top of Book");
	}

	@When("Enter value into Filter fund families field once user enter the value by default the value should appear in the list")
	public void enter_value_into_Filter_fund_families_field_once_user_enter_the_value_by_default_the_value_should_appear_in_the_list() {
		assertThat(etfBrokerDashboardPage.filterFundFamilies.getAttribute("direction")).isEqualTo("down");
	}

	@Then("Enter {string} in Filter fund families field")
	public void enter_a_in_Filter_fund_families_field(String str) throws InterruptedException {
		etfBrokerDashboardPage.filterFundFamilies.type(str);
		Thread.sleep(1000);
		assertThat(etfBrokerDashboardPage.fundFamiliesList.stream().map(WebElementFacade::getTextContent)
				.collect(Collectors.toList())).extracting(t->t.substring(0, 1)).containsOnly("A");
	}

	@Then("Verify user is able view data in UI as per fund families filter value in ETF broker dashboard screen")
	public void verify_user_is_able_view_data_in_UI_as_per_fund_families_filter_value_in_ETF_broker_dashboard_screen() {
		etfBrokerDashboardPage.filterFundFamilies.typeAndEnter("Arrow");
		assertThat(etfBrokerDashboardPage.firstFundFamilies.getTextContent()).isEqualTo("Arrow");
	}

	@When("Enter value into Filter symbols field once user enter the value by default the value should appear in the list")
	public void enter_value_into_Filter_symbols_field_once_user_enter_the_value_by_default_the_value_should_appear_in_the_list() {
		assertThat(etfBrokerDashboardPage.filterSymbols.getAttribute("direction")).isEqualTo("down");
	}

	@Then("Enter {string} in Filter symbols field")
	public void enter_a_in_Filter_symbols_field(String str) throws InterruptedException {
		etfBrokerDashboardPage.filterSymbols.type(str);
		Thread.sleep(1000);
		assertThat(etfBrokerDashboardPage.filterSymbolsList.stream().map(WebElementFacade::getText)
				.collect(Collectors.toList())).extracting(t->t.substring(0, 1)).containsOnly("B");
	}

	@Then("Verify user is able to enter symbol value in filter symbol field under ETF broker dashboard screen")
	public void verify_user_is_able_to_enter_symbol_value_in_filter_symbol_field_under_ETF_broker_dashboard_screen() {
		etfBrokerDashboardPage.filterSymbols.typeAndEnter("BANK");
	}

	@Then("Verify user is able view data in UI as per symbol filter value in ETF broker dashboard screen")
	public void verify_user_is_able_view_data_in_UI_as_per_symbol_filter_value_in_ETF_broker_dashboard_screen() {
		etfBrokerDashboardPage.filterSymbols.typeAndEnter("MUB");
		assertThat(etfBrokerDashboardPage.firstFilterSymbol.getTextContent()).isEqualTo("MUB");
	}

	@When("Click on dropdown icon from Pivot combobox")
	public void click_on_dropdown_icon_from_Pivot_combobox() {
		etfBrokerDashboardPage.pivot.waitUntilClickable().click();
	}

	@Then("Verify Date, Ticker and Fund family values is available in pivot combobox under ETF broker dashboard screen")
	public void verify_Date_Ticker_and_Fund_family_values_is_available_in_pivot_combobox_under_ETF_broker_dashboard_screen() {
		assertThat(etfBrokerDashboardPage.pivotItems.stream().map(WebElementFacade::getTextContent)
				.collect(Collectors.toList())).containsExactly("Date", "Ticker", "Fund Family");
	}

	@When("Select Date from pivot combobox list")
	public void select_Date_from_pivot_combobox_list() {
		etfBrokerDashboardPage.pivotItems.get(0).click();
	}

	@When("Select Ticker from pivot combobox list")
	public void select_Ticker_from_pivot_combobox_list() {
		etfBrokerDashboardPage.pivotItems.get(1).click();
	}
	
	@Then("Verify in result section ticker/date and family/ticker will display under ticker/date/family dropdown in UI")
	public void verify_in_result_section_date_and_family_will_display_under_ticker_dropdown_in_UI() {
		etfBrokerDashboardPage.findAll(etfBrokerDashboardPage.expand).get(0).click();
		etfBrokerDashboardPage.findAll(etfBrokerDashboardPage.expand).get(1).click();
		etfBrokerDashboardPage.findAll(etfBrokerDashboardPage.expand).get(2).click();
		etfBrokerDashboardPage.findAll(etfBrokerDashboardPage.expand).get(3).click();
		boolean flag = false;
		List<WebElementFacade> pivotTickerItems = etfBrokerDashboardPage.findAll(
				"//div[@class='rt-tr-group'][@role='rowgroup']/div[@role='row']/div[@role='gridcell'][@class='rt-td text-col'][3]");
		List<WebElementFacade> pivotFamilyItems = etfBrokerDashboardPage.findAll(
				"//div[@class='rt-tr-group'][@role='rowgroup']/div[@role='row']/div[@role='gridcell'][@class='rt-td text-col'][4]");
		for (int i = 0; i <= pivotTickerItems.size(); i++) {
			if (!pivotTickerItems.get(i).getTextContent().isEmpty()
					&& !pivotFamilyItems.get(i).getTextContent().isEmpty()) {
				flag = true;
				break;
			} else
				flag = false;
		}
		assertThat(flag).isEqualTo(true);
	}

	@When("Select Family from pivot combobox list")
	public void select_Family_from_pivot_combobox_list() {
		etfBrokerDashboardPage.pivotItems.get(2).click();
	}

	@When("Click on dropdown icon from Time period combobox")
	public void click_on_dropdown_icon_from_Time_period_combobox() {
		etfBrokerDashboardPage.timePeriod.click();
	}

	@Then("Verify Pre opening, Post opening, Regular market, Closing values are available in Time period dropdown field under ETF broker dashboard")
	public void verify_Pre_opening_Post_opening_Regular_market_Closing_values_are_available_in_Time_period_dropdown_field_under_ETF_broker_dashboard() {
		assertThat(etfBrokerDashboardPage.timePeriodItems.stream().map(WebElementFacade::getTextContent)
				.collect(Collectors.toList())).containsExactly("Pre Opening (9:00-9:30)", "Post Opening (9:30-10:00)",
						"Regular Market (10:00-15:00)", "Closing (15:00-16:00)");
	}

	@Then("Verify user is able to select Pre opening value from the list in Time period field under ETF broker dashboard screen")
	public void verify_user_is_able_to_select_Pre_opening_value_from_the_list_in_Time_period_field_under_ETF_broker_dashboard_screen() {
		etfBrokerDashboardPage.timePeriodItems.get(0).click();
	}

	@Then("(Verify user is able view data in UI as per Pre opening value in Time period field under ETF broker dashboard screen|User should be able view data in UI as per Post opening value in Time period field under ETF broker dashboard screen|User should be able view data in UI as per Regular market value in Time period field under ETF broker dashboard screen|User should be able view data in UI as per Closing value in Time period field under ETF broker dashboard screen|User should be able view data in UI as per Top of book value in Depth field under ETF broker dashboard screen)")
	public void verify_user_is_able_view_data_in_UI_as_per_Pre_opening_value_in_Time_period_field_under_ETF_broker_dashboard_screen() {
		etfBrokerDashboardPage.waitUntillProgressBarDisappears();
		assertThat(etfBrokerDashboardPage.pivotTable.isDisplayed()).isEqualTo(true);
	}

	@Then("User should be able to select Post opening value from the list in Time period field under ETF broker dashboard screen")
	public void user_should_be_able_to_select_post_opening_value_from_the_list_in_time_period() {
		etfBrokerDashboardPage.timePeriodItems.get(1).click();
	}

	@Then("User should be able to select Regular market value from the list in Time period field under ETF broker dashboard screen")
	public void user_should_be_able_to_select_Post_opening_value_from_the_list_in_Time_period_field_under_ETF_broker_dashboard_screen() {
		etfBrokerDashboardPage.timePeriodItems.get(2).click();
	}

	@Then("User should be able to select Closing value from the list in Time period field under ETF broker dashboard screen")
	public void user_should_be_able_to_select_Closing_value_from_the_list_in_Time_period_field_under_ETF_broker_dashboard_screen() {
		etfBrokerDashboardPage.timePeriodItems.get(3).click();
	}

	@When("Click on dropdown icon from Depth combobox")
	public void click_on_dropdown_icon_from_Depth_combobox() {
	    etfBrokerDashboardPage.depth.waitUntilVisible().click();
	}
	
	@Then("{string}, {string} and {string} list should be available in Depth field under ETF broker dashboard")
	public void list_should_be_available_in_Depth_field_under_ETF_broker_dashboard(String string, String string2, String string3) {
		assertThat(etfBrokerDashboardPage.depthItems.stream().map(WebElementFacade::getTextContent)
				.collect(Collectors.toList())).containsExactly(string, string2, string3);
	}

	@Then("User should be able to select Top of book value from the list in Depth field under ETF broker dashboard screen")
	public void user_should_be_able_to_select_Top_of_book_value_from_the_list_in_Depth_field_under_ETF_broker_dashboard_screen() {
	    etfBrokerDashboardPage.depthItems.get(0).click();
	}
	
	@Then("User should be able to select ${int}k value from the list in Depth field under ETF broker dashboard screen")
	public void user_should_be_able_to_select_$_k_value_from_the_list_in_Depth_field_under_ETF_broker_dashboard_screen(Integer int1) {
		etfBrokerDashboardPage.depthItems.get(1).click();
	}

	@Then("User should be able view data in UI as per ${int}k value in Depth field under ETF broker dashboard screen")
	public void user_should_be_able_view_data_in_UI_as_per_$_k_value_in_Depth_field_under_ETF_broker_dashboard_screen(Integer int1) {
		etfBrokerDashboardPage.waitUntillProgressBarDisappears();
		assertThat(etfBrokerDashboardPage.pivotTable.isDisplayed()).isEqualTo(true);
	}
	
	@Then("Verify user is able to select ${int}k value from the list in Depth field under ETF broker dashboard screen")
	public void verify_user_is_able_to_select_$_k_value_from_the_list_in_Depth_field_under_ETF_broker_dashboard_screen(Integer int1) {
		etfBrokerDashboardPage.depthItems.get(2).click();
	}
}
