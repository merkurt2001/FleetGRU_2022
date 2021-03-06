package com.eu6gr13.pages;

import com.eu6gr13.utilities.BrowserUtils;
import com.eu6gr13.utilities.ConfigurationReader;
import com.eu6gr13.utilities.Driver;
import com.eu6gr13.utilities.Screanshot;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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


    public void anyCar() {   //  random say?? ile car table dan herhangi bir car a t??kl??yoruz.
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

    public void verifyColorSelect(){   // add event pop up sayfas??ndaki color se??me methodu. t??m colorlara t??klay??p akabinde se??ilimi kontrol?? yap??yoruz.
        int counter=0;
        for (int i = 0; i< colors_Locator.size(); i++) {
            BrowserUtils.waitFor(1);

            JavascriptExecutor jse = (JavascriptExecutor ) Driver.get();
            jse.executeScript("arguments[0].click();", colors_Locator);

            if(!afterColor_Locator.isDisplayed()) {
                counter++;
            }
        }
        if(counter>0){
            Assert.assertTrue( false);
        }else
            Assert.assertTrue(true);
    }

    public void verifyRepeatOption(List<String> expectedList){  // "Daily", "Weekly", "Monthly", "Yearly" kelimelerini list string format??nda al??yor

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

    public void matchGridSettingsColumnTitle(List<String> expectedColName){
        BrowserUtils.waitFor(5);
        Assert.assertEquals("NOT match",expectedColName,BrowserUtils.getElementsText(gridSettings_ColumnTitle_locator));
        System.out.println("expectedColName = " + expectedColName);
        System.out.println("actualColNames = " + BrowserUtils.getElementsText(gridSettings_ColumnTitle_locator));
        BrowserUtils.waitFor(3);
    }
    public void enterGridSettingsQuickSearch(String enterColumnName){
        BrowserUtils.waitFor(5);
        gridSettings_QuickSearch_Locator.sendKeys(enterColumnName);
    }

    public void matchGridSettingsColumnFilter(String expectedColumnName){
        Assert.assertEquals("Does NOT match", expectedColumnName, columnFilter_Match_Locator.getText());

    }

    /**
     *US-010 Grid Settings-method blocks
     * Assignee : Fatih
     */
    //suat**********

    public void selectRandomRow(){
        Random random = new Random();
        int i = random.nextInt(carRows_Locator.size());
        carRows_Locator.get(i);
    }
    public void hoverRandomThreeDot(){
        Random random = new Random();
        BrowserUtils.waitFor(2);
        int i = random.nextInt(carRows_Locator.size());
        System.out.println(i);
        BrowserUtils.waitFor(2);

        String dotElement = "(//td[@class='action-cell grid-cell grid-body-cell'])["+i+"]";

        BrowserUtils.waitFor(2);
        //  BrowserUtils.waitForClickablility(carRowsThreeDot_Locator.get(i),5);
        WebElement webElement = Driver.get().findElement(By.xpath(dotElement));
        BrowserUtils.hover(webElement);
        if(deleteButton_Locator.isEnabled()){

        }else{
            BrowserUtils.waitFor(2);
            //BrowserUtils.waitForClickablility(carRowsThreeDot_Locator.get(i),5);
            carRowsThreeDot_Locator.get(i).click();
        }
    }

    public void verifyVisibleRandomThreeDot(){
        Random random = new Random();
        BrowserUtils.waitFor(3);
        int i = random.nextInt(carRows_Locator.size());
        BrowserUtils.waitFor(1);

        System.out.println("i = " + i);
        // BrowserUtils.waitForVisibility(carRows_Locator.get(i),4);
        Assert.assertTrue(carRowsThreeDot_Locator.get(i).isDisplayed());
    }

    public void navigateToDelete() {
        Random random = new Random();
        int i = random.nextInt(25);
        BrowserUtils.waitFor(2);
        if(deleteButton_Locator.isDisplayed()){

            String tabLocator = "(//tbody/tr/td[20])["+i+"]";

            String deleteLocator = "//tbody/tr[contains(text(),'Delete')]";
            try {
                BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
                WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
                new org.openqa.selenium.interactions.Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
            } catch (Exception e) {
                BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
            }
            try {
                BrowserUtils.waitForPresenceOfElement(By.xpath(deleteLocator), 5);
                BrowserUtils.waitForVisibility(By.xpath(deleteLocator), 5);
                BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath(deleteLocator)));
                Driver.get().findElement(By.xpath(deleteLocator));
            } catch (Exception e) {
                // BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(deleteLocator)),  5);

            }
        }else{
            carRowsThreeDot_Locator.get(i).click();
        }

    }

    public void loginSuat(String userType) {
        //go to login page
        Driver.get().get(ConfigurationReader.get("url"));
        //based on input enter that user information
        String username =null;
        String password =null;

        if(userType.equals("driver")){
            username = ConfigurationReader.get("driver_username");
            password = ConfigurationReader.get("driver_password");
        }else if(userType.equals("salesmanager")){
            username = ConfigurationReader.get("salesmanager_username");
            password = (ConfigurationReader.get("salesmanager_password"));
        }else if(userType.equals("storemanager")){
            username = ConfigurationReader.get("storemanager_username");
            password = ConfigurationReader.get("storemanager_password");
        }
        //send username and password and login
        login2(username,password);
    }

    public void  login3(String username,String password){  //Can't be static because; Web Elements can be static but not action
        usernameBox_Locator.sendKeys(username);
        passwordBox_Locator.sendKeys(password);
        loginButton.click();
    }

    public static void login2(String username, String password) {
        new Actions().login3(username, password);
    }

    public void clickDelete(){
//            Random random = new Random();
//            int i = random.nextInt(25);
//            BrowserUtils.waitFor(2);
//            String tabLocator = "(//tbody/tr/td[20])["+i+"]";
//
//            String deleteLocator = "//tbody/tr[contains(text(),'Delete')]";
//            try {
//                BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
//                WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
//                new org.openqa.selenium.interactions.Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
//            } catch (Exception e) {
//                BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
//            }
//            try {
//                BrowserUtils.waitForPresenceOfElement(By.xpath(deleteLocator), 5);
//                BrowserUtils.waitForVisibility(By.xpath(deleteLocator), 5);
//                BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath(deleteLocator)));
//                Driver.get().findElement(By.xpath(deleteLocator)).click();
//            } catch (Exception e) {
//                // BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(deleteLocator)),  5);
//
//            }
        deleteButton_Locator.click();
    }

    public void verifyAlertText(String title){

        BrowserUtils.waitFor(2);
        Assert.assertEquals(title,alertMassage_Locator.getText());
    }

    public void yesAlert(){
        yesDelete_Locator.click();
        BrowserUtils.waitFor(2);
    }

    public void verifyAssertMassage(String expectedMassage){
        String actualMassage = massage_Locator.getText();
        BrowserUtils.waitFor(2);
        Assert.assertEquals(expectedMassage,actualMassage);
    }

    public void verifyOptions(List<String> menuOptions){
        BrowserUtils.waitFor(5);
        List<String> actualOptions = BrowserUtils.getElementsText(menuOptions_Locators);
        //BrowserUtils.waitFor(3);
        Assert.assertEquals(actualOptions,menuOptions);
        System.out.println("menuOptions = " + menuOptions);
        System.out.println("actualOptions = " + actualOptions);
    }
