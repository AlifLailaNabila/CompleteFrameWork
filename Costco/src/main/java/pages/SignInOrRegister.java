package pages;
import base.CommonAPIOfFrameWork;
import dataReader.XlsDataReaderUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;
import reporting.TestLogger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class SignInOrRegister extends CommonAPIOfFrameWork {
    @FindBy(css = "#header_sign_in")
    public static WebElement signIn;
    @FindBy(css = "#logonId")
    public static WebElement emailId;
    @FindBy(css = "#LogonForm > fieldset > div:nth-child(5) > input")
    public static WebElement signInButton;
    @FindBy(css = "#logonPassword")
    public static WebElement passwordBar;
    @FindBy(css = "#LogonForm > fieldset > div:nth-child(4) > div > label")
    public static WebElement checkBox;
    @FindBy(css = "#LogonForm > fieldset")
    public static WebElement registrationFrame;
    @FindBy(css = "#LogonForm > fieldset > div:nth-child(2) > label.error")
    public static WebElement emailError;
    @FindBy(css = "#LogonForm > fieldset > div:nth-child(3) > label.error")
    public static WebElement blankPasswordError;
    @FindBy(css = "#logon > div > div > div.critical-notification.form-group")
    public static WebElement invalidPassError;

    public void signInClick(){
        signIn.click();
    }
    public void inputData(){
        emailId.sendKeys("agis@gmail.com");
        passwordBar.sendKeys("sgdjskhgs");
    }
    public void signInButtonClick(){
        signInButton.click();
    }

    public List<String>  openingSignInPage() {
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        signIn.click();
        emailId.click();
        emailId.sendKeys("abcd");
        signInButton.click();
        String actual1=(emailError.getText());
        String actual2=(blankPasswordError.getText());
        List<String>actualList=new ArrayList<String>();
        actualList.add(actual1);
        actualList.add(actual2);
        System.out.println(actualList);
        return actualList;
    }
    public void signInButtonEnableStatus() {
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        signIn.click();
        boolean tx = signInButton.isEnabled();
        System.out.println(tx);
    }
    public void checkBoxSelectStatus() {
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        signIn.click();
    }
    public void sizeOfSignIn() {
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        getSizeOfElement(signIn);
    }
    public List <String> signUpHardCoded(String email, String password) throws InterruptedException {
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        signIn.click();
        Thread.sleep(900);
        emailId.sendKeys(email);
        Thread.sleep(900);
        passwordBar.sendKeys(password);
        Thread.sleep(900);
        signInButton.click();
        Thread.sleep(900);
        String actual1=(emailError.getText());
        String actual2=(blankPasswordError.getText());
        List<String>actualList=new ArrayList<String>();
        actualList.add(actual1);
        actualList.add(actual2);
        System.out.println(actualList);
        return actualList;
    }
    public String invalidPass(String email, String password) throws InterruptedException{
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        signIn.click();
        Thread.sleep(900);
        emailId.sendKeys(email);
        Thread.sleep(900);
        passwordBar.sendKeys(password);
        Thread.sleep(900);
        signInButton.click();
        //String actual=InvalidPassError.getText();
        String actual=(invalidPassError.getText());
        return actual;
    }
    @DataProvider
    public Iterator<Object[]> supplyData(){
        ArrayList<Object[]> testData =
                XlsDataReaderUtil.getDataFromExcel();
        return testData.iterator();
    }
    public void clickSignIn(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        signIn.click();
    }
    public void clickEmailId(String email) {
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        emailId.sendKeys(email);
    }
    public void clickPassword(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        passwordBar.click();
    }
    public void clickSignInButton() {
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        signInButton.click();
    }
    public String testSignInWithExcel(String email, String password,String message) throws InterruptedException{
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        signIn.click();
        Thread.sleep(900);
        emailId.sendKeys(email);
        Thread.sleep(900);
        passwordBar.sendKeys(password);
        Thread.sleep(900);
        signInButton.click();
        //String actual=InvalidPassError.getText();
        String actual=(invalidPassError.getText());
        return actual;
    }
}
