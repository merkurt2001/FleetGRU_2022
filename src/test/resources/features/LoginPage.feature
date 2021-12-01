@login
Feature: user should be able to login with valid credential
  @FLT-1274
  Scenario Outline: Login as a user
    Given the user is on the login page
    When the user enters the "<userType>" information
    Then the user should be able to login

    Examples:
      | userType     |
      | driver       |
      | salesmanager |
      | storemanager |

  @FLT-1275
  Scenario Outline: Verify that users can't login to the application with Invalid UserName
    Given the user is on the login page
    When the user enters the invalid "<user>" valid "<password>" information
    Then Users should see Invalid Username or Password message
    Examples:
      | user   | password    |
      |use1|UserUser123|
      |sales12|UserUser123|
      |Storemana?|UserUser123|



  @FLT-1276
  Scenario Outline: Verify that Please fill in this field message is displayed
    Given the user is on the login page
    When the user enters the  "<userType>" and "<password>" information
    Then Warning message should be displayed in the relevant field
    Examples:
      |userType|password   |
      |        |UserUser123|
      |user1   |           |
  @FLT-1277
  Scenario: Verify that users can go to forgot password page by clicking on Forgot your password link
    Given the user is on the login page
    When Users click on forgot your password button
    Then Users land on Forgot Password Page

  @FLT-1278
  Scenario: Verify that Remember Me checkbox is visible and clickable
    Given the user is on the login page
    Then Users can see Remember me checkbox
    And Users can click on Remember me checkbox

  @FLT-1279
  Scenario Outline: Verify that users see password characters in bullet points
    Given the user is on the login page
    When Users enter their "<Passwords>"
    Then they should see the "<Passwords>" as bullet points
    Examples:
      |Passwords|
      |*90?_|
      |User|
      |1238/|
  @FLT-1280
  Scenario Outline: Verify that Enter Key is Working Properly - Positive Scenario
    Given the user is on the login page
    When "<Username>" enters "<Password>" and hit the Enter key
    Then "<UserType>" should see "<Landing Page>"
    Examples:
      |Username|Password|UserType|Landing Page|
      |user1|UserUser123|Driver|Quick Launchpad|
      |storemanager86|UserUser123|Store Manager|Dashboard|
      |salesmanager135|UserUser123|Sales Manager|Dashboard|
  @FLT-1281
  Scenario Outline: Verify that Enter Key is Working Properly - Negative  Scenario
    Given the user is on the login page
    When "<Username>" enters "<Password>" and hit the Enter key
    Then Users should see Invalid Username or Password message
    Examples:
      |Username|Password|
      |use1|UserUser123|
      |storemanage86|UserUser123|
  @FLT-1282
  Scenario Outline: Verify that Users can see their names once they logged in
    Given the user is on the login page
    When the user enters the "<userType>" information
    Then the user should be able to login
    And "<Username>" should see his-her "<Name>"


    Examples:
      | userType     |Name|
      | driver       |John Doe|
      | salesmanager |John Doe|
      | storemanager |John Doe|