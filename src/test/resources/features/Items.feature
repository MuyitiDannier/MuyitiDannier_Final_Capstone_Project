@Crater
Feature: Items Feature
  As a user, I want to be able to manage items

  Background:
    Given user is navigated to Crater login page
    When user enters "accounts@crater.com" in the username field
    And user enters "primetech@school" in the password field
    And user clicks on login button
    Then user should be logged in successfully
    And user should be able to see "Setting" page title is being displayed
  @Regression
  Scenario: user should be able to add, delete or update items
    When user clicks on Items menu link
    Then user should be navigated to the Items page
    When user clicks on + Add Item
    Then user should be navigated to New Item page
    When user enters "Dan's New Backpack" into the Name field
    And user enters "4500" into the Price field
    And user selects "Dollars" within the Unit field
    And user enters "This backpack is from Dan's collections." into the Description field
    When user clicks on the Save Item button
    Then user should be able to see a flash message "Success! Item created successfully" with a close button to the right being displayed
    And user should be able to verify the flash message disappears within 5 seconds or less
    And user should be navigated back to the Items page
    And user should be able to view new item being displayed within the Items table
    And user should be able to see entered information within the Name, Unit, Price and Description application database
