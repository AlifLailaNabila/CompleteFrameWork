package pages;
import base.CommonAPIOfFrameWork;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;

import java.util.ArrayList;
import java.util.List;
public class HomePage extends CommonAPIOfFrameWork {
    @FindBy(css = "#search-field")
    public static WebElement searchInput;
    @FindBy(xpath = "//img[@class='bc-logo logo-us']")
    public static WebElement costcoLogo;
    @FindBy(css = "#search-dropdown-select")
    public static WebElement allInput;
    @FindBy(css = "#navigation-dropdown")
    public static WebElement alldepartmentsInput;
    @FindBy(css = "#Home_Ancillary_3")
    public static WebElement hoverPharmacyElement;
    @FindBy(css = "#WC_CategoriesSidebarDisplayf_links_3_1")
    public static WebElement electronics;
    @FindBy(css = "#WC_CategoriesSidebarDisplayf_links_3_1")
    public static WebElement tvNdTuner;
    @FindBy(xpath = "#WC_CategoriesSidebarDisplayf_links_3_1 > i")
    public static WebElement electronicsxpath;
    @FindBy(xpath = "//*[@id=\"Home_Ancillary_0\"]")
    public static WebElement grocery;
    @FindBy(xpath = "//*[@id=\"primary-category-container\"]/li[1]")
    public static WebElement organic;
    @FindBy(id = "WC_CategoriesSidebarDisplayf_links_3_5")
    public static WebElement furniture;
    ////ol[@id='primary-category-container']/li
    @FindBy(id = "//ol[@id='primary-category-container']/li/a")
    public static WebElement electronicsButton;
    @FindBy(id = "#warehouse-locations-dropdown")
    public static WebElement findWarehouse;
    @FindBy(xpath = "//a[@id='country-select']/span")
    public static WebElement uS;
    @FindBy(css = "#Home_Ancillary_1")
    public static WebElement businessDelivery;
    @FindBy(css = "#Home_Ancillary_3")
    public static WebElement optical;
    @FindBy(css = "#Home_Ancillary_4")
    public static WebElement pharmacy;
    @FindBy(css = "#Home_Ancillary_5")
    public static WebElement service;
    public void showCostcoTitle() { showTitle(driver); }
    public WebElement getSearchInput(){
        return searchInput;
    }
    public void getSearchResult(String value){
        getSearchInput().sendKeys(value,Keys.ENTER);
    }
    //click All
    public WebElement getAllInput() {
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        return allInput;
    }
    public boolean clickBusinessDelivery(){
        businessDelivery.click();
        return true;
    }
    public boolean clickOptical(){
        optical.click();
        return true;
    }
    public boolean clickPharmacy(){
        pharmacy.click();
        return true;
    }
    public boolean clickService(){
        service.click();
        return true;
    }
    public void getclick(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        getAllInput().click();
    }
    //click Shop All Departments
    public WebElement getAlldepartments(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        return alldepartmentsInput;
    }
    public void getclickAlldepartments(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        getAlldepartments().click();
    }
    //List showing all
    public List<String> allDropdown(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        List<String> tx= new ArrayList<>();
        tx=getTextFromWebElements("#search-dropdown-select");
        return tx;
    }
    public List<String> allDropDown2(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        getTextFromWebElements("#search-dropdown-select");
        return null;
    }
    public List<String>listOfStringOfAllDept(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        List <String>element=new ArrayList<>();
        getListOfString(driver.findElements(By.cssSelector("#warehouse-locations-dropdown")));
        return element;
    }
    //hovering
    public void hoverShopAllDepartments(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        Actions actions = new Actions(driver);
        actions.moveToElement(alldepartmentsInput).perform();
        actions.moveToElement(electronics).perform();
    }
    public void enableStatusSearchBar(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        isEnableStatus(driver,getSearchInput());
    }
    public void logoValidation(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        isDisplayedStatus(costcoLogo);
    }
    public void navigateTesting(){
        navigateHardCoded();
        navigateBack();
        navigateBack();
        navigateForward();
        refreshPage();
    }
}
