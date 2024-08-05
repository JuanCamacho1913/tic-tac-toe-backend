![Descripción alternativa](src/main/resources/static/tic-tac-toe.jpg)

# Documentación del Proyecto Tic-Tac-Toe

## Descripción
**Este proyecto proporciona un servicio de juego que le permite a los usuarios jugar Tic Tac Toe multi-jugador a través de una interfaz de programación de aplicaciones**.

## Características
Este proyecto consiste en el desarrollo de una API con tecnología **Java utilizando el framework Spring Boot**. Esta API tiene como objetivo el suministro de información de clubes y jugadores. A continuación, se detallan las principales características de este proyecto:

1. **API de Suministro de Información**: Se crea una API que ofrece diversas funcionalidades para obtener información de clubes y jugadores, incluyendo:
     - Búsqueda de jugadores por el nombre.
     - Listado completo de clubes y jugadores.
     - Filtrado de clubes y jugadores por identificador.
     - Acceso a la imagen de un club en particular.
2. **Almacenamiento en Base de Datos**: Se implementa un esquema de base de datos, preferiblemente MySQL, para almacenar toda la información necesaria. Esto incluye datos relacionados con clubes y jugadores.

## Configuración
Se debe de configurar en el archivo application.properties las propiedades correspondientes para MySQL:
```properties
spring.datasource.url=jdbc:mysql://<Tu host>:<Tu puerto>/<Tu base de datos>
spring.datasource.username=<Tu username>
spring.datasource.password=<Tu password>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

Esto incluye tambien configuración de Hibernate:
```properties
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```
## Paquetes del Proyecto
El proyecto está organizado en los siguientes paquetes:

- `com.tic.tac.toe.domain`: Contiene clases para capturar errores de la aplicacion y devolverlos como respuesta. Define la logica de negocio de la aplicacion y es un puente para conectarse con la capa de persistencia.
- `com.tic.tac.toe.persistence`: Define entidades a la base de datos y conexion con la base de datos.
- `com.tic.tac.toe.presentation`: Contiene clases DTO para toda la aplicacion y controladores.
- `com.tic.tac.toe.utils`: Contiene mapeadores para convertir entre entidades y DTO.

## Clases Principales
A continuación, se describen algunas de las clases principales del proyecto:

### `IClubService` y `IPlayerService`
- Interfaces de servicio que definen operaciones relacionadas con clubes y jugadores. Sus implementaciones se encuentran en `ClubServiceImpl` y `PlayerServiceImpl`, respectivamente.
### `findPlayerByName` y Repositorio
- El método `findPlayerByName` y su repositorio gestionan interacciones de los usuarios con la aplicación.
### Controladores
- Los controladores, como `ClubController`, y `PlayerController`, gestionan las solicitudes HTTP y responden con datos a los clientes.

## Manejo de Excepciones
El proyecto incluye un sistema de manejo de excepciones que garantiza una respuesta adecuada a diferentes tipos de errores, El manejo de excepciones se realiza a través de las clases ClubExceptionHandler y PlayerExceptionHandler.

## Resumen
Este documento proporciona una visión general de la estructura del proyecto, sus componentes claves y configuraciones.



