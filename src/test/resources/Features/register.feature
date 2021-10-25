Feature: Register on the website

  Background: 
    Given User is on the homepage
    When User clicks on Signin button

  Scenario Outline: A new user registration
    When User creates an account with valid "<EmailId>"
    And Provide personal details "<Title>", "<Firstname>", "<Lastname>", "<Password>", "<Birthday>", "<Birthmonth>", "<Birthyear>", "<Address>", "<City>", "<State>", "<Zip>", "<Mobile>"
    And Click on Register button
    Then User validates "<Firstname>", "<Lastname>" are correct
    When User clicks on Sign out button
    Then User logs off successfully

    Examples: 
      | EmailId           | Title | Firstname | Lastname | Password  | Birthday | Birthmonth | Birthyear | Address    | City    | State   | Zip   | Mobile     |
      | situser@test.com  |       | sit       | user     | password1 |        1 |          6 |      1990 | 3 lanecove | Florida | Florida | 12345 | 1234567890 |
      | situser1@test.com |       | sit       | user1    | password1 |       21 |         10 |      1995 | 4 lanecove | Alaska  | Alaska  | 12343 | 1235566890 |

  Scenario Outline: Add product to cart, checkout and complete payment
    When User logs in with valid "<EmailId>", "<Password>"
    And user navigates to tshirts and adds a product to cart

    Examples: 
      | EmailId          | Password  |
      | situser@test.com | password1 |
