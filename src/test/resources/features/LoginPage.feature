@login
Feature: user should be able to login with valid credential

  Scenario Outline: Login as a user
    Given the user is on the login page
    When the user enters the "<userType>" information
    Then the user should be able to login

    Examples:
      | userType     |
      | driver       |
      | salesmanager |
      | storemanager |