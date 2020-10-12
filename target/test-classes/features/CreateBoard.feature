Feature: Create New Board

  Background:
    Given the user goes to link
    And the user logs in


  Scenario: New Board
    And click to Create New Board
    And the user writes a board name "Kukushka"
    And choose blue color
    And the user click team visible
    And the select public
    And the user click make public
    And the user click createBoardButton
    And the user enters the list following
      | TO DO          |
      | IN DEVELOPMENT |
      | READY FOR TEST |
      | IN TESTING     |
      | DONE           |


