Feature: Login

  @Login
  Scenario: Успешный логин юзера
    Given Пользователь запускает браузер
    When Пользователь открывает домашнюю страницу ilcarro
    And Пользователь нажимает на ссылку Login
    And Пользователь вводит валидные данные
    And Пользователь нажимает на кнопку Yalla
    Then Пользователь проверяет отображение сообщения об успешном логине
    And Пользователь закрывает браузер

  @InvalidPassword
  Scenario Outline: Неуспешный логин юзера
    Given Пользователь запускает браузер
    When Пользователь открывает домашнюю страницу ilcarro
    And Пользователь нажимает на ссылку Login
    And Пользователь вводит валидный email и невалидный password
      | email   | password   |
      | <email> | <password> |
    And Пользователь нажимает на кнопку Yalla
    Then Пользователь проверяет отображение сообщения об неуспешном логине
    And Пользователь закрывает браузер
    Examples:
      | email             | password   |
      | test_qa@gmail.com | Password11 |
      | test_qa@gmail.com | password@1 |
      | test_qa@gmail.com | Password1  |
      | test_qa@gmail.com | Password@  |
