package com.eu6gr13.pages;

import com.eu6gr13.utilities.BrowserUtils;
import com.eu6gr13.utilities.ConfigurationReader;
import com.eu6gr13.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Actions extends Locators {

    public void driverLogin(){
        usernameBox_Locator.sendKeys(ConfigurationReader.get("driver_username"));
        passwordBox_Locator.sendKeys(ConfigurationReader.get("driver_password"));
        loginButton.click();
    }


    public  void salesManagerLogin(){
        usernameBox_Locator.sendKeys(ConfigurationReader.get("salesmanager_username"));
        passwordBox_Locator.sendKeys(ConfigurationReader.get("salesmanager_password"));
        loginButton.click();
    }

    public  void  storeManagerLogin(){
        usernameBox_Locator.sendKeys(ConfigurationReader.get("storemanager_username"));
        passwordBox_Locator.sendKeys(ConfigurationReader.get("storemanager_password"));
        loginButton.click();
    }


    public void login(String username,String password){
        usernameBox_Locator.sendKeys(username);
        passwordBox_Locator.sendKeys(password);
        loginButton.click();
    }

    public void login(String userNameStr) {
        usernameBox_Locator.sendKeys(ConfigurationReader.get(userNameStr+"_username"));
        passwordBox_Locator.sendKeys(ConfigurationReader.get(userNameStr+"_password"));
        loginButton.click();
        BrowserUtils.waitFor(2);
        // verification that we logged
    }
    public void verifyLogin(){

        BrowserUtils.waitFor(2);
        String actualTitle=getPageSubTitle();

        if(actualTitle.equalsIgnoreCase("Dashboard")||actualTitle.equalsIgnoreCase("Quick Launchpad"))
            Assert.assertTrue(true);

        else Assert.assertTrue(false);
    }

    /**
     * @return page name, for example: Dashboard
     */
    public String getPageSubTitle() {
        //ant time we are verifying page name, or page subtitle, loader mask appears
        waitUntilLoaderScreenDisappear();
//        BrowserUtils.waitForStaleElement(pageSubTitle);
        return pageSubTitle_Locator.getText();
    }


    /**
     * Waits until loader screen present. If loader screen will not pop up at all,
     * NoSuchElementException will be handled  bu try/catch block
     * Thus, we can continue in any case.
     */
    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
            wait.until(ExpectedConditions.invisibilityOf(loaderMask_Locator));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getUserName_Locator(){
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(userName_Locator, 5);
        return userName_Locator.getText();
    }


    public void logOut(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(userName_Locator);
        BrowserUtils.clickWithJS(logOutLink_Locator);
    }
    public void goToMyUser(){
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(userName_Locator, 5).click();
        BrowserUtils.waitForClickablility(myUser_Locator, 5).click();

    }

    /**
     * This method will navigate user to the specific module in vytrack application.
     * For example: if tab is equals to Activities, and module equals to Calls,
     * Then method will navigate user to this page: http://qa2.vytrack.com/call/
     *
     * @param tab
     * @param module
     */
    public void navigateToModule(String tab, String module) {

        String tabLocator = "//span[normalize-space()='" + tab + "' and contains(@class, 'title title-level-1')]";
        //     String moduleLocator2 = "//span[@class='title title-level-1' and contains(text(),'"+ module + "')]";

        String moduleLocator = "//span[normalize-space()='" + module + "' and contains(@class, 'title title-level-2')]";
        //     String moduleLocator2 = "//span[@class='title title-level-2' and contains(text(),'"+ module + "')]";
        try {
            BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
            WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
            new org.openqa.selenium.interactions.Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
        }
        try {
            BrowserUtils.waitForPresenceOfElement(By.xpath(moduleLocator), 5);
            BrowserUtils.waitForVisibility(By.xpath(moduleLocator), 5);
            BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath(moduleLocator)));
            Driver.get().findElement(By.xpath(moduleLocator)).click();
        } catch (Exception e) {
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(moduleLocator)),  5);

        }

    }


    public void anyCar() {   //  random sayı ile car table dan herhangi bir car a tıklıyoruz.
        BrowserUtils.waitFor(5);
        WebElement element;

        Random random = new Random();
        int num = random.nextInt(tableRowCount_Locator.size())+1;
        if(num>0 && num<26){
            element= Driver.get().findElement(By.xpath("(//table/tbody/tr/td[2])["+num+"]"));
        }
        else{ element= Driver.get().findElement(By.xpath("(//table/tbody/tr/td[2])[3]")); }
        element.click();

    }

    public void verifyColorSelect(){   // add event pop up sayfasındaki color seçme methodu. tüm colorlara tıklayıp akabinde seçilimi kontrolü yapıyoruz.
        int counter=0;
        for (int i = 0; i< colors_Locator.size(); i++) {
            BrowserUtils.waitFor(1);

            JavascriptExecutor jse = (JavascriptExecutor ) Driver.get();
            jse.executeScript("arguments[0].click();", colors_Locator.get(i));

            if(!afterColor_Locator.isDisplayed()) {
                counter++;
            }
        }
        if(counter>0){
            Assert.assertTrue( false);
        }else
            Assert.assertTrue(true);
    }

    public void verifyRepeatOption(List<String> expectedList){  // "Daily", "Weekly", "Monthly", "Yearly" kelimelerini list string formatında alıyor

        WebElement dropdownelement = Driver.get().findElement(By.xpath("//select[@class='recurrence-repeats__select']"));
        BrowserUtils.waitForVisibility(dropdownelement,6);
        Select stateDropdown = new Select(dropdownelement);

        List<WebElement> options = stateDropdown.getOptions();

        List<String> actualInformation = new ArrayList<>();
        for(WebElement option : options){
            actualInformation.add(option.getText());
        }
        Assert.assertEquals(actualInformation,expectedList);

    }

    public void AfterByclickAbleCheck() {
        ;
        Assert.assertTrue(BrowserUtils.waitForVisibility(never_Locator,5).isDisplayed());
        Assert.assertTrue(BrowserUtils.waitForVisibility(after_Locator,5).isDisplayed());
        Assert.assertTrue(BrowserUtils.waitForVisibility(by_Locator,5).isDisplayed());

        JavascriptExecutor jse = (JavascriptExecutor ) Driver.get();

        Assert.assertTrue(never_Locator.isSelected());


        jse.executeScript("arguments[0].click();", after_Locator);

        BrowserUtils.waitForPageToLoad(5);
        Assert.assertTrue(after_Locator.isSelected());

        jse.executeScript("arguments[0].click();",BrowserUtils.waitForVisibility( by_Locator,5));

        Assert.assertTrue(by_Locator.isSelected());
    }

    public void repeatOptionClick() {
        BrowserUtils.waitForVisibility(repeatOptions_Locator,10);

        JavascriptExecutor jse = (JavascriptExecutor ) Driver.get();
        jse.executeScript("arguments[0].click();", repeatOptions_Locator);

        BrowserUtils.waitForPageToLoad(9);
    }
    public void repeatButtonClick() {

        BrowserUtils.waitForVisibility(repeat_Locator,10);
        JavascriptExecutor jse = (JavascriptExecutor ) Driver.get();
        jse.executeScript("arguments[0].click();", repeat_Locator);
        BrowserUtils.waitForPageToLoad(9);
    }

    public void allDayEventButtonInWindowClick() {


        Assert.assertTrue(BrowserUtils.waitForVisibility(timeBox_Locator,10).isDisplayed());

        JavascriptExecutor jse = (JavascriptExecutor ) Driver.get();
        jse.executeScript("arguments[0].click();", allDayEvent_Locator);

        BrowserUtils.waitForPageToLoad(9);
    }

    public void verifyAddEventButton() {

        Assert.assertTrue(BrowserUtils.waitForVisibility(addEvent_Locator,6).isDisplayed());
    }
    public void addEventButtonClick() {

        BrowserUtils.waitForVisibility(addEvent_Locator,10).click();

    }
    public void verifyAddEventPageAccess() {

        Assert.assertTrue(BrowserUtils.waitForVisibility(
                addEventTitle_Locator,10).isDisplayed());
    }
    public void verifyTimeBoxesWillDisappear() {
        Assert.assertFalse(timeBox_Locator.isDisplayed());
    }
    public void verifyRepeatGroupsIsDisable() {

        Assert.assertTrue(BrowserUtils.waitForVisibility(repeatGroups_Locaator,10).isDisplayed());
    }
    public void addEventWindowTitleBoxAddText(String s) {


        BrowserUtils.waitForVisibility(addEventWindowTitleBox_Locator,10).sendKeys(s);
    }
    public void addEventWindowSaveButtonClick() {
        BrowserUtils.waitFor(3);
        BrowserUtils.waitForVisibility(addEventWindowSaveButton_Locator,10).click();

    }
    public void verifyEventsInformation() {
        Assert.assertTrue( BrowserUtils.waitForVisibility(afterSaveButtonTitleCheckInGeneralInformation_Locator,10).isDisplayed());
    }



    /**
     *US-010 Grid Settings-method blocks
     * Assignee : Fatih
     */
    public void clickGearIcon(){
        //  BrowserUtils.waitForVisibility(gearIcon_Locator,15).click();
        BrowserUtils.waitFor(5);
        gearIcon_Locator.click();
        BrowserUtils.waitFor(2);
    }

    public void gridSettingsTitleIsDisplayed(){
        BrowserUtils.verifyElementDisplayed(gridSettings_Title_Locator);
    }

    public void matchColumnTitle(List<String> expectedColName){
        BrowserUtils.waitFor(5);
        Assert.assertEquals("NOT match",expectedColName,BrowserUtils.getElementsText(gridSettings_ColumnTitle_locator));
        System.out.println("expectedColName = " + expectedColName);
        System.out.println("actualColNames = " + BrowserUtils.getElementsText(gridSettings_ColumnTitle_locator));
        BrowserUtils.waitFor(3);
    }
    public void enterQuickSearch(String enterColumnName){
        BrowserUtils.waitFor(5);
        gridSettings_QuickSearch_Locator.sendKeys(enterColumnName);
    }

    public void matchColumnFilter(String expectedColumnName){
        Assert.assertEquals("Does NOT match", expectedColumnName, columnFilter_Match_Locator.getText());

    }

    /**
     *US-010 Grid Settings-method blocks
     * Assignee : Fatih
     */


}


