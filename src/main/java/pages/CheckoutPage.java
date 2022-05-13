package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//input[contains(@class, 'total__submit')]")
    private WebElement paymentCartButton;

    @FindBy(xpath = "//div[@class='checkout-form']")
    private WebElement paymentForm;

    @FindBy(xpath = "//input[contains(@class, 'submit')]")
    private WebElement completeOrderButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void clickPaymentCartButton() {
        paymentCartButton.click();
    }

    public WebElement getPaymentCartButton() {
        return paymentCartButton;
    }

    public WebElement getPaymentForm() {
        return paymentForm;
    }

    public boolean isPaymentFormVisible() {
        return paymentForm.isDisplayed();
    }

    public boolean isCompleteOrderButtonVisible() {
        return completeOrderButton.isDisplayed();
    }

}
