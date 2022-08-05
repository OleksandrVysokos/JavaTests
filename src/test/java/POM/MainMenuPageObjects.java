package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainMenuPageObjects {
    WebDriver driver = new ChromeDriver();

    public MainMenuPageObjects(WebDriver driver) {}

    public void clickOnTheSearchDistanceButton() {
        WebElement searchDistanceButton = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='sidebar']/div[1]/form[1]/div/div[2]/a"))));
        searchDistanceButton.findElement(By.xpath("//*[@id='sidebar']/div[1]/form[1]/div/div[2]/a")).click();
    }
    public void enterDataToFromField() {
        String from = "Радищева, Київ";
        WebElement fromInputField = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div[1]/form[2]/div[2]/div[2]/input"))));
        fromInputField.findElement(By.xpath("/html/body/div/div[1]/div[1]/form[2]/div[3]/div[2]/input")).click();
        fromInputField.sendKeys(from);
    }
    public void enterDataToToField() {
        String to = "Кембридж";
        WebElement toInputField = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div[1]/form[2]/div[3]/div[2]/input"))));
        toInputField.findElement(By.xpath("/html/body/div/div[1]/div[1]/form[2]/div[3]/div[2]/input")).click();
        toInputField.sendKeys(to);
    }
    public void selectTypeOfTransport() {
        WebElement selectTransport = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div[1]/form[2]/div[4]/div[1]/select")));
        selectTransport.findElement(By.xpath("//*[@id='sidebar']/div[1]/form[2]/div[4]/div[1]/select")).click();
        WebElement optionsTransport = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div[1]/form[2]/div[4]/div[1]/select/option[1]"))));
        optionsTransport.click();
    }
    public void goButtonClick() {
        WebElement clickToGoButton = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='sidebar']/div[1]/form[2]/div[2]/div[2]")));
        clickToGoButton.click();
    }
}
