package pages;
import base.CommonAPIOfFrameWork;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;

public class CountrySelection extends CommonAPIOfFrameWork {
    @FindBy(xpath = "//a[@id='country-select']/span")
    public static WebElement uSButtonXpath;
    @FindBy(id = "oo_tab")
    public static WebElement feedBack;
    @FindBy(css = "//#waypoint_icons > a:nth-child(1)")
    public static WebElement website;
    public void alertPopUp() {
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        navigate("https://www.costco.com/LogonForm");
        feedBack.click();
        waitUntilClickAble(website);
        website.click();
    }
}
