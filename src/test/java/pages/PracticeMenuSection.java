package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import session.Session;

public class PracticeMenuSection {
    public WebElement yourBasketButton;

    public PracticeMenuSection(){
        yourBasketButton = Session.getSession().getBrowser().findElement(By.xpath("//a[normalize-space()='Log out']"));
    }

}
