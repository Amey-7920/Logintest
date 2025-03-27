import MainPL.Basepage;
import MainPL.HomePage;
import MainPL.Loginpage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends Basepage {
    private Loginpage loginPage;
    private HomePage homePage;

    @BeforeClass
    public void setUp() {
        setup();
        loginPage = new Loginpage(page);
    }

    @Test
    public void testLogin() {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();

        // Wait for the home page to load (Example: Dashboard visible)
        homePage = new HomePage(page);
        boolean isHomePageLoaded = homePage.isHomePageLoaded();
        Assert.assertTrue(isHomePageLoaded, "Home page didn't load after login!");
    }

    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}
