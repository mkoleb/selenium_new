package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by zozo on 01.11.2016.
 */
public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver)
    {this.driver = driver;}

    public void enterLogin(String login)
    {driver.findElement(By.xpath("//input[@id='login-form-username']")).sendKeys("m.koleboshin");}

    public void enterPassword(String password)
    {driver.findElement(By.xpath("//input[@id='login-form-password']")).sendKeys("m.koleboshin");}

    public void clickSubmit()
    {driver.findElement(By.xpath("//input[@id='login-form-submit']")).click();}

}
