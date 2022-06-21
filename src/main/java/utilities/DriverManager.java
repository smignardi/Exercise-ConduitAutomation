package utilities;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {
    private final Logs logs = new Logs();
    private String browser;

    public WebDriver initLocalDriver(){
        if(browser == null){
            logs.debug("Seteando Chrome como browser por default");
            browser = "CHROME";
        }

        switch (this.browser){
            case "CHROME" :
                ChromeDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "EDGE":
                EdgeDriverManager.edgedriver().setup();
                return new EdgeDriver();
            default:
                return null;
        }
    }



}
