Feature: Hepsiburada Functionality Check

  Background:
    Given Navigate to hepsiburada and check correct website
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: Adding and deleting an item

    When Enter an item name as "samsung" and check results
    And  Like second page fifth cell phone
    Then Added list Pupup message should be displayed

    And Go to liked page and check selected item
    When Add selected item to basket
    Then Added basket Pupup message should be displayed

    When Go to basket and delete selected item
    Then Deleted Pupup message should be displayed

    And Go to liked page and delete selected item






