package testSuite;

import org.junit.jupiter.api.*;
import pages.*;
import session.Session;
public class PracticeLogin {

    @BeforeEach
    public void openBrowser(){
        Session.getSession().getBrowser().get("https://practicetestautomation.com/practice-test-login/");
    }

    @AfterEach
    public void closeBrowser(){
        Session.getSession().getBrowser().quit();
    }

    @Test
    @Order(1)
    public void verifyLoginSuccessfully() throws InterruptedException {

        PracticeLoginSection practiceLoginSection = new PracticeLoginSection();
        practiceLoginSection.emailTxtBox.sendKeys("student");
        practiceLoginSection.pwdTxtBox.sendKeys("Password123");
        practiceLoginSection.loginButton.click();

        PracticeMenuSection practiceMenuSection = new PracticeMenuSection();
        // verification
        Assertions.assertTrue(practiceMenuSection.yourBasketButton.isDisplayed(),
                "ERROR> no se pudo iniciar sesion");
    }

}
