package base;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.services.sheets.v4.Sheets;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.bcel.classfile.Utility;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Optional;
import org.testng.asserts.SoftAssert;
import reporting.ExtentManager;
import reporting.ExtentTestManager;
import reporting.TestLogger;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
public class CommonAPIOfFrameWork {
    public static ExtentReports extent;
    /*@Parameters( {"url"})
     //@BeforeMethod
     public  void setUp(@Optional("http://www.costco.com") String url){
        System.setProperty("webdriver.chrome.driver", "/Users/alifnabila/IdeaProjects/CostcoWebAuto/GenericOfCostco/Browser-Driver/mac/chromedriver");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get(url);
        //Thread.sleep(7000);
    }*/
    @BeforeSuite
    public void extentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }
    @BeforeMethod
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName().toLowerCase();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }
    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }
    @AfterMethod
    public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));
        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }
        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        }
        ExtentTestManager.endTest();
        extent.flush();
        if (result.getStatus() == ITestResult.FAILURE) {
            //screenShotCapture(driver, result.getName());
        }
        //driver.quit();
    }
    @AfterSuite
    public void generateReport() {
        extent.close();
    }
    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
    public static WebDriver driver = null;
    public String browserstack_username= "";
    public String browserstack_accesskey = "";
    public String saucelabs_username = "alifnabila";
    public String saucelabs_accesskey = "9a405ef9-17fd-4e2d-9f01-41b5dfbae39d";
    @Parameters({"useCloudEnv","cloudEnvName","os","os_version","browserName","browserVersion","url"})
    @BeforeMethod
    public void setUp(@Optional("false") boolean useCloudEnv, @Optional("false")String cloudEnvName,
                      @Optional("OS X") String os,@Optional("10") String os_version, @Optional("chrome") String browserName, @Optional("34")
                              String browserVersion, @Optional("http://www.costco.com") String url)throws IOException {
        System.setProperty("webdriver.chrome.driver", "/Users/alifnabila/IdeaProjects/CostcoWebAuto/GenericOfCostco/Browser-Driver/mac/chromedriver");
        if(useCloudEnv==true){
            if(cloudEnvName.equalsIgnoreCase("browserstack")) {
                getCloudDriver(cloudEnvName,browserstack_username,browserstack_accesskey,os,os_version, browserName, browserVersion);
            }else if (cloudEnvName.equalsIgnoreCase("saucelabs")){
                getCloudDriver(cloudEnvName,saucelabs_username, saucelabs_accesskey,os,os_version, browserName, browserVersion);
            }
        }else{
            getLocalDriver(os, browserName);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
        driver.get(url);
        //driver.manage().window().maximize();
    }
    public WebDriver getLocalDriver(@Optional("mac") String OS, String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            if(OS.equalsIgnoreCase("OS X")){
                System.setProperty("webdriver.chrome.driver", "../GenericOfCostco/Browser-Driver/mac/chromedriver");
            }else if(OS.equalsIgnoreCase("Windows")){
                System.setProperty("webdriver.chrome.driver", "../GenericOfCostco/Browser-Driver/windows/chromedriver.exe");
            }
            driver = new ChromeDriver();
        } else if(browserName.equalsIgnoreCase("chrome-options")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            if(OS.equalsIgnoreCase("OS X")){
                System.setProperty("webdriver.chrome.driver", "../GenericOfCostco/Browser-Driver/mac/chromedriver");
            }else if(OS.equalsIgnoreCase("Windows")){
                System.setProperty("webdriver.chrome.driver", "../GenericOfCostco/Browser-Driver/windows/chromedriver.exe");
            }
            driver = new ChromeDriver(options);
        }
        else if(browserName.equalsIgnoreCase("firefox")){
            if(OS.equalsIgnoreCase("OS X")){
                System.setProperty("webdriver.gecko.driver", "../GenericOfCostco/Browser-Driver/mac/geckodriver");
            }else if(OS.equalsIgnoreCase("Windows")) {
                System.setProperty("webdriver.gecko.driver", "../GenericOfCostco/Browser-Driver/windows/geckodriver.exe");
            }
            driver = new FirefoxDriver();
        } else if(browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "../GenericOfCostco/Browser-Driver/IE/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        return driver;
    }
    //*************Method for cloud environments**********************************
    public WebDriver getCloudDriver(String envName,String envUsername, String envAccessKey,String os, String os_version,String browserName,
                                    String browserVersion)throws IOException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("browser",browserName);
        cap.setCapability("browser_version",browserVersion);
        cap.setCapability("os", os);
        cap.setCapability("os_version", os_version);
        if(envName.equalsIgnoreCase("Saucelabs")){
            //resolution for Saucelabs
            driver = new RemoteWebDriver(new URL("http://" + envUsername + ":" + envAccessKey +
                    "@ondemand.saucelabs.com:80/wd/hub"), cap);
        }else if(envName.equalsIgnoreCase("Browserstack")) {
            cap.setCapability("resolution", "1024x768");
            driver = new RemoteWebDriver(new URL("http://" + envUsername + ":" + envAccessKey +
                    "@hub-cloud.browserstack.com/wd/hub"), cap);
        }
        return driver;
    }
    @AfterMethod
    public void cleanUp() {
        //  driver.quit();
    }
    public static void sleepFor(WebDriver driver, int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }
    public static void implicitWait(WebDriver driver, int sec) {
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }
    public void getSizeOfElement(WebElement element) {
        Dimension dimension = element.getSize();
        System.out.println("Width of element: " + dimension.width);
        System.out.println("Height of element: " + dimension.height);
    }
    //ForButtons
    public static boolean isEnableStatus(WebDriver driver, WebElement web) {
        boolean en = web.isEnabled();
        System.out.println(en);
        return en;
    }
    //For Every Element
    public void isDisplayedStatus(WebElement element) {
        boolean value = element.isDisplayed();
        System.out.println(value);
    }
    //For CheckBox, DropDown, RadioButton
    public void isSelectedStatus(WebElement element) {
        boolean value = element.isSelected();
        System.out.println(value);
    }
    public void clickOnCss(String locator) {
        driver.findElement(By.cssSelector(locator)).click();
    }
    public void clickOnElement(String locator) {
        try {
            driver.findElement(By.cssSelector(locator)).click();
        } catch (Exception ex1) {
            try {
                driver.findElement(By.xpath(locator)).click();
            } catch (Exception ex2) {
                driver.findElement(By.id(locator)).click();
            }
        }
    }
    public void typeOnCss(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }
    public void typeByXpath(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }
    //For Google Sheet
    public void inputValueInTextBoxByWebElement(WebElement webElement, String value){
        webElement.sendKeys(value );
    }
    public String getTextByWebElement(WebElement webElement){
        String text = webElement.getText();
        return text;
    }
    public void sleepFor(int sec)throws InterruptedException{
        Thread.sleep(sec * 1000);
    }
    public void clearInputBox(WebElement webElement){
        webElement.clear();
    }
    public void typeOnInputBox(String locator, String value) {
        try {
            driver.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex1) {
            System.out.println("ID locator didn't work");
        }
        try {
            driver.findElement(By.name(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex2) {
            System.out.println("Name locator didn't work");
        }
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex3) {
            System.out.println("CSS locator didn't work");
        }
    }
    public void takeEnterKeys(String locator) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }
    public void keysInput(String locator) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }
    public void clearInputField(String locator) {
        driver.findElement(By.cssSelector(locator)).clear();
    }
    //handling Alert
    public void okAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void cancelAlert(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    //get title of the current page
    public static String showTitle(WebDriver driver) {
        String title = driver.getTitle();
        return title;
    }
    public String getCurrentPageUrl() {
        String url = driver.getCurrentUrl();
        System.out.println(url);
        return url;
    }
    //Hovering
    public void mouseHoverByCSS(String locator) {
        try {
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        } catch (Exception ex) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }
    public void mouseHoverByXpath(String locator) {
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        } catch (Exception ex) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }
    public void navigate(String url){
        driver.navigate().to(url);
    }

    public void navigateHardCoded() {
        driver.navigate().to("https://www.costco.com");
        driver.navigate().to("https://www.costco.com/LogonForm");
        driver.navigate().to("https://www.costcophotocenter.com/Home?utm_source=costco.com&utm_medium=referral&utm_campaign=Costco.com%20Navigation%20Bar&utm_term=Photo%20Main&utm_content=Photo");
    }
    public void navigateToSpecificPage(String url) {
        driver.navigate().to(url);
    }
    public void navigateBack() {
        driver.navigate().back();
    }
    public void navigateForward() {
        driver.navigate().forward();
    }
    public void refreshPage() {
        driver.navigate().refresh();
    }
    public String getText(String locator) {
        try {
            String st = driver.findElement(By.xpath(locator)).getText();
            System.out.println("Locator found by ID");
            System.out.println(st);

        } catch (Exception ex1) {
            System.out.println("Locator can't be found by ID");
        }
        try {
            String st = driver.findElement(By.cssSelector(locator)).getText();
            System.out.println("Locator found by CSS");
            System.out.println(st);
            return st;
        } catch (Exception ex2) {
            System.out.println("Locator can't be found by CSS");
        }
        try {
            String st = driver.findElement(By.xpath(locator)).getText();
            System.out.println("Locator found by xpath");
            System.out.println(st);
            return st;
        } catch (Exception ex3) {
            System.out.println("Locator can't be found by xpath");
        }
        return locator;
    }
    public List<String> getListOfString(List<WebElement> list) {
        List<String> items = new ArrayList<String>();
        for (WebElement element : list) {
            items.add(element.getText());
        }
        System.out.println(items);
        return items;
    }
    public List<String> getTextFromWebElements(String locator) {
        try {
            List<WebElement> element = new ArrayList<WebElement>();
            List<String> text = new ArrayList<String>();
            element = driver.findElements(By.xpath(locator));
            for (WebElement web : element) {
                text.add(web.getText());
            }
            return text;
        } catch (Exception ex2) {
            System.out.println("Locator can't be found by xpath");
        }
        try {
            List<WebElement> element = new ArrayList<WebElement>();
            List<String> text = new ArrayList<String>();
            element = driver.findElements(By.cssSelector(locator));
            for (WebElement web : element) {
                text.add(web.getText());
                System.out.println(text);
            }
            return text;
        } catch (Exception ex1) {
            System.out.println("Locator can't be found by CSS");
        }
        return null;
    }
    public void selectOptionByVisibleText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }
    public void selectOptionByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }
    public void selectOptionByIndex(WebElement element, int value) {
        Select select = new Select(element);
        select.selectByIndex(value);
    }
    //iFrame Handle
    public void iframeHandle(WebElement element) {
        driver.switchTo().frame(element);
    }
    public void goBackToHomeWindow() {
        driver.switchTo().defaultContent();
    }
    public void tagName() {
        WebElement element = driver.findElement(By.tagName("input"));
        System.out.println(element);
    }
    //Get All Links
    public List<String> getLinks() {
        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        element = driver.findElements(By.tagName("a"));
        System.out.println(element.size());
        for (WebElement web : element) {
            System.out.println(web.getAttribute("href"));
        }
        return text;
        ////a[text()='Pharmacy']
    }
    public void windowHandle(WebDriver driver) {
        String window1=driver.getWindowHandle();
        System.out.println(window1);
        for (String windows : driver.getWindowHandles()) {
            if (windows.equals(window1)==false) {
                System.out.println(windows);
                driver.switchTo().window(windows);
                break;
            }
        }
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
    }
   public static void screenShotCapture(WebDriver driver, String screenShotFileName){
       DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
       Date date =new Date();
       File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       try{
           FileUtils.copyFile(file, new File("./ScreenShots/"+df.format(date)+" "+screenShotFileName+".png"));
           } catch (IOException e) {
           System.out.println("Exception while taking screenshot "+e.getMessage());
       }
   }
    public void waitUntilClickAble(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, 35);
        WebElement element=wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
    public void waitUntilVisible(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitUntilSelectable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean element = wait.until(ExpectedConditions.elementToBeSelected(locator));
    }
    public void upLoadFile(String locator,String path){
        driver.findElement(By.cssSelector(locator)).sendKeys(path);
        /* path example to upload a file/image
           path= "C:\\Users\\rrt\\Pictures\\ds1.png";
         */
    }
    public String converToString(String st){
        String splitString ;
        splitString = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(st), ' ');
        System.out.println(splitString);
        return splitString;
    }
    public void switchTabs(Integer toClose, Integer toKeep) {

        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"t");
        driver.get("https://www.costco.com");
        System.out.println(driver.getTitle());
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"\t");
        //ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        //driver.switchTo().window(tabs.get(toClose));
        //driver.close();
        //driver.switchTo().window(tabs.get(toKeep));
    }
    // Assert Data
    public void assertData(List<String> actualList, List<String> expectedList){
        for (int i = 0; i < actualList.size(); i++) {
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(actualList.get(i).contains(expectedList.get(i)));
            System.out.println("LinkVerified " + expectedList.get(i));
        }
    }
    public void SendKeys(WebElement element, String keys, String elementName){
        TestLogger.log("Sending Keys to " + elementName);
        element.sendKeys(keys);
        TestLogger.log("Keys Sent Successfully to "+ elementName);
    }
    public void typeByXpathNEnter(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }
    //clear Input
    public void clearInputByXpath(String locator) {
        driver.findElement(By.xpath(locator)).clear();
    }
    public void clickOnLinkCSS(String locator) {
        driver.findElement(By.cssSelector(locator)).click();
    }
}

