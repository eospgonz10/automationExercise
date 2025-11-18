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
    Cuando el cliente completa el formulario de registro con datos válidos
    Entonces se crea la cuenta y muestra el mensaje de confirmación

  @registroDataDriven
  Esquema del escenario: Registro de múltiples usuarios con datos variables
    Cuando el cliente completa el registro con nombre "<nombre>" y email "<email>"
    Entonces se crea la cuenta y muestra el mensaje de confirmación

    Ejemplos:
      | nombre    | email                    |
      | Usuario1  | user1@automation.com     |
      | Usuario2  | user2@automation.com     |
      | Usuario3  | user3@automation.com     |
