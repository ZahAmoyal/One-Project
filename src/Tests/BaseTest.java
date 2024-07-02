package Tests;

import Flows.OneFlow;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    static WebDriver driver;

    static OneFlow oneFlow;

    // ביצוע איתחול לכל הflows
    public static void resetFlows() {
        oneFlow = new OneFlow(driver);
    }


    public static void setupBrowzer() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/AsusX514/IdeaProjects/SportArticels/src/Data/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        //chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("disable-popup-blocking");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60000));
        driver.manage().window().maximize();
    }
    public void waitVisibility(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1500));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    @BeforeClass
    public static void setup(){
        setupBrowzer();
        resetFlows();
    }


}
