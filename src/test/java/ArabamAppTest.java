import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
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
    public void arabamTest() throws InterruptedException {
        // driver.findElement(By.xpath("//*[@text='İlan ver']")).click();

        //Arabam kac para bolumune tikla
        driver.findElement(By.xpath("//*[@text='Arabam kaç para?']")).click();

        // Aracimin fiyatini merak ediyorum bolomune tikla
        AndroidElement fiyatMerak= driver.findElement(By.xpath("//*[@text='Aracımın fiyatını merak ediyorum']"));
        fiyatMerak.click();

        //Volkswagen markasini secelim
        TouchAction action=new TouchAction<>(driver);
        action.press(PointOption.point(543,1730)).
                waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).
                moveTo(PointOption.point(537,381)).
                release().perform();

        Thread.sleep(2000);

        driver.findElementByXPath("  //*[@text='Volkswagen']").click();

        /*a ction.press(PointOption.point(537,381)).
                waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).
                moveTo(PointOption.point(543,1732)).
                release().perform();

         */

        // Yil secimi yap
        driver.findElementByXPath("  //*[@text='2011']").click();

        // Model secimi yap
        driver.findElementByXPath("  //*[@text='Passat']").click();

        // Govde secimi yap
        driver.findElementByXPath("  //*[@text='Sedan']").click();

        // Yakit tipi secimi
        driver.findElementByXPath("  //*[@text='Benzin']").click();

        // Vites tipini secelim
        driver.findElementByXPath("  //*[@text='Yari Otomatik']").click();

        // Versiyon secimi yapalim
        Thread.sleep(1000);
        action.press(PointOption.point(490,1747)).release().perform();

        // Aracin km bilgilerini girelim
        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("190000");
        }
        else {
            driver.findElementById("com.dogan.arabam:id/et_km").sendKeys("190000");
        }
        driver.findElementById("com.dogan.arabam:id/btn_price_prediction_submit").click();

        // aracin rengini secelim
        driver.findElementByXPath("  //*[@text='Gri (metalik)']").click();

        // Opsiyonel donanim varsa secelim
        driver.findElementById("  com.dogan.arabam:id:btnNext").click();

        // Degisen bilgisi ekleyerek tramer kaydi belirtelim
        AndroidElement kaput= driver.findElementById("com.dogan,arabam:id/iv_B01001");
        kaput.click();

        driver.findElementByXPath("(//*[@text='Boyali'])[2]").click();

        Thread.sleep(1000);
        driver.findElementById("com.dogan.arabam:id/btn_next").click();

        // Aracimizin fiyatinin 500.00 tl den fazla oldugunu test edelim







    }
}
