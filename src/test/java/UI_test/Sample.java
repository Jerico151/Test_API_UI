package UI_test;

import UI_test.Pages.BankPage;
import UI_test.Pages.ResultPage;
import UI_test.Pages.SearchPage;
import UI_test.Settings.Driver;
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
