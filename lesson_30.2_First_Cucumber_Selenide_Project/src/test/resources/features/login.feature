Feature: Login

  @LoginPositive
  Scenario: Successful login
    Given User is on HomePage
    When User clicks on Login icon
    Then User is verifies Login form
    When User enter valid credentials
    And clicks on Anmelden button
    Then User verifies user name status
    When User clicks on the User icon
    Then User verifies user name