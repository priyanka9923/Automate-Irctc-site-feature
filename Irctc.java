package demo;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Irctc {
    ChromeDriver driver;
    public Irctc()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    //get the first element in the irctc site
    public void testCase02() throws InterruptedException{
        // 1. Launch Browser (Chrome) :ChromeDriver()
        // 1.2 Maximize Window :driver.windows().manage().maximize();
        // 1.5 Handle Sync issue using implicitlyWait() :driver.windows().timeouts().implicitlyWait(30,TimeUnit.SECONDS)
        // 2. Load URL  driver.get("https://www.irctc.co.in/nget/train-search")
        driver.get("https://www.irctc.co.in/nget/train-search");
        //  wait for 10 sec  
        Thread.sleep(1000);
        // enter blr in the input box "from" Using Locator "XPath" "(*//input[@role='searchbox'])[1]" || sendKeys("blr")
        driver.findElementByXPath("(*//input[@role='searchbox'])[1]").sendKeys("blr");
        // get the first element in the drop down  Using Locator "XPath" "(*//span[@class='ng-star-inserted'])[1]"
        System.out.println(driver.findElementByXPath("(*//span[@class='ng-star-inserted'])[1]").getText());
        // Print the first city name  "(*//span[@class='ng-star-inserted'])[1]" | getText()
        
   }
    
}
