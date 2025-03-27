package MainPL;

import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    // You can define methods for elements and actions on the Home page
    public boolean isHomePageLoaded() {
        // Example locator for a home page element
        return page.locator("//*[contains(text(), 'Dashboard')]").isVisible();
    }
}
