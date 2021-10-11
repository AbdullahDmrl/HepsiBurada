package Utils;

import Pages.Parent;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class BaseDriver {

    public static WebDriver driver;

    public static WebDriver getDriver()
    {   if (!runningFromIntelij()) {
            // Hafizada calisma yani headless work(Jenkins) bu durumda intelij den calismaz ve option vermeliyiz
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu", "--window-size=1400,2400"); //width, height
           // WebDriverManager.chromedriver().setup();
             WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }
        else {     // Intelij den calisiyorsa asagidakini set ediyor

         WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
        }
        String classPath=System.getProperty("java.class.path");

        System.out.println("classPath = " + classPath);
        System.out.println("Intellij den mi calisiyor= "+runningFromIntelij());
        return driver;


    }

    public static void DriverQuit()
    {

        Parent.delay(5);

       driver.quit();
    }

    public static boolean runningFromIntelij()
    {

        String classPath=System.getProperty("java.class.path");
        return classPath.contains("idea_rt.jar");
    }

}
