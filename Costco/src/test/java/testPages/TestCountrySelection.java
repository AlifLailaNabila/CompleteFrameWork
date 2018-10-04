package testPages;
import base.CommonAPIOfFrameWork;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CountrySelection;
import pages.CustomerService;
import reporting.TestLogger;
public class TestCountrySelection extends CountrySelection {
    CountrySelection countrySelection;
    @BeforeMethod
    public void initializationOfElement(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        countrySelection=PageFactory.initElements(CommonAPIOfFrameWork.driver, CountrySelection.class);
    }
    @Test
    public void testDismissAlert(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        countrySelection.alertPopUp();
    }
    @Test
    public void testConvertToString(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        converToString("AHIL");
    }
}
