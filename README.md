![Descripción alternativa](src/main/resources/static/tic-tac-toe-futbol.jpeg)

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

### peticiones HTTP:

**Player:**

- **GET**
- `/v1/player/findAll`: Muestra la busqueda de toda la lista de jugadores.
- `/v1/player/find/{id}`: Muestra la busqueda de jugador por identificador.
- `/v1/player/find`: Muestra la busqueda de jugador por el nombre.
- **POST**
- `/v1/player/create`: Gestiona la creación de jugadores con su club.
- `/v1/player/create/assign`: Gestiona la creación de jugadores y se asigna por identificador el club.
- **PUT**
- `/v1/player/update/{id}`: Gestiona la actualización de datos del jugador por identificador.
- **DELETE**
- `/v1/player/delete/{id}`: Elimina jugador en DB por identificador.

**Club:**

- **GET**
- `/v1/club/findAll`: Muestra la busqueda de toda la lista de clubes.
- `/v1/club/find/{id}`: Muestra la busqueda del club por identificador.
- **POST**
- `/v1/club/create`: Gestiona la creación del club.
- **PUT**
- `/v1/club/update/{id}`: Gestiona la actualización de datos del club por identificador.
- **DELETE**
- `/v1/club/delete/{id}`: Elimina club en DB por identificador.

## Manejo de Excepciones
El proyecto incluye un sistema de manejo de excepciones que garantiza una respuesta adecuada a diferentes tipos de errores, El manejo de excepciones se realiza a través de las clases ClubExceptionHandler y PlayerExceptionHandler.

## Pasos Para descargar este archivo
1. En GitHub.com, navega a la página principal del repositorio.
2. Encima de la lista de archivos, haz clic en botón verde **<> Code**.
3. Haz clic en **Download ZIP**.

## Pasos Para descargar un fichero
1. En GitHub.com, navega a la página principal del repositorio.
2. Navegas hasta el fichero y damos clic para ingresar al fichero.
2. En la parte superior del fichero, haz clic en **Raw**.
3. Te llevará al contenido del fichero, haz clic derecho y guardar como.

## Resumen
Este documento proporciona una visión general de la estructura del proyecto, sus componentes claves y configuraciones.



