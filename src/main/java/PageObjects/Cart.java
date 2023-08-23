package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Cart extends AbstractComponent {
    WebDriver driver;

    public Cart(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='cartSection']")
    List<WebElement> produseInCart;
    @FindBy(xpath = "//button[text()='Checkout']")
    WebElement checkout;

    public Checkout produsInCart(String numeProdus){
        for(int i =0; i<produseInCart.size();i++){
            if(produseInCart.get(i).findElement(By.cssSelector("div[class='cartSection'] h3")).getText().equalsIgnoreCase(numeProdus)){
                System.out.println("produsul e in cart");
            }
            else {
                System.out.println("produsul nu e in cart");
            }
        }
        checkout.click();
        Checkout checkout = new Checkout(driver);
        return checkout;
    }




}
