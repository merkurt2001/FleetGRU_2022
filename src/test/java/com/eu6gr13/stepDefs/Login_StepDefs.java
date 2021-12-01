package com.eu6gr13.stepDefs;

import com.eu6gr13.pages.Actions;
import com.eu6gr13.utilities.ConfigurationReader;
import com.eu6gr13.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
}
