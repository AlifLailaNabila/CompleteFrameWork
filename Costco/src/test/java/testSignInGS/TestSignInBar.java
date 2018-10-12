package testSignInGS;

import base.CommonAPIOfFrameWork;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignInOrRegister;
import reporting.TestLogger;
import signInBar.SignInGS;

import java.io.IOException;
import java.util.List;
public class TestSignInBar extends SignInGS {
    SignInGS googleSheetSignIn;
    SignInOrRegister signInOrRegister;
    @BeforeMethod
    public void initializationOfElement(){
        googleSheetSignIn=PageFactory.initElements(CommonAPIOfFrameWork.driver, SignInGS.class);
        signInOrRegister=PageFactory.initElements(CommonAPIOfFrameWork.driver, SignInOrRegister.class);
    }
    @Test
    public void testLogInByInvalidIdPassUsingGoogleSheet() throws IOException, InterruptedException {
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        googleSheetSignIn.signIn.click();
        sleepFor(3);
        sleepFor(3);
        int i = 0;
        String spreadsheetId = "1QYj8-C4CwZbUtpqkcTE3zCB8nyvuG8RXGwnobMn_qYM";
        String range = "Sheet1!B2:D";
        List<String> actualErrorMessage = googleSheetSignIn.signInByInvalidIdPass(spreadsheetId, range);
        List<List<Object>> expectedErrorMessage = googleSheetSignIn.getSpreadSheetRecords(spreadsheetId, range);
        for (List row : expectedErrorMessage) {
            Assert.assertTrue(actualErrorMessage.get(i).contains(row.get(2).toString()));
            System.out.println("expected" + row.get(2).toString());
            System.out.println(expectedErrorMessage.get(i) + ": Search - Passed");
            i++;
        }
        System.out.println("testLogInByInvalidIdPassUsingGoogleSheet Passed");
    }
    @Test
    public void SearchItemsFromSearchBox() throws IOException, InterruptedException, Exception {
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        googleSheetSignIn.searchItemsByName();
    }
}
