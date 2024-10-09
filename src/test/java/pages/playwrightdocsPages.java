package pages;

import com.microsoft.playwright.Locator;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static context.Context.page;


public class playwrightdocsPages {
    protected static String valuseTOcheck;

    public static void selectValuleFromDropDown(String searchVal) {
        page.hover(".navbar__item.dropdown.dropdown--hoverable");
        page.locator("//*[@class=\"dropdown__menu\"]/li/a[contains(text(),'" + searchVal + "')]").click();

    }

    public static void searchForTopic(String topic) {
        page.waitForTimeout(500);
        page.locator(".DocSearch-Search-Icon").click();
        Locator search = page.locator(".DocSearch-Input");
        search.fill(topic);
        page.waitForTimeout(500);
        search.press("Enter");
        valuseTOcheck = topic;
    }

    public static void validateTopic() {
        page.locator("h1").waitFor(new Locator.WaitForOptions().setTimeout(2000));
        Locator heading = page.locator("h1");
        assertThat(heading).containsText(valuseTOcheck);
    }
}
