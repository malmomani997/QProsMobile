package QProsMobileTask;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public weatherAppHelper WeatherAppHelper;
    private AndroidDriver driver;
    private AppiumDriverLocalService appiumServiceBuilder;

    public AndroidDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver has not been initialized. Call configureAppium() first.");
        }
        return driver;
    }

    public void configureAppium() throws MalformedURLException {
        appiumServiceBuilder = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\USER\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();

        appiumServiceBuilder.start();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "Uiautomator2");
        capabilities.setCapability("app", "C:\\Users\\USER\\Desktop\\QProsMobile\\src\\test\\java\\QProsMobileTask\\resources\\Weather Forecast.apk");
        capabilities.setCapability("deviceName", "myTestDevice");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (appiumServiceBuilder != null) {
            appiumServiceBuilder.stop();
        }
    }

    @BeforeTest
    public void setup() throws MalformedURLException {
        configureAppium();
        WeatherAppHelper = new weatherAppHelper(getDriver());
    }

}