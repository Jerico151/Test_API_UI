package uiTest.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.*;

public class SearchPage {

    private final static String baseUrl = "https://www.google.com/";

    @FindBy(how = How.NAME, using = "q")
    private SelenideElement searchBox;

    public ResultPage search(String query) {
        searchBox.setValue(query).pressEnter();
        return page(ResultPage.class);
    }
    public static SearchPage getNew(){
        return open(baseUrl, SearchPage.class);
    }
}
