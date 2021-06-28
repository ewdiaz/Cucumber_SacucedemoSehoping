Feature: Login
  El usuario ingresará a la pagina web

  Scenario: Ingresar a la paina "saucedemo.com"
    Given El usuario se encuentre en la pagina inicial de "saucedemo.com" y llene los campos "username" y "password"
    When  ingrese, seleccione el producto "Sauce Labs Fleece Jacket" y dar click sobre el
    Then Cuando sea encontrado, agregalo al carrito