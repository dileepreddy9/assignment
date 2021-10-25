Feature: registration

  Scenario: Validate signin functionality
    
    Given: user is on landing page
    When: user has clicked on the signin
    Then: user can see login and registration page


  Scenario: create account
    Given: user is on the registration page
    When: user enters valid email address
    And: clicks on create account link
    Then: user should see personal information page


  Scenario: enter personal details and register
    Given: User is on the personal information page
    When: user provides valid details
    And: user clicks on register button
    Then: User should see homepage with username and last name on the page

