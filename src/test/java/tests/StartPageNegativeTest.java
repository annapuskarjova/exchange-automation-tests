package tests;

import org.testng.annotations.Test;
import pages.BtcbitStartPage;
import pageFactory.PageInstancesFactory;

public class StartPageNegativeTest extends BaseTest{
    String pageLink = "https://btcbit.net";

    @Test public void testMaxSpendAmountError() {
        driver.get(pageLink);
        BtcbitStartPage startPage = PageInstancesFactory.getInstance(BtcbitStartPage.class);
        startPage.enterSpendAmount("5000");
        startPage.clickExchangeButton();
        startPage.maxLimit.isDisplayed();
    }

    @Test public void testExchangeSellMaxAmount(){
        driver.get(pageLink);
        BtcbitStartPage startPage = PageInstancesFactory.getInstance(BtcbitStartPage.class);
        startPage.clickOnSellLink();
        startPage.enterSpendAmountOnBuyCalculator("10");
        startPage.clickExchangeSellButton();
        startPage.checkMaxSellAmount("2.00000");
    }
}
