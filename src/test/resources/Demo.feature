@Demo1
Feature: General Store App Functionality

  Scenario: User opens the General Store App
    Given the user opens the General Store Application

  Scenario: User Selects Country
    When the user scroll down and selects the country "India"
    Then verifying if the selected country

  Scenario: User Tries to Login Without Name Field
    When the user tries to Login without entering the name field he will be getting an error
    Then verifying if the user is  gets the error

  Scenario: User Tries to Login With Name Field
    When the user enters the name "Diksha" and tries to login
    Then verifying if the user successfully login

  Scenario: User Added Shoes to Cart
    When the user adds shoes to the cart
    Then verifying if the shoe that the user has added is added successfully or not

  Scenario: User Moves Checkout section
    When the user moves to checkout
    Then verifying if details

  Scenario: User Performs a Web Search
    When the user performs a web search
    Then verifying if "Gemini" is displayed
