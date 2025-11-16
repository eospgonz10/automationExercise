# author: Estiven Ospina González
# language: es
@productos
Característica: Selección y gestión de productos

  Yo como cliente registrado
  Quiero navegar y seleccionar productos
  Para agregarlos a mi carrito de compras

  Antecedentes:
    Dado que "Cliente" navega a la página de Automation Exercise
    Y el cliente ha iniciado sesión con credenciales válidas

  @seleccionProductoUnico
  Escenario: Agregar un producto al carrito exitosamente
    Cuando el cliente agrega el primer producto al carrito
    Entonces debe ver los productos agregados en el carrito
