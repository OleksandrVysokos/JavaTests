import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Tests {
    @Test
    public void mainTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.openstreetmap.org/");
        driver.manage().window().maximize();
        WebElement searchDistanceButton = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='sidebar']/div[1]/form[1]/div/div[2]/a"))));
        searchDistanceButton.findElement(By.xpath("//*[@id='sidebar']/div[1]/form[1]/div/div[2]/a")).click();
        String from = "Радищева, Київ";
        String to = "Кембридж";
        WebElement fromInputField = (new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div[1]/form[2]/div[2]/div[2]/input"))));
        fromInputField.findElement(By.xpath("/html/body/div/div[1]/div[1]/form[2]/div[3]/div[2]/input")).click();
        fromInputField.sendKeys(from);
        WebElement toInputField = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div[1]/form[2]/div[3]/div[2]/input"))));
        toInputField.findElement(By.xpath("/html/body/div/div[1]/div[1]/form[2]/div[3]/div[2]/input")).click();
        toInputField.sendKeys(to);
        WebElement selectTransport = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div[1]/form[2]/div[4]/div[1]/select")));
        selectTransport.findElement(By.xpath("//*[@id='sidebar']/div[1]/form[2]/div[4]/div[1]/select")).click();
        WebElement optionsTransport = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div[1]/form[2]/div[4]/div[1]/select/option[1]"))));
        optionsTransport.click();
        WebElement clickToGoButton = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='sidebar']/div[1]/form[2]/div[2]/div[2]")));
        clickToGoButton.click();
        WebElement actualResult = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div[5]/p[1]")));
        String actual = actualResult.getText();
        Assert.assertEquals(actual, "Расстояние: 2423km. Время: 154:28.");
    }
}
