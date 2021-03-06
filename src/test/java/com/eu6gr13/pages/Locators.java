package com.eu6gr13.pages;

import com.eu6gr13.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
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

    @FindBy(xpath= "//div[@class='column-manager-actions']/a")
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

    @FindBy(xpath = "//tbody/tr/td/label[text()='Id']")
    public WebElement gridSettings_AfterSor_IdtTitle_locator;

     /**     US-010 Grid Settings-locators Assignee : Fatih        */
//suat******
    @FindBy(css = "tbody>tr") // cars page satırlar
    public List<WebElement> carRows_Locator;

    @FindBy(xpath = "//td[@class='action-cell grid-cell grid-body-cell']") // cars page 3nokta
    public List<WebElement> carRowsThreeDot_Locator;

    @FindBy(xpath = "//i[@class='fa-trash-o hide-text']")
    public WebElement deleteButton_Locator;

    @FindBy(xpath = "(//div/h3)[2]")
    public WebElement alertMassage_Locator;

    @FindBy(xpath = "//a[@*='btn ok btn-danger']")
    public WebElement yesDelete_Locator;

    @FindBy(xpath = "//div[@class=\"message\"]")
    public WebElement massage_Locator;

    @FindBy(css = "span.title-level-1")
    public List<WebElement> menuOptions_Locators;

    @FindBy(xpath = "(//div/label)[4]")
    public WebElement record_Locator;

    @FindBy(css = "div>h5")
    public WebElement generalInformationPageTitle_Locator;

    @FindBy(xpath = "//div[.='Invalid user name or password.']") //login olmak için invalid bilgi girildikten sonra çıkan uyarı mesajı
    public WebElement invalidInformationText_Locator;

    @FindBy(css= "div.alert > div") // username veya password girilmediğinde çıkan uyarı yazısı
    public WebElement alertText_Locator;

    @FindBy(partialLinkText = "Forgot your") //forgot password butonu
    public WebElement forgotYourPasswordLocator;

    @FindBy(id = "remember_me") // remember me butonu
    public WebElement rememberMeLocator;

    @FindBy (xpath = "//span[.='General Information']") //MURAT
    public WebElement generalInformationPage_Locator;

    @FindBy (xpath = "//table/tbody/tr/td[21]") //MURAT
    public List<WebElement> any3dot_Locator;

    @FindBy(xpath = "//a[@title='View']") //MURAT
    public WebElement eyeIcon_Locator;

    //Ugur Filtre Butonu locator
    @FindBy(xpath = "//a[@title='Filters']") //sağ üst köşede bulunan filter iconu
    public WebElement filterIcon;

    //ugur manage filters locator
    @FindBy(xpath = "//a[@class='add-filter-button']") //sol üst kösede bulunan Manage filters butonu
    public WebElement manageFiltersButton;

    //Ugur - dropdown listesindeki tüm filtreler
    @FindBy(xpath = "//li//label")
    public List<WebElement> filtersList;

    //Ugur - dropdown listesindeki seçili filtreler
    @FindBy(xpath = "//span[@class='filter-items']/div[@style='display: inline-block;']")
    public List<WebElement> selectedFilterElements;

    //Ugur - Filtre adı yazma butonu
    @FindBy(xpath = "//div//input")
    public WebElement filterSearchBox;

    //Ugur - Reset Filters Butonu
    @FindBy(xpath = "//i[@class='fa-refresh']")
    public WebElement resetButton;
    @FindBy(xpath = "//a[@*='Filters']")
    public WebElement filterButton_Locator;

    @FindBy(xpath = "//button/a")
    public WebElement manageFiltersButton_Locator;

    @FindBy(xpath = "//b")
    public WebElement driverLink_Locator;

    @FindBy(xpath = "//button[contains(text(),'contains')]")
    public WebElement containsLink_Locator;

    @FindBy(css = ".dropdown-item.choice-value")
    public List<WebElement> methods_Locator;

    @FindBy(xpath = "//div[2]/input[1]")
    public WebElement inputBox_Locator;

    @FindBy(css = ".btn.btn-primary.filter-update")
    public WebElement updateButton_Locator;

    @FindBy(xpath = "//td[@data-column-label='Driver']")
    public List<WebElement> driverNames_Locator;
