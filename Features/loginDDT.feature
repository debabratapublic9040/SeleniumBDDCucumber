Feature: Loginpage

@smoke 
Scenario Outline: Login to the application with valid username and passowrd DDT testing

Given user lunch chrome browser
When user lunch url "https://aguat.indecomm.net/AuditGenius_External_UAT/"
And validate landing page logo
And click on login link
Then login page should be displayed
When user enter username as "<username>"
And user enter password as "<password>"
And user click on login button


Examples:
| username | password |
| Debabrata | Password16$ |
| Debabrata1 | Password16$ |