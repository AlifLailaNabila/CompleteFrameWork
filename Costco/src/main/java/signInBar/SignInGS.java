package signInBar;
import base.CommonAPIOfFrameWork;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static googleAPI.GoogleSheetReader.getSheetsService;
public class SignInGS extends CommonAPIOfFrameWork {
    @FindBy(css = "#header_sign_in")
    public static WebElement signIn;
    @FindBy(css = "#logonId")
    public static WebElement emailId;
    @FindBy(css = "#LogonForm > fieldset > div:nth-child(5) > input")
    public static WebElement signInButton;
    @FindBy(css = "#logonPassword")
    public static WebElement passwordBar;
    @FindBy(css = "#LogonForm > fieldset > div:nth-child(2) > label.error")
    public static WebElement emailError;
    @FindBy(css = "#LogonForm > fieldset > div:nth-child(3) > label.error")
    public static WebElement blankPasswordError;
    @FindBy(css = "#logon > div > div > div.critical-notification.form-group")
    public static WebElement signInError;
    @FindBy(css = "#search-field")
    public static WebElement searchBar;
    public List<List<Object>> getSpreadSheetRecords(String spreadsheetId, String range) throws IOException {
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        // Build a new authorized API client service.
        Sheets service = getSheetsService();
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.size() == 0) {
            return null;
        } else {
            return values;
        }
    }
    // LogIn by using Google Sheet sheet data
    public List<String> signInByInvalidIdPass(String spreadsheetId, String range) throws IOException, InterruptedException {
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        List<List<Object>> col2Value = getSpreadSheetRecords(spreadsheetId, range);
        List<String> actual = new ArrayList<>();
        for (List row : col2Value) {
            sleepFor(1);
            inputValueInTextBoxByWebElement(emailId, row.get(0).toString());
            inputValueInTextBoxByWebElement(passwordBar, row.get(1).toString());
            sleepFor(1);
            signInButton.click();
            actual.add(getTextByWebElement(signInError));
            System.out.println(getTextByWebElement(signInError));
            clearInputBox(emailId);
            clearInputBox(passwordBar);
            sleepFor(1);
        }
        return actual;
    }
    public List<String> searchItemsByName() throws IOException, InterruptedException, Exception {
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        List<List<Object>> values = getSpreadSheetRecords("1vyXCpuy3an7XOPL69fJH0p5YsHoSFwta1_GK2BQ7Ys4", "Sheet1!A1:A");
        List<String> actual = new ArrayList<>();

        for (List row : values) {
            int i = 0;
            sleepFor(2);
            if (i <= row.size()) {
                inputValueInTextBoxByWebElement(searchBar, row.get(i).toString());
                sleepFor(2);
                //actual.add(getCurrentPageUrl());
                clearInputBox(searchBar);
                sleepFor(2);
                i++;
            }
        }
        return actual;
    }
}
