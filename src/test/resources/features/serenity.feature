# language: en
# Authos:Sofka

Feature: Inicio de sesion con usuario y password en la aplicacion serenity.is, crear nuevos clientes y pedidos
  Como usuario, Quiero iniciar sesion en serenity.is con usuario y password
  Para crear nuevos clientes y crear ordenes de pedido con sus respectivos productos

  # Antecedentes: Inicio de sección con usuario y password genéricos

  @Clientes @Regresion
  Scenario Outline: : Crear un nuevo cliente exitoso con todos los campos disponibles
    Given que quiero iniciar sesion con usuario "admin" y contrasena "serenity" en serenity.is
    Given que quiero crear un nuevo cliente
    When ingreso los datos del nuevo cliente y hago clic en el botón guardar
      | id   | empresa   | nContacto   | tContacto   | representante   | direccion   | pais   | ciudad   | region   | codigoPostal   | telefono   | fax   | fContacto   | uContactoPor   | correo   |
      | <id> | <empresa> | <nContacto> | <tContacto> | <representante> | <direccion> | <pais> | <ciudad> | <region> | <codigoPostal> | <telefono> | <fax> | <fContacto> | <uContactoPor> | <correo> |
    Then debería ver el nuevo cliente en la lista general de cliente registrados en el sistema <id>
    Examples: :
      | id    | empresa          | nContacto    | tContacto       | representante | direccion       | pais      | ciudad       | region    | codigoPostal | telefono  | fax        | fContacto  | uContactoPor   | correo           |
      | ABJDM | Banco Torre Alta | Juan Antomio | Gerente General | Laura Call    | Cra 14 # 14 -20 | Argentina | Buenos Aires | Sueroeste | 123456       | 321456789 | 6017458596 | 11/15/2022 | Michael Suyama | correo@gmail.com |

  @Pedidos @Regresion
  Scenario Outline: : Crear un nuevo pedido exitoso en el sistema
    Given que quiero iniciar sesion con usuario "admin" y contrasena "serenity" en serenity.is
    Given que quiero crear un nuevo pedido ingreso los datos del pedido
      | cliente   | fPedido   | fEnvio   | empleado   |
      | <cliente> | <fPedido> | <fEnvio> | <empleado> |
    When ingreso los productos del pedido y hago clic en el botón guardarm
      | producto   | precio   | cantidad   |
      | <producto> | <precio> | <cantidad> |
    Then debería ver el nuevo pedido en la lista general de pedidos registrados en el sistema
    Examples:
      | cliente                                    | fPedido    | fEnvio     | empleado       | producto          | precio | cantidad |
      | Ana Trujillo Emparedados y helados [ANATR] | 11/23/2022 | 11/26/2022 | Michael Suyama | Camembert Pierrot | 19.00  | 15       |