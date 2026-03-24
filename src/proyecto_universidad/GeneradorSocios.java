
package proyecto_universidad;

import java.util.ArrayList;
import java.util.Random;


public class GeneradorSocios {
    static ArrayList<Socio> listaSocios = new ArrayList<>();
    static Random random = new Random();

    static String[] nombres = {
        "Carlos", "Ana", "Luis", "Maria", "Mohamed", "Laura", "Jose", "Daniela",
        "Pedro", "Valeria", "Andres", "Camila", "Ricardo", "Sofia"
    };

    static String[] apellidos = {
        "Lopez", "Ramirez", "Fernandez", "Gomez", "Soto", "Vargas", "Morales",
        "Jimenez", "Castro", "Herrera", "Mendoza", "Rojas"
    };

    private static String generarNombreCompleto() {
        int indiceNombre = random.nextInt(nombres.length);
        int indiceApellido = random.nextInt(apellidos.length);
        String nombre = nombres[indiceNombre];
        String apellido = apellidos[indiceApellido];
        return nombre + " " + apellido;
    }

    public static void cargarSocios(int cantidad) {

        for (int i = 0; i < cantidad; i++) {

            String nombre = generarNombreCompleto();
            Socio socio = new Socio(nombre);

            int probabilidad = random.nextInt(100);

            if (probabilidad < 70) {
                socio.setEstadoSocio(Estadosocio.ACTIVO);
            } else {
                socio.setEstadoSocio(Estadosocio.MOROSO);
                int multa = 5000 + random.nextInt(5000);
                socio.setMultasAcumuladas(multa);
            }

            listaSocios.add(socio);
        }
    }

    public static void mostrarSocios() {
        for (int i = 0; i < listaSocios.size(); i++) {
            Socio s = listaSocios.get(i);

            String linea = s.getIdSocio() + " | " + s.getNombreCompleto() + " | " +
                           s.getFechaRegistro() + " | " + s.getEstadoSocio();

            if (s.getMultasAcumuladas() > 0) {
                linea = linea + " | Multa: " + s.getMultasAcumuladas();
            }

            System.out.println(linea);
        }
        
        
    }
    
    public static void resumenSocios(){

    int total = listaSocios.size();
    int activos = 0;
    int morosos = 0;

    for(int i = 0; i < listaSocios.size(); i++){

        Socio s = listaSocios.get(i);

        if(s.getEstadoSocio() == Estadosocio.ACTIVO){
            activos++;
        }

        if(s.getEstadoSocio() == Estadosocio.MOROSO){
            morosos++;
        }
    }

    System.out.println("===== RESUMEN SOCIOS =====");
    System.out.println("Total Socios Registrados: " + total);
    System.out.println("Socios Activos: " + activos);
    System.out.println("Socios Morosos: " + morosos);
}
 
}


