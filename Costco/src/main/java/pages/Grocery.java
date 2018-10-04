package pages;
import base.CommonAPIOfFrameWork;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;

import java.util.concurrent.TimeUnit;

public class Grocery extends CommonAPIOfFrameWork {
    @FindBy(css = "#Home_Ancillary_0")
    public  static WebElement groceryBarCSS;
    @FindBy(css = "#postal-code-input")
    public  static WebElement zipCodeCSS;
    @FindBy(xpath = "//div[@id='delivery-postal-popup-body']/span")
    public  static WebElement zipCodeText;
    public void clickGrocery(){
        groceryBarCSS.click();
    }
    public void clickGroceryWithGet(){
        groceryBarCSS.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        getText("//*[@id=\"delivery-postal-popup-body\"]/span");
    }
    public void valueZipCodeCSS(){
        groceryBarCSS.click();
        typeOnInputBox("#postal-code-input", "1000");
        clickOnElement("#postal-code-submit");
    }
    public void clearZipCodeField() {
        groceryBarCSS.click();
        typeOnInputBox("#postal-code-input","121212");
        clearInputField("#postal-code-input");
    }
    public void getGroceryText() { getText("#Home_Ancillary_0");
    }
    public void photoHover(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        groceryBarCSS.click();
    }
    public void defaultChecking(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        navigateHardCoded();
        goBackToHomeWindow();
    }
    public void photoHoverTest(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        mouseHoverByXpath("#Home_Ancillary_5");
    }
    public void zipCodeText(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        groceryBarCSS.click();
        getText("//div[@id='delivery-postal-popup-body']/span");
    }
}
