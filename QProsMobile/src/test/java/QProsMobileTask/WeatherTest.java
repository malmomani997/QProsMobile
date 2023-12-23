package QProsMobileTask;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;



public class WeatherTest extends BaseTest {

    @Test
    public void verifyTemperatureFormatSelection() {

        WeatherAppHelper.selectFahrenheitTemperature();
        Assert.assertEquals(WeatherAppHelper.getSelectedTemperatureFormat(), "C", "Temperature format is not as expected");

        WeatherAppHelper.select24HoursFormat();
        Assert.assertEquals(WeatherAppHelper.getSelectedTimeFormat() , "24 Hour" , "Time format is not as expected");

        WeatherAppHelper.confirmAppSettings();
        WeatherAppHelper.confirmLocation();

        Assert.assertTrue(WeatherAppHelper.humidityAndRainIconsDisplayedForSixHours(),"Humidity or Raining icons are not displayed for the next six hours");
    }

    @AfterTest
    public void tearDown() {
        super.tearDown();
    }
}