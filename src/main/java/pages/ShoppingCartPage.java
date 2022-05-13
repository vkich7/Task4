package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {


    @FindBy(xpath = "//div[@class='modal__header']")
    private WebElement shoppingCartTitle;

    @FindBy(xpath = "//a[contains(@class,'submit ng-star-inserted')]")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[contains(@class, 'shopping-cart-item--shopping-cart-your-order')]|//section[@data-code or @data-product-code]")
    private WebElement shoppingCartItem;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getShoppingCartTitle() {
        return shoppingCartTitle;
    }

    public boolean isShoppingCartTitleVisible() {
        return shoppingCartTitle.isDisplayed();
    }

    public void clickCheckoutButton() {
        //checkoutButton.click();
        JavascriptExecutor executor = (JavascriptExecutor) this.driver;
        executor.executeScript("arguments[0].click();", checkoutButton);
    }

}
