package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//header[contains(@class, 'header')]")
    private WebElement header;

    @FindBy(xpath = "//ul[@class='header-actions']/li[contains(@class, 'cart')]")
    private WebElement cartIcon;

    @FindBy(xpath = "//li[contains(@class, 'item--language')]")
    private WebElement languageButton;

    @FindBy(xpath = "//ul[@class='header-actions']/li[contains(@class, 'user')]")
    private WebElement signInButton;

    @FindBy(xpath = "//header//img[contains(@src,'content.rozetka.com.ua/widget')]")
    private WebElement homeButton;

    @FindBy(xpath = "//div[@class='auth-modal ng-star-inserted']")
    private WebElement signInForm;

    @FindBy(xpath = "//input[@id='registerUserEmail']")
    private WebElement emailFieldToRegister;
    @FindBy(xpath = "//input[@id='registerUserPassword']")
    private WebElement passwordFieldToRegister;
    @FindBy(xpath = "//button[contains(@class,'auth-modal__submit')]")
    private WebElement submitRegisterButton;

    @FindBy(xpath = "//input[@id='auth_email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='auth_pass']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@class='modal__close']")
    private WebElement signInPopupCloseButton;

    @FindBy(xpath = "//button[@id='fat-menu']")
    private WebElement catalogButton;

    @FindBy(xpath = "//div[@class='menu-wrapper menu-wrapper_state_animated']")
    private WebElement catalogMenu;

    @FindBy(xpath = "//input[contains(@class, 'search')]")
    private WebElement searchField;

    @FindBy(xpath = "//button[contains(@class, 'search-form__submit')]")
    private WebElement searchButton;

    @FindBy(xpath = "//ul[@class='header-actions']/li[contains(@class, 'cart')]//button")
    private WebElement cartButton;

    @FindBy(xpath = "//footer//ul[@class='socials__list']")
    private WebElement socialsList;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public boolean isHeaderVisible() {
        return header.isDisplayed();
    }

    public boolean isCartIconVisible() {
        return cartIcon.isDisplayed();
    }

    public String getLanguageButtonText() {
        return languageButton.getText();
    }

    public boolean isSignInButtonVisible() {
        return signInButton.isDisplayed();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public boolean isEmailFieldVisible() {
        return emailField.isDisplayed();
    }

    public boolean isPasswordFieldVisible() {
        return passwordField.isDisplayed();
    }

    public void clickSignInPopupCloseButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", signInPopupCloseButton);
    }

    public void clickCatalogButton() {
        catalogButton.click();
    }

    public boolean isStorePopupVisible() {
        return catalogMenu.isDisplayed();
    }

    public boolean isSearchFieldVisible() {
        return searchField.isDisplayed();
    }

    public void clickCartButton() {
        cartIcon.click();
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText, Keys.ENTER);
    }

    public WebElement getSignInForm()
    { return signInForm; }
    public WebElement getCatalogMenu()
    { return catalogMenu; }

    public WebElement getCartButton() {
        return cartButton;
    }

    public String getAmountOfProductsInCartList() {
        return cartButton.getText();
    }

}
