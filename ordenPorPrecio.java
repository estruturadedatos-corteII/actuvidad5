public void ordenarPorPrecio() {
    if (cabeza == null || cabeza.siguiente == null) return;

    boolean huboIntercambio;
    do {
        huboIntercambio = false;
        Nodo anterior = null;
        Nodo actual = cabeza;

        while (actual != null && actual.siguiente != null) {
            Nodo siguiente = actual.siguiente;

            if (actual.dato.precio > siguiente.dato.precio) {
                // Aquí va la lógica de intercambio de referencias que armamos
                huboIntercambio = true;
                
                // IMPORTANTE: Después del intercambio, el "anterior" 
                // para la siguiente pareja ahora es 'siguiente'
            } else {
                // Si no hay intercambio, solo avanzamos
                anterior = actual;
                actual = siguiente;
            }
        }
    } while (huboIntercambio);
}