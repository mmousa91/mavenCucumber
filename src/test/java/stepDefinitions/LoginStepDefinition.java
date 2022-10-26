package stepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefinition {
WebDriver driver = null;
LoginPage Login;


    @Given("user open browser")

    public void user_open_browser() throws InterruptedException {
        String Chromepath = System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver",Chromepath);

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        Thread.sleep(2000);

        Login = new LoginPage(driver);

    }

    @And("user navigates to login page")

    public void user_navigates()
    {
        driver.get("https://the-internet.herokuapp.com/login");

    }

    @When("^user enter \"(.*)\" and \"(.*)\"$")

    public void valid_data(String username, String password)
    {
        Login.LoginSteps("tomsmith" , "SuperSecretPassword!");

    }

    @And("user click on login button")
    public void login_button() throws InterruptedException {
        Login.PasswordPom().sendKeys(Keys.ENTER);
        Thread.sleep(3000);

    }

    @Then("user can login successfuly and enter the login page")
    public void success_login()
    {
        String expectedResult= "You logged into a secure area!";
        String actualResult =driver.findElement(Login.FlashPom()).getText();

        Assert.assertTrue(actualResult.contains(expectedResult));
     //   Assert.assertEquals(actualResult.contains(expectedResult),true);

    }

    @Then("user could not login")
    public void wrong_login()
    {
         String expectedResult = "Your username is invalid!";
        String actualResult =driver.findElement(Login.FlashPom()).getText();

        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    @And("user go to home page")
    public void home_page()
    {
Assert.assertEquals("https://the-internet.herokuapp.com/secure",driver.getCurrentUrl());
    }
}
