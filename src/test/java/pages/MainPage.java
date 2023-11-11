package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import session.Session;

public class MainPage {
    public WebElement loginButton;

    public MainPage(){
        loginButton = Session.getSession().getBrowser().findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]"));
    }

}
