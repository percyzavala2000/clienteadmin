# ClienteAdmin - Sistema de Administración de Clientes

Este proyecto es una aplicación web desarrollada con **Spring Boot**, que permite administrar una lista de clientes (personas) con información básica como nombre, apellido, correo electrónico, teléfono y saldo.

## Tecnologías utilizadas
- ☕ Java 17
- 🌱 Spring Boot 3.x
- 🛢️ Spring Data JPA
- 🔒 Spring Security
- 🎨 Thymeleaf
- 🎯 Bootstrap 5 (para el diseño responsivo)
- 🐬 MySQL 8
- 🛠️ Maven
-    Docker 
-    Spring MVC
-    Hibernate / JPA


## Requisitos

- Java 17 o superior
- Maven 3.8+
- MySQL Server 8
- IDE recomendado: IntelliJ IDEA / Eclipse / VSCode

## Configuración inicial

1. **Base de datos:**

   Crear una base de datos llamada `personasDB` en tu servidor de MySQL:

  ## 🗄️ Configuración de la base de datos

- **Base de datos**: `personasDB`
- **Tablas**:
  - `persona`
  - `usuario`
  - `rol`
### Script de Tablas

```sql
CREATE DATABASE IF NOT EXISTS personasDB;

USE personasDB;

CREATE TABLE persona (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    correo VARCHAR(100),
    telefono VARCHAR(20),
    saldo DOUBLE
);

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(45) UNIQUE,
    password VARCHAR(128)
);

CREATE TABLE rol (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(45),
    usuario_id INT,
    CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);
```
## diagrama de la base de datos

```plaintext
+-----------+        +---------+
|  usuario  |        |    rol   |
|-----------|        |---------|
| id        |<------>| usuario_id |
| username  |        | nombre   |
| password  |        +---------+
+-----------+

+-----------+
|  persona  |
|-----------|
| id        |
| nombre    |
| apellido  |
| correo    |
| telefono  |
| saldo     |
+-----------+
```



   Puedes ejecutar el script anterior en tu cliente MySQL para crear la base de datos y las tablas necesarias.

   **Nota:** Asegúrate de que el usuario de MySQL tenga permisos para crear bases de datos y tablas.
   Si no tienes un cliente MySQL, puedes usar herramientas como [MySQL Workbench](https://www.mysql.com/products/workbench/) o [DBeaver](https://dbeaver.io/).

   ```sql
2. **Datos de conexión:**

   Editar el archivo `src/main/resources/application.properties` si tu usuario o contraseña de MySQL son diferentes:

   ```properties
spring.application.name=clienteadmin
logging.pattern.dateformat=hh:mm
spring.main.banner-mode=off
spring.thymeleaf.cache=false

# Conexión a MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/personasDB?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=admin
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

# Mostrar SQL
spring.jpa.properties.hibernate.format_sql=true
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE

spring.web.resources.add-mappings=true

   ```

3. **Scripts iniciales:**

   Puedes agregar manualmente personas a la tabla si no tienes un script de inserción automática.

## Ejecución del proyecto

1. Clona el repositorio:

   ```bash
   git clone https://github.com/percyzavala2000/clienteadmin.git
   cd clienteadmin
   ```

2. Compila y ejecuta el proyecto con Maven:

   ```bash
   ./mvnw spring-boot:run
   ```

   O si prefieres desde el IDE, simplemente ejecuta la clase `ClienteadminApplication.java`.

3. Accede a la aplicación:

   ```
   http://localhost:8080/
   ```

## Credenciales de acceso

- Usuario: **admin**
- Contraseña: **admin**

_(o según las configuraciones de tu base de datos y Spring Security)_

## Funcionalidades principales

- Listado de personas.
- Agregar nueva persona.
- Editar datos de persona.
- Eliminar persona.
- Cálculo de saldo total de clientes.
- Control de acceso con roles (ROLE_ADMIN, ROLE_USER).
- Páginas protegidas (Error 403 para usuarios sin permisos).

## Diseño responsivo

La aplicación utiliza Bootstrap para adaptarse correctamente a dispositivos móviles, tabletas y computadoras.

---

## Contacto

Desarrollado por Percy Zavala.  
Email: percyzavala@gmail.com  
LinkedIn: [\[Percy Zavala\]](https://www.linkedin.com/in/percy-zavala-53047b307/)

---


