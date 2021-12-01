package com.eu6gr13.stepDefs;

import com.eu6gr13.pages.Actions;
import com.eu6gr13.utilities.ConfigurationReader;
import com.eu6gr13.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

//Ugur kısa login metod
public class FiltersMenuStepDefs extends Actions {
    @Given("the user is logged in as {string}")
    public void the_user_is_logged_in_as(String user) {
        Driver.get().get(ConfigurationReader.get("url"));
        salesManagerLogin();
        waitUntilLoaderScreenDisappear();
    }

    //Ugur istenen modlu giden step
    @Given("the user is on the {string} {string} page")
    public void the_user_is_on_the_page(String tab, String module) throws InterruptedException {
        navigateToModule(tab, module);
    }

    //Ugur Filter butona basma
    @Given("the user cliks on filter icon")
    public void the_user_cliks_on_filter_icon() throws InterruptedException {
        waitUntilLoaderScreenDisappear();
        clickOnFilterIcon();
    }

    //Ugur Manage Filter butona basma
    @Given("the user clicks on Manage Filters button")
    public void the_user_clicks_on_Manage_Filters_button() throws InterruptedException {
        waitUntilLoaderScreenDisappear();
        manageFiltersButton.click();
    }

    //Ugur Manage filter visible kontrol etme
    @Then("Manage Filter button should be visible")
    public void manage_Filter_button_should_be_visible() {
        Assert.assertTrue(manageFiltersButton.isDisplayed());
    }

    //Ugur reset butonuna basma
    @When("the user clicks on reset button")
    public void the_user_clicks_on_reset_button() {
       clickOnResetButton();
    }

    //Ugur filterelin resetlendiğini kontrol etme
    @Then("all filters should be removed")
    public void all_filters_should_be_removed() {
       verifyNoFilterIsApplied();
    }

    //Ugur Sıralı filtreleri tıklayarak seçme
    @When("the user clicks on the following filters")
    public void the_user_clicks_on_the_following_filters(List<String> selectElms) {
        chooseFiltersByClick(selectElms);
    }

    //Ugur İşaretlenen filtrelerin seçildiğini teyit
    @Then("Verify the selected filters are")
    public void verify_the_selected_filters_are(List<String> selectedElms) {
        verifySelectedFiltersAreApplied(selectedElms);
    }

    //Ugur Filtre adını yazma
    @When("the user types filter name {string}")
    public void the_user_types_filter_name(String filterName) throws InterruptedException {
        chooseFilterByTypingName(filterName);
    }

    //Ugur adını yazdığın filtrenin secildiğini teyit
    @Then("Verify the {string} filter is selected")
    public void verify_the_filter_is_selected(String filterName) {
        verifyTypedFilterIsSelected(filterName);
    }



}
