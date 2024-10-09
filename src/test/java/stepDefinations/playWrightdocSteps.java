package stepDefinations;

import com.microsoft.playwright.*;
import context.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static pages.playwrightdocsPages.*;

public class playWrightdocSteps {

    private final Page page;

    public playWrightdocSteps() {
        Context.lunchBrowser();
        this.page = Context.getPage();
    }

    @Given("open the site {string}")
    public void inChromeBrowserOpenTheSite(String URl) {
        page.navigate(URl);
    }

    @When("In dropdown select {string}")
    public void inDropdownSelect(String selectVal) {
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
