package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.AssertJUnit.assertTrue;

public class BtcbitStartPage extends BasePage {

    /** The calculatorPaymentMethod. */
    @FindBy(className = "calculator__payment-method")
    public WebElement calculatorPaymentMethod;


    /** amount to spend on buy calculator*/
    @FindBy(id = "sum")
    private WebElement amountToSpendSelector;

    /** amount to spend on sell calculator*/
    @FindBy(id = "sum2")
    private WebElement amountToSpendOnSellCalc;

    @FindBy(id = "js-exchange-btn-buy")
    private WebElement exchangeButton;

    @FindBy(id = "js-exchange-btn-sell")
    private WebElement exchangeSellButton;

    @FindBy(id = "calculator__to_fees_block")
    public WebElement calculatorFeeBlock;

    @FindBy(id = "calculator__service_fee")
    public WebElement serviceFee;

    @FindBy(id = "calculator__network_fee")
    public WebElement networkFee;

    @FindBy(id = "calculator__processing_fee")
    public  WebElement processingFee;

    @FindBy(id ="limit")
    public  WebElement maxLimit;

    @FindBy(id = "sum_max2")
    public WebElement maxSellAmount;

    @FindBy(css = "a[href='#sell']")
    private WebElement sellLink;

    @FindBy(xpath = "   /html/body/div[1]/section[1]/div/div[1]/form/div/div[3]/div[2]/ul/li[1]/span")
    private WebElement processingFeeSell;

    /**
     * Instantiates a new <a href="https://btcbit.net">btcbit.net</a> page.
     * @param driver the driver
     */
    public BtcbitStartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Enter amount to spend
     * @param key the key
     */
    public void enterSpendAmount(String key) {
        assertTrue(amountToSpendSelector.isDisplayed());
        amountToSpendSelector.click();
        amountToSpendSelector.sendKeys(key);
    }
    public void enterSpendAmountOnBuyCalculator(String key) {
        assertTrue(amountToSpendOnSellCalc.isDisplayed());
        amountToSpendOnSellCalc.click();
        amountToSpendOnSellCalc.sendKeys(key);
    }

    public void checkServiceFeeBlockIsDisplayed() {
        assertTrue(calculatorFeeBlock.isDisplayed());
    }

    public void checkNetworkFeeValue(String value) {
        assertTrue(networkFee.getText().contains(value));
    }

    public void checkServiceFeeValue(String value) {
        assertTrue(serviceFee.getText().contains(value));
    }

    public void checkServiceFeeValueSell(String value) {
        WebElement serviceFeeSell = driver.findElement(By.xpath("/html/body/div[1]/section[1]/div/div[2]/form/div/div[3]/div[2]/ul/li[2]/span"));
        assertTrue(serviceFeeSell.getText().contains(value));
    }

    public void checkFeeBlockSellIsDisplayed(){
        WebElement serviceBlock = driver.findElement(By.xpath("/html/body/div[1]/section[1]/div/div[2]/form/div/div[3]/div[2]"));
        serviceBlock.isDisplayed();
    }

    public void checkProcessingFeeValue(String value){
       assertTrue(processingFee.getText().contains(value));
    }

    public  void clickOnPaymentMethod(){
        calculatorPaymentMethod.click();
    }
    public  void clickOnPaysafecard(){
        WebElement paysafecard = driver.findElement(By.xpath("//*[@id='calculator-buy-payment-methods-select']/li[6]/span"));
        paysafecard.click();
    }

    /**
     * click on exchange button
     */
    public void clickExchangeButton() {
        exchangeButton.click();
    }

    /**
     * It's not a good practice to use xpath, as if you change the DOM, the text won't work.
     * As well it is better not to name elements with the same name like in this case.
     */
    public void checkFeeBlockSellExists() {
        driver.findElement(By.xpath("/html/body/div[1]/section[1]/div/div[1]/form/div/div[3]/div[2]/ul")).isDisplayed();
    }

    public void clickExchangeSellButton(){
        exchangeSellButton.click();
    }

    public void clickOnSellLink() {
        sellLink.click();
    }

    public void checkMaxSellAmount(String value){
        assertTrue(maxSellAmount.getText().contains(value));
    }
}
