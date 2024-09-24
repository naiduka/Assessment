package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pages.CCarDetailsPage;
import pages.CHomePage;
import util.Car;
import util.Constants;
import util.ReadCarDetails;

import java.time.Duration;
import java.util.List;

public class CarValuationTest {
    private static final Logger logger = LoggerFactory.getLogger(CarValuationTest.class);

@Test
    public static void carValidationTests() {
        WebDriver driver = null;
        CHomePage cHomePage;

        ReadCarDetails readCarDetails = new ReadCarDetails();
        List<String> registrationNumbers = readCarDetails.readInputData();
        List<Car> cars= readCarDetails.readActualCarDetails();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        for (String regnum: registrationNumbers)
        {
            driver.get(Constants.url);
            cHomePage = new CHomePage(driver);
            cHomePage.pageLoadwaitTime();
            cHomePage.enterRegNum(regnum);
            cHomePage.getQuote();
            CCarDetailsPage ccardetails = new CCarDetailsPage(driver);
            if (!ccardetails.getErrorMessage())
            {
                cHomePage.pageLoadwaitTime();

               String regnumber = ccardetails.getregNum();
               String carmaker = ccardetails.getManfacturer();
               String carmodel = ccardetails.getModel();
               String bodystyle = ccardetails.getBodyStyle();
               String fuelType = ccardetails.getFuelType();
               String transmission = ccardetails.getTransmission();
               String year = ccardetails.getYear();
               Car actualcar=new Car(regnumber,carmaker,carmodel,bodystyle,fuelType,transmission,year);
               boolean isCarMatched = false;
               for (Car car: cars)
               {
                    if (car.equals(actualcar))
                   {
                       isCarMatched = true;
                       break;
                   }
               }
               if (isCarMatched)
               {
                   logger.info("\u001B[32m"+"Car Details are matching for registration number: "+ actualcar.regNum()+"\u001B[0m");
               }
               else
               {
                   logger.error("\u001B[31m"+"Car Details are not matching for registration number: "+ actualcar.regNum() + "\u001B[0m");
               }

            }
            else
            {
                logger.error("\u001B[31m" + "Car Registration Details does not exist for registration number: "+ regnum + "\u001B[0m");

            }

    }
    }
}
