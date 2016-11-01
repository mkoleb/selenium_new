package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateIssue {
    private WebDriver driver;
    String issueKey = "";

    public CreateIssue(WebDriver driver) {
        this.driver = driver;
    }

    public void createIssue() {
        WebElement createButton = (new WebDriverWait(driver, 10))                                           // ждем появление кнопки
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='create_link']")));    //
        createButton.click();                                                                               //нажимаем после ее появления

        WebElement issueType = (new WebDriverWait(driver, 10))                                                           //EXPLICIT wait?
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='issuetype-field']")));

        issueType.clear();          //убираем, если что-то было написано
        issueType.sendKeys("Bug");  // определяем тип

        issueType.sendKeys(Keys.ENTER); //кликаем создать
    }

    public void createSummary() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement summary = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='summary']")));
        summary.clear();
        summary.sendKeys("my wd summary");
    }

    public void deleteIssue() {
        driver.get("http://soft.it-hillel.com.ua:8080/browse/" + issueKey);
        driver.findElement(By.xpath("//*[@id='opsbar-operations_more']/span[1]")).click();
        driver.findElement(By.xpath("//*[@id='delete-issue']/span")).click();
        driver.findElement(By.xpath("//*[@id='delete-issue-submit']")).click();
    }

}
