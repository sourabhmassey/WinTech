package StepDefs.GoogleNews;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by SAM on 22/02/2016.
 */
public class googleNewsStepDefs {
    public WebDriver driver;
    public List<WebElement> articleList;
    public List<WebElement> newsHeadLines;

    @Before("@GoogleNews")
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After("@GoogleNews")
    public void tearDown() {
        driver.close();
    }

    @Given("^i am on the news page of google$")
    public void i_am_on_the_news_page_of_google() {
        driver.get("http://news.google.com/");
        assertEquals("Google News", driver.getTitle());
        System.out.println("The Title: Google News is verified");
        System.out.println("------------------------------------------------------------------");
    }

    @Then("^i should be able to capture all the headline text on the news page$")
    public void i_should_be_able_to_capture_all_the_headline_text_on_the_news_page() {
        articleList = driver.findElements(By.className("esc-lead-article-title"));
        System.out.println();
        for (WebElement artList : articleList) {
            SearchContext context = artList;
            newsHeadLines = context.findElements(By.className("titletext"));

            for (WebElement nhl : newsHeadLines){
                System.out.println(nhl.getText());
                System.out.println();
            }

        }
    }
}
