package QProsMobileTask;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

public class weatherAppHelper {

    private AndroidDriver driver;

    public weatherAppHelper(AndroidDriver driver) {
        this.driver = driver;
    }

    private WebElement getWeatherFormatList() {
        return driver.findElement(By.id("com.info.weather.forecast:id/iv_temp_dropdown"));
    }

    private WebElement getWeatherFormatSelected() {
        return driver.findElement(By.id("com.info.weather.forecast:id/tv_temp_setting"));
    }

    private WebElement getCelsiusOption() {
        return driver.findElement(By.xpath("//android.widget.TextView[@text=\"C\"]"));
    }

    private WebElement getTimeFormatList(){
        return driver.findElement(By.id("com.info.weather.forecast:id/iv_timeformat_dropdown"));
    }

    private WebElement get24HoursOption(){
        return driver.findElement(By.xpath("//android.widget.TextView[@text=\"24 Hour\"]"));
    }

    private WebElement getTimeFormatSelected(){
        return driver.findElement(By.id("com.info.weather.forecast:id/tv_timeformat_setting"));
    }

    private WebElement getDoneButton(){
        return driver.findElement(By.id("com.info.weather.forecast:id/tv_button_done"));
    }

    private WebElement getConfirmPolicyButton(){
        return driver.findElement(By.id("com.info.weather.forecast:id/ll_got_it"));
    }

    private WebElement getConfirmLocationWhileUsingAppButton(){
        return driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
    }

    private List<WebElement> humidityIcons(){
        return driver.findElements(By.xpath("(//android.widget.LinearLayout[@resource-id='com.info.weather.forecast:id/ll_humidity'])/android.widget.ImageView"));
    }

    private List<WebElement> rainingIcons(){
        return driver.findElements(By.xpath("(//android.widget.ImageView[@resource-id=\"com.info.weather.forecast:id/iv_rain_chance\"])"));
    }


    public void selectFahrenheitTemperature() {
            getWeatherFormatList().click();
            getCelsiusOption().click();
    }

    public String getSelectedTemperatureFormat() {
            return getWeatherFormatSelected().getText();
    }

    public void select24HoursFormat(){
        getTimeFormatList().click();
        get24HoursOption().click();
    }

    public String getSelectedTimeFormat(){
        return getTimeFormatSelected().getText();
    }

    public void confirmAppSettings(){
        getDoneButton().click();
        getConfirmPolicyButton().click();
    }

    public void confirmLocation(){
        getConfirmLocationWhileUsingAppButton().click();
    }


    public boolean iconsAreDisplayed(List<WebElement> iconsList) {
        int counter = 0;

        for (int i = 0; i < 6; i++) {
            if (iconsList.get(i).isDisplayed()) {
                counter++;
            }
        }
        return counter == 6;
    }


    public boolean humidityAndRainIconsDisplayedForSixHours(){
        return iconsAreDisplayed(humidityIcons()) && iconsAreDisplayed(rainingIcons());
    }


}
