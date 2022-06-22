package utilities;

import org.openqa.selenium.WebDriver;
import pageobjects.index.IndexPage;
import pageobjects.checkout.CartPage;
import pageobjects.checkout.StepOnePage;
import pageobjects.checkout.StepTwoPage;
import pageobjects.credentials.LoginPage;
import pageobjects.shopping.HomeShoppingPage;
import pageobjects.signup.SignUpPage;

public class CommonFlows {
    private final Logs log = new Logs();
    private final WebDriver driver;

    public CommonFlows(WebDriver driver) {
        this.driver = driver;
    }

    public void goToIndex() {
        var indexPage = new IndexPage(driver);

        indexPage.goToIndex();
        indexPage.waitPageToLoad();
    }


    public void goToSignUp(){
        var indexPage = new IndexPage(driver);
        var signupPage = new SignUpPage(driver);

        indexPage.goToSignUp();
        signupPage.waitPageToLoad();
        signupPage.verifyPage();
    }

    public void loginValidUser() {
        var validCredentials = new DataProviders().getValidCredentials();
        var loginPage = new LoginPage(driver);
        var homeShoppingPage = new HomeShoppingPage(driver);

        loginPage.fillLogin(validCredentials.getUsername(), validCredentials.getPassword());
        homeShoppingPage.waitPageToLoad();
    }

    public void goToCart() {
        var homeShoppingPage = new HomeShoppingPage(driver);
        var cartPage = new CartPage(driver);

        loginValidUser();
        homeShoppingPage.addAllItemsToCart();
        homeShoppingPage.clickOnShoppingCart();
        cartPage.waitPageToLoad();
    }

    public void goToStepOne() {
        var cartPage = new CartPage(driver);
        var stepOnePage = new StepOnePage(driver);

        goToCart();
        cartPage.clickOnCheckout();
        stepOnePage.waitPageToLoad();
    }

    public void goToStepTwo() {
        var userData = new DataProviders().getUserData();
        var stepOnePage = new StepOnePage(driver);
        var stepTwoPage = new StepTwoPage(driver);

        goToStepOne();
        stepOnePage.fillForm(userData.getFirstname(), userData.getLastName(), userData.getZipcode());
        stepTwoPage.waitPageToLoad();
    }

}
