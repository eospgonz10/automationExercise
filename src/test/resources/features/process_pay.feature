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
    Cuando el cliente completa el pago con tarjeta válida
    Entonces se muestra el mensaje de pago confirmado

  @pagoDataDriven
  Esquema del escenario: Procesar pagos con diferentes tarjetas
    Cuando el cliente completa el pago con tarjeta "<tarjeta>"
    Entonces debe ver el mensaje "ORDER PLACED!" en la confirmación

    Ejemplos:
      | tarjeta           |
      | 4111111111111111  |
      | 5555555555554444  |
      | 378282246310005   |
