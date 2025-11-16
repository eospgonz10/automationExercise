# author: Estiven Ospina González
# language: es
@confirmacion
Característica: Confirmación de orden

  Yo como cliente que ha realizado un pago
  Quiero ver la confirmación de mi orden
  Para validar que mi compra fue exitosa

  Antecedentes:
    Dado que "Cliente" navega a la página de Automation Exercise
    Y el cliente ha iniciado sesión con credenciales válidas
    Y tiene productos en el carrito
    Y ha procesado el pago exitosamente

  @confirmacionExitosa
  Escenario: Visualizar confirmación de orden exitosa
    Entonces debe ver el mensaje "ORDER PLACED!" en la confirmación
    Y debe visualizar el botón para continuar navegando
    
  @confirmacionCompleta
  Escenario: Validar detalles completos de la confirmación
    Entonces debe ver el mensaje "ORDER PLACED!" en la confirmación
    Y debe ver el mensaje de felicitaciones
    Y puede continuar navegando en el sitio
