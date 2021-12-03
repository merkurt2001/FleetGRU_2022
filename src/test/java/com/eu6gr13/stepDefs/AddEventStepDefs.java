package com.eu6gr13.stepDefs;

import com.eu6gr13.pages.Actions;

import com.eu6gr13.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AddEventStepDefs extends Actions {

    @When("users navigate to {string} and then {string}")
    public void users_navigate_to_and_then(String menu, String submenu) throws InterruptedException {
        navigateToModuleYasin(menu, submenu);
    }

    @Then("users can see {string} page")
    public void users_can_see_page(String title) {
        Assert.assertEquals("https://qa.fleetgru.com/entity/Extend_Entity_Carreservation", Driver.get().getCurrentUrl());
    }
    @When("users click on any vehicle")
    public void users_click_on_any_vehicle() {
        clickOnSomeVehicle();
    }

    @Then("users will see specific car page")
    public void users_will_see_specific_car_page() {
        Assert.assertTrue(getUserInfo().contains(Actions.driverInfo));
    }

    @Then("Drivers can't see addEvent button")
    public void drivers_can_t_see_addEvent_button() {
        Assert.assertEquals(false, isAddEventVisible());
    }
    @Then("Users can see addEvent button")
    public void users_can_see_addEvent_button() {
        Assert.assertTrue(isAddEventVisible());
    }

    @Then("Users can click on addEvent button")
    public void users_can_click_on_addEvent_button() {
        Assert.assertTrue(isAddEventClickable());
    }
    @When("Users clicked on addEvent button")
    public void users_clicked_on_addEvent_button() {
        clickAddEvent();
    }

    @Then("Compulsory Fields must be shown")
    public void compulsory_Fields_must_be_shown(List<String> fields) {
        Assert.assertEquals(fields, getCompulsoryFields());
    }
    @Then("Users shouldnt save event by only filling out {string}")
    public void users_shouldnt_save_event_by_only_filling_out(String string) {
        Assert.assertEquals(true, sendWithOnlyOneInput(string));
    }
    @Then("AddEvent Page opens")
    public void addevent_Page_opens() {
        Assert.assertTrue(addEventPageOpens());
    }





}
