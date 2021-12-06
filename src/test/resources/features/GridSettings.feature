@FLT-1288  @FLT-1222 @WİP
Feature: User should be able to arrange grid settings
  Agile User Story: As a user, I should be able to arrange vehicle table columns
  via "grid settings" functionality under the Fleet-Vehicles page

  @FLT-1289
  Scenario Outline: AC 1-"Grid Settings" should be visible
    Given the user is on the login page
    And the user enters the "<userType>" information
    And the user navigates to "Fleet" "Vehicles"
    When the user clicks on the gear icon
    Then the Grid Settings should be visible

    Examples:
      | userType     |
      | driver       |
      | salesmanager |
      | storemanager |

  @FLT-1290
  Scenario Outline: AC 2- Column names in grid settings should be shown as below
    Given the user is on the login page
    And the user enters the "<userType>" information
    And the user navigates to "Fleet" "Vehicles"
    When the user clicks on the gear icon
    Then the Column names in grid settings should be shown as below
      | Id                        |
      | License Plate             |
      | Tags                      |
      | Driver                    |
      | Location                  |
      | Chassis Number            |
      | Model Year                |
      | Last Odometer             |
      | Immatriculation Date      |
      | First Contract Date       |
      | Catalog Value (VAT Incl.) |
      | Seats Number              |
      | Doors Number              |
      | Color                     |
      | Transmission              |
      | Fuel Type                 |
      | CO2 Emissions             |
      | Horsepower                |
      | Horsepower Taxation       |
      | Power (KW)                |

    Examples:
      | userType     |
      | driver       |
      | salesmanager |
      | storemanager |


  @FLT-1291
  Scenario Outline: AC 3- User can find any column by typing the name on "Quick Search" input box
    Given the user is on the login page
    And the user enters the "<userType>" information
    And the user navigates to "Fleet" "Vehicles"
    And the user clicks on the gear icon
    When the user types any column name on Quick Search box
      | Id                        |
      | License Plate             |
      | Tags                      |
      | Driver                    |
      | Location                  |
      | Chassis Number            |
      | Model Year                |
      | Last Odometer             |
      | Immatriculation Date      |
      | First Contract Date       |
      | Catalog Value (VAT Incl.) |
      | Seats Number              |
      | Doors Number              |
      | Color                     |
      | Transmission              |
      | Fuel Type                 |
      | CO2 Emissions             |
      | Horsepower                |
      | Horsepower Taxation       |
      | Power (KW)                |
    Then the column name should be visible

    Examples:
      | userType     |
      | driver       |
      | salesmanager |
      | storemanager |


  @FLT-1292
  Scenario Outline: AC 4- User can select any column by clicking the column name
    Given the user is on the login page
    And the user enters the "<userType>" information
    And the user navigates to "Fleet" "Vehicles"
    And the user clicks on the gear icon
    When the user click any column name
    Then the user should select corresponding column

    Examples:
      | userType     |
      | driver       |
      | salesmanager |
      | storemanager |

  @FLT-1293
  Scenario Outline: AC 5- User can arrange the order of the columns (by dragging and dropping)
    Given the user is on the login page
    And the user enters the "<userType>" information
    And the user navigates to "Fleet" "Vehicles"
    And the user clicks on the gear icon
    When the user drag and drop columns
    Then the user should arrange the order of the columns

    Examples:
      | userType     |
      | driver       |
      | salesmanager |
      | storemanager |

  @FLT-1294
  Scenario Outline: AC 6- User can see all corresponding changes under 'Fleet-Vehicles' pages
    Given the user is on the login page
    And the user enters the "<userType>" information
    And the user navigates to "Fleet" "Vehicles"
    And the user clicks on the gear icon
    When the user arrange any change
    Then the user should see all corresponding changes on the All Cars table

    Examples:
      | userType     |
      | driver       |
      | salesmanager |
      | storemanager |