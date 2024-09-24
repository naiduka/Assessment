package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CHomePage {
    WebDriver wdriver = null;
    public CHomePage(WebDriver driver)
    {
        wdriver = driver;
        PageFactory.initElements(wdriver, this);
    }

    @FindBy(xpath ="//input[@id='registration-number-input']")
    private WebElement regNum;

    @FindBy(xpath="//button[@id='find-vehicle-btn']")
    private WebElement findQuote;

    public void enterRegNum(String num)
    {
        regNum.sendKeys(num);
    }

    public void getQuote()
    {
        findQuote.click();
    }

    public void pageLoadwaitTime()
    {
        wdriver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
    }

}
