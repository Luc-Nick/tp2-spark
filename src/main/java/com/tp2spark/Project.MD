# Organización de Directorios en un Proyecto MVC con Spark

### Un esquema de directorios típico para implementar el patrón MVC usando Spark podría verse así:

/src
 └── /main
     └── /java
         └── /com/tuapp
             ├── /controllers   --> Controladores (Controller)
             ├── /models        --> Modelos (Model), incluidos los DAOs
             ├── /services      --> Servicios que manejan la lógica de negocio
             ├── /views         --> Plantillas de vistas (si usas, por ejemplo, Velocity, Thymeleaf, etc.)
             └── /utils         --> Clases utilitarias si las necesitas


## Desglose de directorios: 

- /controllers: Aquí estarán los controladores que manejarán las solicitudes HTTP. Son los responsables de recibir las peticiones, invocar los métodos de los servicios y devolver la respuesta al cliente (por ejemplo, una página HTML, JSON, etc.).

- /models: En este directorio irán los Modelos (entidades que representan los datos) y los DAOs (clases que acceden a la base de datos).

- /services: Este directorio contiene la lógica de negocio de la aplicación. Los servicios interactúan con los DAOs y contienen validaciones, transformaciones de datos o cualquier lógica de negocio.

- /views: Si tu aplicación genera vistas HTML, este es el directorio donde irán tus archivos de plantillas (como Velocity o Thymeleaf). También puedes usar Mustache o FreeMarker, según tus preferencias. 
(Nota: En nuestro proyecto no generamos vistas)