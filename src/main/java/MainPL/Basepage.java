package MainPL;

import com.microsoft.playwright.*;

public class Basepage {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); // set headless(true) to run without UI
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://qa.tevi.co/login");

    }

    public void tearDown() {
        if (page != null) page.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
