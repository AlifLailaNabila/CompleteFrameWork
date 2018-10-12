package testPages;


import base.CommonAPIOfFrameWork;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import reporting.TestLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class TestHomePage extends HomePage {
    HomePage homePage;
    @BeforeMethod
    public void initializationOfElement() {
        homePage = PageFactory.initElements(CommonAPIOfFrameWork.driver, HomePage.class);
    }
    @Test
    public void testShowCostcoTitle(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        showCostcoTitle();
    }
    @Test
    public void testSearchBar(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        homePage.getSearchResult("Table");
    }
//    @Test()
//    public  void testAllInput(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        homePage.getclick();
//    }
//    @Test()
//    public  void testGetAllDept() {
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        homePage.getAlldepartments();
//        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//    }
//    @Test()
//    public void testDropdownOfAll() {
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        List<String> text1 = new ArrayList<String>();
//        text1 = allDropdown();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        for (String e : text1) {
//            System.out.println(e);
//        }
//    }
//    @Test()
//    public void hoverPharmacy() {
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        WebElement element = hoverPharmacyElement;
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element).perform();
//    }
//    @Test()
//    public void testHoverShopAllDepartments(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        hoverShopAllDepartments();
//    }
//    @Test()
//    public void testNavigate(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        homePage.navigateTesting();
//    }
//    @Test()
//    public void testCurrentURL(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        navigateHardCoded();
//        getCurrentPageUrl();
//    }
//    @Test()
//    public void testEnableStatusSearchBar(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        enableStatusSearchBar();
//    }
//    @Test()
//    public void testListOfStringOfAllDept(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        listOfStringOfAllDept();
//    }
//    @Test()
//    public void testDropDownOfAll(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        allDropDown2();
//    }
//    @Test()
//    public void testAllDept(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        selectOptionByVisibleText(allInput,"Grocery");
//    }
//    @Test()
//    public void testTagName(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        tagName();
//    }
//    @Test()
//    public void testGetAllLinks(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        getLinks();
//    }
//    @Test()
//    public void testCostcoLogo(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//       logoValidation();
//    }
//    //blocking the site
//    @Test()
//    public void testBusinessDelivery(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        boolean actual=clickBusinessDelivery();
//        Assert.assertEquals(actual,true);
//    }
//    @Test()
//    public void testOptical(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        boolean actual=clickOptical();
//        Assert.assertEquals(actual,true);
//    }
//    @Test()
//    public void testpharmacy(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        boolean actual=clickPharmacy();
//        Assert.assertEquals(actual,true);
//    }
//    @Test()
//    public void testService(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        boolean actual=clickService();
//        Assert.assertEquals(actual,true);
//    }
}
