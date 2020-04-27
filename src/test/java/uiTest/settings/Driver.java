package uiTest.settings;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

public abstract class Driver {
    @BeforeClass
    public void setupBrowser() {
        Configuration.browser = "chrome";
    }
}
