import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ArabamAppTest {
    AndroidDriver<AndroidElement> driver;
    final String cihazAdi="PIXEL2";
    final String platformIsmi="Android";
    final String version="10.0";
    final String automation="UiAutomator2";

    @BeforeTest
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,cihazAdi);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,platformIsmi);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,version);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,automation);
        capabilities.setCapability("appPackage","com.dogan.arabam");
        capabilities.setCapability("appActivity", "com.dogan.arabam.presentation.feature.home.HomeActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET,false);

        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }

    @Test
    public void arabamTest(){
        // driver.findElement(By.xpath("//*[@text='İlan ver']")).click();

        //Arabam kac para bolumune tikla
        driver.findElement(By.xpath("//*[@text='Arabam kaç para?']")).click();

        // Aracimin fiyatini merak ediyorum bolomune tikla
        AndroidElement fiyatMerak= driver.findElement(By.xpath("//*[@text='Aracımın fiyatını merak ediyorum']"));
        fiyatMerak.click();

        //Volkswagen markasini secelim

        // Yil secimi yap

        // Model secimi yap



    }
}
