package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver ;
    public LoginPage (WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="username")
    WebElement usernamePF;

    public WebElement usernamePom(){


        return driver.findElement(By.id("username"));

    }

    public WebElement PasswordPom(){

        return driver.findElement(By.id("password"));
    }

    public By FlashPom(){

        return  By.id("flash");
    }

    public By LogoutPom(){

        return By.cssSelector("a[href=\"/logout\"]");
    }


    public void LoginSteps(String username ,String password){
        usernamePF.clear();
        usernamePom().sendKeys(username);

        PasswordPom().sendKeys(password);


    }
}
