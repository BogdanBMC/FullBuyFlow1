package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalog extends AbstractComponent {

    WebDriver driver;

    public ProductCatalog(WebDriver driver){
        super(driver);
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }


@FindBy(css = ".mb-3")
List<WebElement> listaProduse;


By products = By.cssSelector(".mb-3");
By addToCart = By.cssSelector(".btn.btn.w-10.rounded");
By toastMessage = By.cssSelector("#toast-container");

@FindBy(css = ".ng-animating")
        WebElement animation;

@FindBy(css = "button[routerlink='/dashboard/cart']")
WebElement cartButton;




public List<WebElement> productList(){
    waitForElementToAppear(products);
    return listaProduse;
}

    public WebElement getProdName(String prodName) throws Exception {
        for(WebElement produs : listaProduse){
            if(produs.findElement(By.tagName("b")).getText().equalsIgnoreCase(prodName)){
                return produs;
            }
        }
        throw new Exception("produs e null");
    }

public void addToCartBogdan(String prName){
    for(WebElement produs : listaProduse){
        if(produs.findElement(By.tagName("b")).getText().equalsIgnoreCase("iphone 13 pro")){
            produs.findElement(By.cssSelector(".btn.btn.w-10.rounded")).click();
            break;
        }
    }
}


public Cart addToCart(String prName2) throws Exception {
getProdName(prName2).findElement(addToCart).click();
waitForElementToAppear(toastMessage);
waitForElementToDissapear(animation);
cartButton.click();
    Cart cart = new Cart(driver);
    return cart;

}


}









