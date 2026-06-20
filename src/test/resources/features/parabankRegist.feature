@All
  Feature: Para bank Registration

    @Positive @Register
    Scenario: Success Register
      Given User is on para bank homepage
      When User click register link button
      Then User is in register page
      When User input name
      And User input address detail
      And User fill valid username and password
      And User input valid password confirmation
      When User click register button
      Then User register successfully

    @Negative @Register
    Scenario: Failed register - Miss match Password
      Given User is on para bank homepage
      When User click register link button
      Then User is in register page
      When User input name
      And User input address detail
      And User fill valid username and password
      And User input invalid password confirmation
      When User click register button
      Then User get error password did not match
