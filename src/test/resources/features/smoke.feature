@FLT-1256
Feature: 

	#User Story : 
	#
	#As a user, I should be able to see the detailed information of a specific vehicle (General Information Page)
	#
	# 
	#
	#Acceptance Criteria:
	#
	#{color:red}*1- User can see the "General Information" page by clicking on any vehicle (row), under 'Fleet-Vehicle' module*{color}
	#2- User can see the "General Information" page clicking on the "Eye (View)" icon at the end of each row, under 'Fleet-Vehicle' module
	#3- Sales manager and store manager should see "Edit", "Delete" and "Add Event" buttons on the "General Information" page
	#4- Driver shouldn't see "Add Event", "Edit" and "Delete" buttons
	#5- Vehicle information displayed on the "General Information" page and "Fleet-Vehicle" page should be the same
	@FLT-1240 @FLT-1255 @FLT-1239
	Scenario Outline: TC01 Vehicle General Inf - Verify the General Information Page Visibility (US-07)
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

	#{color:#00875a}*User Story :* {color}
	#
	#As a store manager and sales manager, I should be able to add an event
	#
	# 
	#
	#{color:#ff8b00}*_Acceptance Criteria:_*{color}
	# *1-* When a user clicks on the filter icon, the "Manage Filter" button should be visible
	# *2- User can apply filters by clicking on the filter name, from the 'Manage Filters' menu.*
	# *3*- User can apply filters by typing the filter name, from the 'Manage Filters' menu.
	# *4*- *User can apply multiple filters at the same time*
	# *5*- User can remove all filters by clicking on the reset icon, under the 'Fleet-Vehicles' module
	@FLT-1249 @FLT-1255 @FLT-1253
	Scenario: UN-SP4-AC2+AC4-Verify user can apply filters by clicking on filter name
			Given the user is logged in as "sales manager"
				And the user is on the "Fleet" "Vehicles" page
				And the user cliks on filter icon
				And the user clicks on Manage Filters button
				When the user clicks on the following filters
					|Tags	|
					|Driver	|
				Then Verify the selected filters are
					|Tags	|
					|Driver	|	

	#{color:#00875a}*User Story :* {color}
	#
	#As a 'Sales Manager' and 'Store Manager', I should be able to delete a car
	#
	# 
	#
	#{color:#ff8b00}*_Acceptance Criteria:_*{color}
	#
	#*1*-All users can see the delete button by hovering over the three dots at the end of each row
	#
	#*2*- "Delete Confirmation" pop up should be displayed when the user clicks on the delete button
	#
	#*3*-*"You do not have permission to perform this action." message should be displayed if the driver clicks on the "Yes, Delete" button.*
	#
	#*4*- 'Sales Manager' and 'Store Manager' can delete any car by clicking on the delete button at the end of each row and the "Item deleted" message should be displayed.
	#
	#*5*- When 'Sales Manager' and 'Store Manager' go to the 'General Information' page by clicking on any vehicle/row, they can delete any vehicle by clicking on the 'Delete' button and the "Car deleted" message should be displayed.
	#
	#*6*-When 'Sales Manager' and 'Store Manager' delete a car, the corresponding car should also be removed from the Fleet-Vehicle page.
	@FLT-1236 @FLT-1255 @FLT-1233
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
			

	#{color:#00875a}*User Story :*{color} 
	#
	#As a user, I should be able to log in{color:#ff8b00} {color}
	#
	#{color:#ff8b00}*_Acceptance Criteria:_*{color}
	#
	#{color:#de350b}*1-All users can log in with valid credentials (We have 3 types of users such as sales manager, store manager, truck driver).*{color}
	#{color:#de350b}     *- Driver should land on the "Quick Launchpad" page after successful login*{color}
	#{color:#de350b}     *- Sales Manager/ Store Manager should land on the "Dashboard" page after successful login*{color}
	#
	#*2*-"Invalid username or password." should be displayed for invalid (valid username-invalid password and invalid username-valid password) credentials
	#
	#*3*- "Please fill out this field" message should be displayed if the password or username is empty
	#
	#*4*-User land on the ‘Forgot Password’ page after clicking on the "Forgot your password?" link
	#
	#*5*-User can see "Remember Me" link exists and is clickable on the login page
	#
	#*6*-User should see the password in bullet signs by default
	#
	#*7*- Verify if the ‘Enter’ key of the keyboard is working correctly on the login page.
	#
	#*8-* All users can see their own usernames in the profile menu, after successful login
	@FLT-1274 @FLT-1255
	Scenario Outline: All users can log in with valid credentials
		Given the user is on the login page
		When the user enters the "<userType>" information
		Then the user should be able to login
		
		Examples:
		      | userType     |
		      | driver       |
		      | salesmanager |
		      | storemanager |