//EMİR LOCATORS

    @FindBy(xpath = "//li//label")
    public List<WebElement> allManageFiltersItem_Locator;

    @FindBy(xpath = "//tbody/tr/td[7]")
    public List<WebElement> LastOdometerTableColumn_Locator;

    @FindBy(xpath = "//div[@class='filter-start']/input")
    public WebElement BetweenStartInputBox_Locator;

    @FindBy(xpath = "//div[@class='filter-end']/input")
    public WebElement BetweenEndInputBox_Locator;

    @FindBy(xpath = "//button[text()='Update']")
    public WebElement BetweenUpdateButton_Locator;

    @FindBy(xpath = "//button[contains(text(),'between')]")
    public WebElement FiltersItemControlBoxFirstElement_Locator;

    @FindBy(xpath = "//button[contains(text(),'between')]/../ul/li")
    public List<WebElement> FiltersItemControlBoxAllElement_Locator;

    @FindBy(xpath = "(//label[@class='dib'])[3]")
    public WebElement totalItem_Locator;


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

    public static String driverInfo="";

    @FindBy(css = "tr.grid-row")
    public List<WebElement> vehicles;

    @FindBy(xpath = "//i[contains(@class, \"fa-chevron-right\")]/..")
    public WebElement nextPageButton;

    @FindBy(id = "prependedInput")
    public WebElement usernameInputLocator;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInputLocator;

    @FindBy(id = "_submit")
    public WebElement loginButtonLocator;

    @FindBy(css= "div.alert > div")
    public WebElement alertTextLocator;



    @FindBy(className = "user-name")
    public WebElement userInfo;
    @FindBy(partialLinkText = "Add Event")
    public WebElement addEventButton;

    @FindBy(css = "h1.oro-subtitle")
    public WebElement middleTitleLocator;

    @FindBy(className = "dropdown-toggle")
    public WebElement nameLocator;
    @FindBy(xpath = "//a[text()=\"Logout\"]")
    public WebElement logOutLocator;

    @FindBy(xpath = "//*[@class=\"required\"]/em[text()=\"*\"]/..")
    public List<WebElement> required;
    @FindBy(xpath = "//label[text()=\"Title\"]")
    public WebElement titleInput;
    @FindBy(xpath = "//label[contains(text(), \"Organizer display\")]")
    public WebElement organizerDisplay;
    @FindBy(xpath="//label[contains(text(), \"email\")]")
    public WebElement organizerEmail;
    @FindBy(css = ".btn.btn-primary")
    public WebElement saveButton;
    @FindBy(xpath = "//button[@title=\"close\"]")
    public WebElement closeButton;
    @FindBy(className = "ui-dialog")
    public WebElement addEventPopUp;

    //ASTEKİN
   //@FindBy(xpath = "//td[@data-column-label='Driver']")
    //public List<WebElement> driverNames_Locator;
    @FindBy(xpath = "//div[@class='grid-container']/table")
    public WebElement informationTable_locator;
    @FindBy(xpath = "//label[@class='dib'][2]")
    public WebElement totalPage_locator;
    @FindBy(xpath = "//input[@type='number']")
    public WebElement pageNumber_locator;
    @FindBy(css = ".fa-chevron-right.hide-text")
    public WebElement forwardNumber_locator;
    @FindBy(css = ".fa-chevron-left.hide-text")
    public WebElement backwardNumber_locator;
    @FindBy(xpath = "//label[@class='dib'][3]")
    public WebElement totalRecordsPage_locator;
    @FindBy (xpath = "(//a[contains(@class,'mode-text-only')])[1]")
    public WebElement exportGrid_locator;
    @FindBy (xpath = "//a[@data-index='0']")
    public WebElement CSV_download_locator;
    @FindBy (xpath = "//a[@data-index='1']")
    public WebElement XLSX_download_locator;
    @FindBy(css = ".flash-messages-holder>div")
    public WebElement downloadMessage;

    /*
       SAffet locators buradan alınacak

        */
    @FindBy(xpath = "//span[.='Vehicles']")// fleet/ vehicles table locator SAFFET
    public WebElement vehicleTableLocator;

    @FindBy(xpath = "//label[@class='control-label']")// saffet
    public WebElement viewPerPageLocator;

    @FindBy(css = ".dropdown-item") // drop-down locator saffet
    public List<WebElement> numbers_locator;

    @FindBy(xpath = "//button[@class='btn dropdown-toggle ']") //all drop-downs locator SAffet
    public WebElement viewPerpagebuttonLocator;


    @FindBy(xpath = "//span[.='Model Year']")  //table/tbody/tr/td[7] Model year locator SAffet
    public WebElement modelYearLocator;

    @FindBy(xpath = "//td[contains(@class,'cell-ModelYear')]")
    public List<WebElement> modelYearsColumn;

    @FindBy(xpath = "//a[3]/i[@class='fa-refresh']")
    public WebElement resetLocator;

    @FindBy (xpath = "//div/button[@class= 'btn dropdown-toggle ']")
    public WebElement button_locator;

    @FindBy(xpath = "//div[@class='btn-group open']/ul/li")
    public List<WebElement> buttonDropdown_Locator;

    @FindBy(xpath = "(//label[@class='dib'])[2]")
    public WebElement pageSizeText_Locator;

    @FindBy(xpath = "(//ul[@class='icons-holder']//li/a)[2]")// //i[@class='fa-chevron-right hide-text']
    public WebElement tableRightButton_Locator;

    @FindBy(xpath = "(//ul[@class='icons-holder']//li/a)[1]")
    public WebElement tableLeftButton_Locator;

    @FindBy(xpath = "//table/tbody/tr")
    public  List<WebElement> tablerowCount_Locator;


    @FindBy(xpath = "//th/a/span[@class='grid-header-cell__label']")
    public List<WebElement> allTableTitle_locator;

    @FindBy(xpath = "//a[@class='grid-header-cell__link']//span[@class='caret']")
    public  List<WebElement> spanCaret_Locator;

    @FindBy(xpath = "//a[@class='action btn reset-action mode-text-only']")
    public WebElement resetButton_Locator;
    /*
    SAffet locators

     */








}
