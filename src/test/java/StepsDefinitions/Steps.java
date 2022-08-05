package StepsDefinitions;

import Hooks.Hooks;
import POM.MainMenuPageObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class Steps {
    WebDriver driver = new ChromeDriver();

    @Given("User launches Google Chrome browser and go to url https:www.openstreetmap.org")
    public void userLaunchesGoogleChromeBrowserAndGoToUrl() {
        Hooks hooks = new Hooks(driver);
        hooks.setUp();
    }

    @When("User click on the search distance button")
    public void userClickOnTheSearchDistanceButton() {
        MainMenuPageObjects distanceButton = new MainMenuPageObjects(driver);
        distanceButton.clickOnTheSearchDistanceButton();
    }

    @When("enter From point ")
    public void enterFromPoint() {
        MainMenuPageObjects fromField = new MainMenuPageObjects(driver);
        fromField.enterDataToFromField();
    }

    @When("enter To point ")
    public void enterToPoint() {
        MainMenuPageObjects toField = new MainMenuPageObjects(driver);
        toField.enterDataToToField();
    }

    @When("in the transport option dropdown list select Bicycle (OSRM)")
    public void inTheTransportOptionDropdownListSelectBicycleOsrm() {
        MainMenuPageObjects selectFromDropdownList = new MainMenuPageObjects(driver);
        selectFromDropdownList.selectTypeOfTransport();
    }

    @When("click to Go button")
    public void clickToGoButton() {
        MainMenuPageObjects goButton = new MainMenuPageObjects(driver);
        goButton.goButtonClick();
    }

    @Then("Verify the distance is 2423km")
    public void verify_the_distance_is_2423km() {
        Hooks hooks = new Hooks(driver);
        hooks.afterTest();
    }
}
