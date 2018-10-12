package testPages;
import base.CommonAPIOfFrameWork;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CustomerService;
import reporting.TestLogger;
public class TestCustomerService extends CustomerService {
    CustomerService customerService;
    @BeforeMethod
    public void initializationOfElement(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        customerService=PageFactory.initElements(CommonAPIOfFrameWork.driver, CustomerService.class);
    }
//    @Test(priority = 1, enabled = true)
//    public void testCustomerService(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        boolean actual=customerService.searchCustomerService();
//        Assert.assertEquals(actual,true);
//    }
//    @Test
//    public void testCreditCard(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        customerService.creditCardEnd();
//        navigateToSpecificPage("https://www.costco.com/credit-card.html");
//        //customerService.setCreditCard2();
//        String actual=getText("#costcoModalText");
//        System.out.println(actual);
//        String expected="";
//        Assert.assertEquals(actual,expected);
//    }
//    @Test
//    public void testMembership(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        boolean actual=customerService.membershipEnd();
//        Assert.assertEquals(actual,true);
//    }
//    @Test
//    public void testWindowHandle(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        customerService.popNewWindow();
//    }
//    @Test
//    public void testTabSwitching(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        customerService.tabSwitching();
//        switchTabs(1,2);
//    }
}


