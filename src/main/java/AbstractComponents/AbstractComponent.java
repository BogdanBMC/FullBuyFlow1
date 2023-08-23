package AbstractComponents;

import PageObjects.OrderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {

WebDriver driver;



    public AbstractComponent(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@routerlink='/dashboard/myorders']" )
    WebElement orders;

public void waitForElementToAppear(By findBy) {
    WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
    w.until(ExpectedConditions.visibilityOfElementLocated(findBy));

}

    public void waitForWebElementToAppear(WebElement findBy) {
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.visibilityOf (findBy));

    }

public  void waitForElementToDissapear(WebElement animation){
    WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(4));
    w.until(ExpectedConditions.invisibilityOf(animation));
}

public OrderPage goToOrdersPage() throws InterruptedException {
    orders.click();
    Thread.sleep(2000);
    OrderPage orderPage = new OrderPage(driver);
            return orderPage;
}


}
