package testDataReader;
import base.CommonAPIOfFrameWork;
import dataReader.XlsDataReaderUtil;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CountrySelection;
import pages.SignInOrRegister;
import reporting.TestLogger;
import java.util.ArrayList;
import java.util.Iterator;
public class SignIn extends SignInOrRegister {
    SignInOrRegister signInOrRegister;
    @BeforeMethod
    public void initializationOfElement(){
        signInOrRegister=PageFactory.initElements(CommonAPIOfFrameWork.driver, SignInOrRegister.class);
    }
    @Test(dataProvider = "supplyData")
    public void testsignInWithExcel(String email, String password, String message) throws InterruptedException {
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        TestLogger.log("email: " + email);
        TestLogger.log("password: " + password);
        TestLogger.log("message: " + message);
        signInOrRegister.signIn.click();
        Thread.sleep(900);
        TestLogger.log("In Sign In Page");
        signInOrRegister.emailId.sendKeys(email);
        Thread.sleep(900);
        signInOrRegister.passwordBar.sendKeys(password);
        Thread.sleep(900);
        signInOrRegister.signInButton.click();
        TestLogger.log("Test Passed");
    }
}
