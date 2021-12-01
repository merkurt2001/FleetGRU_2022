package com.eu6gr13.stepDefs;

import com.eu6gr13.pages.Actions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class DeleteCar_StepDefs extends Actions {

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String user) {
        loginSuat(user);
    }

    @When("the user navigates to {string} to {string}")
    public void the_user_navigates_to_to(String tab, String module) {
        navigateToModule(tab,module);
    }

    @When("the title contains {string}")
    public void the_title_contains(String contain) {
        verifyModule(contain);
    }

    @Then("each users must see over the three dots at the end of each row")
    public void each_users_must_see_over_the_three_dots_at_the_end_of_each_row() {
        verifyVisibleRandomThreeDot();

    }

    @Then("each user must hovering over the three dots at the end of any rows")
    public void each_user_must_hovering_over_the_three_dots_at_the_end_of_any_rows() {
        hoverRandomThreeDot();
    }

    @Then("all users can see the delete button  at the end of each row")
    public void all_users_can_see_the_delete_button_at_the_end_of_each_row() {
        navigateToDelete();
    }


    @Then("click delete button")
    public void click_delete_button() {
        clickDelete();
    }

    @Then("all user should see {string} on pop")
    public void all_user_should_see_on_pop(String title) {
        verifyAlertText(title);
    }

    @Then("all user should click Yes, Delete on pop")
    public void all_user_should_click_Yes_Delete_on_pop() {
        yesAlert();
    }

    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> menuOptions) {
        verifyOptions(menuOptions);
    }

    @Then("users should see {string} massage")
    public void users_should_see_massage(String massage) {
        verifyAssertMassage(massage);
    }

    @Then("check total records before delete")
    public void check_total_records_before_delete() {
        beforeDeleteRecords();
    }

    @Then("check total records after delete")
    public void check_total_records_after_delete() {
        afterDeleteRecords();
    }

    @Then("total records after deletion must be one less than records before deletion")
    public void total_records_after_deletion_must_be_one_less_than_records_before_deletion() {
        verifyDeleteRecords();
    }

    @Then("clicking on any vehicle-row")
    public void clicking_on_any_vehicle_row() {
        selectAnyCar();
    }

    @Then("verify the {string} page")
    public void verify_the_page(String expectedTitle) {
        verifyGetTitlePage(expectedTitle);
    }


}
