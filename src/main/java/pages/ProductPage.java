package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//button[contains(@class,'buy-button')]")
    private List<WebElement> addToCartButtons;

    @FindBy(xpath = "//div[@class='cart-footer ng-star-inserted']/button")
    private WebElement continueShoppingButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAddToCartFirstButton() {
        return addToCartButtons.get(0);
    }
    public WebElement getAddToCartLastButton() {
        return addToCartButtons.get(addToCartButtons.size()-1);
    }

    public void isContinueShoppingButtonVisible() {
        continueShoppingButton.isDisplayed();
    }


}
