@login
Feature: Users can successfully logs out
@FLT-1284
  Scenario Outline: Verify that users can successfully log out by using log out option
    Given users successfully logged in to the application with "<userType>"
    When users clicks log out button on the top menu
    Then Users are on the login page
    Examples:
      |userType       |
      |driver         |
      |salesmanager   |
      |storemanager   |
  @FLT-1285
  Scenario Outline: Verify that once users logged out, they can't login to the application by using return button
    Given users successfully logged in to the application with "<userType>"
    When users clicks log out button on the top menu
    Then Users are on the login page
    And Users can't login back to the application by clicking return button
    Examples:
      |userType       |
      |driver         |
      |salesmanager   |
      |storemanager   |
  @FLT-1286
  Scenario Outline: Verify that users can log out by closing the open tabs
    Given users successfully logged in to the application with "<userType>"
    When Users close the tab where application is open
    Then Users are succesfully logged out and need to login again
    Examples:
      |userType       |
      |driver         |
      |salesmanager   |
      |storemanager   |
