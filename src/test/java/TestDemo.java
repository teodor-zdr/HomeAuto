import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class TestDemo {

    WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Teodor\\Documents\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
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

    @Test
    public void jsonParser() {
        String jsonLine = "{\n" +
                " \"data\": {\n" +
                "  \"translations\": [\n" +
                "   {\n" +
                "    \"translatedText\": \"Hello world\"\n" +
                "   }\n" +
                "  ]\n" +
                " }\n" +
                "}";}
        public String parse(String jsonLine) {
            JsonElement jelement = new JsonParser().parse(jsonLine);
            JsonObject jobject = jelement.getAsJsonObject();
            jobject = jobject.getAsJsonObject("data");
            JsonArray jarray = jobject.getAsJsonArray("translations");
            jobject = jarray.get(0).getAsJsonObject();
            String result = jobject.get("translatedText").getAsString();
            return result;
        }

    @Test
    public void checkbox() {
        driver.get("");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
