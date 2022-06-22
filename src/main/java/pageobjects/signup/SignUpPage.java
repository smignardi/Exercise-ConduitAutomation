package pageobjects.signup;

import base.BasePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignUpPage extends BasePage {

    private final By signUpForm = By.className("auth-page");
    private final By usernameInput = By.xpath("//input[@placeholder='Username']");
    private final By emailInput = By.xpath("//input[@placeholder='Email']");
    private final By passwordInput = By.xpath("//input[@placeholder='Password']");
    private final By signInBtn = By.xpath("//button[text()='Sign in']");
    private final By errorMessage = By.xpath("//ul[@class='error-messages']");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(signUpForm,this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        log.info("Verificando los elementos de la UI");

        log.info("Verificando que el input de Username aparezca");
        softAssert.assertTrue(verifyIsDisplayed(usernameInput),"El Username input no se muestra");

        log.info("Verificando que el input de Email aparezca");
        softAssert.assertTrue(verifyIsDisplayed(emailInput),"El Email input no se muestra");

        log.info("Verificando que el input del Passwor aparezca");
        softAssert.assertTrue(verifyIsDisplayed(passwordInput),"El Password input no se muestra");

        log.info("Verificando que el btn de Sign in aparezca");
        softAssert.assertTrue(verifyIsDisplayed(signInBtn),"El Password input no se muestra");

        softAssert.assertAll();
    }

    public void fillSignUpForm(String username, String email, String password){
        log.info("Ingresando el username");
        type(usernameInput,username);

        log.info("Ingresando el email");
        type(emailInput,email);

        log.info("Ingresando el password");
        type(passwordInput, password);

        log.info("Click en el boton de Sign In");
        click(signInBtn);
    }


    public void verifyErrorMessageText(String text) {
        waitVisibility(errorMessage);

        log.info("Verificando si el mensaje de error se muestra");
        Assert.assertTrue(verifyIsDisplayed(errorMessage));

        log.info("Verificando que el texto del mensaje de error sea el correcto");
        Assert.assertEquals(getText(errorMessage), text);
    }
}
