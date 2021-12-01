Feature:


	@FLT-1248 @FLT-1253
	Scenario: UN-SP4-AC1-Verify "Manage Filter" button is visibile
		Given the user is logged in as "sales manager"
		And the user is on the "Fleet" "Vehicles" page
		When the user cliks on filter icon
		Then Manage Filter button should be visible


	@FLT-1249 @FLT-1253
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


	@FLT-1250 @FLT-1253
	Scenario: UN-SP4-AC3 Verify user can apply filters by typing filter name
		Given the user is logged in as "sales manager"
		And the user is on the "Fleet" "Vehicles" page
		And the user cliks on filter icon
		And the user clicks on Manage Filters button
		When the user types filter name "Tags"
		Then Verify the "Tags" filter is selected


	@FLT-1252 @FLT-1253
	Scenario: UN-SP4-AC5-Verify user can remove all filters by clicking on reset button
		Given the user is logged in as "sales manager"
		And the user is on the "Fleet" "Vehicles" page
		And the user cliks on filter icon
		And the user clicks on Manage Filters button
		When the user clicks on the following filters
			|Tags	|
			|Driver	|
		When the user clicks on reset button
		Then all filters should be removed
		