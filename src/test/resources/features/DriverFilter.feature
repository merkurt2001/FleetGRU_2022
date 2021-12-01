@wip
Feature: As a user, I should be able to use the "Driver" filter under the Fleet-Vehicles page

  Background:
    Given the user is on the login page
    And the user enter the "driver" information
    And the user should be able to login
    And the user navigates to "Fleet" "Vehicles"

  @FLT-1296 @wip
  Scenario: User can select "Driver" filter under 'Fleet-Vehicles' module

    When the user click the Filter button
    When the user click Manage Filter
    When the user select "Driver" filter

  @FLT-1297 @wip
  Scenario: "Driver" filter should provide the methods shown as below:

    When the user click the Filter button
    When the user click Manage Filter
    And the user select "Driver" filter
    And the user clicks Driver link
    And the user click Contains link
    Then methods are shown following type

      | Contains         |
      | Does Not Contain |
      | Is Equal To      |
      | Starts With      |
      | Ends With        |
      | Is Any Of        |
      | Is Not Any Of    |
      | Is Empty         |
      | Is Not Empty     |

  @FLT-1298 @wip
  Scenario: The user selects "Contains" method with a keyword, the results should contain the specified keyword

    When the user click the Filter button
    When the user click Manage Filter
    And the user select "Driver" filter
    And the user clicks Driver link
    And the user click Contains link
    And the user select "Contains" method
    And the user writes a "Frederick"
    And the user clicks the update button
    Then the result should contain the "Frederick"

  @FLT-1299 @wip
  Scenario: The user selects "Does Not Contain" method with a keyword, the results should not contain the specified keyword

    When the user click the Filter button
    When the user click Manage Filter
    And the user select "Driver" filter
    And the user clicks Driver link
    And the user click Contains link
    And the user select "Does Not Contain" method
    And the user writes a "Hewitt"
    And the user clicks the update button
    Then the result should not contain the "Hewitt"

  @FLT-1300 @wip
  Scenario: The user selects "Starts with" method with a keyword, the results should start with the specified keyword

    When the user click the Filter button
    When the user click Manage Filter
    And the user select "Driver" filter
    And the user clicks Driver link
    And the user click Contains link
    And the user select "Starts with" method
    And the user writes a "Ker"
    And the user clicks the update button
    Then the result should start with "Ker"

  @FLT-1301 @wip
  Scenario: The user selects "Ends With" method with a keyword, the results should end with the specified keyword

    When the user click the Filter button
    When the user click Manage Filter
    And the user select "Driver" filter
    And the user clicks Driver link
    And the user click Contains link
    And the user select "Ends With" method
    And the user writes a "kin"
    And the user clicks the update button
    Then the result should end with "kin"

  @FLT-1302 @wip
  Scenario: The user selects "Is Equal to" method with a keyword, the results should match the specified keyword exactly

    When the user click the Filter button
    When the user click Manage Filter
    And the user select "Driver" filter
    And the user clicks Driver link
    And the user click Contains link
    And the user select "Is Equal to" method
    And the user writes a "Gideon Scarisbrick"
    And the user clicks the update button
    Then the result should match the "Gideon Scarisbrick" exactly

  @FLT-1303 @wip
  Scenario Outline: Methods  ("Contains", "Does Not Contains", "Starts With", "Ends With", "Is Equal to") shouldn't accept non-alphabetical characters
    When the user click the Filter button
    When the user click Manage Filter
    And the user select "Driver" filter
    And the user clicks Driver link
    And the user click Contains link
    And the user select "<MenuTypes>" method
    And the user writes a "<KeyWords>"
    Then methods shouldn't accept non-alphabetical characters
    Examples:

      | MenuTypes        | KeyWords |
      | Contains         | 3{5&*)(  |
      | Does Not Contain | %$:^@$}! |
      | Starts With      | 9"8!\^!  |
      | Ends With        | ^%*&)0-? |
      | Is Equal to      | @1[]7*&  |