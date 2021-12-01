package com.eu6gr13.stepDefs;

import com.eu6gr13.pages.Actions;
import com.eu6gr13.utilities.Screanshot;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class FleetVehicle_StepDefs extends Actions {

    @Given("the user navigates to {string} {string}")
    public void the_user_navigates_to(String string, String string2) {navigateToModule(string,string2);}

    @Given("click on the any vehicle")
    public void click_on_the_any_vehicle() { anyCar(); }

    @When("The user clickable Add Event button")
    public void the_user_clickable_Add_Event_button() { verifyAddEventButton();}

    @When("the user click Add Event button")
    public void the_user_click_Add_Event_button() { addEventButtonClick();}

    @Then("the user access Add Event Page")
    public void the_user_access_Add_Event_Page() { verifyAddEventPageAccess(); Screanshot.takeScreenShot();}

    @Then("the user select any color")
    public void the_user_select_any_color() { verifyColorSelect();}
    @When("the user click All day event button")
    public void the_user_click_All_day_event_button() { Screanshot.takeScreenShot(); allDayEventButtonInWindowClick();}

    @Then("click time boxes will disappear")
    public void click_time_boxes_will_disappear() {verifyTimeBoxesWillDisappear();}

    @When("the user click Repeat button")
    public void the_user_click_Repeat_button() { Screanshot.takeScreenShot(); repeatButtonClick();}

    @Then("Repeat groups is disable")
    public void repeat_groups_is_disable() { verifyRepeatGroupsIsDisable(); Screanshot.takeScreenShot();}

    @When("the user click Repeat options")
    public void the_user_click_Repeat_options() { Screanshot.takeScreenShot(); repeatOptionClick(); Screanshot.takeScreenShot();}

    @Then("Daily, Weekly, Monthly, Yearly is disable")
    public void daily_Weekly_Monthly_Yearly_is_disable(List<String> str) { verifyRepeatOption(str);}

    @Then("Never,After,By is disable and clickable")
    public void never_After_By_is_disable_and_clickable() { AfterByclickAbleCheck();}

    @When("the user writes {string} in the title")
    public void the_user_writes_in_the_title(String str) { addEventWindowTitleBoxAddText(str); Screanshot.takeScreenShot();}

    @When("the user click save button")
    public void the_user_click_save_button() { addEventWindowSaveButtonClick();}

    @Then("the user can see all events information")
    public void the_user_can_see_all_events_information() {verifyEventsInformation();}

}
