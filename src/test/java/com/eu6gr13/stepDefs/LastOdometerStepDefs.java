package com.eu6gr13.stepDefs;

import com.eu6gr13.pages.Actions;
import com.eu6gr13.utilities.BrowserUtils;
import com.eu6gr13.utilities.Screanshot;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class LastOdometerStepDefs extends Actions {

    @When("the user navigates to {string} to {string}")
    public void the_user_select_from_the_top_bar(String string, String string2) {
        BrowserUtils.waitFor(3);
        navigateToModule(string,string2);
        BrowserUtils.waitFor(5);
    }

    @When("the user click the Filter button")
    public void the_user_click_the_Filter_button() {
        clickFilterBtn();

    }
    @When("the user click Manage Filter")
    public void the_user_click_Manage_Filter() {
       manageFiltersButton_Locator.click();
    }
    @Then("the user select {string} filter")
    public void the_user_select_filter(String item) {

       selectFilter(item);
    }

    @Then("the user click {string} box")
    public void the_user_click_box(String string) {
       getFiltersItemControlBox(string).click();
        Screanshot.takeScreenShot();
    }

    @Then("the user click choose button")
    public void the_user_click_choose_button() {
        FiltersItemControlBoxFirstElement_Locator.click();
    }

    @Then("content of list should have to following  types")
    public void content_of_list_should_have_to_following_types(List<String> expectedList) {
        List<String> actualList=BrowserUtils.getElementsText(FiltersItemControlBoxAllElement_Locator);

        Assert.assertEquals(expectedList,actualList);
    }
    @Then("user selects {string} method")
    public void user_selects_method(String string) {
       userSelectMethod(string);
    }

    @Then("the user enters start value {string} end value {string}")
    public void the_user_enters_start_value_end_value(String string, String string2) {
        BetweenStartInputBox_Locator.sendKeys(string);
        BetweenEndInputBox_Locator.sendKeys(string2);
        Screanshot.takeScreenShot();
    }
    @Then("click the Update button")
    public void click_the_Update_button() {
     BetweenUpdateButton_Locator.click();
     BrowserUtils.waitFor(2);
    }
    @Then("results table should only show Last Odometer between {string} to {string}")
    public void results_table_should_only_show_Last_Odometer_between_to(String string, String string2) {
       betweenMethod(string, string2);

    }

    @Then("the user enters value {string}")
    public void the_user_enters_value(String string) {
        BetweenStartInputBox_Locator.sendKeys(string);
        Screanshot.takeScreenShot();
    }

    @Then("All the results should match {string} exactly")
    public void all_the_results_should_match_exactly(String string) {
       resultMatchMethod(string);
    }

    @Then("All the results should be more than {string} value")
    public void all_the_results_should_be_more_than_value(String string) {
     resultMoreThanMethod(string);

    }
    @Then("All the results should be less than {string} value")
    public void all_the_results_should_be_less_than_value(String string) {
       resultLessThanMethod(string);
    }
    @Then("only empty values should be displayed")
    public void only_empty_values_should_be_displayed() {
       emptyValuesMethod();
    }

    @Then("click the Update button and result table should not change")
    public void click_the_Update_button_and_result_table_should_not_change() {
       resultTableNotChangeMethod();
    }

}


