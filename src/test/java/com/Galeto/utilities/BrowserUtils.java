package com.Galeto.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    public static void sleep(int second){

        second *= 1000;
        try{
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }
    //TC #2: Create utility method
    //1. Create a new class called BrowserUtils
    //2. Create a method to make Task1 logic re-usable
    //3. When method is called, it should switch window and verify title.
    //Method info:
    //• Name: switchWindowAndVerify
    //• Return type: void
    //• Arg1: WebDriver
    //• Arg2: String expectedInUrl
    //• Arg3: String expectedTitle

    public static void switchWindowAndVerify(String expectedInUrl, String expectedInTitle){

        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowHandles) {
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current UTL: " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }
        //5. Assert:Title contains “Etsy”
        String actualTitle = Driver.getDriver().getTitle();


        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }

    public static void verifyTitle( String expectedTitle){
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }

    public static void verifyTitleContains(String expectedInTitle){
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));
    }

    public static void waitForInvisibilityOf(WebElement target){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    public static void waitForTitleContains(String title){
        //Create the object of 'WebDriverWait' class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.titleContains(title));
    }


    public static List<String> dropdownOption_as_STRING(WebElement dropdownElement){

        Select month = new Select(dropdownElement);
        List<WebElement> actualMonth_as_WEBELEMENT = month.getOptions();

        List<String > actualMonth_as_asSTRING = new ArrayList<>();

        for (WebElement each : actualMonth_as_WEBELEMENT) {

            actualMonth_as_asSTRING.add(each.getText());
        }

        return actualMonth_as_asSTRING;
    }

    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue){

        for (WebElement each : radioButtons) {
            if (each.getAttribute("value").equals(attributeValue)){
                each.click();
            }
        }

    }


}
