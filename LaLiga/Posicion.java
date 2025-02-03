package LaLiga;

public class Posicion {
    public Equipo equipo;
    public int posicion;
    public int puntos;
    public int partidosJugados;
    public int partidosGanados;
    public int partidosEmpatados;
    public int partidosPerdidos;
    public int golesAFavor;
    public int golesEnContra;
    public int diferenciaDeGoles;
    
    public Posicion(Equipo equipo) {
        this.equipo = equipo;
        this.posicion = 0;
        this.puntos = 0;
        this.partidosJugados = 0;
        this.partidosGanados = 0;
        this.partidosEmpatados = 0;
        this.partidosPerdidos = 0;
        this.golesAFavor = 0;
        this.golesEnContra = 0;
        this.diferenciaDeGoles = 0;
    }
}