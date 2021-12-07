 @FLT-1216
Feature: As a user I should be able to arrange vehicle table data under Fleet-Vehicle page

  @FLT-1340
  Scenario Outline: User can arrange rows/vehicle numbers to be displayed by clicking on 'View Per Page' button under Fleet-Vehicles module

    Given the user is on the login page
    And the user enters the "<userType>" information
    And the user should be able to login
    When the user navigates to "Fleet" "Vehicles"
    Then the view per page button is displayed
    Examples:
      | userType     |
      | driver       |
      | salesmanager |
      | storemanager |

  @FLT-1341
  Scenario Outline: The value of 'View Per Page' should be '25' by default
    Given the user is on the login page
    And the user enters the "<userType>" information
    And the user should be able to login
    When the user navigates to "Fleet" "Vehicles"
    Then  the value of View Per Page should be 25 by default
    Examples:
      | userType     |
      | driver       |
      | salesmanager |
      | storemanager |

  @FLT-1342
  Scenario Outline: View Per Page' includes the values shown as below and the user can select each of them 10,20,50,100

    Given the user is on the login page
    And the user enters the "<userType>" information
    And the user should be able to login
    And the user navigates to "Fleet" "Vehicles"
    When the user click the View Per Page button
    Then the content of the View Per Page should be the below
      | 10  |
      | 25  |
      | 50  |
      | 100 |

    Then the user can arrange rows vehicle numbers by clicking on "100" button
    Examples:
      | userType     |
      | driver       |
      | salesmanager |
      | storemanager |

  @FLT-1343
  Scenario Outline: User can sort a column in ascending or descending order by clicking the column name
    Given the user is on the login page
    And the user enters the "<userType>" information
    And the user should be able to login
    And the user navigates to "Fleet" "Vehicles"
    When the user click the Model Year button
    Then the user can sort a column in ascending or descending order
    Examples:
      | userType     |
      | driver       |
      | salesmanager |
      | storemanager |

  @FLT-1344
  Scenario Outline: User can remove all sortings and filterings on the page by using the reset button
    Given the user is on the login page
    And the user enters the "<userType>" information
    And the user should be able to login
    And the user navigates to "Fleet" "Vehicles"
    When the user click the Model Year button
    Then the user click the reset button
    Then the user can remove all sortings and filterings on the page
    Examples:
      | userType     |
      | driver       |
      | salesmanager |
      | storemanager |