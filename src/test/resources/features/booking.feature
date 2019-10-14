Feature: Making a booking

  Background: The booking site should be available
    Given I am able to navigate to the site

  @Smoke
  Scenario: Should be able to save a record
    When I am on the booking form and enter data
      | firstname | ee-qa-fname |
      | surname   | ee-qa-sname |
      | price     | 1500        |
      | deposit   | false       |
      | checkIn   | 2020-01-01  |
      | checkOut  | 2020-01-02  |
    And I save it
    Then I should see the booking