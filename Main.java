import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ListaSimple miCatalogo = new ListaSimple();
        String archivo = "productos.csv";

        // 1. Cargamos datos apenas inicia el programa
        miCatalogo.cargarCSV(archivo);

        int opcion = 0;
        do {
            System.out.println("\n--- 🛒 MENÚ DE INVENTARIO ---");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Mostrar Catálogo");
            System.out.println("3. Eliminar Producto (ID)");
            System.out.println("4. Ordenar por Precio");
            System.out.println("5. Guardar y Salir");
            System.out.print("Selecciona una opción: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("ID: "); int id = leer.nextInt();
                    leer.nextLine(); // Limpiar el buffer
                    System.out.print("Nombre: "); String nombre = leer.nextLine();
                    System.out.print("Precio: "); double precio = leer.nextDouble();
                    
                    miCatalogo.insertarFinal(new Producto(id, nombre, precio));
                    System.out.println("✅ Producto agregado.");
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE PRODUCTOS ---");
                    miCatalogo.mostrarLista(); // Método que recorre con el while
                    break;

                case 3:
                    System.out.print("ID a eliminar: ");
                    int idEliminar = leer.nextInt();
                    if (miCatalogo.eliminarPorId(idEliminar)) {
                        System.out.println("🗑️ Producto eliminado.");
                    } else {
                        System.out.println("❌ No se encontró ese ID.");
                    }
                    break;

                case 4:
                    miCatalogo.ordenarPorPrecio();
                    System.out.println("⚖️ Lista ordenada por precio (Burbuja).");
                    break;

                case 5:
                    // 2. Guardamos antes de cerrar
                    miCatalogo.guardarEnCSV(archivo);
                    System.out.println("💾 Datos guardados. ¡Adiós!");
                    break;

                default:
                    System.out.println("⚠️ Opción no válida.");
            }
        } while (opcion != 5);
    }
}
