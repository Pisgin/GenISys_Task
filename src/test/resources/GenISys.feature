@wip
Feature: Register / Login / play Casino game / play Lottery game

  Scenario: The user can be able to register to the system

    Given The user can be able to navigate to the tour page
    When The user can be able to log in as a new user
    And The user can be able to enter their email address
    And The user can be able to enter phone number
    And The user can be able to enter name and surname
    And The user can be able to set a password
    Then The user registration can be completed.


  Scenario: With the registered user information can be able to login

    Given The user can be able to navigate to the tour page
    When The user can be able to login
    Then The user can be able to check that he/she are logged in


  Scenario: The user can be able to see that he/she cannot play the Casino game without a balance

    Given The user can be able to login from tour page
    When The user can be able to enter the Casino page
    Then The user can be able to see that he/she cannot play without a balance


  Scenario:  when the user wins in the Casino game, the money in his/her account increases and
    can be able to see that the money decreases when he/she lose

    Given The user can be able to login from the tour page and go to the Casino page
    When The user can be able to top up and check his/her account
    And The user can be able to control the options in the Casino game
    Then the user can be able to see that his/her balance increases when his/her win and decreases when his/her lose


  Scenario: The user can be able to buy in the Lottery and see the balance updated

    Given The user can be able to login from the tour page and go to the Lottery page
    When The user can be able to add new lottery
    And The user can be able to buy Lottery as a single ticket
    And THe user can be able to buy lotteries
    Then The user can be able to see the change in the balance after the purchase


  Scenario: The user can be able to add new lotteries in Lottery, make selections,
  make purchases and see the balance updated

    Given The user can be able to login from the tour page and go to the Lottery page
    Then The user can be able to add new lotteries
    And The user can be able to choose new lotteries
    And THe user can be able to buy lotteries
    Then The user can be able to see the change in the balance after the purchase
















