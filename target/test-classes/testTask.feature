Feature: openstreetmap.org distance calculator
  Scenario: User wants to calculate the distance if he will ride a bicycle(OSRM)
    Given User launches Google Chrome browser and go to url https://www.openstreetmap.org/
    When User click on the "Finding a distance between two points" button
    And enter From point | Радищева, Київ |
    And enter To point | Кембридж |
    And in the transport option dropdown list select Bicycle (OSRM)
    And click to Go button
    Then Verify the distance is 2423km and close a browser
