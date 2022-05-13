package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//rz-search[@class='ng-star-inserted']")
    private List<WebElement> searchResultsList;
    @FindBy(xpath = "//button[contains(@class,'buy-button')]")
    private WebElement buyButton;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSearchResultsListFirstProduct() {
        searchResultsList.get(0).click();
    }

    public void clickBuyButton() {
        buyButton.click();
    }
}
