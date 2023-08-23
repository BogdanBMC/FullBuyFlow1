package P1;

import PageObjects.*;
import TestComponents.BaseTests;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class SubmitOrderTest extends BaseTests {
    String product = "iphone 13 pro";
        @Test(dataProvider="getData", groups = {"purchase","smoke"})
        public  void submitOrder(HashMap<String,String> input) throws Exception {
    String country = "Romania";

    //login
    ProductCatalog productCatalog = landingPage.logIn(input.get("email"),input.get("pass"));
    //Product catalog page
    Cart cart = productCatalog.addToCart(input.get("product"));
    //cart
    Checkout checkout = cart.produsInCart(input.get("product"));
    //checkout
    checkout.selectCounty(country);
    ConfirmationPage confirmationPage = checkout.order();
    //confirmation
            // Assert.assertEquals("THANKYOU FOR THE ORDER.",confirmationPage.getConfirmatioonMessage() );
}

@Test(dependsOnMethods = {"submitOrder"})
    public void OrderHistoryTest() throws Exception {
    ProductCatalog productCatalog = landingPage.logIn("testaugust@gmail.com","Testtest123?");
        OrderPage orderPage =  productCatalog.goToOrdersPage();
        if(orderPage.produsInOrders(product).equalsIgnoreCase("produsul e in cart")){
            Assert.assertTrue(true);
        }
        else {Assert.assertTrue(false);}
}

@DataProvider
    public Object[][] getData(){

    HashMap <String,String> map = new HashMap<String, String>();
    map.put("email","testaugust@gmail.com");
    map.put("pass","Testtest123?" );
    map.put("product","iphone 13 pro" );

    HashMap <String,String> map1 = new HashMap<String, String>();
    map1.put("email","anshika@gmail.com");
    map1.put("pass","Iamking@000" );
    map1.put("product","ZARA COAT 3" );


    return new Object[][]  {{map},{map1} }; //Object e generic data type
}




}
