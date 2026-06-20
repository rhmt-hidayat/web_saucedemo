@All
  Feature: Login

    @Test1 @Positive @Login
    Scenario: Login Valid
      Given User is on login page
      When User fill username and password valid
      And User click login button
      Then User verify login result

    @Test2 @Negative @Login
    Scenario: Login Invalid
      Given User is on login page
      When User fill username and password invalid
      And User click login button
      Then User get error message