package tests;

import org.testng.annotations.Test;
import pages.BtcbitStartPage;
import pageFactory.PageInstancesFactory;

public class BuyExchangeTest extends BaseTest{
    String pageLink = "https://btcbit.net";

    @Test public void testExchangeAdvCashEURToBTC() {
        driver.get(pageLink);
        BtcbitStartPage startPage = PageInstancesFactory.getInstance(BtcbitStartPage.class);
        startPage.enterSpendAmount("100");
        startPage.clickExchangeButton();
        startPage.checkServiceFeeBlockIsDisplayed();
        startPage.checkServiceFeeValue("5");
        startPage.checkNetworkFeeValue("1");
        startPage.checkProcessingFeeValue("0.00 EUR");
    }

    @Test public void testSelectPaysafeCard() {
        driver.get(pageLink);
        BtcbitStartPage startPage = PageInstancesFactory.getInstance(BtcbitStartPage.class);
        startPage.clickOnPaymentMethod();
        startPage.clickOnPaysafecard();
        startPage.enterSpendAmount("100");
        startPage.clickExchangeButton();
        startPage.checkFeeBlockSellExists();
    }

    @Test public void testExchangeSellSepa(){
        driver.get(pageLink);
        BtcbitStartPage startPage = PageInstancesFactory.getInstance(BtcbitStartPage.class);
        startPage.clickOnSellLink();
        startPage.enterSpendAmountOnBuyCalculator("0.01");
        startPage.clickExchangeSellButton();
        startPage.checkFeeBlockSellIsDisplayed();
        startPage.checkServiceFeeValueSell("12");
    }

    /** Test should fail because new driver was not started. But on the webpage pop up appears*/
    @Test public void testFailExample() {
        BtcbitStartPage startPage = PageInstancesFactory.getInstance(BtcbitStartPage.class);
        startPage.enterSpendAmount("100");
        startPage.clickExchangeButton();
        startPage.checkServiceFeeBlockIsDisplayed();
    }

    /** Test is ignored*/
    @Test (enabled=false)
    public void testToSkipExample() {
        driver.get(pageLink);
        BtcbitStartPage startPage = PageInstancesFactory.getInstance(BtcbitStartPage.class);
    }
}
