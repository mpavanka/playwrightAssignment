package context;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class Context {
    public static Page page;
    public static Browser browser;
    public static BrowserContext context;
    static Playwright playwright;

    public static void lunchBrowser(){
        playwright = Playwright.create();
        String browserType = System.getProperty("BrowserType");
//        String browserType = System.getenv("BROWSER");
        boolean headLess = Boolean.parseBoolean((System.getProperty("headLess")));
        System.out.println(browserType);
        switch (browserType){
            case "chrome" ->
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chromium").setHeadless(headLess));
            case "edge" ->
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(headLess));
            case "webkit" ->
                    browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(headLess));
            case "Firefox" ->
                    browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headLess));
            default ->
                    throw new IllegalArgumentException("Browser not supported: " + browserType);
        }
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterAll
    public void closeBrowser(){
        context.close();
        browser.close();
    }

    public static Page getPage(){
        return page;
    }
}
