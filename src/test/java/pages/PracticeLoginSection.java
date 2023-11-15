package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import session.Session;

public class PracticeLoginSection {

    public WebElement emailTxtBox;
    public WebElement pwdTxtBox;
    public WebElement loginButton;

    public PracticeLoginSection(){
        emailTxtBox = Session.getSession().getBrowser().findElement(By.id("username"));
        pwdTxtBox = Session.getSession().getBrowser().findElement(By.id("password"));
        loginButton = Session.getSession().getBrowser().findElement(By.id("submit"));

    }

}
