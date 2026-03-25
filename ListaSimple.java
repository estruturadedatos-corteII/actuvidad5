import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ListaSimple {
    // 1. La "cabeza" debe estar aquí arriba, fuera de los métodos
    Nodo inicio;

    public void guardarEnCSV(String nombreArchivo) {
        try (PrintWriter escritor = new PrintWriter(new FileWriter(nombreArchivo))) {
            Nodo auxiliar = inicio;

            while (auxiliar != null) {
                Producto a = auxiliar.dato;
                // Escribimos: ID,Nombre,Precio
                escritor.println(a.id + "," + a.nombre + "," + a.precio);
                auxiliar = auxiliar.siguiente; // ¡No olvides avanzar el puntero!
            }
            System.out.println("¡Datos guardados exitosamente!");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    public void cargarCSV(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (!archivo.exists())
            return; // Si no hay archivo, no hacemos nada

        try (Scanner lector = new Scanner(archivo)) {
            while (lector.hasNextLine()) {
                String[] datos = lector.nextLine().split(",");

                // Convertimos y guardamos
                int id = Integer.parseInt(datos[0]);
                double precio = Double.parseDouble(datos[2]);

                this.insertarFinal(new Producto(id, datos[1], precio));
            }
        } catch (Exception e) {
            System.out.println("Error al cargar");
        }
    }

    // 2. El método va dentro de la misma clase
    public void insertarFinal(Producto a) {
        Nodo nuevo = new Nodo(a);

        if (inicio == null) {
            inicio = nuevo;
        } else {
            // Aquí es donde necesitamos buscar el último
            Nodo auxiliar = inicio;

            // ¿Cómo avanzamos hasta el final?
            while (auxiliar.siguiente != null) {
                auxiliar = auxiliar.siguiente;
            }

            // ¡Aquí hacemos la conexión que hablamos antes!
            auxiliar.siguiente = nuevo;
        }
    }

    public void ordenarPorPrecio() {
        if (inicio == null || inicio.siguiente == null)
            return;

        boolean Intercambio;
        do {
            Intercambio = false;
            Nodo anterior = null;
            Nodo actual = inicio;

            while (actual != null && actual.siguiente != null) {
                Nodo siguiente = actual.siguiente;

                if (actual.dato.precio > siguiente.dato.precio) {
                    Intercambio = true;

                    // 1. Intercambio de brazos (punteros)
                    actual.siguiente = siguiente.siguiente;
                    siguiente.siguiente = actual;

                    // 2. Conectar con el nodo de atrás (o la cabeza)
                    if (anterior == null) {
                        inicio = siguiente;
                    } else {
                        anterior.siguiente = siguiente;
                    }

                    // 3. Para la siguiente pareja, 'siguiente' quedó atrás
                    anterior = siguiente;
                    // Nota: 'actual' sigue siendo el mismo, pero ahora está adelante
                } else {
                    // Si no hubo intercambio, avanzamos normal
                    anterior = actual;
                    actual = actual.siguiente;
                }
            } // Cierre del while
        } while (Intercambio); // Cierre del do-while
    }

    public boolean eliminarPorId(int idBusca) {
        if (inicio == null)
            return false;

        // Caso 1: ¿Es el primer elemento?
        if (inicio.dato.id == idBusca) {
            inicio = inicio.siguiente;
            return true;
        }

        // Caso 2: Buscar en el resto de la lista
        Nodo anterior = inicio;
        Nodo actual = inicio.siguiente;

        while (actual != null) {
            if (actual.dato.id == idBusca) {
                // ¡Lo encontramos! Aquí hacemos el puente
                anterior.siguiente = actual.siguiente;
                return true;
            }
            // Si no es este, avanzamos ambos punteros
            anterior = actual;
            actual = actual.siguiente;
        }
        return false; // No se encontró
    }

    public void mostrarLista() {
        // Empezamos desde el primer nodo
        Nodo auxiliar = inicio;

        // Si la lista no tiene nada, avisamos al usuario
        if (auxiliar == null) {
            System.out.println("⚠️ El catálogo está vacío.");
            return;
        }

        System.out.println("\n--- 📦 LISTA DE PRODUCTOS ---");
        // Recorremos la lista hasta que el auxiliar llegue al final (null)
        while (auxiliar != null) {
            Producto p = auxiliar.dato;
            System.out.println("ID: " + p.id + " | Nombre: " + p.nombre + " | Precio: $" + p.precio);

            // ¡Súper importante! Avanzamos al siguiente nodo
            auxiliar = auxiliar.siguiente;
        }
        System.out.println("-----------------------------\n");
    }
}