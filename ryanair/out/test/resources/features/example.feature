Feature: Ryanair booking
  In order to book a trip
  As a generic user
  I want to search a flight  from some city
  to another city in the given days by the user
  for the given number and types of passengers

  Scenario: Ryanair booking
    Given I have ryanair webpage open in Chrome
    And I close cookies politics
    When I click for ida
    And I want to go from 'Valladolid'
    And I want to go to 'Barcelona'
    And I want to go next day from today
    And The trip is for 2 adults
    And I click in go button
    And Close rooms window
    Then I see the result page with almost one flight

