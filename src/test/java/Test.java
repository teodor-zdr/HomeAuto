import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class Test {

    WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Teodor\\Documents\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @org.testng.annotations.Test
    public void test() throws InterruptedException {
        driver.get("http://codebins.com/bin/4ldqomk/latest");
        Thread.sleep(2000);
        String msg = "Swimming (4)";
        WebElement frame = driver.findElement(By.id("resultFrame"));
        driver.switchTo().frame(frame);
        //WebElement element = driver.findElement(By.xpath("//ul[@data-filtername=\"sport\"]/li"));
        //System.out.print(element.getText());
        boolean match = false;
        List<WebElement> elements = driver.findElements(By.xpath("//ul[@data-filtername=\"sport\"]/li"));
        for(WebElement e:elements){
            if(e.getText().equalsIgnoreCase(msg)){
                match = true;
            }
        }
        assertTrue(match, "not match!!!!!");



    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
