package stepDefinations;

import com.microsoft.playwright.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static pages.playwrightdocsPages.*;

public class playWrightdocSteps {

    public static Page page;
    static Browser browser;
    public static BrowserContext context;
    static Playwright playwright;

    @Before
    public static void beforeStart() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
    }

    @Given("In chrome browser open the site {string}")
    public void inChromeBrowserOpenTheSite(String URl) {
        page.navigate(URl);
    }

    @When("In dropdown select {string}")
    public void inDropdownSelect(String selectVal) throws InterruptedException {
        selectValuleFromDropDown(selectVal);
    }

    @Then("Click on Search link and enter any topic {string} in the search box.")
    public void clickOnSearchLinkAndEnterAnyTopicInTheSearchBox(String topic) {
        searchForTopic(topic);
    }

    @And("Validate the topic")
    public void validateTheTopic() {
        validateTopic();
    }
}
