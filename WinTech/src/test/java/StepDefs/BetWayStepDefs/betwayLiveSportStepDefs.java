package StepDefs.BetWayStepDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by S.A.M. on 22/02/2016.
 */
public class betwayLiveSportStepDefs{

    public WebDriver driver;
    public List<WebElement> liveSports;
    public List<WebElement> liveMatches;

    @Before("@Betway")
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After("@Betway")
    public void tearDown() {
        driver.close();
    }

    @Given("^i am on the betway site$")
    public void i_am_on_the_betway_site() {
        driver.get("https://sports.betway.com/");
        assertEquals("Online Betting at Betway: Football Bets, Horses & other Sports!", driver.getTitle());
        System.out.println("The Title: Online Betting at Betway: Football Bets, Horses & other Sports! is verified");
    }

    @When("^i enter the live matches section$")
    public void i_enter_the_live_matches_section() {
        driver.findElement(By.className("showMoreEvents")).click();
        assertEquals("Bet In-Play at Betway Sports", driver.getTitle());
    }

    @Then("^i should be able to capture the list of live matches$")
    public void i_should_be_able_to_capture_the_list_of_live_matches() {
        liveSports = driver.findElements(By.className("all_events_sportContainer"));

        for (WebElement sportList : liveSports) {
            SearchContext context = sportList;
            System.out.println("-------------------");
            System.out.println(context.findElement(By.className("alleventspage_sportTitle")).getText());
            System.out.println("-------------------");
            liveMatches = context.findElements(By.className("all_events_eventTitle"));

            for (WebElement live : liveMatches) {
                System.out.println(live.getText());
            }

        }
    }

}

