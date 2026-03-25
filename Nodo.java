public class Nodo {
    Producto dato;   // Aquí guardamos el objeto Producto
    Nodo siguiente;  // El "brazo" que apunta al siguiente vagón

    // Constructor: Así es como se crea un nuevo nodo
    public Nodo(Producto p) {
        this.dato = p;
        this.siguiente = null; // Al principio no apunta a nadie
    }
}
