# author: Estiven Ospina González
# language: es
@e2e
Característica: Flujo E2E completo de compra

  Yo como cliente
  Quiero completar el flujo desde login hasta confirmación de compra
  Para validar la integración end-to-end del sistema

  @flujoCompletoUsuarioExistente
  Escenario: Flujo E2E - Usuario existente realiza compra completa
    Dado que "Cliente" navega a la página de Automation Exercise
    Cuando el cliente inicia sesión con email "prueba1@udea.edu.co" y password "Prueba123"
    Y agrega un producto y va al carrito
    Y procede al checkout desde el carrito
    Y completa el pago con tarjeta válida
    Entonces debe ver el mensaje "ORDER PLACED!" en la confirmación
    Y la orden se registra en el sistema
