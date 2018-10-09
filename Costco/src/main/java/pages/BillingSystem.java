package pages;

import base.CommonAPIOfFrameWork;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;

import java.security.Key;

public class BillingSystem extends CommonAPIOfFrameWork {
    @FindBy(id = "cart-d")
    public static WebElement cart;
    @FindBy(css = "#ShopCartForm > div.row > div > input")
    public static WebElement continueShop;
    @FindBy(css = "#slick-slide00 > div.caption > p.description")
    public static WebElement product;
    @FindBy(id = "add-to-cart-btn")
    public static WebElement addToCart;
    @FindBy(css = "#postal-code-input")
    public static WebElement zip;
    @FindBy(css = "#postal-code-input")
    public static WebElement zipSubmit;
    @FindBy(css = "#costcoModalText > div.added-items > div > ul > li.item-details > div.row > div.col-md-5.hidden-xs.hidden-sm > p")
    public static WebElement itemAdded;
    @FindBy(css = "#Home_Ancillary_0")
    public static WebElement grocery;
    @FindBy(css = "#search-results > div.c_408102 > div > div > div:nth-child(1) > div.six-tiles.row.gutter > div:nth-child(4) > a > div > div")
    public static WebElement item;
    @FindBy(css = "#search-results > ctl:cache > div.product-list.grid > div:nth-child(1) > div > div.thumbnail > div.caption.link-behavior > div.caption > p.description > a")
    public static WebElement firstItem;
    @FindBy(css = "")
    public static WebElement cont;
    public void addToCartCheck(){
        TestLogger.log(getClass().getSimpleName()+": "+converToString((new Object(){}.getClass().getEnclosingMethod().getName())));
        grocery.click();
        typeOnInputBox("#postal-code-input","11416");
    }
}
