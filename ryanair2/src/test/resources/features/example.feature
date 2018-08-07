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
    And I want to go to 'Barcelona-El Prat'
    And I want to go next day from today
    And The trip is for '2' adults
    And I click in go button
    And Close rooms window
    Then I see the result page with almost one flight

  @parametros
  Scenario Outline: Ryanair booking with parameters table
    Given I have ryanair webpage open in Chrome
    And I close cookies politics
    When I click for '<direccion>'
    And I want to go from '<salida>'
    And I want to go to '<llegada>'
    And I want to go in date '<date>'
    And I want to return in date '<dateReturn>'
    And The trip is for '<numberOfAdults>' adults
    And I click in go button
    And Close rooms window
    Then I see the result page with almost one flight

    Examples:
      | direccion | salida     | llegada           | date              | dateReturn      | numberOfAdults |
      | idaVuelta | Valladolid | Barcelona-El Prat |  August 8, 2018   | August 12, 2018 | 2              |


