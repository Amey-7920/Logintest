package MainPL;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;

    // Locators
    private Locator dashboardElement;
    private Locator profileButton;
    private Locator logoutButton;
    private Locator searchBox;
    private Locator searchButton;

    public HomePage(Page page) {
        this.page = page;
        this.dashboardElement = page.locator("//*[contains(text(), 'Dashboard')]");
        this.profileButton = page.locator("#profileButton");
        this.logoutButton = page.locator("#logoutButton");
        this.searchBox = page.locator("#searchBox");
        this.searchButton = page.locator("#searchButton");
    }

    // Check if home page is loaded
    public boolean isHomePageLoaded() {
        return dashboardElement.isVisible();
    }

    // Click on the profile button
    public void clickProfile() {
        profileButton.click();
    }

    // Click on the logout button
    public void clickLogout() {
        logoutButton.click();
    }

    // Perform a search action
    public void search(String query) {
        searchBox.fill(query);
        searchButton.click();
    }

    // Get the page title
    public String getPageTitle() {
        return page.title();
    }
}
