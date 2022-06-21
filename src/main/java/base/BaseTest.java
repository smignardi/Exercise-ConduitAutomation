package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.CommonFlows;
import utilities.DriverManager;
import utilities.Logs;

public abstract class BaseTest {

    protected WebDriver driver;
    protected CommonFlows commonFlows;
    protected final Logs logs = new Logs();
    protected final String regression = "Regression";
    protected final String smoke = "Smoke";

    @BeforeMethod(alwaysRun = true)
    protected void setUpBase(){
        driver = new DriverManager().initLocalDriver();

        logs.debug("Maximizando la pantalla");
        driver.manage().window().maximize();

        logs.debug("Borrando todos los cookies");
        driver.manage().deleteAllCookies();

        initPages();

        commonFlows = new CommonFlows(driver);
        commonFlows.goToIndex();
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDownBase() {
        logs.debug("Killing the driver");
        driver.quit();
    }

    protected abstract void initPages();
}
