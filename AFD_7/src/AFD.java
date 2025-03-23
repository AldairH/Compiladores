class AFD {
    private TablaAFD tabla;
    public AFD(TablaAFD tabla) {
        this.tabla = tabla;
    }

    public boolean afd(String cadena) {
        int estadoActual = 0;
        for (char simbolo : cadena.toCharArray()) {
            int nuevoEstado = tabla.obtenerSiguienteEstado(estadoActual, simbolo);
            if (nuevoEstado == -1) return false;
            estadoActual = nuevoEstado;
        }
        return tabla.esEstadoDeAceptacion(estadoActual);
    }
}