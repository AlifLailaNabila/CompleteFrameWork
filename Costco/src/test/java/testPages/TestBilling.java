package testPages;

import base.CommonAPIOfFrameWork;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BillingSystem;
import reporting.TestLogger;

public class TestBilling extends BillingSystem {
    BillingSystem billingSystem;
    @BeforeMethod
    public void initializationOfElement(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        billingSystem=PageFactory.initElements(CommonAPIOfFrameWork.driver, BillingSystem.class);
    }
//    @Test
//    public void testAddToCart(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        billingSystem.addToCartCheck();
//    }
}
