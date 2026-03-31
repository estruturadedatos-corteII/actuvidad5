# actuvidad5
Sistema de Gestión de Inventario (Listas Enlazadas)
Este proyecto es una aplicación de consola en Java que permite gestionar un catálogo de productos utilizando una Estructura de Datos de Lista Enlazada Simple. El sistema permite realizar operaciones CRUD, ordenar los datos y mantener la información guardada en un archivo externo.

🚀 Características
Estructura de Datos Dinámica: Implementación de una lista enlazada propia (nodos) sin usar librerías de colecciones de Java.

Operaciones Principales:

Insertar: Agrega productos al final de la lista.

Mostrar: Recorre y visualiza todos los productos en consola.

Eliminar: Busca y quita un producto mediante su ID único.

Ordenar: Algoritmo de Burbuja optimizado para intercambiar referencias de nodos (por precio).

Persistencia de Datos (CSV):

Guardado Automático: Los datos se escriben en un archivo productos.csv al salir.

Carga Automática: El sistema recupera los datos guardados al iniciar la aplicación.

🛠️ Estructura del Código
El proyecto se divide en 4 clases fundamentales:

Producto.java: Clase modelo que contiene id, nombre y precio.

Nodo.java: El contenedor que permite enlazar un producto con el siguiente en la memoria.

ListaSimple.java: El motor del programa. Contiene toda la lógica de manipulación de la lista y manejo de archivos.

Main.java: Interfaz de usuario con un menú interactivo (switch y do-while).

 Instrucciones de Uso
Compilar: Asegúrate de tener instalados todos los archivos en la misma carpeta.

Ejecutar: Inicia la clase Main.

Interacción: * Usa el menú para agregar productos.

Prueba la opción de Ordenar para ver cómo los nodos se reacomodan por precio.

Al elegir "Guardar y Salir", se generará el archivo productos.csv en la carpeta raíz.

Notas de Implementación
Se utilizó PrintWriter y Scanner para la gestión de archivos por su simplicidad y eficiencia.

El intercambio de nodos en el ordenamiento se realiza mediante referencias, lo que demuestra un manejo avanzado de punteros en Java.
https://drive.google.com/file/d/1siZE8_b6owOL3V6m86AKdTi8e_BTXHwr/view?usp=drive_link
