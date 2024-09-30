package stepDefinations;

import com.microsoft.playwright.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static pages.talentPortalPages.*;

public class employeeSteps {

    static Page page;
    static Browser browser;
    public static BrowserContext context;
    static Playwright playwright;

    @Before
    public static void beforeStart() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
        context = browser.newContext();
    }

    @Given("login to talent portal")
    public void loginToTalentPortal() {
        String URL = System.getProperty("loginURL");
        navigateToTalentPortal(URL);
    }

    @Then("In Quick Search, enter any name and click on Search button")
    public void inQuickSearchEnterAnyNameAndClickOnSearchButton() {
        searchForEmployee();
    }

    @And("Capture Mail Id and Phone number from the results and print the same.")
    public void captureMailIdAndPhoneNumberFromTheResultsAndPrintTheSame() {
        readDetails();
    }

    @And("Close browser window")
    public void closeBrowserWindow() {
        browser.close();
    }

    @Then("Click on Global links")
    public void clickOnGlobalLinks() {
        clickOnGlobalLink();
    }

    @And("Click on Corporate Directory")
    public void clickOnCorporateDirectory() {
        clickOnCorporationlink();
    }
}
