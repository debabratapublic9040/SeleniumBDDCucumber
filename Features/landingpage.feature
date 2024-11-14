Feature: Landingpage

@sanity
Scenario: Landing page title and logo validation

Given user lunch chrome browser
When user lunch url "https://aguat.indecomm.net/AuditGenius_External_UAT/"
And validate landing page logo
And click on login link
And close the browser

