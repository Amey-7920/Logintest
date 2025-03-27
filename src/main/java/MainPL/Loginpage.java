package MainPL;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Loginpage  extends Basepage{
    private Locator usernameField;
    private Locator passwordField;
    private Locator loginButton;

    public Loginpage(Page page) {
        this.page = page;
//        page.navigate("https://qa.tevi.co/login");
        usernameField = page.locator("input[name='username']");
        passwordField = page.locator("input[name='password']");
        loginButton = page.locator("button[type='submit']");
    }

    // Actions on the login page
    public void enterUsername(String username) {
        usernameField.fill(username);
    }

    public void enterPassword(String password) {
        passwordField.fill(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isLoginPageLoaded() {
        return usernameField.isVisible() && passwordField.isVisible();
    }
}
