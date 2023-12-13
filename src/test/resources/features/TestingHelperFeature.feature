Feature: Test new vsip tester helper service
  I should be able to send SQS messages to vsip to start kicking off messages
  @test_suite
  Scenario Outline: A prisoner is released
    Given A prisoner "<prisonerCode>" is released from "<prisonCode>"

    Examples:
      | prisonerCode                | prisonCode            |
      | VSIP1_TST                   | CFI                   |

  @test_suite
  Scenario Outline: A prisoner is received
    Given A prisoner "<prisonerCode>" is received from "<prisonCode>"

    Examples:
      | prisonerCode                | prisonCode            |
      | VSIP1_TST                   | CFI                   |

  @test_suite
  Scenario Outline: A prisoner has a restriction from and to a date
    Given A prisoner "<prisonerCode>" has a restriction from "<startDate>" to "<endDate>"

    Examples:
      | prisonerCode                | startDate            | endDate        |
      | VSIP1_TST                   | 2023-12-03           | 2023-12-27     |

  @test_suite
  Scenario Outline: A prisoner has a restriction from a date
    Given A prisoner "<prisonerCode>" has a restriction from "<startDate>"

    Examples:
      | prisonerCode                | startDate            |
      | VSIP1_TST                   | 2023-12-03           |

  @test_suite
  Scenario Outline: A visitor has a restriction from and to a date
    Given A visitor "<visitorId>" has a restriction from "<startDate>" to "<endDate>"

    Examples:
      | visitorId                | startDate            | endDate        |
      | SOMEVISITID              | 2023-12-03           | 2023-12-27     |

  @test_suite
  Scenario Outline: A visitor has a restriction from a date
    Given A visitor "<visitorId>" has a restriction from "<startDate>"

    Examples:
      | visitorId                   | startDate            |
      | SOMEVISITID                 | 2023-12-03           |

  @test_suite
  Scenario Outline: A prisoner has a non association
    Given A prisoner "<prisonerCode>" has a non association with "<nonAssociationPrisonerCode>"

    Examples:
      | prisonerCode                | nonAssociationPrisonerCode            |
      | VSIP1_TST                   | VSIP2_TST                             |