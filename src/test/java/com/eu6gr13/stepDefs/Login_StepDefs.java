package com.eu6gr13.stepDefs;

import com.eu6gr13.pages.Actions;
import com.eu6gr13.utilities.BrowserUtils;
import com.eu6gr13.utilities.ConfigurationReader;
import com.eu6gr13.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefs extends Actions {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() { Driver.get().get(ConfigurationReader.get("url"));}

    @When("the user enters the {string} information")
    public void the_user_enters_the_information(String user) { login(user);}

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() { verifyLogin();
    }

    @When("the user enter the {string} information")
    public void the_user_enter_the_information(String user) { login(user);}


    @When("the user enters the invalid {string} valid {string} information")
    public void the_user_enters_the_invalid_valid_information(String user, String password) {
        login22(user,password);
    }

    @Then("Users should see Invalid Username or Password message")
    public void users_should_see_Invalid_Username_or_Password_message() {
        invalidInformation();
    }

    @When("the user enters the valid {string} invalid {string} information")
    public void the_user_enters_the_valid_invalid_information(String user, String password) {
        login22(user,password);
    }


    @Then("Warning message should be displayed in the relevant field")
    public void warning_message_should_be_displayed_in_the_relevant_field() {
        Assert.assertEquals("Please fill out this field.",alertTextEmpty());
    }

    @When("the user enters the  {string} and {string} information")
    public void the_user_enters_the_and_information(String user, String password) {
        login2(user,password);
    }

    @When("Users click on forgot your password button")
    public void users_click_on_forgot_your_password_button() {
        clickForgetPass();
        BrowserUtils.waitFor(2);
    }

    @Then("Users land on Forgot Password Page")
    public void users_land_on_Forgot_Password_Page() {
        forgotPasswordPage();
    }

    @Then("Users can see Remember me checkbox")
    public void users_can_see_Remember_me_checkbox() {
        rememberMeCheckBox();
    }

    @Then("Users can click on Remember me checkbox")
    public void users_can_click_on_Remember_me_checkbox() {
        rememberMeİsClickable();
    }

    @When("Users enter their {string}")
    public void users_enter_their(String passWord) {
        enterPassword(passWord);
    }

    @Then("they should see the {string} as bullet points")
    public void they_should_see_the_as_bullet_points(String string) {
        isBulletSigns(string);
    }

    @When("{string} enters {string} and hit the Enter key")
    public void enters_and_hit_the_Enter_key(String username, String password) {
        loginWithEnterKey( username,  password);
    }

    @Then("{string} should see {string}")
    public void should_see(String usertype, String resultpage) {
        Assert.assertEquals(resultpage,getPageSubTitle());

    }

    @Then("{string} should see his-her {string}")
    public void should_see_his_her(String usertype, String name) {
        nameCheck(usertype,name);
    }

    @Given("users successfully logged in to the application with {string}")
    public void users_successfully_logged_in_to_the_application_with(String usertype) {
        fullLogin(usertype);
    }

    @When("users clicks log out button on the top menu")
    public void users_clicks_log_out_button_on_the_top_menu() {
        logOut();
    }

    @Then("Users are on the login page")
    public void users_are_on_the_login_page() {
        BrowserUtils.waitFor(15);
        Assert.assertEquals("https://qa.fleetgru.com/user/login", Driver.get().getCurrentUrl());
    }

    @Then("Users can't login back to the application by clicking return button")
    public void users_can_t_login_back_to_the_application_by_clicking_return_button() {
        backMethod();
    }

    @When("Users close the tab where application is open")
    public void users_close_the_tab_where_application_is_open() {
        closeTab();
    }

    @Then("Users are succesfully logged out and need to login again")
    public void users_are_succesfully_logged_out_and_need_to_login_again() {
        Assert.assertEquals("https://qa.fleetgru.com/", Driver.get().getCurrentUrl());
    }


}