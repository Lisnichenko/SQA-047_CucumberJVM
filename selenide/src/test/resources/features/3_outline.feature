Feature: When User Add New Record
  As a user I want to add task to TODO list
  In order to not forget anything

  Scenario Outline:  Adding apple to the list
    Given user is on the angular page
    When user adds new task "<Task>"
    Then "<Task>" should appear in the list
    And remove "<Task>"

    Examples:
      | Task  |
      | Apple |
      | Grape |
      | Peach |

#You can group examples of positive tests and negative tests in different tables

