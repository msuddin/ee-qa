Feature: Deleting a booking

  Background: The booking site should be available
    Given I am able to navigate to the site
    And I am on the booking form and enter data
      | firstname | ee-qa-fnameD |
      | surname   | ee-qa-snameD |
      | price     | 1500         |
      | deposit   | false        |
      | checkIn   | 2020-01-01   |
      | checkOut  | 2020-01-02   |
    And I save it
    And I should see the booking
    And I save it's record ID

  @Smoke
  Scenario: Should be able to delete a record
    When I delete the booking using it's record ID
    Then it should not be visible anymore
