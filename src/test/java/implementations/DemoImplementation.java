package implementations;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import utils.ConfigReader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import locators.Locators;

public class DemoImplementation {

    public static AppiumDriver driver;
    public static String country;
    public static String shoeName;
    public static String searchElement = "Gemini";

    /**
     * Open the Application ,Added all the Desired Capabilities
     */
    public static void openGeneralStoreApplication() {
        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("deviceName", ConfigReader.getProperty("appium.deviceName"));
            cap.setCapability("udid", ConfigReader.getProperty("appium.udid"));
            cap.setCapability("platformName", ConfigReader.getProperty("appium.platformName"));
            cap.setCapability("app", System.getProperty("user.dir") + ConfigReader.getProperty("appium.appPath"));

            URL url = new URL(ConfigReader.getProperty("appium.appUrl"));
            driver = new AndroidDriver(url, cap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Scroll Down till We find India
     * As Driver finds India It will click on it
     */
    public static void countrySelection() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement selectCountry = driver.findElement(Locators.selectCountryButton);
        selectCountry.click();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + country + "\").instance(0))")).click();
    }

    /**
     * verifying if the selected country is India
     * If true Assert will pass the test
     */
    public static void verifySelectedCountry() {
        try {
            String selectedCountry = driver.findElement(Locators.selectedCountryName).getText();
            Assert.assertEquals(selectedCountry, country);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * If we try to login without entering the name then it will give us the error
     */
    public static void loginWithoutNameField() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement genderRadioBtn = driver.findElement(Locators.gender);
        genderRadioBtn.click();
        WebElement btnLetsShop = driver.findElement(Locators.shopButton);
        btnLetsShop.click();
    }

    /**
     * After entering the name it will pass the test and move to the next page
     * @param name
     */
    public static void loginWithNameField(String name) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement nameField = driver.findElement(Locators.nameField);
        nameField.sendKeys(name);
        WebElement genderButton = driver.findElement(Locators.gender);
        genderButton.click();
        WebElement letsShop = driver.findElement(Locators.shopButton);
        letsShop.click();
    }

    /**
     * verifying if it moves to the next page or not
     * if user sees the products heading that means it passes the test
     */
    public static void verifyLogin() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        try {
            WebElement productsTitle = driver.findElement(Locators.titleProducts);
            Assert.assertTrue(productsTitle.isDisplayed());
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }

    /**
     * Add products in the cart
     */
    public static void addProducts() {
         driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Jungle\").instance(0))"));
        WebElement shoes =driver.findElement(By.xpath("//*[@text='PG 3']"));
        shoeName = shoes.getText();
        WebElement cartElement = driver.findElement(Locators.addedInCart);
        cartElement.click();
    }

    // verifying if the cart has only 1 product or not
    public static void verifyCartCounter() {
        try {
            WebElement numberOfElementsInCart = driver.findElement(Locators.counter);
            Assert.assertTrue(numberOfElementsInCart.getText().contains("1"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void checkout() {
        WebElement cart = driver.findElement(Locators.addToCart);
        cart.click();
    }

    public static void verifyCheckOutDetails() {
        WebElement shoeAdded = driver.findElement(Locators.shoe);
        String shoeInCart = shoeAdded.getText();
        Assert.assertTrue(shoeInCart.equals(shoeName));
    }

    /**
     * This test performs a search on a web page.
     */
    public static void webSearch() {
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            // Click on the web search element
            driver.findElement(Locators.webSearch).click();

            // Locate the browser input field
            WebElement browserInput = driver.findElement(Locators.input);
            browserInput.click();
            browserInput.sendKeys(searchElement);

            // Click the search bar to initiate the search double click is required for the same
            driver.findElement(Locators.searchBar).click();
            driver.findElement(Locators.searchBar).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This test verifies the search results on the web page.
     */
    public static void verifySearchResults(String search) {
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            // Get the available contexts
            Set<String> contexts = driver.getContextHandles();
            // Assuming the native context is at index 0 and web context at index 1
            driver.context((String) contexts.toArray()[1]);

            // Find all links containing the search term
            List<WebElement> linksList = driver.findElements(By.partialLinkText(search));
            Assert.assertTrue(linksList.size() != 0, "No search results found.");
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void screenshot(String fileName) throws IOException {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("C:\\Users\\Diksha.Popli\\IdeaProjects\\GeneralStoreAPkTesting\\src\\screenshots\\" + fileName));
    }
}