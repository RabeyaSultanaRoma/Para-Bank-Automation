@Smoke @Regression @Functional
Feature: Login function

@Positive @TC_BOL13
Scenario Outline: as para bank user, login should fail with invalid credential
Given open browser
And go to para bank application    
When put valid user name "<User>"
And put valid password "<Password>"
And click login button
Then login should fail and error msg contains An internal error has ocuured and has been logged

    Examples: 
      | User        | Password |
      | sgyuvuy     | rrrrr    |
      | hb67k       | ftttt    |
      | stud24      | uihb2024 |
