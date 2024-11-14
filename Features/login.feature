Feature: Loginpage

@regression
Scenario: Login to the application with valid username and passowrd

Given user lunch chrome browser
When user lunch url "https://aguat.indecomm.net/AuditGenius_External_UAT/"
And validate landing page logo
And click on login link
Then login page should be displayed
When user enter username as "Debabrata1"
And user enter password as "Password16$"
And user click on login button
And logged out from application
