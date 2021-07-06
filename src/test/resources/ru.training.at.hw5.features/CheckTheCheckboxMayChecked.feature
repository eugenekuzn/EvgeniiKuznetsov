Feature: Checking that checkboxes may be checked and log row table shows logs

  Scenario: Check that checkboxes may be checked

    Given I open JDI GitHub test site

    And I login as user with username "Roman Iovlev"

    And I click on "Service" in Header

    And I click on "User Table" button in opened Service dropdown

    When I select 'vip' checkbox for "Sergey Ivan"

    Then 1 log row has "Vip: condition changed to true" text in log section