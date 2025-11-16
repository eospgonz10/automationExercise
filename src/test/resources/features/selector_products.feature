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

  @seleccionProductos
  Escenario: Agregar múltiples productos al carrito exitosamente
    Cuando el cliente navega a la sección de productos
    Y agrega los productos con IDs "1,2,3" al carrito
    Y visualiza el carrito de compras
    Entonces debe ver los productos agregados en el carrito

  @seleccionProductoUnico
  Escenario: Agregar un solo producto al carrito
    Cuando el cliente navega a la sección de productos
    Y agrega el producto con ID "1" al carrito
    Y visualiza el carrito de compras
    Entonces debe ver los productos agregados en el carrito

  @seleccionProductosDataDriven
  Esquema del escenario: Agregar diferentes combinaciones de productos
    Cuando el cliente navega a la sección de productos
    Y agrega los productos con IDs "<productos>" al carrito
    Entonces debe ver confirmación de productos agregados

    Ejemplos:
      | productos |
      | 1,2       |
      | 3,4,5     |
      | 1         |
