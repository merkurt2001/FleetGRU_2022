@smoke
Feature:

	@FLT-1234 @FLT-1233
	Scenario Outline: FLT 1220 TC-01 All users can see the delete button by hovering over the three dots at the end of each row
		Given the user logged in as "<userType>"
		And the user should be able to login
		When the user navigates to "Fleet" to "Vehicles"
		And the title contains "Car"
		Then each users must see over the three dots at the end of each row
		And each user must hovering over the three dots at the end of any rows
		And all users can see the delete button  at the end of each row
		Examples:
		      | userType      |
		      | driver        |
		      | storemanager |
		      | salesmanager |
			


	@FLT-1235 @FLT-1233
	Scenario Outline: FLT 1220 TC-02 Delete Confirmation" pop up should be displayed when the user clicks on the delete button
		Given the user logged in as "<userType>"
		When the user navigates to "Fleet" to "Vehicles"
		Then the title contains "Car"
		And each user must hovering over the three dots at the end of any rows
		And click delete button
		And all user should see "Delete Confirmation" on pop
		And all user should click Yes, Delete on pop
		Examples:
		      | userType      |
		      | driver        |
		      | storemanager |
		      | salesmanager |
			

	@FLT-1236 @FLT-1233
	Scenario: FLT 1220 TC-03 "You do not have permission to perform this action." message should be displayed if the driver clicks on the "Yes, Delete" button.
		Given the user logged in as "driver"
		Then the user should see following options
		      | Fleet      |
		      | Customers  |
		      | Activities |
		      | System     |
		And the user navigates to "Fleet" to "Vehicles"
		And the title contains "Car"
		And each user must hovering over the three dots at the end of any rows
		And click delete button
		And all user should see "Delete Confirmation" on pop
		And all user should click Yes, Delete on pop
		Then users should see "You do not have permission to perform this action." massage


	@FLT-1237 @FLT-1233
	Scenario Outline: FLT 1220 TC-04 'Sales Manager' and 'Store Manager' can delete any car by clicking on the delete button at the end of each row and the "Item deleted" message should be displayed
		Given the user logged in as "<userType>"
		Then the user should see following options
		      | Dashboards         |
		      | Fleet              |
		      | Customers          |
		      | Sales              |
		      | Activities         |
		      | Marketing          |
		      | Reports & Segments |
		      | System             |
		And the user navigates to "Fleet" to "Vehicles"
		And the title contains "Car"
		And check total records before delete
		And each user must hovering over the three dots at the end of any rows
		And click delete button
		And all user should see "Delete Confirmation" on pop
		And all user should click Yes, Delete on pop
		And users should see "Item deleted" massage
		And check total records after delete
		And total records after deletion must be one less than records before deletion
		Examples:
		      | userType      |
		      | storemanager |
		      | salesmanager |


	@FLT-1238 @FLT-1233
	Scenario Outline: FLT 1220 TC-05 When 'Sales Manager' and 'Store Manager' go to the 'General Information' page by clicking on any vehicle/row, they can delete any vehicle by clicking on the 'Delete' button and the "Car deleted" message should be displayed and verify
		Given the user logged in as "<userType>"
		Then the user should see following options
		      | Dashboards         |
		      | Fleet              |
		      | Customers          |
		      | Sales              |
		      | Activities         |
		      | Marketing          |
		      | Reports & Segments |
		      | System             |
		When the user navigates to "Fleet" to "Vehicles"
		Then the title contains "Car"
		And check total records before delete
		And clicking on any vehicle-row
		And verify the "General Information" page
		And click delete button
		And all user should see "Delete Confirmation" on pop
		And all user should click Yes, Delete on pop
		And users should see "Car deleted" massage
		And check total records after delete
		And total records after deletion must be one less than records before deletion
		Examples:
		      | userType      |
		      | storemanager  |
		      | salesmanager  |
		