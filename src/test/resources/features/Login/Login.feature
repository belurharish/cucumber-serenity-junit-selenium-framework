Feature: Grapevine Login

  @regression
  Scenario: Login with valid credential
    Given Enter TMX url into address bar in the browser
    When Verify Login screen is displayed
    And Enter valid email address and password
    And Click on I agree & sign in button
    Then Verify home screen is displayed

  @smoke
  Scenario: Login with invalid credential
    Given Enter TMX url into address bar in the browser
    When Verify Login screen is displayed
    And Enter invalid email address and password
    And Click on I agree & sign in button
    Then Verify appropriate error message is displayed

  @TC_5
  Scenario: Verify Copyright message is displaying in left down corner in all screens
    Given Enter TMX url into address bar in the browser
    When Verify Login screen is displayed
    Then Verify Copyright message is displaying in left down corner in Login screen
    And Enter valid email address and password
    And Click on I agree & sign in button
    Then Verify Copyright message is displaying in left down corner in all screens

  @TC_6
  Scenario: Verify Year which is displaying in Copyright message is dynamic from server
    Given Enter TMX url into address bar in the browser
    When Verify Login screen is displayed
    Then Verify Year which is displaying in Copyright message is dynamic from server
    