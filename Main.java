import ExtraccionDatos.*;
import LaLiga.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> nombresEquipos = ExtraerEquipos.extraer("equipos.txt");
        Liga liga = new Liga();

        int sequenciaId = 0;

        for (String nombre : nombresEquipos) {
            Equipo equipo = new Equipo(nombre, sequenciaId);

            liga.agregarEquipo(equipo);
            sequenciaId++;
        }

        liga.inicializarClasificacion();
        liga.guardarPartidos(ExtraerPartidos.extraer("partidos.txt", liga));
        liga.analizarPartidos();
        liga.imprimirClasificacionEnArchivo("clasificacion.txt");
    }
}