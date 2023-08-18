package stepdefinitions;

import implementations.DemoImplementation;
import io.cucumber.java.en.*;

public class StepDefinition {

    public static int count=0;
    @Given("^the user opens the General Store Application$")
    public void openGeneralStoreApp() {
        DemoImplementation.openGeneralStoreApplication();
    }

    @When("^the user scroll down and selects the country \"(.*)\"$")
    public void selectCountry(String country)  {
        DemoImplementation.country = country;
        DemoImplementation.countrySelection();
        try {
            DemoImplementation.screenshot("Screenshot" +count++ +".jpg");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("^verifying if the selected country$")
    public void verifySelectedCountry() {
        DemoImplementation.verifySelectedCountry();
        try {
            DemoImplementation.screenshot("Screenshot" +count++ +".jpg");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("^the user tries to Login without entering the name field he will be getting an error$")
    public void enterShopWithoutNameField() {
        DemoImplementation.loginWithoutNameField();
        try {
            DemoImplementation.screenshot("Screenshot" +count++ +".jpg");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("^the user enters the name \"(.*)\" and tries to login$")
    public void enterShopWithNameField(String name) {
        DemoImplementation.loginWithNameField(name);
        try {
            DemoImplementation.screenshot("Screenshot" +count++ +".jpg");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("^verifying if the user is  gets the error$")
    public void verifyErrorOccurrence() {
        DemoImplementation.verifyLogin();
        try {
            DemoImplementation.screenshot("Screenshot" +count++ +".jpg");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("^verifying if the user successfully login$")
    public void verifyUserEntersShop() {
        DemoImplementation.verifyLogin();
        try {
            DemoImplementation.screenshot("Screenshot" +count++ +".jpg");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("^the user adds shoes to the cart$")
    public void addProductsToCart() {
        DemoImplementation.addProducts();
        try {
            DemoImplementation.screenshot("Screenshot" +count++ +".jpg");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("^verifying if the shoe that the user has added is added successfully or not$")
    public void verifyCartCounter() {
        DemoImplementation.verifyCartCounter();
        try {
            DemoImplementation.screenshot("Screenshot" +count++ +".jpg");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @When("^the user moves to checkout$")
    public void moveToCheckout() {
        DemoImplementation.checkout();
        try {
            DemoImplementation.screenshot("Screenshot" +count++ +".jpg");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("^verifying if details$")
    public void verifyCartItemsContents() {
        DemoImplementation.verifyCheckOutDetails();
        try {
            DemoImplementation.screenshot("Screenshot" +count++ +".jpg");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("the user performs a web search")
    public void theUserPerformsAWebSearch() {
        DemoImplementation.webSearch();
        try {
            DemoImplementation.screenshot("Screenshot" +count++ +".jpg");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Then("^verifying if \"(.*)\" is displayed$")
    public void verifyingIfSearchResultsAreDisplayed(String searchElement) {
        DemoImplementation.verifySearchResults(searchElement);
    }
}
