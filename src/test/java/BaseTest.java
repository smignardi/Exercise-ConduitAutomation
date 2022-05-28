import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Logs;

public class BaseTest {

    public WebDriver driver;
    private Logs log = new Logs();
    private String url = "https://www.google.com";

    @BeforeMethod
    public void setup() {
        log.info("Seteando el driver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        log.info("Maximizando pantalla");
        driver.manage().window().maximize();
        log.info("Borrando cookies");
        driver.manage().deleteAllCookies();
    }


    @Test(priority = 0)
    @Description("Test con allure report")
    @Story("MSA-1234")
    @Severity(SeverityLevel.MINOR)
    public void test1() {
        log.debug("Abriendo pagina de google");
        driver.get(url);
        var currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,url,"Las url no son iguales!");
    }

    @Test(priority = 1)
    @Description("Test con allure report 2")
    @Story("MSA-1234")
    @Severity(SeverityLevel.MINOR)
    public void test2() {
        log.debug("Abriendo pagina de google");
        driver.get(url);
        var currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(url,url,"Las url no son iguales!");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
        log.info("Fin del test");
        log.printSeparator();
    }


}
