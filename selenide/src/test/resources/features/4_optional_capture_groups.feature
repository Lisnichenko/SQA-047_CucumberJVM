Feature: When User Add New Record
  As a user I want to add taske to TODO list
  In order to not forget anything

  #optional noncapture
  Scenario: Adding task to the list
    Given user is on the angular page
    When user adds new task "Apple"
    Then "Apple" should appear in the list
    And remove "Apple"
  #optional noncapture
  Scenario: Adding item to the list
    Given user is on the angular page
    When user adds new item "Grape"
    Then "Grape" should appear in the list
    And remove "Grape"


