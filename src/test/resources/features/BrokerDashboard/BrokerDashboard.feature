Feature: ETFBrokerDashboard

  @TC_1
  Scenario: Verify ETF broker dashboard screen will open once user select ETF broker dashboard tab from menu button
    Then Verify ETF broker dashboard screen will open

  @TC_2
  Scenario: Verify Filter Fund Families, Filter Symbols, Start Date, End Date, Broker, Pivot, Time Period and depth filters are present in ETF broker dashboard Page
    Given Verify ETF broker dashboard screen will open
    Then Verify Filter Fund Families, Filter Symbols, Start Date, End Date, Broker, Pivot, Time Period and depth filters are present in ETF broker dashboard Page

  @TC_3
  Scenario: Verify Broker, Family, Date and Ticker names are available under Pivoted tab
    Given Verify ETF broker dashboard screen will open
    Then Verify Broker, Family, Date and Ticker names are available under Pivoted tab

  @TC_4
  Scenario: Verify Quoting, Shares and Value names are available under Bid tab
    Given Verify ETF broker dashboard screen will open
    Then Verify Quoting, Shares and Value names are available under Bid tab

  @TC_5
  Scenario: Verify Quoting, Shares and Value names are available under Ask tab
    Given Verify ETF broker dashboard screen will open
    Then Verify Quoting, Shares and Value names are available under Ask tab

  @TC_6
  Scenario: Verify $values and BPS names are available under Spread tab
    Given Verify ETF broker dashboard screen will open
    Then Verify $values and BPS names are available under Spread tab

  @TC_7
  Scenario: Verify by default date is previous day (current date - 1) in Start date field under ETF broker dashboard page
    Given Verify ETF broker dashboard screen will open
    Then Verify by default date is previous day in Start date field under ETF broker dashboard page

  @TC_8
  Scenario: Verify by default date is previous day (current date - 1) in End date field under ETF broker dashboard page
    Given Verify ETF broker dashboard screen will open
    Then Verify by default date is previous day in End date field under ETF broker dashboard page

  @TC_9
  Scenario: Verify by default Regular Market (10:00-15:00) value will display in Time Period field under ETF broker dashboard page
    Given Verify ETF broker dashboard screen will open
    Then Verify by default 'Regular Market (10:00-15:00)' value will display in Time Period field under ETF broker dashboard page

  @TC_10
  Scenario: Verify by default Top of Book value will display in Depth field under ETF broker dashboard page
    Given Verify ETF broker dashboard screen will open
    Then Verify by default Top of Book value will display in Depth field under ETF broker dashboard page

  @TC_11
  Scenario: Verify Filter fund families field is a typeahead field in ETF broker dashboard screen
    Given Verify ETF broker dashboard screen will open
    When Enter value into Filter fund families field once user enter the value by default the value should appear in the list
    Then Enter 'a' in Filter fund families field

  @TC_12
  Scenario: Verify user is able to enter value in filter fund families field under ETF broker dashboard page
    Given Verify ETF broker dashboard screen will open
    Then Enter value into Filter fund families field once user enter the value by default the value should appear in the list

  @TC_13
  Scenario: Verify user is able view data in UI as per fund families filter value in ETF broker dashboard screen
    Given Verify ETF broker dashboard screen will open
    When Enter value into Filter fund families field once user enter the value by default the value should appear in the list
    Then Verify user is able view data in UI as per fund families filter value in ETF broker dashboard screen

  @TC_14
  Scenario: Verify user is able view data in UI as per fund families filter value in ETF broker dashboard screen
    Given Verify ETF broker dashboard screen will open
    When Enter value into Filter symbols field once user enter the value by default the value should appear in the list
    Then Enter 'B' in Filter symbols field

  @TC_15
  Scenario: Verify user is able to enter symbol value in filter symbol field under ETF broker dashboard screen
    Given Verify ETF broker dashboard screen will open
    Then Verify user is able to enter symbol value in filter symbol field under ETF broker dashboard screen

  @TC_16
  Scenario: Verify user is able view data in UI as per symbol filter value in ETF broker dashboard screen
    Given Verify ETF broker dashboard screen will open
    Then Verify user is able view data in UI as per symbol filter value in ETF broker dashboard screen

  @TC_20
  Scenario: Verify Date, Ticker and Fund family values is available in pivot combo box under ETF broker dashboard screen
    Given Verify ETF broker dashboard screen will open
    When Click on dropdown icon from Pivot combobox
    Then Verify Date, Ticker and Fund family values is available in pivot combobox under ETF broker dashboard screen

  @TC_21
  Scenario: Verify user is able to select Date from pivot combobox in ETF broker dashboard screen
    Given Verify ETF broker dashboard screen will open
    When Click on dropdown icon from Pivot combobox
    And Select Date from pivot combobox list
    Then Verify in result section ticker and family will display under date dropdown in UI

  @TC_22
  Scenario: Verify user is able to select Ticker value from pivot combobox in ETF broker dashboard screen
    Given Verify ETF broker dashboard screen will open
    When Click on dropdown icon from Pivot combobox
    And Select Ticker from pivot combobox list
    Then Verify in result section date and family will display under ticker dropdown in UI

  @TC_23
  Scenario: Verify user is able to select Fund family value from the pivot combobox in ETF broker dashboard screen
    Given Verify ETF broker dashboard screen will open
    When Click on dropdown icon from Pivot combobox
    And Select Family from pivot combobox list
    Then Verify in result section date and ticker will display under family dropdown in UI

  @TC_24
  Scenario: Verify Pre opening, Post opening, Regular market, Closing values are available in Time period dropdown field under ETF broker dashboard
    Given Verify ETF broker dashboard screen will open
    When Click on dropdown icon from Time period combobox
    Then Verify Pre opening, Post opening, Regular market, Closing values are available in Time period dropdown field under ETF broker dashboard

  @TC_25
  Scenario: Verify Pre opening, Post opening, Regular market, Closing values are available in Time period dropdown field under ETF broker dashboard
    Given Verify ETF broker dashboard screen will open
    When Click on dropdown icon from Time period combobox
    Then Verify user is able to select Pre opening value from the list in Time period field under ETF broker dashboard screen

  @TC_26
  Scenario: Verify user is able view data in UI as per Pre opening value in Time period field under ETF broker dashboard screen
    Given Verify ETF broker dashboard screen will open
    When Click on dropdown icon from Time period combobox
    Then Verify user is able to select Pre opening value from the list in Time period field under ETF broker dashboard screen
    And Verify user is able view data in UI as per Pre opening value in Time period field under ETF broker dashboard screen

  @TC_27
  Scenario: Verify user is able to select Post opening value from the list in Time period field under ETF broker dashboard screen
    Given Verify ETF broker dashboard screen will open
    When Click on dropdown icon from Time period combobox
    Then User should be able to select Post opening value from the list in Time period field under ETF broker dashboard screen

  @TC_28
  Scenario: Verify user is able view data in UI as per Post opening value in Time period field under ETF broker dashboard screen
    Given Verify ETF broker dashboard screen will open
    When Click on dropdown icon from Time period combobox
    Then User should be able to select Post opening value from the list in Time period field under ETF broker dashboard screen
    And User should be able view data in UI as per Post opening value in Time period field under ETF broker dashboard screen

  @TC_29
  Scenario: Verify user is able view data in UI as per Post opening value in Time period field under ETF broker dashboard screen
    Given Verify ETF broker dashboard screen will open
    When Click on dropdown icon from Time period combobox
    Then User should be able to select Regular market value from the list in Time period field under ETF broker dashboard screen

  @TC_30
  Scenario: Verify user is able view data in UI as per Post opening value in Time period field under ETF broker dashboard screen
    Given Verify ETF broker dashboard screen will open
    When Click on dropdown icon from Time period combobox
    Then User should be able to select Regular market value from the list in Time period field under ETF broker dashboard screen
    And User should be able view data in UI as per Regular market value in Time period field under ETF broker dashboard screen

  @TC_31
  Scenario: Verify user is able view data in UI as per Post opening value in Time period field under ETF broker dashboard screen
    Given Verify ETF broker dashboard screen will open
    When Click on dropdown icon from Time period combobox
    Then User should be able to select Closing value from the list in Time period field under ETF broker dashboard screen

  @TC_32
  Scenario: Verify user is able view data in UI as per Closing value in Time period field under ETF broker dashboard screen
    Given Verify ETF broker dashboard screen will open
    When Click on dropdown icon from Time period combobox
    Then User should be able to select Closing value from the list in Time period field under ETF broker dashboard screen
    And User should be able view data in UI as per Closing value in Time period field under ETF broker dashboard screen

  @TC_33
  Scenario: Verify Top of book, $100k and $200k list is available in Depth field under ETF broker dashboard
    Given Verify ETF broker dashboard screen will open
    When Click on dropdown icon from Depth combobox
    Then 'Top of Book', '$100K' and '$200k' list should be available in Depth field under ETF broker dashboard

  @TC_34
  Scenario: Verify Top of book, $100k and $200k list is available in Depth field under ETF broker dashboard
    Given Verify ETF broker dashboard screen will open
    When Click on dropdown icon from Depth combobox
    Then User should be able to select Top of book value from the list in Depth field under ETF broker dashboard screen

  @TC_35
  Scenario: Verify user is able view data in UI as per Top of book value in Depth field under ETF broker dashboard screen
    Given Verify ETF broker dashboard screen will open
    When Click on dropdown icon from Depth combobox
    Then User should be able to select Top of book value from the list in Depth field under ETF broker dashboard screen
    And User should be able view data in UI as per Top of book value in Depth field under ETF broker dashboard screen

  @TC_36
  Scenario: Verify user is able to select $100k value from the list in Depth field under ETF broker dashboard screen
    Given Verify ETF broker dashboard screen will open
    When Click on dropdown icon from Depth combobox
    Then User should be able to select $100k value from the list in Depth field under ETF broker dashboard screen

  @TC_37
  Scenario: Verify user is able view data in UI as per $100k value in Depth field under ETF broker dashboard screen
    Given Verify ETF broker dashboard screen will open
    When Click on dropdown icon from Depth combobox
    Then User should be able to select $100k value from the list in Depth field under ETF broker dashboard screen
    And User should be able view data in UI as per $100k value in Depth field under ETF broker dashboard screen

  @TC_38
  Scenario: Verify user is able to select $200k value from the list in Depth field under ETF broker dashboard screen
    Given Verify ETF broker dashboard screen will open
    When Click on dropdown icon from Depth combobox
    Then Verify user is able to select $200k value from the list in Depth field under ETF broker dashboard screen

  @TC_39
  Scenario: Verify user is able view data in UI as per $200k value in Depth field under ETF broker dashboard screen
    Given Verify ETF broker dashboard screen will open
    When Click on dropdown icon from Depth combobox
    Then Verify user is able to select $200k value from the list in Depth field under ETF broker dashboard screen
    And User should be able view data in UI as per $200k value in Depth field under ETF broker dashboard screen
