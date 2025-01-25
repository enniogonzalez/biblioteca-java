# Sistema de Gestión de Biblioteca

## Descripción General
Este proyecto es un sistema básico para la gestión de una biblioteca, desarrollado con el objetivo de practicar y aplicar los principios fundamentales de la programación orientada a objetos (POO). El sistema permite realizar operaciones como el seguimiento de libros, autores, usuarios y préstamos, implementando conceptos clave como herencia, encapsulamiento, polimorfismo y asociaciones entre clases.

## Requisitos Funcionales

### 1. Gestión de Libros
- Los libros tienen los siguientes atributos: título, autor, año de publicación, ISBN único y categoría (e.g., "Ficción", "Ciencia", "Historia").
- Funcionalidades:
  - Agregar un libro.
  - Buscar libros por título o ISBN.
  - Listar todos los libros disponibles.

### 2. Gestión de Autores
- Los autores tienen los siguientes atributos: nombre, apellido, nacionalidad y una lista de libros que han escrito.
- Funcionalidades:
  - Listar los libros escritos por un autor específico.

### 3. Gestión de Usuarios
- Los usuarios tienen los siguientes atributos: ID único, nombre, dirección de correo electrónico y una lista de libros prestados.
- Funcionalidades:
  - Registrar nuevos usuarios.
  - Listar todos los usuarios registrados.

### 4. Sistema de Préstamos
- Características principales:
  - Un usuario puede prestar hasta 3 libros a la vez.
  - Cada préstamo incluye una fecha de inicio y una fecha de vencimiento (14 días desde el inicio).
  - No se permite prestar libros ya prestados.
  - Los usuarios pueden devolver libros, actualizando su disponibilidad.

## Requisitos Técnicos

### 1. Clases Principales
- `Libro`
- `Autor`
- `Usuario`
- `Prestamo`
- Una clase principal `Biblioteca` para gestionar el sistema.

### 2. Relaciones entre Clases
- Un autor puede tener varios libros.
- Un usuario puede tener varios préstamos.
- Cada préstamo está asociado a un único libro y un único usuario.

### 3. Encapsulamiento y Validación
- Uso de modificadores de acceso (`private`, `protected`, `public`) para proteger atributos.
- Implementación de getters y setters para acceder y modificar atributos.
- Validaciones:
  - No se pueden duplicar libros con el mismo ISBN.
  - No se pueden registrar usuarios con el mismo ID.
  - Un usuario no puede prestar más de 3 libros al mismo tiempo.

### 4. Organización por Paquetes
- `biblioteca.libros`: Contiene las clases `Libro` y `Autor`.
- `biblioteca.usuarios`: Contiene la clase `Usuario`.
- `biblioteca.prestamos`: Contiene la clase `Prestamo`.
- `biblioteca.main`: Contiene la clase `Biblioteca` y el método `main`.

### 5. Polimorfismo
- Se incluyen dos tipos de libros:
  - `LibroFisico`: Con un atributo adicional para el estado del libro (e.g., "Nuevo", "Usado").
  - `LibroDigital`: Con un atributo adicional para la URL de descarga.

### 6. Persistencia Temporal
- Uso de `ArrayList` para almacenar libros, autores, usuarios y préstamos en memoria.

## Opcionales para Ampliar el Proyecto

### 1. Sistema de Categorías
- Implementación de una clase `Categoria` para agrupar libros por género y listar libros de una categoría específica.

### 2. Interacción con el Usuario
- Creación de un menú en consola para realizar operaciones como:
  - Registrar libros.
  - Buscar usuarios.
  - Realizar préstamos.

### 3. Manejo de Excepciones
- Creación de excepciones personalizadas para manejar errores comunes:
  - `LibroNoDisponibleException`: Para intentar prestar un libro ya prestado.
  - `UsuarioNoEncontradoException`: Para operaciones con usuarios inexistentes.