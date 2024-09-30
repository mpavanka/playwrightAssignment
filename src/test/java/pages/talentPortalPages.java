package pages;

import com.microsoft.playwright.*;

import static selectors.selectors.*;
import static stepDefinations.employeeSteps.context;


public class talentPortalPages {

    static Page page = context.newPage();

    public static void navigateToTalentPortal(String url) {
        page.navigate(url);
    }

    public static void clickOnGlobalLink() {
        page.locator(globalLinks).click();
        page.evaluate("window.scrollTo(0, 700)");
    }

    public static void clickOnCorporationlink() {
        page.locator(corporateLinks).click();
    }

    public static void searchForEmployee() {
        String employee = System.getProperty("searchValue");
        page.locator(searchValue).fill(employee);
        page.locator(searchButton).click();
    }

    public static void readDetails() {
        String mailID = page.locator(mailIdlocator).textContent();
        String number = page.locator(numberSelector).textContent();
        System.out.println("Mail Id of the employee : " + mailID);
        System.out.println("mobile number of the employee : " + number);
    }
}
