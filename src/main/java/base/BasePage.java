package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utilities.Logs;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected Logs log = new Logs();
    protected int timeout;
    protected WebDriverWait wait;
    protected SoftAssert softAssert;
    private final String mainUrl = "https://www.saucedemo.com/";

    public BasePage(WebDriver driver, int timeout) {
        this.driver = driver;
        this.timeout = timeout;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(this.timeout));
        softAssert = new SoftAssert();
    }

    public BasePage(WebDriver driver) {
        this(driver,5);
    }

    protected void type(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }

    protected void click(By locator){
        driver.findElement(locator).click();
    }

    protected boolean verifyIsDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();
    }

    protected void waitVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitPage(By locator, String className) {
        var message = String.format("Wait %s page to load for %d seconds", className, timeout);
        log.info(message);

        waitVisibility(locator);

        message = String.format("%s page loaded successfully", className);
        log.info(message);
    }

    public void goToIndex() {
        log.info("Going to the index page");
        driver.get(mainUrl);
    }

    protected abstract void verifyPage();

    public abstract void waitPageToLoad();
}
