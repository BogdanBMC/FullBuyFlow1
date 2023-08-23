package P1;

import PageObjects.*;
import TestComponents.BaseTests;
import TestComponents.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;



public class ErrorValidations extends BaseTests {


    @Test(groups = {"error Handling"}, retryAnalyzer = Retry.class)   // trebuie bagat manual in testele care vreau sa le repete retry analizer  in caz de fail
    public void errorTest() {
        landingPage.logIn("testaugust@gmail.com", "sdgfdsgfd");
        Assert.assertEquals("Incorrect eml or password.", landingPage.getErrorMessage());

    }

    @Test
    public  void productOrderValidation() throws Exception {
        String email = "testaugust@gmail.com";
        String pass = "Testtest123?";
        String product = "iphone 13 pro";
        String country = "Romania";

        //login
        ProductCatalog productCatalog = landingPage.logIn(email,pass);
        //Product catalog page
        Cart cart = productCatalog.addToCart(product);
        //cart
        Checkout checkout = cart.produsInCart(product);
        //checkout
        checkout.selectCounty(country);
        ConfirmationPage confirmationPage = checkout.order();
        //confirmation
      //  confirmationPage.getConfirmatioonMessage();
        Assert.assertEquals("THANKYOU FOR THE ORDER.",confirmationPage.getConfirmatioonMessage() );
    }


}
