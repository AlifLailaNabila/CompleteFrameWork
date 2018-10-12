package triggerTest;

import base.CommonAPIOfFrameWork;
import featureOfProduct.Trigger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import reporting.TestLogger;
import java.io.IOException;
public class TestTrigger  extends Trigger {
    Trigger trigger;
    @BeforeMethod
    public void initializationOfElement() {
        trigger = PageFactory.initElements(CommonAPIOfFrameWork.driver, Trigger.class);
    }
//    @Test
//    public void testSelectFeature() throws IOException, InterruptedException {
//        trigger.selectFeature();
//    }
}
