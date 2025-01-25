package biblioteca;

import java.util.ArrayList;


public class Autor {
    private String nombre;
    private String apellido;
    private String nacionalidad;
    ArrayList<Libro> libros = new ArrayList<Libro>();
    

    public Autor(String nombre, String apellido, String nacionalidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
    }

    public void agregarLibro(Libro libro) {
        this.libros.add(libro);
    }

    public ArrayList<Libro> getLibros() {
        return this.libros;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getNacionalidad() {
        return this.nacionalidad;
    }
}