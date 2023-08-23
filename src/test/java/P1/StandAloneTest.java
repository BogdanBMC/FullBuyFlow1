package P1;

import PageObjects.LandingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {

public static void main(String[] args) throws InterruptedException {

    System.setProperty("werdriver.chrome.driver","\"D:\\Java\\Chromedriver\\chromedriver_win32\\chromedriver.exe\\");
    WebDriver driver = new ChromeDriver();
    driver.get("https://rahulshettyacademy.com/client/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    String email = "testaugust@gmail.com";
    String pass = "Testtest123?";
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));


    //login
    LandingPage landingPage = new LandingPage(driver);
    driver.findElement(By.id("userEmail")).sendKeys(email);
    driver.findElement(By.id("userPassword")).sendKeys(pass);
    driver.findElement(By.id("login")).click();

    //addproduct to cart
   List<WebElement> listaProduse = driver.findElements(By.cssSelector(".mb-3"));
   for(WebElement produs : listaProduse){
        if(produs.findElement(By.tagName("b")).getText().equalsIgnoreCase("iphone 13 pro")){
            produs.findElement(By.cssSelector(".btn.btn.w-10.rounded")).click();
            break;
        }
   }
    wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating")))) ;
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
   System.out.println(driver.findElement(By.cssSelector("#toast-container")).getText());
    driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
    // verify products in cart
   List<WebElement> produseInCart = driver.findElements(By.xpath("//div[@class='cartSection']"));
   for(int i =0; i<produseInCart.size();i++){
       if(produseInCart.get(i).findElement(By.cssSelector("div[class='cartSection'] h3")).getText().equalsIgnoreCase("iphone 13 pro")){
           Assert.assertTrue(true);
           System.out.println(produseInCart.get(i).getText());
       }
   }
//buy
    driver.findElement(By.xpath("//button[text()='Checkout']")).click();
//confirm and close
driver.findElement(By.cssSelector("input[placeholder*='Country']")).sendKeys("ro");
Thread.sleep(1000);
 List<WebElement> tari = driver.findElements(By.cssSelector(".ng-star-inserted"));

 for(WebElement tara : tari){
     if(tara.getText().equalsIgnoreCase("Romania")){
         tara.click();
         break;
     }
 }
driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
    System.out.println(driver.findElement(By.cssSelector(".hero-primary")).getText());
    driver.close();
}
}
