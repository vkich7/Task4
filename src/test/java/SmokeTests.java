import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmokeTests extends BaseTest {


    private static final long DEFAULT_WAITING_TIME = 10;
    private  static final int WAIT_TIME_IN_SECONDS = 40;

    @Test
    public void checkMainComponentsOnHomePage() {
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        assertTrue(getHomePage().isHeaderVisible());
        assertTrue(getHomePage().isSearchFieldVisible());
        assertTrue(getHomePage().isCartIconVisible());
        assertTrue(getHomePage().getLanguageButtonText().equalsIgnoreCase("RU\nUA"));
        assertTrue(getHomePage().isSignInButtonVisible());
        getHomePage().clickSignInButton();
        getHomePage().waitVisibilityOfElement(10, getHomePage().getSignInForm());
        assertTrue(getHomePage().isEmailFieldVisible());
        assertTrue(getHomePage().isPasswordFieldVisible());
        getHomePage().clickSignInPopupCloseButton();
        getHomePage().clickCatalogButton();
        getHomePage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getHomePage().getCatalogMenu());
        assertTrue(getHomePage().isStorePopupVisible());
        getHomePage().clickCartButton();
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getShoppingCartPage().getShoppingCartTitle());
        assertTrue(getShoppingCartPage().isShoppingCartTitleVisible());
    }

    @Test
    public void checkAddToCartOneItem() throws InterruptedException {
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHomePage().isSearchFieldVisible();
        getHomePage().enterTextToSearchField("ball");
        getHomePage().implicitWait(WAIT_TIME_IN_SECONDS);
        getSearchResultsPage().clickWishListOnFirstProduct();
        getSearchResultsPage().clickBuyButton();
        getHomePage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getHomePage().getCartButton());
        assertTrue(getHomePage().getCartButton().isDisplayed());
        getHomePage().waitTextToBePresentInElement(DEFAULT_WAITING_TIME, getHomePage().getCartButton(), "1");
        assertEquals(getHomePage().getAmountOfProductsInCartList(), "1");
    }

    @Test
    public void checkAddToCart() {
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        //getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getHomePage().isSearchFieldVisible();
        getHomePage().enterTextToSearchField("ssd");
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHomePage().implicitWait(WAIT_TIME_IN_SECONDS);
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHomePage().implicitWait(WAIT_TIME_IN_SECONDS);
        getHomePage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getProductPage().getAddToCartFirstButton());
        getProductPage().getAddToCartFirstButton().click();
        getHomePage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getProductPage().getAddToCartLastButton());
        getProductPage().getAddToCartLastButton().click();
        getHomePage().getCartButton().click();
        getProductPage().isContinueShoppingButtonVisible();
        getShoppingCartPage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getShoppingCartPage().getShoppingCartItem());
        getShoppingCartPage().clickCheckoutButton();
        getShoppingCartPage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getCheckoutPage().getPaymentCartButton());
        getCheckoutPage().clickPaymentCartButton();
        getShoppingCartPage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getCheckoutPage().getPaymentForm());
        assertTrue(getCheckoutPage().isPaymentFormVisible());
        assertTrue(getCheckoutPage().isBillingFormVisible());
        assertTrue(getCheckoutPage().isCompleteOrderButtonVisible());
    }
}
