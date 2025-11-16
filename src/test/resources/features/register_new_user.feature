# author: Estiven Ospina González
# language: es
@registro
Característica: Registro de nuevo usuario

  Yo como cliente potencial
  Quiero registrarme en el sitio web
  Para poder realizar compras y gestionar mi cuenta

  Antecedentes:
    Dado que "Cliente" navega a la página de Automation Exercise

  @registroExitoso
  Escenario: Registro exitoso de nuevo usuario con datos completos
    Cuando el cliente accede a la opción "Signup / Login"
    Y completa el formulario inicial con nombre "TestUser" y email único
    Y completa el formulario de registro con los siguientes datos:
      | campo             | valor                  |
      | Género            | Male                   |
      | Contraseña        | Test123!               |
      | Día               | 15                     |
      | Mes               | January                |
      | Año               | 1990                   |
      | Newsletter        | true                   |
      | Ofertas           | true                   |
      | Nombre            | John                   |
      | Apellido          | Doe                    |
      | Compañía          | Tech Solutions         |
      | Dirección         | 123 Main Street        |
      | País              | United States          |
      | Ciudad            | Los Angeles            |
      | Código postal     | 90001                  |
      | Teléfono          | 3001234567             |
    Entonces el sistema debe crear la cuenta exitosamente
    Y debe mostrar el mensaje "ACCOUNT CREATED!"

  @registroDataDriven
  Esquema del escenario: Registro de múltiples usuarios con datos variables
    Cuando el cliente accede a la opción "Signup / Login"
    Y completa el formulario inicial con nombre "<nombre>" y email "<email>"
    Y completa el formulario de registro con password "<password>" y ciudad "<ciudad>"
    Entonces el sistema debe crear la cuenta exitosamente

    Ejemplos:
      | nombre    | email                    | password  | ciudad       |
      | Usuario1  | user1@automation.com     | Pass123!  | New York     |
      | Usuario2  | user2@automation.com     | Pass456!  | Miami        |
      | Usuario3  | user3@automation.com     | Pass789!  | Chicago      |
