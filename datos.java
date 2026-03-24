public class Producto {
    int id;
    String nombre;
    double precio;

}

public class Nodo {
    Producto dato; // La información del producto
    Nodo siguiente; // El enlace al próximo vagón

    public Nodo(Producto producto) {
        this.dato = producto;
        this.siguiente = null; // Al crear un nodo, aún no apunta a nadie
    }
}