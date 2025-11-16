# author: Estiven Ospina González
# language: es
@pago
Característica: Proceso de pago

  Yo como cliente con productos en el carrito
  Quiero procesar el pago de mi orden
  Para completar mi compra

  Antecedentes:
    Dado que "Cliente" navega a la página de Automation Exercise
    Y el cliente ha iniciado sesión con credenciales válidas
    Y tiene productos en el carrito

  @pagoExitoso
  Escenario: Procesar pago con tarjeta válida exitosamente
    Cuando el cliente procede al checkout desde el carrito
    Y completa el pago con los siguientes datos de tarjeta:
      | campo        | valor              |
      | Nombre       | John Doe           |
      | Número       | 4111111111111111   |
      | CVC          | 123                |
      | Mes          | 12                 |
      | Año          | 2027               |
    Entonces debe ver el mensaje de confirmación de pago

  @pagoDataDriven
  Esquema del escenario: Procesar pagos con diferentes tarjetas
    Cuando el cliente procede al checkout desde el carrito
    Y completa el pago con nombre "<nombre>", tarjeta "<tarjeta>", CVC "<cvc>"
    Entonces debe ver el mensaje de confirmación de pago

    Ejemplos:
      | nombre       | tarjeta           | cvc |
      | John Smith   | 4111111111111111  | 123 |
      | Jane Doe     | 5555555555554444  | 456 |
      | Bob Johnson  | 378282246310005   | 789 |
