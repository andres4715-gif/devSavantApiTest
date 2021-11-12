Feature: Check countries and cities

  Scenario Outline: Test Countries ans cities Api Results
    Given request for this base_link and endPoint
    When user enter "<country>" and "<city>"
    Then user should have "<status>" as a response

    Examples:
      | country  | city       | status |
      | Africa   | Abidjan    | 200    |
      | Africa   | Accra      | 200    |
      | Africa   | Algiers    | 200    |
      | Africa   | Bissau     | 200    |
      | Africa   | Cairo      | 200    |
      | Africa   | Casablanca | 200    |
      | Africa   | Ceuta      | 200    |
      | Africa   | El_Aaiun   | 200    |
      | Colombia | Machupichu | 400    |