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

    @FindBy (xpath = "//*[@text='Return']")
    public WebElement returnButton;

    @FindBy (xpath = "//*[@text='One way']")
    public WebElement oneWay;

    @FindBy (xpath = "//*[@text='From:']")
    public WebElement kalkisButonu;

    @FindBy (xpath = "//android.view.View[@content-desc=\"Clear All\"]")
    public WebElement defaultUlkeSilme;

    @FindBy (xpath = "//*[@text='İzmir, Turkey']")
    public WebElement izmir;

    @FindBy (xpath = "//*[@text='Choose']")
    public WebElement choose;

    @FindBy (xpath = "(//*[@text='Anywhere'])[1]")
    public WebElement anywhere;

    @FindBy (xpath = "//*[@text='Berlin, Germany']")
    public WebElement berlin;

    @FindBy (xpath = "(//*[@text='Anytime'])[1]")
    public WebElement anyTimeButton;

    @FindBy (xpath = "//*[@text='Set date']")
    public WebElement setDate;

    @FindBy (xpath = "(//*[@text='Search'])[1]")
    public WebElement search;

    @FindBy (xpath = "(//*[@text='Best'])[1]")
    public WebElement bestPrice;

    @FindBy (xpath = "(//*[@text='Cheapest'])[1]")
    public WebElement cheapest;

    @FindBy (xpath = "(//*[@text='Stops'])[1]")
    public WebElement stops;

    @FindBy (xpath = "(//*[@text='Nonstop'])[1]")
    public WebElement nonStop;

    @FindBy (xpath = "//*[@class='android.widget.TextView'][12]")
    public WebElement ticketprice;



    public static void ucButtonTiklama(int baslangic, int bitis, int xCoordinat, int yCoordinat, int wait){
        TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
        for (int i = baslangic; i <bitis ; i++) {
            action.press(PointOption.point(xCoordinat,yCoordinat)).
                    waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                    .release().
                    perform();

        }
    }


}
