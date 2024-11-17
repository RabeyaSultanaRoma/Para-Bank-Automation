@Smoke @Regression @Functional
Feature: Login function

@Positive @TC_BOL12
Scenario Outline: as para bank user, login should success with valid credential
Given open browser
And go to para bank application    
When put valid user name "<User>"
And put valid password "<Password>"
And click login button
Then login should pass and logout button should visible

    Examples: 
      | User      | Password  |     
      | Row1_Col0 | Row1_Col1 |
      | Row2_Col0 | Row2_Col1 |
      | Row3_Col0 | Row3_Col1 |
     
