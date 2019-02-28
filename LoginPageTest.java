package test.loginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.login.LoginPage;

public class LoginPageTest
{
WebDriver driver;
@BeforeTest
public void setup()
{
    System.setProperty("webdriver.firefox.marionette","pathToGeckodriver");
    driver=new FirefoxDriver();
    driver.manage().window().maximize();
    driver.get("");
}
 @Test(priority=5)
public void verify1()
{
    LoginPage login=new LoginPage(driver);
    login.set_username("username");
    login.set_password("password");
    login.click_button();
    String expectedText = "Logged in Successfully";
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[text()[contains(., 'Logged in Successfully')]]"))));
    Assert.assertEquals("Logged in Successfully",expectedText);
}
@Test(priority=1)
public void verify2()
{
    LoginPage login=new LoginPage(driver);
    login.set_username("username");
    login.set_password("password");
    login.click_button();
    Assert.assertEquals(driver.findElement(By.xpath("//*[@id='errorMessage']")).getText(),"Wrong username or password!");
}
@Test(priority=2)
public void verify3()
{
    LoginPage login=new LoginPage(driver);
    login.set_username("username");
    login.set_password("password");
    login.click_button();
    Assert.assertEquals(driver.findElement(By.xpath("//*[@id='errorMessage']")).getText(),"Wrong username or password!");
}
@Test(priority=3)
public void verify4()
{
    LoginPage login=new LoginPage(driver);
    login.set_username("username");
    login.set_password("password");
    login.click_button();
    Assert.assertEquals(driver.findElement(By.xpath("//*[@id='errorMessage']")).getText(),"Wrong username or password!");
}
@Test(priority=4)
public void verify5()
{
    LoginPage login=new LoginPage(driver);
    login.set_username("username");
    login.set_password("password");
    login.click_button();
    Assert.assertEquals(driver.findElement(By.xpath("//*[@id='errorMessage']")).getText(),"Wrong username or password!");
}
@AfterTest
public void close()
{
    driver.close();
}
}
