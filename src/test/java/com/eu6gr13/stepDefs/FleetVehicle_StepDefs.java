package com.eu6gr13.stepDefs;

import com.eu6gr13.pages.Actions;
import com.eu6gr13.utilities.BrowserUtils;
import com.eu6gr13.utilities.Screanshot;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class FleetVehicle_StepDefs extends Actions {

    @Given("the user navigates to {string} {string}")
    public void the_user_navigates_to(String string, String string2) {
        navigateToModule(string, string2);
    }

    @Given("click on the any vehicle")
    public void click_on_the_any_vehicle() {
        anyCar();
    }

    @When("The user clickable Add Event button")
    public void the_user_clickable_Add_Event_button() {
        verifyAddEventButton();
    }

    @When("the user click Add Event button")
    public void the_user_click_Add_Event_button() {
        addEventButtonClick();
    }

    @Then("the user access Add Event Page")
    public void the_user_access_Add_Event_Page() {
        verifyAddEventPageAccess();
        Screanshot.takeScreenShot();
    }

    @Then("the user select any color")
    public void the_user_select_any_color() {
        verifyColorSelect();
    }

    @When("the user click All day event button")
    public void the_user_click_All_day_event_button() {
        Screanshot.takeScreenShot();
        allDayEventButtonInWindowClick();
    }

    @Then("click time boxes will disappear")
    public void click_time_boxes_will_disappear() {
        verifyTimeBoxesWillDisappear();
    }

    @When("the user click Repeat button")
    public void the_user_click_Repeat_button() {
        Screanshot.takeScreenShot();
        repeatButtonClick();
    }

    @Then("Repeat groups is disable")
    public void repeat_groups_is_disable() {
        verifyRepeatGroupsIsDisable();
        Screanshot.takeScreenShot();
    }

    @When("the user click Repeat options")
    public void the_user_click_Repeat_options() {
        Screanshot.takeScreenShot();
        repeatOptionClick();
        Screanshot.takeScreenShot();
    }

    @Then("Daily, Weekly, Monthly, Yearly is disable")
    public void daily_Weekly_Monthly_Yearly_is_disable(List<String> str) {
        verifyRepeatOption(str);
    }

    @Then("Never,After,By is disable and clickable")
    public void never_After_By_is_disable_and_clickable() {
        AfterByclickAbleCheck();
    }

    @When("the user writes {string} in the title")
    public void the_user_writes_in_the_title(String str) {
        addEventWindowTitleBoxAddText(str);
        Screanshot.takeScreenShot();
    }

    @When("the user click save button")
    public void the_user_click_save_button() {
        addEventWindowSaveButtonClick();
    }

    @Then("the user can see all events information")
    public void the_user_can_see_all_events_information() {
        verifyEventsInformation();
    }


    /**
     * US-010 Grid Settings
     * Assignee : Fatih
     */

    @When("the user clicks on the gear icon")
    public void the_user_clicks_on_the_gear_icon() {
        clickGearIcon();
    }

    @Then("the Grid Settings should be visible")
    public void the_Grid_Settings_should_be_visible() {
        gridSettingsTitleIsDisplayed();
    }


    @Then("the Column names in grid settings should be shown as below")
    public void the_Column_names_in_grid_settings_should_be_shown_as_below(List<String> expectedColumnNames) {
        matchGridSettingsColumnTitle(expectedColumnNames);
    }

    @When("the user types any {string} on Quick Search box")
    public void the_user_types_any_on_Quick_Search_box(String enterColNames) {
        enterGridSettingsQuickSearch(enterColNames);
    }

    @Then("the {string} should be visible")
    public void the_should_be_visible(String str) {
        matchGridSettingsColumnFilter(str);
    }

    /**
     * US-010 Grid Settings
     * Assignee : Fatih
     */
    @Then("General information page can be seen") //MURAT
    public void general_information_page_can_be_seen() {
        verifyGeneralInformationPage();
    }

    @Given("click on the any Eye Icon")//MURAT
    public void click_on_the_any_Eye_Icon() {
        clickAnyEyeIcon();
    }

    @Then("{string} button can be seen")//MURAT
    public void button_can_be_seen(String string) {
        verifyEditDeleteAddEventButtons(string);
    }

    @Then("{string} button cannot be seen")//MURAT
    public void button_cannot_be_seen(String string) {
        verifyDriverEditDeleteAddEventButtons(string);
    }

    @Then("General Information page and Fleet-Vehicle page should be the same")//MURAT
    public void general_Information_page_and_Fleet_Vehicle_page_should_be_the_same() {
        verifyGeneralInformationCarTable();
    }

    @When("the user click the Filter button")
    public void theUserClickTheFilterButton() {
        BrowserUtils.waitFor(3);
        ClickTheFilterButton();
    }

    @When("the user click Manage Filter")
    public void theUserClickManageFilter() {
        ClickTheManageFilterButton();
    }

    @When("the user select {string} filter")
    public void theUserSelectFilter(String option) {
        clickAnyOptionOnManageFilterMenu(option);

    }

    @And("the user clicks Driver link")
    public void theUserClicksDriverLink() {
        clickDriverLink();
    }


    @And("the user click Contains link")
    public void theUserClickContainsLink() {
        clickContainsLink();
    }

    @Then("methods are shown following type")
    public void methods_are_shown_following_type(List<String> dataTable) {
        BrowserUtils.waitFor(2);
        Assert.assertEquals(dataTable, createMethodList());
    }

    @When("the user select {string} method")
    public void the_user_select_method(String string) {
        clickAnyMethod(string);
    }

    @When("the user writes a {string}")
    public void the_user_writes_a(String string) {
        sendKeysInputBox(string);
    }

    @When("the user clicks the update button")
    public void the_user_clicks_the_update_button() {
        clickUpdateButton();
    }

    @Then("the result should contain the {string}")
    public void the_result_should_contain_the(String string) {
        verifyMethodsContain(string);
    }

    @Then("the result should not contain the {string}")
    public void the_result_should_not_contain_the(String string) {
        verifyMethodsDoesNotContain(string);
    }

    @Then("the result should start with {string}")
    public void the_result_should_start_with(String string) {
        verifyMethodsStartsWith(string);
    }

    @Then("the result should end with {string}")
    public void the_result_should_end_with(String string) {
        verifyMethodsEndsWith(string);
    }

    @Then("the result should match the {string} exactly")
    public void the_result_should_match_the_exactly(String string) {
        verifyMethodsIsEqualTo(string);
    }

    @Then("methods shouldn't accept non-alphabetical characters")
    public void methods_shouldn_t_accept_non_alphabetical_characters() {
        verifyNotAcceptNon_AlphabeticalCharacters();
    }

    /**
     * CONTINUE
     * US-010 Grid Settings    Assignee : Fatih
     */

    @When("the user click any column name")
    public void the_user_click_any_column_name() {
        selectAllGridSettings();
        clickGridSettingsColumnName();
    }

    @Then("the user should select corresponding column")
    public void the_user_should_select_corresponding_column() {
        isDisplayed_TableTitle_GridSettings();
    }

    @When("the user drag and drop columns")
    public void the_user_drag_and_drop_columns() {
        sortGridSettingsColumns();
    }

    @Then("the user should arrange the order of the columns")
    public void the_user_should_arrange_the_order_of_the_columns() {
        checkSortGridSettings();
    }

    @When("the user arrange any change")
    public void theUserArrangeAnyChange() {
        gridSettingsChangeColumn();
    }

    @Then("the user should see all corresponding changes on the All Cars table")
    public void theUserShouldSeeAllCorrespondingChangesOnTheAllCarsTable() {
        gridSettingsControlTableAllCars();
    }

    @When("the user types any column name on Quick Search box")
    public void theUserTypesAnyColumnNameOnQuickSearchBox(List<String> b) {
        enterGridSettingsQuickSearchBox(b);
    }

    @Then("the column name should be visible")
    public void theColumnNameShouldBeVisible() {
        matchGridSettingsColumnFilterControl();
    }

    /*   FINISH  US-010 Grid Settings  Assignee : Fatih        */


    //AST
    @When("the user writes a \"{int}\"{int}!\\^!\"")
    public void the_user_writes_a(Integer int1, Integer int2) {

    }

    @Then("the user can see vehicle table")
    public void the_user_can_see_vehicle_table() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(informationTable_locator.isDisplayed());
    }

    @Then("the user can see the total page number")
    public void the_user_can_see_the_total_page_number() {
        BrowserUtils.waitFor(3);
        Assert.assertTrue(totalPage_locator.isDisplayed());
    }

    @When("the user clicks on forward button and goes to next page")
    public void the_user_clicks_on_forward_button_and_goes_to_next_page() {
        verifyForwardButton();
    }

    @Then("the user clicks on backward button and goes to previous page")
    public void the_user_clicks_on_backward_button_and_goes_to_previous_page() {
        verifyBackButton();
    }

    @Then("the user can see the total recordings of vehicle")
    public void the_user_can_see_the_total_recordings_of_vehicle() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(totalRecordsPage_locator.isDisplayed());
    }

    @When("the user clicks on export grid button")
    public void the_user_clicks_on_export_grid_button() {
        exportGrid_locator.click();
    }

    @Then("the user can download table in CSV format")
    public void the_user_can_download_table_in_CSV_format() {

    }

    @Then("the user can download table in XLSX format")
    public void the_user_can_download_table_in_XLSX_format() {

    }

}