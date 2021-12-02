Feature: As a user, I should be able to use "Last Odometer" filter under 'Fleet-Vehicles' page

  Background:
    Given the user is on the login page
    And the user enter the "driver" information
    And the user should be able to login
    And the user navigates to "Fleet" to "Vehicles"
    When the user click the Filter button
    When the user click Manage Filter
    Then the user select "Last Odometer" filter

  @wip
  Scenario: User can select "Last Odometer" filter under 'Fleet-Vehicles' page


  @wip
  Scenario: The content of the "Last Odometer" filter should be correct.

    And the user click "Last Odometer" box
    And the user click choose button
    Then content of list should have to following  types
      | Between             |
      | Not Between         |
      | Equals              |
      | Not Equals          |
      | More Than           |
      | Less Than           |
      | Equals Or More Than |
      | Equals Or Less Than |
      | Is Empty            |
      | Is Not Empty        |

  @wip
  Scenario:The user selects "Between" method with numeric values, the results should be between the specified values

    And the user click "Last Odometer" box
    And the user click choose button
    Then user selects "Between" method
    And the user enters start value "20" end value "80"
    And click the Update button
    Then results table should only show Last Odometer between "20" to "80"

  @wip
  Scenario:The user selects "Equals" method with numeric values, the results should match the specified value exactly

    And the user click "Last Odometer" box
    And the user click choose button
    Then user selects "Equals" method
    And the user enters value "100"
    And click the Update button
    Then All the results should match "100" exactly

  @wip
  Scenario:The user selects "More than" method with numeric values, the results should be more than the specified value

    And the user click "Last Odometer" box
    And the user click choose button
    Then user selects "More than" method
    And the user enters value "4000"
    And click the Update button
    Then All the results should be more than "4000" value

  @wip
  Scenario:The user selects "Less than" method with numeric values, the results should be less than the specified value

    And the user click "Last Odometer" box
    And the user click choose button
    Then user selects "Less Than" method
    And the user enters value "1000"
    And click the Update button
    Then All the results should be less than "1000" value

  @wip
  Scenario:The user selects "Is Empty" method, only empty values should be displayed

    And the user click "Last Odometer" box
    And the user click choose button
    Then user selects "Is Empty" method
    And click the Update button
    Then only empty values should be displayed

  @wip
  Scenario Outline: Method ("Between") shouldn't accept non-numeric values

    And the user click "Last Odometer" box
    And the user click choose button
    Then user selects "<link>" method
    And the user enters start value "<start>" end value "<end>"
    Then click the Update button and result table should not change
    Examples:
      | link    | start   | end   |
      | Between | !*/     | $%    |
      | Between | window  | glass |
      | Between | vehicle | 34    |
      | Between | 37      | lock  |

  @wip
  Scenario Outline: Methods ("Equals","More Than","Less Than") shouldn't accept non-numeric values

    And the user click "Last Odometer" box
    And the user click choose button
    Then user selects "<link>" method
    And the user enters value "<start>"
    Then click the Update button and result table should not change
    Examples:
      | link      | start |
      | Equals    | car   |
      | More than | +^^^  |
      | Less Than | apple |
