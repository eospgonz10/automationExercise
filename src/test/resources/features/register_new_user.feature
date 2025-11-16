# author: Estiven Ospina González
# language: es
@registro
Característica: Registro de nuevo usuario

  Yo como cliente potencial
  Quiero registrarme en el sitio web
  Para poder realizar compras y gestionar mi cuenta

  Antecedentes:
    Dado que "Estiven" navega a la página de Automation Exercise

  @registroExitoso
  Escenario: Registro de nuevo usuario exitoso
    Cuando selecciona la opción "Signup / Login"
    Y ingresa su nombre "Estiven" y email "estiven@test.com" para registro
    Y completa el formulario de registro con:
      | Título       | Señor                     |
      | Contraseña   | Password123               |
      | Día nacimiento | 15                      |
      | Mes nacimiento | Enero                   |
      | Año nacimiento | 1990                   |
      | Newsletter   | true                     |
      | Ofertas      | true                     |
    Y ingresa la información de dirección:
      | Primer nombre | Estiven                  |
      | Apellido      | Ospina                   |
      | Compañía      | Tech Solutions           |
      | Dirección     | Calle 123 #45-67         |
      | Dirección 2   | Edificio Torre A         |
      | País          | United States            |
      | Estado        | California               |
      | Ciudad        | Los Angeles              |
      | Código postal | 90001                    |
      | Teléfono      | +1234567890              |
    Entonces el sistema crea la cuenta exitosamente
    Y muestra el mensaje "Account Created!"
    Y redirige al dashboard de la cuenta