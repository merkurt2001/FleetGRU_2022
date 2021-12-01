@ft
Feature: User should be able to arrange grid settings
  Agile User Story: As a user, I should be able to arrange vehicle table columns
  via "grid settings" functionality under the Fleet-Vehicles page


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

  Scenario Outline: AC 3- User can find any column by typing the name on "Quick Search" input box
    Given the user is on the login page
    And the user enters the "<userType>" information
    And the user navigates to "Fleet" "Vehicles"
    And the user clicks on the gear icon
    When the user types any "<column name>" on Quick Search box
    Then the "<column name>" should be visible

    Examples:
      | userType     | column name               |
      | driver       | Id                        |
      | driver       | License Plate             |
      | driver       | Tags                      |
      | driver       | Driver                    |
      | driver       | Location                  |
      | driver       | Chassis Number            |
      | driver       | Model Year                |
      | driver       | Last Odometer             |
      | driver       | Immatriculation Date      |
      | driver       | First Contract Date       |
      | driver       | Catalog Value (VAT Incl.) |
      | driver       | Seats Number              |
      | driver       | Doors Number              |
      | driver       | Color                     |
      | driver       | Transmission              |
      | driver       | Fuel Type                 |
      | driver       | CO2 Emissions             |
      | driver       | Horsepower                |
      | driver       | Horsepower Taxation       |
      | driver       | Power (KW)                |
      | salesmanager | Id                        |
      | salesmanager | License Plate             |
      | salesmanager | Tags                      |
      | salesmanager | Driver                    |
      | salesmanager | Location                  |
      | salesmanager | Chassis Number            |
      | salesmanager | Model Year                |
      | salesmanager | Last Odometer             |
      | salesmanager | Immatriculation Date      |
      | salesmanager | First Contract Date       |
      | salesmanager | Catalog Value (VAT Incl.) |
      | salesmanager | Seats Number              |
      | salesmanager | Doors Number              |
      | salesmanager | Color                     |
      | salesmanager | Transmission              |
      | salesmanager | Fuel Type                 |
      | salesmanager | CO2 Emissions             |
      | salesmanager | Horsepower                |
      | salesmanager | Horsepower Taxation       |
      | salesmanager | Power (KW)                |
      | storemanager | Id                        |
      | storemanager | License Plate             |
      | storemanager | Tags                      |
      | storemanager | Driver                    |
      | storemanager | Location                  |
      | storemanager | Chassis Number            |
      | storemanager | Model Year                |
      | storemanager | Last Odometer             |
      | storemanager | Immatriculation Date      |
      | storemanager | First Contract Date       |
      | storemanager | Catalog Value (VAT Incl.) |
      | storemanager | Seats Number              |
      | storemanager | Doors Number              |
      | storemanager | Color                     |
      | storemanager | Transmission              |
      | storemanager | Fuel Type                 |
      | storemanager | CO2 Emissions             |
      | storemanager | Horsepower                |
      | storemanager | Horsepower Taxation       |
      | storemanager | Power (KW)                |


