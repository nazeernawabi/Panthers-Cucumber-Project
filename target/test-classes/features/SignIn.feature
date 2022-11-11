Feature: Sign In Feature

  Background: 
    Given User is on retail webiste
    When User click on Sign in option

  Scenario: Verify user can sign in into Retail Application
    And User enter email 'nazeernawabi@yahoo.com' and password 'Nazeerjan1234@'
    And User click on login button
    Then User should be logged in into Account

  Scenario Outline: Verify user can sign in into Retail Application with different email and password
    And User enter email <email> and password <password>
    And User click on login button
    Then User should be logged in into Account

    Examples: 
      | email                    | password    |
      | 'ihateteacher@tek.com'   | 'Tek@12345' |
      | 'panthers1@tekschool.us' | 'Tek@12345' |
      | 'panthers@tekschool.us'  | 'Tek@12345' |

  @createAccount
  Scenario: Verify user can create an account into Retail Application
    And User click on create New Account button
    And User fill the signUp informaton with below data
      | name | email              | password        | confirmPassword |
      | Mike | jamie222@yahoo.com | Nazeerjan12345@ | Nazeerjan12345@ |
    And User click on SignUp button
    Then User should be logged into account page
