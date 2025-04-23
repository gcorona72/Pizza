# Pizza App - Sistema de Gestión de Pedidos de Pizza

## Descripción
Pizza App es una aplicación Spring Boot diseñada para gestionar pedidos de pizza. Permite realizar operaciones como crear pedidos, procesar pagos y gestionar clientes, utilizando Supabase como base de datos en la nube.

## Requisitos del sistema
- Java 17+
- Maven 3.6+
- Conexión a internet (para acceder a Supabase)

## Tecnologías utilizadas
- Java 17
- Spring Boot 3.2.0
- Supabase (Base de datos en la nube)
- Maven (Gestión de dependencias)

## Configuración

### Supabase
La aplicación utiliza Supabase como base de datos. Las credenciales están configuradas en `application.properties`:


### Puerto del servidor
La aplicación se ejecuta en el puerto 8080 con el contexto `/pizzaapp`.

## Estructura del proyecto

### Configuración
- `SupabaseConfig.java` - Configuración del cliente Supabase

### Modelos
- `Payment.java` - Modelo para gestionar pagos
- (Otros modelos para pedidos, productos, clientes)

### Repositorios
- `PaymentRepository.java` - Interactúa con la tabla "payments" en Supabase

### Servicios
- Servicio de Autenticación
- Gestión de Pedidos
- Procesamiento de Pagos

## Funcionalidades principales
- Creación y gestión de pedidos de pizza
- Procesamiento de pagos
- Autenticación de usuarios

## Cómo ejecutar la aplicación

1. Clona el repositorio
2. Asegúrate de tener instalado Maven y Java 17
3. Ejecuta el siguiente comando en la raíz del proyecto:

```bash
mvn spring-boot:run
```

La aplicación estará disponible en: http://localhost:8080/pizzaapp

## Notas
- La aplicación utiliza el espacio de nombres `io.supabase` para la integración con Supabase
- Se requiere una cuenta en Supabase y una base de datos configurada con las tablas necesarias

## Licencia
Este proyecto está licenciado bajo la Licencia MIT - ver el archivo LICENSE para más detalles.
