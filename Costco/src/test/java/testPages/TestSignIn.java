package testPages;


import base.CommonAPIOfFrameWork;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignInOrRegister;
import reporting.TestLogger;
import java.util.ArrayList;
import java.util.List;
public class TestSignIn extends SignInOrRegister {
    SignInOrRegister signInOrRegister;
    @BeforeMethod
    public void initializationOfElement() {
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        signInOrRegister = PageFactory.initElements(CommonAPIOfFrameWork.driver, SignInOrRegister.class);
    }
    @Test
    public void openSignInBar(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        signInOrRegister.openingSignInPage();
    }
    @Test
    public void testStatusOfSignInButton(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        signInButtonEnableStatus();
    }
    @Test
    public void testStatusOfCheckBox(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        checkBoxSelectStatus();
        isSelectedStatus(checkBox);
    }
    @Test
    public void testSizeOfSignIn(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        signInOrRegister.sizeOfSignIn();
        //screenShotCapture(driver, "1");
    }
    @Test
    public void testSignInHardCoded() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        List<String> ActualList=signInOrRegister.signUpHardCoded("abcd@","");
        List<String>ExpectedList=new ArrayList<String>();
        ExpectedList.add("Enter a valid email address");
        ExpectedList.add("Please enter a password.");
        System.out.println(ExpectedList);
        Assert.assertEquals(ActualList,ExpectedList);
    }
    @Test
    public void testSignInIvalidEmailNPass() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        String actual=signInOrRegister.invalidPass("abcd@gmail.com","abcd");
        String ecpected="Your account is locked. This is either due to a rejected registration request or due to 4 unsuccessful password attempts, you will be unable to Log on. To reset your forgotten password, enter your email address in below Forget Password section. Instructions to create a new password will be sent to the email address on your account.";
        Assert.assertTrue(actual.contains(ecpected));
    }
    @Test
    public void testEmailError() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        signInOrRegister.getemailError();
        String actual= getText("#LogonForm > fieldset > div:nth-child(3) > label.error");
        String ecpected="Please enter a password.";
        Assert.assertTrue(actual.contains(ecpected));
    }
    @Test
    public void testPassError() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        signInOrRegister.getemailError();
        String ecpected="This field is required";
    }
    @Test
    public void testSignInIvalid() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        String actual=signInOrRegister.invalidPass("abcd@gmail.com","abcd");
        String ecpected="Your account is locked. This is either due to a rejected registration request or due to 4 unsuccessful password attempts, you will be unable to Log on. To reset your forgotten password, enter your email address in below Forget Password section. Instructions to create a new password will be sent to the email address on your account.";
        Assert.assertTrue(actual.contains(ecpected));
    }
}
