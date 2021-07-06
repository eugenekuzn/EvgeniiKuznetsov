Feature: Checkboxes, radio buttons and dropdowns should be map on the Different Elements page,
  be available to select and Log Info Table should contain information according to selected elements

  Scenario: Check Checkboxes Radio Buttons and Dropdowns are displayed and available to select

    Given I open JDI GitHub

    And I login as "Roman Iovlev"

    When I click on "Service" button

    And I click on Different Elements Page

    And Select checkbox 'Water'

    And Select checkbox 'Wind'

    And Select radio 'Selen'

    And Select in dropdown 'Yellow'

    Then Log row displayed 'Water: condition changed to true' after Water checkbox was selected

    And Log row displayed 'Wind: condition changed to true' after Wind checkbox was selected

    And Log row displayed 'metal: value changed to Selen' after Selen radio button was selected

    And Log row displayed 'Colors: value changed to Yellow' after Yellow color was selected