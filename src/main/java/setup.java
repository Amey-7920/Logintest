import com.microsoft.playwright.Playwright;

public class setup {
    public static void main(String[] args) {
        Playwright.create() ; // This installs the necessary browser binaries.
    }
}
