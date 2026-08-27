Vikings Store

Aplicación de gestión de inventario y ventas para una tienda deportiva, desarrollada en Java aplicando Programación Orientada a Objetos.

Descripción

Viking Store es un proyecto personal y académico que simula el sistema de una tienda deportiva. Permite registrar productos, ver el inventario, realizar ventas y buscar productos por nombre.

Tecnologías utilizadas

- Java
- MySQL
- JDBC (MySQL Connector)


Estructura del proyecto

- **Producto.java** → Clase padre con encapsulamiento (atributos privados, getters y setters)
- **Camisa.java** → Clase hija que hereda de Producto, agrega atributo tipo (oversize, manga corta, fit)
- **Pantalon.java** → Clase hija que hereda de Producto, agrega atributo tipo (skinny, nudy, bota recta)
- **Zapatos.java** → Clase hija que hereda de Producto, agrega atributo tipo (guayos, running, aventura)
- **Conexion.java** → Clase que gestiona la conexión entre Java y MySQL (JDBC)
- **tienda.java** → Menú CRUD e interacción con el usuario

Funcionalidades

- ✅ Ver inventario de productos
- ✅ Registrar nuevos productos
- ✅ Vender productos con control de stock
- ✅ Ver historial de ventas con total general
- ✅ Buscar productos por nombre
- ✅ Manejo de excepciones en entradas del usuario

Conceptos aplicados

- Programación Orientada a Objetos (POO)
- Herencia y polimorfismo
- Encapsulamiento (getters y setters)
- Conexión a base de datos con JDBC


Autor

**Diego Fernando Vera**
Tecnólogo en Análisis y Desarrollo de Software
GitHub: diegofvr
