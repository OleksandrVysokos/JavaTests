package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Hooks {
    WebDriver driver = new ChromeDriver();

    public Hooks(WebDriver driver) {

    }

    @Before
    public void setUp() {
        driver.get("https://www.openstreetmap.org/");
        driver.manage().window().maximize();
    }
    @After
    public void afterTest(){
        WebElement actualResult = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div[5]/p[1]")));
        String actual = actualResult.getText();
        Assert.assertEquals(actual, "Расстояние: 2423km. Время: 154:28.");
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.quit();
    }
}
