package searchBar;
import base.CommonAPIOfFrameWork;
import databases.ConnectToSqlDB;
import reporting.TestLogger;

import java.util.ArrayList;
import java.util.List;

public class ElementSearch extends CommonAPIOfFrameWork{
    public static List<String> getItemValue() {
        List<String> itemsList = new ArrayList<String>();
        itemsList.add("Laptop");
        itemsList.add("Books");
        itemsList.add("Cosmetics");
        itemsList.add("Phone");
        itemsList.add("Soap");
        itemsList.add("Bakery");
        itemsList.add("Rice");
        itemsList.add("Gifts");
        return itemsList;
    }
    //put Data to DB-Mysql
    public static void main(String[] args) {
        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
        connectToSqlDB.insertDataFromArrayListToMySql(getItemValue(), "TestCostco", "search");
    }
    //insert datas to db
    public static List<String> setUserName() {
        List<String> username = new ArrayList<String>();
        username.add("Alif");
        username.add("Sabuj");
        username.add("Riaz");
        username.add("Shama");
        username.add("Real");
        return username;
    }
    public static List<String> setUserPass() {
        List<String> passWord = new ArrayList<String>();
        passWord.add("Pass1");
        passWord.add("Pass2");
        passWord.add("Pass3");
        passWord.add("Pass4");
        passWord.add("Pass5");;
        return passWord;
    }
    //bring data from db and search using them
    public void searchByItems() throws Exception {
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
        connectToSqlDB.insertDataFromArrayListToMySql(getItemValue(),"Costco","search");
        List<String> items = connectToSqlDB.readDataBase("Costco", "search");
        for (int i = 0; i < items.size(); i++) {
            typeByXpathNEnter("//*[@id=\"search-field\"]", items.get(i));
            clearInputByXpath("//*[@id=\"search-field\"]");
        }
    }
    //bring data from db and input them
    public void signInInput() throws Exception {
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
        connectToSqlDB.insertDataFromArrayListToMySql(setUserName(), "Email", "EmailID");
        connectToSqlDB.insertDataFromArrayListToMySql(setUserName(), "Password", "passWord");
        List<String> emailID = connectToSqlDB.readDataBase("Email", "EmailID");
        List<String> passWord = connectToSqlDB.readDataBase("Password", "passWord");
        clickOnLinkCSS("#header_sign_in");
        sleepFor(3);
        for (int i = 0; i < emailID.size(); i++) {
            typeByXpath("//*[@id=\"logonId\"]", emailID.get(i));
            sleepFor(3);
            typeByXpath("//*[@id=\"logonPassword\"]", passWord.get(i));
            sleepFor(3);
            clearInputByXpath("//*[@id=\"logonId\"]");
            Thread.sleep(2000);
            clearInputByXpath("//*[@id=\"logonPassword\"]");
            Thread.sleep(2000);
        }
    }
}
