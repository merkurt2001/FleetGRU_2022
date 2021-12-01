
@FLT-1218 @win
Feature: As a store manager and sales manager, I should be able to add an event
  Background:
    Given the user is on the login page
    And the user enter the "storemanager" information
    And the user should be able to login
    And the user navigates to "Fleet" "Vehicles"
    And  click on the any vehicle

  @FLT-1199
  Scenario: User can access the "Add Event" page from the "General Information" page (by clicking on any vehicle/row under Fleet-Vehicle module)
    When The user clickable Add Event button

  @FLT-1153
  Scenario: After clicking on "Add event" button, "Add Event" page should pop up.
    When the user click Add Event button
    Then the user access Add Event Page

  @FLT-1154
  Scenario: User can mark the event with any colour
    When the user click Add Event button
    Then the user access Add Event Page
    Then the user select any color

  @FLT-1155
  Scenario: User can click  "All-day event" check box and after click time boxes will disappear
    When the user click Add Event button
    When the user click All day event button
    Then click time boxes will disappear

  @FLT-1156
  Scenario:  User can repeat the action by specifying occurrence periods and ending time
    When the user click Add Event button
    When the user click Repeat button
    Then Repeat groups is disable
    When the user click Repeat options
    Then Daily, Weekly, Monthly, Yearly is disable
      | Daily   |
      | Weekly  |
      | Monthly |
      | Yearly  |
    Then Never,After,By is disable and clickable

  @FLT-1157
  Scenario: All Users can see all events on the General information page
    When the user click Add Event button
    And the user writes "xxx" in the title
    And the user click save button
    Then the user can see all events information

#Feetvehicle scenario'ları tek bir feature altında toplanacak
   #Buraya her yaptığımız değişiklikten sonra sadece commit yapıyoruz