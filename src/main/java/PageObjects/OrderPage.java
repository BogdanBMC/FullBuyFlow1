package PageObjects;

import AbstractComponents.AbstractComponent;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OrderPage extends AbstractComponent {

    WebDriver driver;
    public OrderPage (WebDriver driver) {
        super(driver);
this.driver = driver;
    }

    @FindBy (css = "tr td:nth-child(3)")
    List<WebElement> produseInOrders;


    public String produsInOrders(String numeProdus) throws Exception {
        for (int i = 0; i < produseInOrders.size(); i++) {
            if (produseInOrders.get(i).getText().equalsIgnoreCase(numeProdus)) {
                return "produsul e in cart";
            } else {
                return "produsul nu e in cart";
            }
        }
        throw new Exception("error");

    }
    }
