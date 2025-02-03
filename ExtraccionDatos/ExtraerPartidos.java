package ExtraccionDatos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import LaLiga.*;

public class ExtraerPartidos {
    public static int[][][] extraer(String filePath, Liga liga) {
        int [][][] partidos = new int[liga.equipos.size()][liga.equipos.size()][2];
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                boolean esLocal = true;
                boolean esVisitante = false;
            
                String nombreLocal = "";
                int golesLocal=0;
                String nombreVisitante = "";
                int golesVisitante=0;

                String texto = "";
            
                for (String part : parts) {
                    boolean banderaEsNumero = esNumero(part);
                    if(!banderaEsNumero && !part.equals( "-")){
                        texto = texto + part + " ";
                    } else if(banderaEsNumero){
                        if(esLocal){
                            nombreLocal = texto;
                            golesLocal = Integer.parseInt(part);
                            esLocal = false;
                            esVisitante = true;
                            texto = "";
                        } else if(esVisitante){
                            golesVisitante = Integer.parseInt(part);
                        }
                    }
                }
                nombreVisitante = texto;
                
                int idLocal = liga.obtenerIdEquipo(nombreLocal.trim());
                int idVisitante = liga.obtenerIdEquipo(nombreVisitante.trim());

                partidos[idLocal][idVisitante][0] = golesLocal;
                partidos[idLocal][idVisitante][1] = golesVisitante;

            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
            e.printStackTrace();
        }

        return partidos;
    }

    public static boolean esNumero(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}