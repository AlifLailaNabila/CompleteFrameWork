package pages;

import base.CommonAPIOfFrameWork;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    @FindBy(css = "#costcoModalText > div.added-items > div > ul > li.item-details > div.row > div.col-md-5.hidden-xs.hidden-sm > p")
    public static WebElement itemAdded;
    public void addToCartCheck(){
        cart.click();
        navigate("https://www.costco.com/Namaste-Organic-Raw-Goods-Variety-Pack%2C-6-pack.product.100242943.html");
        addToCart.click();
        zip.sendKeys("11416");
        getTextByWebElement(itemAdded);
        System.out.println(getTextByWebElement(itemAdded));
    }

}
