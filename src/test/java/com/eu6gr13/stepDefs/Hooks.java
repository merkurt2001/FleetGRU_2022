package com.eu6gr13.stepDefs;

import com.eu6gr13.pages.Actions;
import com.eu6gr13.utilities.BrowserUtils;
import com.eu6gr13.utilities.ConfigurationReader;
import com.eu6gr13.utilities.Driver;
import com.eu6gr13.utilities.Screanshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks extends Actions {

    @Before
    public void setUp(){

        Driver.get().manage().window().maximize();
       // Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @Before("@Driver")
    public void loginasDriver(){
        Driver.get().get(ConfigurationReader.get("url"));
        driverLogin();
        BrowserUtils.waitForPageToLoad(5);
    }
    @Before("@SalesManager")
    public void loginasSalesManager(){
        Driver.get().get(ConfigurationReader.get("url"));
        salesManagerLogin();
        BrowserUtils.waitForPageToLoad(5);
    }
    @Before("@StoreManager")
    public void loginasStoreManager(){
        Driver.get().get(ConfigurationReader.get("url"));
        storeManagerLogin();
        BrowserUtils.waitForPageToLoad(5);
    }

    @Before
    public void setUpScenario(Scenario scenario){
        Screanshot.message = scenario;
    }


    //each steps after screenshot
    // @AfterStep
    //public void screenShot(Scenario step){
    //final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
    //step.attach(screenshot,"image/png",step.getName());}

    @After
    public void tearDown(Scenario scenario){

        //  if(scenario.isFailed()){
        final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png","Last Step Screenshot");
        // }
        try {
            closeButton.click();
        } catch(NoSuchElementException e){
            System.out.println("");
        }

        Driver.closeDriver();

    }

}


