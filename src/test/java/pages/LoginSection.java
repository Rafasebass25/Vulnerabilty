package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import session.Session;

public class LoginSection {

    public WebElement emailTxtBox;
    public WebElement pwdTxtBox;
    public WebElement loginButton;

    public  LoginSection(){
        emailTxtBox = Session.getSession().getBrowser().findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail"));
        pwdTxtBox = Session.getSession().getBrowser().findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword"));
        loginButton = Session.getSession().getBrowser().findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin"));

    }

}