package pageobjects.index;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndexPage extends BasePage {
    private final By signUpButton = By.linkText("Sign up");
    private final By signInButton = By.linkText("Sign in");
    private final By homeButton = By.linkText("Home");
    private final By conduitBanner = By.className("banner");

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(conduitBanner,this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        log.info("Verificando los elementos de la UI");

        log.info("Verificando que el btn de Home Aparezca");
        softAssert.assertTrue(verifyIsDisplayed(homeButton),"El btn de Home no aparece");

        log.info("Verificando que el boton de Sign in aparezca");
        softAssert.assertTrue(verifyIsDisplayed(signInButton),"El boton de Sign in no aparece");

        log.info("Verificando que el Conduit banner aparezca");
        softAssert.assertTrue(verifyIsDisplayed(signUpButton),"El boton de Sign Up no aparece");
    }

    public void goToSignUp(){
        verifyPage();

        log.info("Verificando que se muestre el boton de Sign Up");
        softAssert.assertTrue(verifyIsDisplayed(signUpButton),"No se muestra el btn de SignUp");
        log.info("Haciendo click en el btn de Sign Up");
        click(signUpButton);
    }

    public void goToSignIn(){
        verifyPage();

        log.info("Verificando que se muestre el boton de Sign In");
        softAssert.assertTrue(verifyIsDisplayed(signInButton),"No se muestra el btn de SignIn");
        log.info("Haciendo click en el btn de Sign In");
        click(signInButton);
    }

    public void goToHome(){
        verifyPage();

        log.info("Verificando que se muestre el boton de Home");
        softAssert.assertTrue(verifyIsDisplayed(homeButton),"No se muestra el btn de Home");
        log.info("Haciendo click en el btn de Home");
        click(homeButton);
    }

}
