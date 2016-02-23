@GoogleNews
Feature: As a user of google news i should be able to see and click all the headlines on the news page

  Scenario: Capture headlines from the news.google.com
    Given i am on the news page of google
    Then i should be able to capture all the headline text on the news page