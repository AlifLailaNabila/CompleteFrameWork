package testPages;
import base.CommonAPIOfFrameWork;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Grocery;
import reporting.TestLogger;
import java.util.concurrent.TimeUnit;
public class TestGrocery extends Grocery {
    Grocery grocery;
    @BeforeMethod
    public void initializationOfElement() {
        grocery = PageFactory.initElements(CommonAPIOfFrameWork.driver, Grocery.class);
    }
//    @Test(priority = 1, enabled = true)
//    public void testGroceryButton() {
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        grocery.clickGrocery();
//    }
//    @Test
//    public void testGetText(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        grocery.clickGroceryWithGet();
//    }
//    @Test
//    public void testNegativeZipCode(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        grocery.valueZipCodeCSS();
//    }
//    @Test
//    public void testPositiveZipCode(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        grocery.valueZipCodeCSS();
//    }
//    @Test
//    public void testClearZipCode(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        grocery.clearZipCodeField();
//    }
//    @Test
//    public void testGroceryText(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        getGroceryText();
//    }
//    @Test
//    public void testPhotoHover(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        grocery.photoHoverTest();
//        //return actual;
//    }
//    @Test
//    public void testDefaultWindow(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        defaultChecking();
//    }
//    @Test
//    public void testTextOfZipCode(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        grocery.zipCodeText();
//    }
//    @Test
//    public void photoHoverTest2(){
//        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
//        grocery.photoHover();
//    }
}
