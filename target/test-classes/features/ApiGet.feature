Feature: GET request

  Background:
    Given The user sets URI

  Scenario: GET name
    And The user sends get request "query" "Mike" with endpoint "search/members"
    And Verify the status code is 200
    And Verify the content type is "application/json; charset=utf-8"
    Then Verify Mike is more then 5

  @wip
  Scenario: POST method
    And The user sends post request with "boards" end point
      | name | Salamanca |
    And Verify the status code is 200
    And Verify the content type is "application/json; charset=utf-8"
    Then Verify the board name is "Salamanca"

  @wip
  Scenario: PUT method
    And The user sends put request with "boards" end point
      | name | Santiago |
    And Verify the status code is 200
    And Verify the content type is "application/json; charset=utf-8"
    Then Verify the board name is "Santiago"
  @wip
  Scenario: DELETE method
    And The user sends delete request with "boards" end point
    And Verify the status code is 200
    And Verify the content type is "application/json; charset=utf-8"
    Then Verify the message value is null