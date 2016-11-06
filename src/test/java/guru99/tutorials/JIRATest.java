package guru99.tutorials;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CreateIssue;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;

public class JIRATest {
    String login = "m.koleboshin";
    String pass = "m.koleboshin";


    WebDriver driver = new FirefoxDriver();

    @BeforeTest
    public void prerequisites() {
       WebDriver driver = new FirefoxDriver();

        driver.get("http://soft.it-hillel.com.ua:8080/");
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterLogin(login);
        loginPage.enterPassword(pass);
        loginPage.clickSubmit();
    }

    @Test
    public void createIssue() {

        CreateIssue createIssue = new CreateIssue(driver);
        createIssue.createBug();
        createIssue.createSummary();
        createIssue.createAssignee();
        createIssue.getIssueKey();
        createIssue.deleteIssue();
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
