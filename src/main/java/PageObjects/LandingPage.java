package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {

    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

  //  WebElement email = driver.findElement(By.id("userEmail")).sendKeys(email);
    @FindBy(id = "userEmail")
    WebElement email;
    //WebElement pass = driver.findElement(By.id("userPassword")).sendKeys(pass);
   @FindBy(id = "userPassword")
   WebElement pass;
    @FindBy(id = "login")
    WebElement loginBtn;

    @FindBy (css = "[class*='flyInOut']")
    WebElement errorMessage;

public void goTo(){
    driver.get("https://rahulshettyacademy.com/client/");
}

public String getErrorMessage(){
    waitForWebElementToAppear(errorMessage);
    return errorMessage.getText();
}



    public ProductCatalog logIn(String emailParameter, String passParameter){
        email.sendKeys(emailParameter);
        pass.sendKeys(passParameter);
        loginBtn.click();
        ProductCatalog productCatalog = new ProductCatalog(driver);
        return productCatalog;

    }

}
