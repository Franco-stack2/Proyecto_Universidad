
package proyecto_universidad;

import java.util.ArrayList;
import java.util.Random;


public class GeneradorSocios {
    ArrayList<Socio> listaSocios = new ArrayList<>();
    Random random = new Random();

    private String generarNombreCompleto()
    {
        
    }
    
    public void ejecutarGeneracion() {
        int cantidad = 10; 

        for(int i = 0; i < cantidad; i++) {
            String nombre = generarNombreCompleto();
            Socio socio = new Socio(nombre);

            int probabilidad = random.nextInt(100);

            if (probabilidad < 70) {
                socio.setEstadoSocio(Estadosocio.ACTIVO); 
            } else {
                socio.setEstadoSocio(Estadosocio.MOROSO);
                socio.setMultasAcumuladas(5000 + random.nextInt(5000));
            }

            listaSocios.add(socio);
        }

        for (Socio s : listaSocios) {
            System.out.println(s.getIdSocio() + " - " + s.getNombreCompleto() + " - " + s.getEstadoSocio());
        }
    }
}

