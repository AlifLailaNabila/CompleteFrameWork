package pages;
import base.CommonAPIOfFrameWork;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;
public class CustomerService  extends  CommonAPIOfFrameWork{
    @FindBy(css = "#customer-service-link")
    public static WebElement customerServiceCSS;
    @FindBy(css = "#rn_SourceSearchField_9_SearchInput")
    public static WebElement customerServiceSearchCSS;
    @FindBy(css = "#rn_SourceSearchButton_10_SubmitButton")
    public static WebElement customerServiceSubmitButtonCSS;
    @FindBy(css = "#ProductCategoryList > div > ul.rn_LeftColumn > li:nth-child(1) > a")
    public static WebElement creditCard;
    @FindBy(css = "#ProductCategoryList > div > ul.rn_LeftColumn > li:nth-child(2) > a")
    public static WebElement membership;
    @FindBy(css = "#rn_Multiline_14_Content > ol > li:nth-child(1) > span.rn_Element1 > a")
    public static WebElement howCanIApply;
    @FindBy(xpath = "//li[text()='Apply online ']/a")
    public static WebElement hereLink;
    //#search-results > div.c_279101 > div > div > div:nth-child(2) > div:nth-child(2) > div.row > div:nth-child(1) > a > img
    @FindBy(css = "#search-results > div.c_279101 > div > div > div:nth-child(2) > div:nth-child(2) > div.row > div:nth-child(1) > a > img")
    public static WebElement nextStep;
    @FindBy(css = "#costcoModalText")
    public static WebElement modalText;
    //#rn_Multiline_14_Content > ol > li:nth-child(1) > span.rn_Element1 > a
    @FindBy(css = "#rn_Multiline_14_Content > ol > li:nth-child(1) > span.rn_Element1 > a")
    public static WebElement linkingMembership;
    @FindBy(css = "#kirklandvideo")
    public static WebElement membershipVideo;
    //#kirklandvideo
    public boolean searchCustomerService(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        customerServiceCSS.click();
        customerServiceSearchCSS.sendKeys("Membership");
        customerServiceSubmitButtonCSS.click();
        return true;
    }
    public void creditCardEnd() {
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        customerServiceCSS.click();
        creditCard.click();
        howCanIApply.click();
    }
    public void setCreditCard2(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        nextStep.click();
    }
    public boolean membershipEnd() {
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        customerServiceCSS.click();
        membership.click();
        linkingMembership.click();
        membershipVideo.click();
        return true;
    }
    public void popNewWindow(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        customerServiceCSS.click();
        creditCard.click();
        howCanIApply.click();
        hereLink.click();
        windowHandle(driver);
    }
    public void tabSwitching(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        customerServiceCSS.click();
        creditCard.click();
        howCanIApply.click();
        hereLink.click();
    }
}
