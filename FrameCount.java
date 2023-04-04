package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public abstract class FrameCount {
     ChromeDriver driver;
    public FrameCount()
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
    //frame count
    public void testCase06() throws InterruptedException{
        // 1. Launch Browser (Chrome) :ChromeDriver()
        // 1.2 Maximize Window :driver.windows().manage().maximize();
        // 1.5 Handle Sync issue using implicitlyWait() :driver.windows().timeouts().implicitlyWait(30,TimeUnit.SECONDS)
        // 2. Load URL  https://www.irctc.co.in/nget/train-search
        driver.get("https://www.irctc.co.in/nget/train-search");
        // 3. wait for 10 second  
        Thread.sleep(1000);
        // 4. get the list of iframes in the page Using Locator "Tag Name" "iframe" | driver.findElementsByXPath("*//iframe")
        List<WebElement> list= driver.findElementsByTagName("iframe");
        // 5.2. go to the parent window  driver.switchTo().parentFrame()
        driver.switchTo().parentFrame();
        System.out.println((list.size()));
    }

}
