package guru99.tutorials;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import pages.CreateIssue;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;

public class JIRATest {

    WebDriver driver = new FirefoxDriver();

    @Test
    public void login() {
        //System.setProperty("webdriver.chrome.driver", "geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        String login = "m.koleboshin";
        String pass = "m.koleboshin";
        String eTitle = "Log in - JIRA";
        String aTitle = "";

        driver.get("http://soft.it-hillel.com.ua:8080/");
        driver.manage().window().maximize();
        aTitle = driver.getTitle();
        assertEquals(eTitle, aTitle);

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterLogin(login);
        loginPage.enterPassword(pass);
        loginPage.clickSubmit();

        try {
            Thread.sleep(5000);                 //вопрос с ожиданияим тут. для чего Thread.sleep?
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();
    }

    @Test
    public void createIssue() {
        WebDriver driver = new FirefoxDriver();
        CreateIssue create = new CreateIssue(driver);
        driver.get("http://soft.it-hillel.com.ua:8080/");
        driver.manage().window().maximize();

        create.createIssue();
        create.createSummary();
        create.deleteIssue();

        driver.close();
        driver.quit();

        //то что было изначально:
        /*driver.findElement(By.id("login-form-username")).sendKeys(login); //сделать xpath вместо id
        driver.findElement(By.id("login-form-password")).sendKeys(pass); //сделать xpath вместо id
        driver.findElement(By.id("login-form-submit")).click();
        driver.findElement(By.xpath(".//*[@id='create_link']")).click();
        driver.findElement(By.xpath(".//*[@id='project-field']")).click();
        driver.findElement(By.xpath(".//*[@id='qaautomation2-(qaaut)-71']/a")).click();
        driver.findElement(By.xpath(".//*[@id='issuetype-field']")).click();
        driver.findElement(By.xpath(".//*[@id='bug-145']/a")).click();
        driver.findElement(By.xpath(".//*[@id='summary']")).sendKeys("some summary");
        driver.findElement(By.xpath(".//*[@id='create-issue-submit']")).click(); */
    }
}
