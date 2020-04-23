package UI_test.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.open;

public class BankPage {
    private final static String baseUrl = "https://www.open.ru/";


    @FindBy(how = How.CSS, using = "#main > div > div > div:nth-child(9) > section > div > div > div:nth-child(1) > div > div > div > div > div.main-page-exchange__main > table > tbody > tr:nth-child(2) > td:nth-child(2) > div > span")
    private SelenideElement USDRatePurchase;

    @FindBy(how = How.CSS, using = "#main > div > div > div:nth-child(9) > section > div > div > div:nth-child(1) > div > div > div > div > div.main-page-exchange__main > table > tbody > tr:nth-child(2) > td:nth-child(4) > div > span")
    private SelenideElement USDRateSale;

    @FindBy(how = How.CSS, using = "#main > div > div > div:nth-child(9) > section > div > div > div:nth-child(1) > div > div > div > div > div.main-page-exchange__main > table > tbody > tr:nth-child(3) > td:nth-child(2) > div > span")
    private SelenideElement EURRatePurchase;

    @FindBy(how = How.CSS, using = "#main > div > div > div:nth-child(9) > section > div > div > div:nth-child(1) > div > div > div > div > div.main-page-exchange__main > table > tbody > tr:nth-child(3) > td:nth-child(4) > div > span")
    private SelenideElement EURRateSale;

    public static BankPage getNew(){
        return open(baseUrl, BankPage.class);
    }

    public double getUSDRatePurchase(){
        String doubleValueAsString = USDRatePurchase.getText().replace(",", ".");
        return Double.parseDouble(doubleValueAsString);
    }

    public double getUSDRateSale(){
        String doubleValueAsString = USDRateSale.getText().replace(",", ".");
        return Double.parseDouble(doubleValueAsString);
    }

    public double getEURRatePurchase(){
        String doubleValueAsString = EURRatePurchase.getText().replace(",", ".");
        return Double.parseDouble(doubleValueAsString);
    }

    public double getEURRateSale(){
        String doubleValueAsString = EURRateSale.getText().replace(",", ".");
        return Double.parseDouble(doubleValueAsString);
    }
}