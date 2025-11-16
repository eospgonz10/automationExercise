# author: Estiven Ospina González
# language: es
@e2e
Característica: Flujo E2E completo de compra

  Yo como nuevo cliente
  Quiero completar el flujo completo desde registro hasta confirmación de compra
  Para validar la integración end-to-end del sistema

  @flujoCompletoExitoso
  Escenario: Flujo E2E - Registro, selección de productos, pago y confirmación
    Dado que "Cliente" navega a la página de Automation Exercise
    Cuando el cliente se registra con datos válidos
    Y agrega el primer producto al carrito
    Y procede al checkout desde el carrito
    Y completa el pago con tarjeta válida
    Entonces debe ver el mensaje "ORDER PLACED!" en la confirmación
    Y la orden debe estar confirmada exitosamente

  @flujoCompletoUsuarioExistente
  Escenario: Flujo E2E - Usuario existente realiza compra
    Dado que "Cliente" navega a la página de Automation Exercise
    Cuando el cliente inicia sesión con email "prueba1@udea.edu.co" y password "Prueba123"
    Y agrega el primer producto al carrito
    Y procede al checkout desde el carrito
    Y completa el pago con tarjeta válida
    Entonces debe ver el mensaje "ORDER PLACED!" en la confirmación
