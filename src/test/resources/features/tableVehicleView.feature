@FLT-1215
Feature: As a user, I should be able to see all vehicle information in a table under Fleet-Vehicle page

  @FLT-1334
  Scenario Outline: Vehicles can be seen under Fleet-Vehicle module
    Given the user is on the login page
    When the user enters the "<userType>" information
    Then the user should be able to login
    Then the user navigates to "Fleet" "Vehicles"
    Then the user can see vehicle table

    Examples:
      | userType      |
      | driver        |
      | salesmanager |
      | storemanager |

  @FLT-1335
  Scenario Outline: Total Page number can be seen
    Given the user is on the login page
    When the user enters the "<userType>" information
    Then the user should be able to login
    Then the user navigates to "Fleet" "Vehicles"
    Then the user can see the total page number

    Examples:
      | userType      |
      | driver        |
      | salesmanager |
      | storemanager |

  @FLT-1336
  Scenario Outline: Clicking ">" and "<" button
    Given the user is on the login page
    When the user enters the "<userType>" information
    Then the user should be able to login
    Then the user navigates to "Fleet" "Vehicles"
    When the user clicks on forward button and goes to next page
    Then the user clicks on backward button and goes to previous page

    Examples:
      | userType      |
      | driver        |
      | salesmanager |
      | storemanager |

  @FLT-1337
  Scenario Outline: Total Recordings of Vehicle can be seen
    Given the user is on the login page
    When the user enters the "<userType>" information
    Then the user should be able to login
    Then the user navigates to "Fleet" "Vehicles"
    Then the user can see the total recordings of vehicle

    Examples:
      | userType      |
      | driver        |
      | salesmanager |
      | storemanager |

  @FLT-1338
  Scenario Outline: Downloading the table in XLSX and CSV format
    Given the user is on the login page
    When the user enters the "<userType>" information
    Then the user should be able to login
    Then the user navigates to "Fleet" "Vehicles"
    When the user clicks on export grid button
    Then the user can download table in CSV format
    Then the user can download table in XLSX format

    Examples:
      | userType      |
      | driver        |
      | salesmanager |
      | storemanager |