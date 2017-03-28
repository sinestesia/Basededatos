package es.pamp.modelo;

public class Cliente {
    private String nombre;
    private String categoria;
    private String telefono;

    public Cliente(String nombre, String categoria, String telefono) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
