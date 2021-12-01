@FL-1239
Feature: As a user, I should be able to see the detailed information of a specific vehicle (General Information Page)

  @FLT-1240
Scenario Outline: User can see the "General Information" page by clicking on any vehicle (row), under 'Fleet-Vehicle' module
Given the user is on the login page
And the user enter the "<userType>" information
And the user should be able to login
And the user navigates to "Fleet" "Vehicles"
And  click on the any vehicle
Then General information page can be seen

Examples:
| userType     |
| driver       |
| salesmanager |
| storemanager |

  @FLT-1241
Scenario Outline: User can see the "General Information" page clicking on the "Eye (View)" icon at the end of each row, under 'Fleet-Vehicle' module
Given the user is on the login page
And the user enter the "<userType>" information
And the user should be able to login
And the user navigates to "Fleet" "Vehicles"
And  click on the any Eye Icon
Then General information page can be seen

Examples:
| userType     |
| driver       |
| salesmanager |
| storemanager |

@FLT-1242
Scenario Outline: Sales manager and store manager should see "Edit", "Delete" and "Add Event" buttons on the "General Information" page

Given the user is on the login page
And the user enter the "<userType>" information
And the user should be able to login
And the user navigates to "Fleet" "Vehicles"
And  click on the any vehicle
Then "Edit" button can be seen
Then "Delete" button can be seen
Then "Add" button can be seen

Examples:
| userType     |
| salesmanager |
| storemanager |

@FLT-1243
Scenario: Driver shouldn't see "Add Event", "Edit" and "Delete" buttons
Given the user is on the login page
And the user enter the "driver" information
And the user should be able to login
And the user navigates to "Fleet" "Vehicles"
And  click on the any vehicle
Then "Edit" button cannot be seen
Then "Delete" button cannot be seen
Then "Add" button cannot be seen

@FLT-1244
Scenario Outline:  Vehicle information displayed on the "General Information" page and "Fleet-Vehicle" page should be the same
Given the user is on the login page
And the user enter the "<userType>" information
And the user should be able to login
And the user navigates to "Fleet" "Vehicles"
Then General Information page and Fleet-Vehicle page should be the same

Examples:
| userType     |
| driver       |
| salesmanager |
| storemanager |