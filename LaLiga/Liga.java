

package LaLiga;

import java.util.ArrayList;

public class Liga {
    public ArrayList<Equipo> equipos;
    public Posicion[] clasificacion;
    private int[][][] partidos;

    public Liga() {
        this.equipos = new ArrayList<Equipo>();
    }

    public void agregarEquipo(Equipo equipo) {
        this.equipos.add(equipo);
    }

    public void listarEquipos() {
        for (Equipo equipo : this.equipos) {
            System.out.println("Equipo: " + equipo.nombre + "; ID: " + equipo.id);
        }
    }

    public void guardarPartidos(int[][][] partidos) {
        this.partidos = partidos;
    }

    public ArrayList<Equipo> getEquipos() {
        return this.equipos;
    }

    public int obtenerIdEquipo(String nombre) {
        for (Equipo equipo : this.equipos) {
            if (equipo.nombre.equals(nombre)) {
                return equipo.id;
            }
        }

        return -1;
    }

    public void inicializarClasificacion() {
        int[][][] partidos = new int[this.equipos.size()][this.equipos.size()][2];
        this.clasificacion = new Posicion[this.equipos.size()];

        for (int i = 0; i < this.equipos.size(); i++) {
            this.clasificacion[i] = new Posicion(this.equipos.get(i));
        }
    }

    public void agregarPartido(int idLocal, int idVisitante, int golesLocal, int golesVisitante) {
        this.partidos[idLocal][idVisitante][0] = golesLocal;
        this.partidos[idLocal][idVisitante][1] = golesVisitante;
    }

    public void analizarPartidos() {
        // obtener los partidos del equipo como local
        for (int i = 0; i < this.equipos.size(); i++) {
            for (int j = 0; j < this.equipos.size(); j++) {
                if (i != j) {
                    int golesLocal = this.partidos[i][j][0];
                    int golesVisitante = this.partidos[i][j][1];

                    if (golesLocal > golesVisitante) {
                        this.clasificacion[i].partidosGanados++;
                        this.clasificacion[j].partidosPerdidos++;
                    } else if (golesLocal < golesVisitante) {
                        this.clasificacion[i].partidosPerdidos++;
                        this.clasificacion[j].partidosGanados++;
                    } else {
                        this.clasificacion[i].partidosEmpatados++;
                        this.clasificacion[j].partidosEmpatados++;
                    }

                    this.clasificacion[i].golesAFavor += golesLocal;
                    this.clasificacion[i].golesEnContra += golesVisitante;
                    this.clasificacion[i].diferenciaDeGoles += golesLocal - golesVisitante;

                    this.clasificacion[j].golesAFavor += golesVisitante;
                    this.clasificacion[j].golesEnContra += golesLocal;
                    this.clasificacion[j].diferenciaDeGoles += golesVisitante - golesLocal;

                    if (golesLocal > golesVisitante) {
                        this.clasificacion[i].puntos += 3;
                    } else if (golesLocal == golesVisitante) {
                        this.clasificacion[i].puntos += 1;
                        this.clasificacion[j].puntos += 1;
                    } else {
                        this.clasificacion[j].puntos += 3;
                    }

                    this.clasificacion[i].partidosJugados++;
                    this.clasificacion[j].partidosJugados++;
                }
            }
        }

        this.ordenarClasificacion();
    }

    public void imprimirClasificacionEnArchivo(String archivo) {
        try {
            java.io.FileWriter file = new java.io.FileWriter(archivo);
            int longitudNombreLargo = this.obtenerLongitudDelNombreMasLargo();
            String encabezadoNombreEquipo = this.agregarEspaciosAnombre("Nombre", longitudNombreLargo);
            file.write("Posicion\t" + encabezadoNombreEquipo + "\tPuntos\tPJ\tPG\tPE\tPP\tGF\tGC\tDG\n");
            for (int i = 0; i < this.clasificacion.length; i++) {

                String nombreConEspacios = this.agregarEspaciosAnombre(this.clasificacion[i].equipo.nombre, longitudNombreLargo);
                file.write(
                    this.clasificacion[i].posicion +  "\t\t\t" + 
                    nombreConEspacios + "\t" + 
                    this.clasificacion[i].puntos + "\t\t" + 
                    this.clasificacion[i].partidosJugados + "\t" + 
                    this.clasificacion[i].partidosGanados + "\t" + 
                    this.clasificacion[i].partidosEmpatados + "\t" + 
                    this.clasificacion[i].partidosPerdidos + "\t" + 
                    this.clasificacion[i].golesAFavor + "\t" + 
                    this.clasificacion[i].golesEnContra + "\t" + 
                    this.clasificacion[i].diferenciaDeGoles + "\n");
            }

            file.close();
        } catch (java.io.IOException e) {
            System.out.println("Error al escribir el archivo");
        }
    }

    private String agregarEspaciosAnombre(String nombre, int longitud) {
        String espacios = "";
        for (int i = 0; i < longitud - nombre.length(); i++) {
            espacios += " ";
        }

        return nombre + espacios;
    }
    private int obtenerLongitudDelNombreMasLargo() {
        int longitud = 0;

        for (int i = 0; i < this.clasificacion.length; i++) {
            if (this.clasificacion[i].equipo.nombre.length() > longitud) {
                longitud = this.clasificacion[i].equipo.nombre.length();
            }
        }

        return longitud;
    }

    private void ordenarClasificacion() {
        for (int i = 0; i < this.clasificacion.length; i++) {
            for (int j = 0; j < this.clasificacion.length; j++) {
                if ((this.clasificacion[i].puntos > this.clasificacion[j].puntos) || 
                (this.clasificacion[i].puntos == this.clasificacion[j].puntos && this.clasificacion[i].diferenciaDeGoles > this.clasificacion[j].diferenciaDeGoles)) {
                    Posicion temp = this.clasificacion[i];
                    this.clasificacion[i] = this.clasificacion[j];
                    this.clasificacion[j] = temp;
                }
            }
        }

        for (int i = 0; i < this.clasificacion.length; i++) {
            this.clasificacion[i].posicion = i + 1;
        }
    }
}