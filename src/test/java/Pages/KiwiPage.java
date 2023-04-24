package Pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.time.Duration;

public class KiwiPage {

    public KiwiPage (){
        PageFactory.initElements(Driver.getAndroidDriver(),this);
    }
    @FindBy (xpath = "//*[@text='Continue as a guest']")
    public WebElement asAGuest;

    public void ucButtonTiklama(int baslangic, int bitis, int xCoordinat, int yCoordinat, int wait){
        TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
        for (int i = baslangic; i <bitis ; i++) {
            action.press(PointOption.point(xCoordinat,yCoordinat)).
                    waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                    .release().
                    perform();

        }
    }


}
