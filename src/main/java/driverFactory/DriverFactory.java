package driverFactory;

import static org.junit.Assert.fail;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import dataReader.PropertyReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.webdriver.DriverSource;

public class DriverFactory implements DriverSource {

    @Override
    public WebDriver newDriver() {
        WebDriver _driver = null;
        String _browserName = PropertyReader.read("app.browser").toUpperCase();
        DriverType _driverType = DriverType.valueOf(_browserName);
        switch (_driverType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                _driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                _driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                _driver = new EdgeDriver();
                break;
            case IE:
                WebDriverManager.iedriver().setup();
                _driver = new InternetExplorerDriver();
                break;
            case OPERA:
                WebDriverManager.operadriver().setup();
                _driver = new OperaDriver();
                break;
            case ANDROID:		//Code not tested. Use with caution
            	DesiredCapabilities cap=new DesiredCapabilities();
            	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3_API_28");
            	cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
				try {
					_driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
				} catch (MalformedURLException e) {
					e.printStackTrace();
					fail(e.getMessage()+" "+e.getCause());
				}
            default:
                WebDriverManager.chromedriver().setup();
                _driver = new ChromeDriver();
                break;
        }
        _driver.manage().window().maximize();
        return _driver;
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
