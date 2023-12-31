package testSuite;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class LoginTest {

    WebDriver chrome;
    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chrome/chromedriver.exe");

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("127.0.0.1:9292");
        proxy.setSslProxy("127.0.0.1:9292");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("ignore-certificate-errors");

        Map<String,Object> prefs=  new HashMap<>();
        prefs.put("credentials_enable_service",false);
        chromeOptions.setExperimentalOption("prefs",prefs);
        chromeOptions.setProxy(proxy);

        chrome = new ChromeDriver(chromeOptions);
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        chrome.manage().window().maximize();
        chrome.get("http://todo.ly/");
    }

    @AfterEach
    public void closeBrowser(){
        chrome.quit();
    }

//    @Test
//    @Order(1)
    public void verifyLoginSuccessfully() throws InterruptedException {
        Thread.sleep(5000);
        // click imagen login
        chrome.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();
        // set email
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("zap@zap2023.com");
        // set pwd
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        // click login button
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        // verification
        Assertions.assertTrue(chrome.findElement(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")).isDisplayed(),
                "ERROR> no se pudo iniciar sesion");
    }

}
