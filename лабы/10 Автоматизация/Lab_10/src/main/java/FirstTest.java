import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class FirstTest {
    public ChromeDriver driver;
    @Before
    public void SetUp () {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\НПО\\Testing_5sem\\лабы\\10 Автоматизация\\Lab_10\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.by/");
        driver.findElement(By.name("q")).sendKeys("iTechArt" + Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a#pnnext")));
    }

    @After
    public void Close() {

    }

    //TODO Title вкладки браузера содержит слово “iTechArt”
    @Test
    public void testTitle() {
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("iTechArt"));
    }

    //TODO Первый результат содержит слово “iTechArt”
    @Test
    public void testResult() {
        List<WebElement> linkElements = driver.findElements(By.xpath("//h3[@class=\"LC20lb DKV0Md\"]"));

        for (WebElement l: linkElements)
        {
            System.out.println(l.getText());
        }
       System.out.println(linkElements.size());

        Assert.assertTrue(linkElements.get(0).getText().contains("iTechArt"));
    }
}

