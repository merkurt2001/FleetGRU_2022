package com.eu6gr13.pages;

import com.eu6gr13.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Locators {
    public Locators() {
        PageFactory.initElements(Driver.get(), this);  }
    // PageFactory.initElements(driver, pageObjectClass) implicitly creates the findElement calls behind the scene.
    // PageFactory.initElements() only creates proxies for variables marked with annotations @FindBy,@FindAll

    @FindBy(id="prependedInput")
    public  WebElement usernameBox_Locator;

    @FindBy(id="prependedInput2")
    public  WebElement passwordBox_Locator;

    @FindBy(id="_submit")
    public WebElement loginButton;

    @FindBy(css = "div[class='loader-mask shown']")
    @CacheLookup
    protected WebElement loaderMask_Locator;
    //@CacheLookup, as the name suggests helps us control when to cache a WebElement
    //and when not to. This annotation, when applied over a WebElement, instructs Selenium
    //to keep a cache of the WebElement instead of searching for the WebElement every time
    //from the WebPage. This helps us save a lot of time.

    @FindBy(css = "h1[class='oro-subtitle']")
    public WebElement pageSubTitle_Locator;

    @FindBy(css = "#user-menu > a")
    public WebElement userName_Locator;

    @FindBy(linkText = "Logout")
    public WebElement logOutLink_Locator;

    @FindBy(linkText = "My User")
    public WebElement myUser_Locator;
    @FindBy(xpath = "//a[@title='Add an event to this record']")
    public WebElement addEvent_Locator; //add event butonunun locatorı

    @FindBy(xpath = "//span[text()='Add Event']")
    public WebElement addEventTitle_Locator;  // add event içinde ki add event yazısına ait locator

    @FindBy(xpath = "//span[@role='button']")
    public List<WebElement> colors_Locator;  // add event pop up sayfası içide ki color locator. click yapmadan önce

    @FindBy(xpath = "//span[@role='button' and @data-selected]")// add event pop up sayfası içide ki color locator. click yaptıktan sonra
    public WebElement afterColor_Locator;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")// add event popup sayfasında ki all_day event box
    public WebElement allDayEvent_Locator;

    @FindBy(xpath = "(//input[@class='input-small timepicker-input end ui-timepicker-input'])")// add event popup sayfasında ki timebox
    public WebElement timeBox_Locator;

    @FindBy(xpath = "(//input[@type='checkbox'])[3]")// add event popup sayfasında ki repeat box
    public WebElement repeat_Locator;

    @FindBy(xpath = "//div[@data-name='recurrence-settings']") //after click repeatbox groups locator
    public WebElement repeatGroups_Locaator;

    @FindBy(xpath = "(//div[@class='selector input-widget-select'])[1]")// after click repeatgroups locator options locator
    public WebElement repeatOptions_Locator;

    @FindBy(xpath = "(//input[@type='radio'])[3]") // add event popup sayfasınfa ki box
    public WebElement never_Locator;

    @FindBy(xpath = "(//input[@type='radio'])[4]") // add event popup sayfasınfa ki box
    public WebElement after_Locator;

    @FindBy(xpath = "(//input[@type='radio'])[5]")// add event popup sayfasınfa ki box
    public WebElement by_Locator;

    @FindBy(xpath = "//div[@class='container-fluid accordion']")
    public WebElement allEvents_Locator;  // herhangi bir cara tıkladıktn sonra sayfanın en altında kalan activity bölümü locatorı

    @FindBy(xpath = "//table/tbody/tr/td[2]")
    public List<WebElement> tableRowCount_Locator; //tablo nun satır sayısını bulmak için yazılmış bir locator

    @FindBy(xpath = "(//div[@class='controls']/input)[1]") //açılan add events penceresinin title box'ı
    public WebElement addEventWindowTitleBox_Locator;

    @FindBy(xpath = "//button[@class='btn btn-primary']") //açılan add events penceresinin save butonu
    public WebElement addEventWindowSaveButton_Locator;

    @FindBy(xpath = "//div[@class='message-item message']/strong") // save yapıldıktan sonra general information sayfasının altında çıkan title
    public WebElement afterSaveButtonTitleCheckInGeneralInformation_Locator;

    /**
     *US-010 Grid Settings-locators
     * Assignee : Fatih
     */
    @FindBy(xpath= "//a[@title='Grid Settings']")
    public WebElement  gearIcon_Locator;

    @FindBy(xpath = "//div[text()='Grid Settings']")
    public WebElement gridSettings_Title_Locator;

    @FindBy(className= ".pull-right.disabled")   //
    public WebElement gridSettings_SelectAll_Locator;

    @FindBy(xpath = "(//tbody/tr//td[@class='title-cell'])")
    public List<WebElement> gridSettings_ColumnTitle_locator;

    @FindBy(xpath = "//tbody/tr/td/label")
    public List<WebElement> gridSettings_ColumnName_locator;

    @FindBy(xpath = "//input[@data-role='column-manager-search']")
    public WebElement gridSettings_QuickSearch_Locator;

    @FindBy(xpath = "//span[@class='column-filter-match']")
    public WebElement columnFilter_Match_Locator;

    @FindBy(xpath = "(//tbody/tr//td//span[@title='Move column'])")
    public List<WebElement> gridSettings_Sort_Locator;

    @FindBy(xpath = " //tbody/tr/td[@class='visibility-cell']/input[@type='checkbox']")
    public List<WebElement> gridSettings_Checkbox_locator;

    @FindBy(xpath = "//span[@class='grid-header-cell__label']")
    public List<WebElement> grid_HeaderCell_Locator;

    /**
     *US-010 Grid Settings-locators
     * Assignee : Fatih
     */



}
