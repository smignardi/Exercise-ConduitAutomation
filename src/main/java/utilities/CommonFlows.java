package utilities;

import org.openqa.selenium.WebDriver;
import pageobject.credentials.LoginPage;

public class CommonFlows {
    private final Logs logs = new Logs();
    private final WebDriver driver;

    public CommonFlows(WebDriver driver) {
        this.driver = driver;
    }

    public void goToIndex(){
        var loginPage = new LoginPage(driver);

        loginPage.goToIndex();
        loginPage.waitPageToLoad();
    }


}
