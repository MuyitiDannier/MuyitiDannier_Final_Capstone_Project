@Crater
Feature: Login Functionality
  As a user, I should be able to login to my Crater application

@Smoke
  Scenario: User should be able to login with valid credentials
  Given user is navigated to Crater login page
  When user enters "accounts@crater.com" in the username field
  And user enters "primetech@school" in the password field
  And user clicks on login button
  Then user should be logged in successfully
  And user should be able to see "Setting" page title is being displayed