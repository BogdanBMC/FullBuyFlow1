package TestComponents;

import PageObjects.LandingPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTests {
public WebDriver driver;
public LandingPage landingPage; // variabila din globala si publica din parent, ptr ca nu am mai initializat in metoda jos
//aici e nu dar primeste valoare jos


public WebDriver initialiseBrowser() throws IOException {
    Properties properties = new Properties();
    FileInputStream fileInputStream = new FileInputStream("D:\\Java\\JavaProjects\\MavenBigProject\\src\\main\\java\\Resources\\GlobalData.properties");
    properties.load(fileInputStream);
  //  String browser = properties.getProperty("browser"); //asta ia parametru din properties file
    String browser = System.getProperty("browser"); //asta ia parametru system level din cmd sau maven sau jenkins
   // System.getProperty("browser");


    if(browser.equalsIgnoreCase("chrome")) {
        System.setProperty("werdriver.chrome.driver", "\"D:\\Java\\Chromedriver\\chromedriver_win32\\chromedriver.exe\\");
         driver = new ChromeDriver();
    }
    else if(browser.equalsIgnoreCase("firefox")) {
        System.setProperty("werdriver.geko.driver", "xe\\");
         driver = new FirefoxDriver();
    }
    else if (browser.equalsIgnoreCase("edge")) {
        System.setProperty("werdriver.edge.driver", "\"Dr.exe\\");
         driver = new EdgeDriver();
    }
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    return driver;
}

@BeforeMethod(alwaysRun = true)  // e in parent si o sa fie vericata pe langa ce e in child, deci executa prima
//
public LandingPage launchApp() throws IOException {
   driver= initialiseBrowser();
   landingPage = new LandingPage(driver); //nu se initializeaza alt obiect, doar il face global
    landingPage.goTo();
    return landingPage;
}

@AfterMethod(alwaysRun = true) //ruleaza mereu indiferent de grups
    public void closeDriver(){
    driver.close();
}

    public String screenshot(String testcase, WebDriver driver) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source =  ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("C:\\Users\\culce\\Desktop\\ss\\" + testcase + ".png"));
        return "C:\\Users\\culce\\Desktop\\ss\\" + testcase + ".png";



    }

    

}
