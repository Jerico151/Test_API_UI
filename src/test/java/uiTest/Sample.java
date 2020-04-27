package uiTest;

import uiTest.pages.BankPage;
import uiTest.pages.ResultPage;
import uiTest.pages.SearchPage;
import uiTest.settings.Driver;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

public class Sample extends Driver {

    @Test
    public void RunGoogleSearchingTest() {
        String expectedUrl = "www.open.ru";
        SearchPage searchPage = SearchPage.getNew();
        ResultPage resultPage = searchPage.search("Открытие");

        SelenideElement expectedElement = resultPage.results().findBy(text(expectedUrl)).shouldBe();

        expectedElement.find(By.cssSelector("#rso .r")).click();
        BankPage bankPage = page(BankPage.class);

        Assert.assertTrue(bankPage.getUSDRateSale() > bankPage.getUSDRatePurchase());
        Assert.assertTrue(bankPage.getEURRateSale() > bankPage.getEURRatePurchase());

    }
}
