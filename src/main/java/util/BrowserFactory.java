package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {
    static WebDriver driver;

    @BeforeMethod
    public static WebDriver init(){
        System.out.println("Before Class");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver2.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("http://www.techfios.com/billing/?ng=admin/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    @AfterMethod
    public static void tearDown(){
        driver.close();
        driver.quit();
    }
}