int x;
    public int beforeDeleteRecords(){
        BrowserUtils.waitFor(2);
        String text = record_Locator.getText();
        String[] s = text.split(" ");
        BrowserUtils.waitFor(2);
        int recordNumber = Integer.parseInt(s[2]);
        System.out.println(recordNumber);
        x=recordNumber;
        return recordNumber;
    }

    public int afterDeleteRecords(){
        BrowserUtils.waitFor(4);
        String afterText = record_Locator.getText();
        String[] split = afterText.split(" ");
        BrowserUtils.waitFor(2);
        int afterRecordNumber = Integer.parseInt(split[2]);
        // String afterRecordNumber = split[2];

        System.out.println(afterRecordNumber);
        return afterRecordNumber;
    }

    public void verifyDeleteRecords(){
        BrowserUtils.waitFor(3);
        Assert.assertNotEquals(x,afterDeleteRecords());

    }

    public void verifyGetTitlePage(String expectedTitle){
        BrowserUtils.waitFor(3);
        String actualTitle = generalInformationPageTitle_Locator.getText();
        BrowserUtils.waitFor(1);
        System.out.println(actualTitle);
        System.out.println(expectedTitle);
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    public void selectAnyCar() {
        Random random = new Random();
        int randomRow = random.nextInt(carRows_Locator.size());
        BrowserUtils.waitFor(3);

        carRows_Locator.get(randomRow).click();
    }

    public void verifyModule(String Contain) {
        BrowserUtils.waitFor(3);
        System.out.println(getPageSubTitle());
        Assert.assertTrue(getPageSubTitle().contains(Contain));

        BrowserUtils.waitFor(4);
        Driver.get().findElement(By.xpath("//span[.='Driver']")).click();
        BrowserUtils.waitFor(2);
    }

    public void invalidInformation() {
        BrowserUtils.waitFor(2);
        Assert.assertEquals("Messages doesn't match", "Invalid user name or password.", invalidInformationText_Locator.getText());

    }

    public String alertTextEmpty() {
        BrowserUtils.waitFor(1);
        if (usernameBox_Locator.getAttribute("value").isEmpty()) {
            return usernameBox_Locator.getAttribute("validationMessage");
        } else if (passwordBox_Locator.getAttribute("value").isEmpty()) {
            return passwordBox_Locator.getAttribute("validationMessage");
        }
        return null;


    }

    public void clickForgetPass() {
        forgotYourPasswordLocator.click();
    }

    public void forgotPasswordPage() {
        Assert.assertEquals("https://qa.fleetgru.com/user/reset-request", Driver.get().getCurrentUrl());

    }

    public void rememberMeCheckBox() {

        Assert.assertTrue(rememberMeLocator.getSize().getHeight() != 0);
    }

    public void rememberMe??sClickable() {
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(rememberMeLocator);
        BrowserUtils.waitFor(2);
        Assert.assertTrue(rememberMeLocator.isSelected());

    }

    public void enterPassword(String password) {
        passwordBox_Locator.sendKeys(password);
        BrowserUtils.waitFor(3);
    }

    public void isBulletSigns(String password) {

        Assert.assertTrue(passwordBox_Locator.getAttribute("type").equals("password"));
    }

    public void loginWithEnterKey(String username, String password) {
        usernameBox_Locator.sendKeys(username);
        BrowserUtils.waitFor(1);
        passwordBox_Locator.sendKeys(password + Keys.ENTER);
        BrowserUtils.waitForPageToLoad(10);
    }

    public void nameCheck(String user, String name) {

        Assert.assertEquals(name, userName_Locator.getText());

    }

    public void fullLogin(String usertype) { // url ile birlikte login olmak i??in
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitForPageToLoad(10);
        login(usertype);
    }

    public void backMethod() {
        BrowserUtils.waitFor(3);
        Driver.get().navigate().back();
        BrowserUtils.waitForPageToLoad(10);
        Assert.assertEquals("https://qa.fleetgru.com/user/login", Driver.get().getCurrentUrl());
    }

    public void closeTab() {
//        Driver.get().manage().window().setPosition(new Point(990,0));
//        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//        String url = ConfigurationReader.get("url");
//        Driver.get().get(url);
//
//        new LoginPage().login("salesmanager101", "UserUser123");
//        new DashboardPage().waitUntilLoaderScreenDisappear();

        ((JavascriptExecutor) Driver.get()).executeScript("window.open('about:blank','_blank');");
        new WebDriverWait(Driver.get(), 3).until(ExpectedConditions.numberOfWindowsToBe(2));

        BrowserUtils.waitFor(3);

        ArrayList<String> tabs2 = new ArrayList<>(Driver.get().getWindowHandles());
        Driver.get().close();
        Driver.get().switchTo().window(tabs2.get(1));

        BrowserUtils.waitFor(3);

        Driver.get().get("https://qa.fleetgru.com/user/login");

        try {
            waitUntilLoaderScreenDisappear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BrowserUtils.waitForPageToLoad(15);
        Assert.assertEquals("https://qa.fleetgru.com/", Driver.get().getCurrentUrl());
        BrowserUtils.waitFor(3);

    }
    public void login22(String userName, String passWord) {
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.waitFor(4);
        usernameBox_Locator.sendKeys(userName);
        BrowserUtils.waitFor(1);
        passwordBox_Locator.sendKeys(passWord);
        BrowserUtils.waitFor(6);
        loginButton.click();
        BrowserUtils.waitFor(1);
        // invalid bilgilerle login olmak i??in kullanmam??z gereken method  mustafa
    }
    public void verifyGeneralInformationPage(){ //MURAT
        BrowserUtils.waitFor(3);
        Assert.assertTrue(generalInformationPage_Locator.isDisplayed());
    }

    public void clickAnyEyeIcon() {  //MURAT
        BrowserUtils.waitFor(5);

        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(Driver.get());

        Random random = new Random();
        int num = random.nextInt(any3dot_Locator.size()+1);

        try{
            actions.moveToElement(any3dot_Locator.get(num)).perform();
            BrowserUtils.waitFor(2);
            eyeIcon_Locator.click();
        }catch(Exception e) {
            actions.moveToElement(Driver.get().findElements(By.xpath("//table/tbody/tr/td[20]")).get(num)).perform();
            BrowserUtils.waitFor(2);
            eyeIcon_Locator.click();
        }
    }

    public void verifyEditDeleteAddEventButtons (String button){//MURAT
        BrowserUtils.waitFor(2);
        WebElement button_Locator = Driver.get().findElement(By.xpath("//a[contains(@title,'"+button+"')]"));
        Assert.assertTrue(button_Locator.isDisplayed());
    }

    public void verifyDriverEditDeleteAddEventButtons (String button){//MURAT

        BrowserUtils.waitFor(2);
        try{
            WebElement button_Locator = Driver.get().findElement(By.xpath("//a[contains(@title,'"+button+"')]"));
            Assert.assertFalse(button_Locator.isDisplayed());
        }catch(Exception e) {
            Assert.assertTrue(true);
        }
    }

    public void verifyGeneralInformationCarTable(){//MURATTTT

        BrowserUtils.waitFor(5);

        Random random = new Random();
        int num = random.nextInt(tableRowCount_Locator.size())+1;

        WebElement element = element= Driver.get().findElement(By.xpath("(//table/tbody/tr/td[2])["+num+"]"));


        List<String> carTable = BrowserUtils.getElementsText(By.xpath("//table/tbody/tr["+num+"]/td"));
        System.out.println("car.toString() = " + carTable.toString());

        element.click();

        BrowserUtils.waitFor(2);
        List<String> generalInf = BrowserUtils.getElementsText(By.xpath("//div[@class='controls']/div"));
        List<String> generalInformation = new ArrayList<>();

        for(int i=0; i< generalInf.size();i++){

            if (generalInf.get(i).equals("N/A")){
                generalInformation.add("");
            }else{
                generalInformation.add(generalInf.get(i));
            }
        }
        System.out.println("GI.toString() = " + generalInformation.toString());

        Assert.assertEquals(generalInformation, carTable);

    }



    //Ugur Filter butona basma
    public void clickOnFilterIcon() {
        waitUntilLoaderScreenDisappear();
        filterIcon.click();
    }

    //Ugur Manage Filter butona basma
    public void clickOnManageFilters() {
        waitUntilLoaderScreenDisappear();
        manageFiltersButton.click();
    }

    //Ugur S??ral?? filtreleri t??klayarak se??me
    public void chooseFiltersByClick(List<String> selectedElms){
        for (String item : selectedElms) {
            WebElement a= Driver.get().findElement(By.xpath("//label[@title='"+item+"']/input"));
            a.click();
        }
    }

    //Ugur ????aretlenen filtrelerin se??ildi??ini teyit
    public void verifySelectedFiltersAreApplied(List<String> selectedElms) {
        String allText = "";
        for (WebElement filterElement : selectedFilterElements) {
            allText = allText + filterElement.getText();
        }

        for (String selectedElm : selectedElms) {
            Assert.assertTrue(allText.contains(selectedElm));
        }
    }

    //Ugur Filtre ad??n?? yazarak ??ekme
    public void chooseFilterByTypingName(String filterName) throws InterruptedException {
        //  filterSearchBox.sendKeys(filterName);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].setAttribute('value', '" + filterName +"')", filterSearchBox);
        WebElement a= Driver.get().findElement(By.xpath("//label[@title='"+filterName+"']/input"));
        a.click();
    }

    //   //Ugur ad??n?? yazd??????n filtrenin secildi??ini teyit
    public void verifyTypedFilterIsSelected (String filterName) {
        Assert.assertTrue(selectedFilterElements.get(0).getText().contains(filterName));
    }

    ////Ugur filterelin resetlendi??ini kontrol etme
    public void verifyNoFilterIsApplied () {
        Assert.assertTrue(selectedFilterElements.size()==0);
    }

    //Ugur reset butonuna basma
    public void clickOnResetButton() {
        JavascriptExecutor jse = (JavascriptExecutor ) Driver.get();
        jse.executeScript("arguments[0].click();", resetButton);
    }
    public void ClickTheFilterButton() {
        BrowserUtils.waitFor(3);
        filterButton_Locator.click();
        BrowserUtils.waitFor(2);
    }

    public void ClickTheManageFilterButton() {
        BrowserUtils.waitFor(3);
        manageFiltersButton_Locator.click();
        BrowserUtils.waitFor(2);
    }

    public void clickAnyOptionOnManageFilterMenu(String option) {

        BrowserUtils.waitFor(3);
        WebElement anyOption = Driver.get().findElement(By.xpath("//input[@title = '" + option + "']"));

        anyOption.click();
        BrowserUtils.waitFor(2);
    }

    public void clickDriverLink() {

        BrowserUtils.waitFor(3);
        driverLink_Locator.click();
        BrowserUtils.waitFor(2);
    }

    public void clickContainsLink() {
        BrowserUtils.waitFor(3);
        containsLink_Locator.click();
        BrowserUtils.waitFor(2);
    }

    public List<String> createMethodList() {
        BrowserUtils.waitFor(3);
        return BrowserUtils.getElementsText(methods_Locator);
    }

    public void clickAnyMethod(String method) {
        BrowserUtils.waitFor(3);
        WebElement anyMethod = Driver.get().findElement(By.xpath("//a[contains(text(),'" + method.toLowerCase() + "')]"));
        anyMethod.click();
        BrowserUtils.waitFor(2);
    }

    public void sendKeysInputBox(String string) {
        BrowserUtils.waitFor(3);
        inputBox_Locator.sendKeys(string);
        BrowserUtils.waitFor(2);
    }

    public void clickUpdateButton() {
        BrowserUtils.waitFor(3);
        updateButton_Locator.click();
        BrowserUtils.waitFor(2);
    }

    public void verifyMethodsContain(String str) {
        BrowserUtils.waitFor(3);
        List<String> driverNames = BrowserUtils.getElementsText(driverNames_Locator);
        for (String name : driverNames) {
            Assert.assertTrue(name.toLowerCase().contains(str.toLowerCase()));
        }
        BrowserUtils.waitFor(2);
    }

    public void verifyMethodsDoesNotContain(String str) {
        BrowserUtils.waitFor(3);
        List<String> driverNames = BrowserUtils.getElementsText(driverNames_Locator);
        for (String name : driverNames) {
            Assert.assertFalse(name.toLowerCase().contains(str.toLowerCase()));
        }
        BrowserUtils.waitFor(2);
    }

    public void verifyMethodsStartsWith(String str) {
        BrowserUtils.waitFor(3);
        List<String> driverNames = BrowserUtils.getElementsText(driverNames_Locator);
        for (String driverName : driverNames) {

            Assert.assertEquals(driverName.substring(0, str.length()).toLowerCase(), str.toLowerCase());
        }
        BrowserUtils.waitFor(2);
    }

    public void verifyMethodsEndsWith(String str) {
        BrowserUtils.waitFor(3);
        List<String> driverNames = BrowserUtils.getElementsText(driverNames_Locator);
        for (String driverName : driverNames) {

            Assert.assertEquals(driverName.substring(driverName.length() - str.length()).toLowerCase(), str.toLowerCase());

        }
        BrowserUtils.waitFor(2);
    }

    public void verifyMethodsIsEqualTo(String str) {
        BrowserUtils.waitFor(3);
        List<String> driverNames = BrowserUtils.getElementsText(driverNames_Locator);
        for (String name : driverNames) {

            Assert.assertEquals(name.toLowerCase(), str.toLowerCase());
        }
        BrowserUtils.waitFor(2);
    }
    public void verifyNotAcceptNon_AlphabeticalCharacters(){
        BrowserUtils.waitFor(3);
        String actual = inputBox_Locator.getAttribute("value");
        String expected = "";

        Assert.assertTrue(expected.equals(actual));
        BrowserUtils.waitFor(2);
    }
    //EM??R METHODS

    public int totalItem(){
        String[] str=totalItem_Locator.getText().split(" ");
        int b=Integer.parseInt(str[2]);
        return b;
    }
    public List<String> allManageFiltersName(){
        List<String> allItem=new ArrayList<>();
        for(int i=0; i<allManageFiltersItem_Locator.size(); i++){
            allItem.add(allManageFiltersItem_Locator.get(i).getText());
        }
        return allItem;
    }

    public WebElement getManageFiltersItemCheckbox(String item){

        WebElement a= Driver.get().findElement(By.xpath("//label[@title='"+item+"']/input"));
        return a;
    }

    public WebElement getFiltersItemControlBox(String item){
        WebElement a= Driver.get().findElement(By.xpath("//div[contains(text(),'"+item+"')]"));
        return a;
    }
    public void clickFilterBtn() {
        if (!manageFiltersButton_Locator.isDisplayed()) {
            filterButton_Locator.click();
            BrowserUtils.waitFor(1);
        }
    }
    public void selectFilter(String item){
        if(!getManageFiltersItemCheckbox(item).isSelected()) {
            getManageFiltersItemCheckbox(item).click();
            BrowserUtils.waitFor(2);
            Assert.assertTrue(getManageFiltersItemCheckbox(item).isSelected());
        }
        else {
            getManageFiltersItemCheckbox(item).click();
            BrowserUtils.waitFor(2);
            Assert.assertFalse(getManageFiltersItemCheckbox(item).isSelected());
        }

        Screanshot.takeScreenShot();
    }
    public void userSelectMethod(String method){
        List<String> actualList=BrowserUtils.getElementsText(FiltersItemControlBoxAllElement_Locator);
        for(int i=0; i<actualList.size(); i++){

            if(actualList.get(i).equals(method)){
                FiltersItemControlBoxAllElement_Locator.get(i).click();
                break;
            }
        }
        Screanshot.takeScreenShot();
    }
    public void betweenMethod(String string, String string2){
        double start=Double.parseDouble(string.replace(",",""));
        double end=Double.parseDouble(string2.replace(",",""));

        for(WebElement a: LastOdometerTableColumn_Locator){
            if(start<=Double.parseDouble(a.getText().replace(",",""))&&end>=Double.parseDouble(a.getText().replace(",",""))){
                Assert.assertTrue(true);
            }
            else{Assert.assertTrue(false);}
        }
    }
    public void resultMatchMethod(String string){
        double equalitem = Double.parseDouble(string.replace(",",""));
        List<String> actualList = BrowserUtils.getElementsText(LastOdometerTableColumn_Locator);

        if (!actualList.isEmpty()) {
            for (WebElement a : LastOdometerTableColumn_Locator) {
                if (equalitem == Double.parseDouble(a.getText().replace(",",""))) {
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }
        }
        else {
            Assert.assertTrue(true);
        }
    }
    public void resultMoreThanMethod(String string){
        if(string.contains(",")) string.replace(",","");
        double item = Double.parseDouble(string);

        List<String> actualList = BrowserUtils.getElementsText(LastOdometerTableColumn_Locator);

        if (!actualList.isEmpty()) {
            for (WebElement a : LastOdometerTableColumn_Locator) {
                if (item < Double.parseDouble(a.getText().replace(",",""))) {
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }
        }
        else {
            Assert.assertTrue(true);
        }
    }
    public void resultLessThanMethod(String string){
        if(string.contains(",")) string.replace(",","");
        double item = Double.parseDouble(string);
        List<String> actualList=new ArrayList<>();
        for (String a  :BrowserUtils.getElementsText(LastOdometerTableColumn_Locator) ) {
            if(a.contains(",")) a.replace(",","");
            actualList.add(a);
        }

        if (!actualList.isEmpty()) {
            for (String a : actualList) {
                if (item > Double.parseDouble(a)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }
        }
        else {
            Assert.assertTrue(true);
        }
    }
    public void emptyValuesMethod(){
        List<String> actualList=BrowserUtils.getElementsText(LastOdometerTableColumn_Locator);

        if (!actualList.isEmpty()) {
            for (String a : actualList) {
                if (a.isEmpty()) {
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }
        }
        else {
            Assert.assertTrue(true);
        }
    }
    public void resultTableNotChangeMethod(){
        int total_first=totalItem();
        BetweenUpdateButton_Locator.click();
        BrowserUtils.waitFor(1);
        int total_last=totalItem();
        Assert.assertEquals(total_last,total_first);
    }

    /**      CONTINUE
     * US-010 Grid Settings-method blocks
     * Assignee : Fatih
     */
    public void selectAllGridSettings() {
        BrowserUtils.waitFor(2);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].click();", gridSettings_SelectAll_Locator);
        BrowserUtils.waitFor(2);
    }

    public void clickGridSettingsColumnName() {
        for (int i = 1; i <= gridSettings_ColumnName_locator.size(); i++) {
            Driver.get().findElement(By.xpath("//table/tbody/tr[" + i + "]//td/label")).click();
        }
        for (int i = gridSettings_ColumnName_locator.size(); i >= 1; i--) {
            Driver.get().findElement(By.xpath("//table/tbody/tr[" + i + "]//td/label")).click();
        }
    }

    public void isDisplayed_TableTitle_GridSettings() {
        for (int i = 1; i <= gridSettings_ColumnName_locator.size(); i++) {
            Assert.assertTrue(Driver.get().findElement(By.xpath("//th[starts-with(@class,'grid-cell')][" + i + "]//span[text()]")).isDisplayed());
        }
    }

    public void sortGridSettingsColumns() {
        selectAllGridSettings();
        for (int i = 2, k = 1; i <= gridSettings_Sort_Locator.size(); i++) {
            WebElement sourceGridSettingsColumn = Driver.get().findElement(By.xpath("(//tbody/tr//td//span[@title='Move column'])[" + i + "]"));
            WebElement targetGridSettingsColumn = Driver.get().findElement(By.xpath("(//tbody/tr//td//span[@title='Move column'])[" + k + "]"));
            new org.openqa.selenium.interactions.Actions(Driver.get()).clickAndHold(sourceGridSettingsColumn).moveToElement(targetGridSettingsColumn).release(targetGridSettingsColumn).build().perform();
            //System.out.println("target = " + k + " "  + Driver.get().findElement(By.xpath("//tbody/tr[@class='renderable']["+ k +"]/td/label")).getText());
            k++;
        }
    }

    public void checkSortGridSettings() {
        String actualTitleAfterSort = Driver.get().findElement(By.xpath("//tbody/tr[@class='renderable'][20]/td/label")).getText();
        System.out.println("actualTitleAfterSort = " + actualTitleAfterSort);
        System.out.println("expected= " + gridSettings_AfterSor_IdtTitle_locator.getText());
        Assert.assertEquals("sort Faild", gridSettings_AfterSor_IdtTitle_locator.getText(), actualTitleAfterSort);
    }

    public void gridSettingsChangeColumn() {
        selectAllGridSettings();
        for (int i = gridSettings_ColumnName_locator.size(); i >= 1; i--) {
            Driver.get().findElement(By.xpath("//table/tbody/tr[" + i + "]//td/label")).click();
        }

    }

    public void gridSettingsControlTableAllCars() {
        Assert.assertTrue(Driver.get().findElement(By.xpath("//th[starts-with(@class,'grid-cell')][1]//span[text()]")).isDisplayed());
    }

    /**
     * US-010 Grid Settings-method blocks
     * Assignee : Fatih
     */
    /*
    Yasin Actions Added Below
     */
    public void clickOnSomeVehicle(){
        Random r= new Random();
        if(r.nextInt(10)>5){
            nextPageButton.click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            vehicles= Driver.get().findElements(By.cssSelector("tr.grid-row"));
        }
        WebElement vehicleToBeClicked= vehicles.get(r.nextInt(vehicles.size())-1);
        driverInfo=vehicleToBeClicked.findElement(By.xpath(".//td[@data-column-label='Driver']")).getText();
        vehicleToBeClicked.click();
        BrowserUtils.waitForPageToLoad(5);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void LoginWithCredentials(String username, String password){
        usernameInputLocator.sendKeys(username);
        passwordInputLocator.sendKeys(password);
        loginButtonLocator.click();
    }

    public String returnAlert(){
        return alertTextLocator.getText();
    }
    public String returnEmptyAlert(){
        if(usernameInputLocator.getAttribute("value").isEmpty()){
            return usernameInputLocator.getAttribute("validationMessage");
        }else if (passwordInputLocator.getAttribute("value").isEmpty()){
            return passwordInputLocator.getAttribute("validationMessage");
        }
        return null;
    }

    public boolean rememberMeIsVisible() throws InterruptedException {
        return rememberMeLocator.getSize().getHeight()!=0;
    }
    public boolean rememberMeIsClickable() throws InterruptedException {
        BrowserUtils.clickWithJS(rememberMeLocator);
        return rememberMeLocator.isSelected();
    }




    public void loginWithEnter(String username, String password){
        usernameInputLocator.sendKeys(username);
        passwordInputLocator.sendKeys(password + Keys.ENTER);
    }

    public String getUserInfo(){
        BrowserUtils.waitForPageToLoad(5);
        return userInfo.getText();
    }
    public boolean isAddEventVisible(){
        BrowserUtils.waitForPageToLoad(5);
        return addEventButton.getSize().getWidth()!=0;
    }
    public boolean isAddEventClickable(){
        WebDriverWait wait=new WebDriverWait(Driver.get(), 10);
        return addEventButton.isDisplayed() && addEventButton.isEnabled();
    }
    public void clickAddEvent(){
        addEventButton.click();
        BrowserUtils.waitForPageToLoad(5);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String getMidHeader() {
        BrowserUtils.waitForPresenceOfElement(By.className("oro-subtitle"), 10);
        return middleTitleLocator.getText();
    }
    public String getName(){
        return nameLocator.getText();
    }
    public void LogOut(){
        nameLocator.click();
        logOutLocator.click();
    }


    public List<String> getCompulsoryFields(){
        System.out.println(required.get(0).getText());
        return required.stream().map(item -> item.getText().substring(0, item.getText().length()-1)).collect(Collectors.toList());
    }
    public boolean sendWithOnlyOneInput(String input){
        Driver.get().findElement(By.xpath("//input[contains(@name, \""+input+"\")]")).sendKeys("AutomatedTest");
        saveButton.click();
        try {
            Thread.sleep(2000);
            Driver.get().findElement(By.className("validation-failed"));
        } catch (NoSuchElementException | InterruptedException e){
            return false;
        }
        return true;
    }
    public boolean addEventPageOpens(){
        return addEventPopUp.isDisplayed();
    }

    public String navigateToModuleYasin(String menu, String subMenu) throws InterruptedException {
        Thread.sleep(4000);
        String menuLocatorPath="//span[normalize-space()=\""+menu+"\" and contains(@class, \"title-level-1\")]";
        String subMenuLocatorPath="//span[normalize-space()=\""+subMenu+"\" and contains(@class, \"title-level-2\")]";

        Driver.get().findElement(By.xpath(menuLocatorPath)).click();
        Driver.get().findElement(By.xpath(subMenuLocatorPath)).click();
        BrowserUtils.waitForPageToLoad(5);
        Thread.sleep(5000);
        return Driver.get().getCurrentUrl();
    }
    /**
     * US-010 Grid Settings-method blocks
     * Assignee : Fatih
     */
    int a;
    public void enterGridSettingsQuickSearchBox(List<String> enterColumnName){
        a=0;
        for (int i = 0; i < enterColumnName.size(); i++) {
            BrowserUtils.waitFor(1);
            gridSettings_QuickSearch_Locator.sendKeys(enterColumnName.get(i));

            System.out.println("girilen de??er "+enterColumnName.get(i));
            System.out.println("c??kan de??er"+columnFilter_Match_Locator.getText());
            if(!enterColumnName.get(i).equals(columnFilter_Match_Locator.getText())){
                a++;}
            gridSettings_QuickSearch_Locator.clear();
        }

    }
    public void matchGridSettingsColumnFilterControl(){
        System.out.println("a : "+a);
        if(a==0)
            Assert.assertTrue("Does NOT match", true);
        else Assert.assertTrue(false);

    }
    /**
     * US-010 Grid Settings-method blocks
     * Assignee : Fatih
     */

    public void verifyForwardButton(){
BrowserUtils.waitForVisibility(pageNumber_locator,5);
        int firstNumber = Integer.parseInt(pageNumber_locator.getAttribute("value"));
        forwardNumber_locator.click();
        BrowserUtils.waitForPageToLoad(10);
        int secondNumber = Integer.parseInt(pageNumber_locator.getAttribute("value"));

        Assert.assertEquals(secondNumber, firstNumber + 1);
        BrowserUtils.waitFor(2);


    }

    public void verifyBackButton(){


        BrowserUtils.waitForVisibility(pageNumber_locator,5);
        int firstNumber = Integer.parseInt(pageNumber_locator.getAttribute("value"));
        backwardNumber_locator.click();
        BrowserUtils.waitForPageToLoad(10);
        int secondNumber = Integer.parseInt(pageNumber_locator.getAttribute("value"));

        Assert.assertEquals(secondNumber, firstNumber - 1);
    }
    public void verifyCSVDownload(){
        BrowserUtils.waitFor(1);
        CSV_download_locator.click();
        //System.out.println("table.downloadMessage.getText() = " + table.downloadMessage.getText());
        BrowserUtils.waitFor(2);
        Assert.assertTrue(downloadMessage.isDisplayed());


    }

    public void verifyXLSDownload(){

        exportGrid_locator.click();

        BrowserUtils.waitFor(1);
        XLSX_download_locator.click();
        BrowserUtils.waitFor(2);
        //System.out.println("table.downloadMessage.getText() = " + table.downloadMessage.getText());
        Assert.assertTrue(downloadMessage.isDisplayed());
    }

    /*SAffet Actions*/

    public void viewPerPageButton_isDisplayed() {
        BrowserUtils.waitFor(3);
        viewPerpagebuttonLocator.isDisplayed();
    }

    public void defaultValueOfPerPage(int number) {
        BrowserUtils.waitFor(5);
        Assert.assertEquals(number, Integer.parseInt(viewPerpagebuttonLocator.getText()));


    }

    public void viewPerPageButton_click() {
        BrowserUtils.waitFor(3);
        JavascriptExecutor executor = (JavascriptExecutor) Driver.get();
        executor.executeScript("arguments[0].click();", viewPerpagebuttonLocator);
    }

    public void viewPerPageContent_match(List<String> data) {
        for (int i = 0; i < data.size(); i++) {
            Assert.assertEquals(data.get(i), numbers_locator.get(i).getText());

        }
    }

    public void viewPerPage_ArrangeRows(String num) {
        getNumbersLocator(num).click();
        BrowserUtils.waitFor(3);
        Assert.assertEquals(num, viewPerpagebuttonLocator.getText());

    }

    public void viewPerPage_ModelYear() {
        BrowserUtils.waitFor(3);
        JavascriptExecutor executor = (JavascriptExecutor) Driver.get();
        executor.executeScript("arguments[0].click();", modelYearLocator);

    }

    public void viewPerPage_SortColumn() {

        BrowserUtils.waitFor(4);
        button_locator.click();
        BrowserUtils.waitFor(4);
        buttonDropdown_Locator.get((buttonDropdown_Locator.size()) - 1).click();
        BrowserUtils.waitFor(4);

        List<String> list = getTableTitle_item("Model Year");
        if (totalTablePage() > 1) {
            for (int i = 1; i < totalTablePage(); i++) {
                BrowserUtils.waitFor(2);
                tableRightButton_Locator.click();
                BrowserUtils.waitFor(2);
                list.addAll(getTableTitle_item("Model Year"));
                BrowserUtils.waitFor(1);
            }
        }

        List<String> listAfterOrderExpected = new ArrayList<>();
        listAfterOrderExpected.addAll(list);
        Collections.sort(listAfterOrderExpected);


        Assert.assertEquals(list, listAfterOrderExpected);
    }

    public void viewPerPage_ResetButton() {
        BrowserUtils.waitFor(3);
        resetButton_Locator.click();
        BrowserUtils.waitFor(3);

    }

    public void viewPerPage_Remove() {
        for (WebElement a : spanCaret_Locator) {
            Assert.assertFalse(a.isDisplayed());
        }

    }

    public int totalTablePage() {
        String[] a = pageSizeText_Locator.getText().trim().split(" ");
        return Integer.parseInt(a[1]);
    }

    public List<String> getTableTitle_item(String item) {
        List<String> list = new ArrayList<>();

        for (int i = 1; i < tablerowCount_Locator.size() + 1; i++) {

            if (Driver.get().findElement(By.xpath("(//tbody/tr[@class='grid-row'])["+i+"]//td[@data-column-label='Model Year']")).getText().isEmpty())
                list.add(" ");
            else
                list.add(Driver.get().findElement(By.xpath("(//tbody/tr[@class='grid-row'])["+i+"]//td[@data-column-label='Model Year']")).getText());
        }
        return list;
    }


    public WebElement getNumbersLocator(String item) {

        for (WebElement webElement : numbers_locator) {
            if (webElement.getText().equals(item)) {
                return webElement;

            }


        }
        return null;
    }
    /*SAffet Actions     */
}








