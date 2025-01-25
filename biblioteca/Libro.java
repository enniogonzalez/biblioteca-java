package biblioteca;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Libro {
    private String titulo;
    private LocalDate anio;
    private String ISBN;
    private Categorias categoria;

    public Libro(String titulo, String anio, String ISBN, Categorias categoria) {
        this.titulo = titulo;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            this.anio = LocalDate.parse(anio, formatter);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            this.anio = null; // or handle the error as needed
        }
        this.ISBN = ISBN;
        this.categoria = categoria;
    }
    
    public String getTitulo() {
        return this.titulo;
    }
    
    public LocalDate getAnio() {
        return this.anio;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public Categorias getCategoria() {
        return this.categoria;
    }
}
