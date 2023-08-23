package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Checkout extends AbstractComponent {
    WebDriver driver;

    public Checkout(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(css = "input[placeholder*='Country']")
    WebElement countryField;

    @FindBy(css = ".ng-star-inserted")
    List<WebElement> tari;

    @FindBy(xpath = "//a[text()='Place Order ']")
    WebElement order;

    public void selectCounty (String country) throws InterruptedException {
        countryField.click();
        countryField.sendKeys("Ro");
        Thread.sleep(1000);
        for(WebElement tara : tari){
            if(tara.getText().equalsIgnoreCase(country)){
                tara.click();
                break;
            }
        }
    }

    public ConfirmationPage order(){
        order.click();
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        return confirmationPage;
    }



}
