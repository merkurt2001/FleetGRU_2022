package com.eu6gr13.pages;

import com.eu6gr13.utilities.BrowserUtils;
import com.eu6gr13.utilities.ConfigurationReader;
import com.eu6gr13.utilities.Driver;
import com.eu6gr13.utilities.Screanshot;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

    public void rememberMeİsClickable() {
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

    public void fullLogin(String usertype) { // url ile birlikte login olmak için
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
        // invalid bilgilerle login olmak için kullanmamız gereken method  mustafa
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

    //Ugur Sıralı filtreleri tıklayarak seçme
    public void chooseFiltersByClick(List<String> selectedElms){
        for (String item : selectedElms) {
            WebElement a= Driver.get().findElement(By.xpath("//label[@title='"+item+"']/input"));
            a.click();
        }
    }

    //Ugur İşaretlenen filtrelerin seçildiğini teyit
    public void verifySelectedFiltersAreApplied(List<String> selectedElms) {
        String allText = "";
        for (WebElement filterElement : selectedFilterElements) {
            allText = allText + filterElement.getText();
        }

        for (String selectedElm : selectedElms) {
            Assert.assertTrue(allText.contains(selectedElm));
        }
    }

    //Ugur Filtre adını yazarak çekme
    public void chooseFilterByTypingName(String filterName) throws InterruptedException {
        //  filterSearchBox.sendKeys(filterName);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].setAttribute('value', '" + filterName +"')", filterSearchBox);
        WebElement a= Driver.get().findElement(By.xpath("//label[@title='"+filterName+"']/input"));
        a.click();
    }

    //   //Ugur adını yazdığın filtrenin secildiğini teyit
    public void verifyTypedFilterIsSelected (String filterName) {
        Assert.assertTrue(selectedFilterElements.get(0).getText().contains(filterName));
    }

    ////Ugur filterelin resetlendiğini kontrol etme
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
    //EMİR METHODS

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
}



