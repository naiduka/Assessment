package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CCarDetailsPage {
    WebDriver wdriver = null;
    public CCarDetailsPage(WebDriver driver)
    {
        wdriver = driver;
        PageFactory.initElements(wdriver, this);
    }

    @FindBy(xpath ="//p[@id='vehicleSummaryRegNumber']/b")
    private WebElement regNum;

    @FindBy(xpath ="//p[text()='Manufacturer: ']/b")
    private WebElement manfacturer;

    @FindBy(xpath ="//p[text()='Model: ']/b")
    private WebElement model;

    @FindBy(xpath ="//p[text()='Body style: ']/b")
    private WebElement bodyStyle;

    @FindBy(xpath ="//p[text()='Year: ']/b")
     private WebElement year;

    @FindBy(xpath ="//p[text()='Transmission: ']/b")
    private WebElement transmission;

    @FindBy(xpath ="//p[text()='Fuel type: ']/b")
    private WebElement fuelType;

    @FindBy(xpath ="//p[text()='Engine size: ']/b")
    private WebElement engineSize;

    @FindBy(xpath="//h3[contains(text(),'We couldn')]")
    private WebElement errorMessage;

    public boolean getErrorMessage()
    {
    try {
        String error = errorMessage.getText();
        System.out.println("Registration Number:" + error);
        if (error.length()!=0) {
            return true;
        }
    }catch(Exception e)
    {
        return false;
    }
    return true;
    }


    public String getregNum()
    {
        String regnum=regNum.getText();
        System.out.println("Registration Number: " + regnum);
        return regnum;
    }

    public String getBodyStyle()
    {

        System.out.println("Body Style: " + bodyStyle.getText());
        return bodyStyle.getText();
    }

    public String getManfacturer()
    {
        System.out.println("Manfacturer: " + manfacturer.getText());
        return manfacturer.getText();
    }

    public String getModel()
    {
        System.out.println("Model: " + model.getText());
        return model.getText();
    }

    public String getYear()
    {
        System.out.println("Year" + year.getText());
        return year.getText();
    }

    public String getTransmission()
    {
        System.out.println("Transmission: " + transmission.getText());
        return transmission.getText();
    }

    public String getFuelType()
    {
        System.out.println("Fuel Type: " + fuelType.getText());
        return fuelType.getText();
    }
}
