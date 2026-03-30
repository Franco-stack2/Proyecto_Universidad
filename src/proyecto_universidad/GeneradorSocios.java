
package proyecto_universidad;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

public class GeneradorSocios {
    private ArrayList<Socio> listaSocios = new ArrayList<>();
    private Random random = new Random();

    private String[] nombres = {
        "Carlos", "Ana", "Luis", "Maria", "Mohamed", "Laura", "Jose", "Daniela",
        "Pedro", "Valeria", "Andres", "Camila", "Ricardo", "Sofia"
    };

    private String[] apellidos = {
        "Lopez", "Ramirez", "Fernandez", "Gomez", "Soto", "Vargas", "Morales",
        "Jimenez", "Castro", "Herrera", "Mendoza", "Rojas"
    };


    public  String generarNombreCompleto() {
        int indiceNombre = random.nextInt(nombres.length);
        int indiceApellido = random.nextInt(apellidos.length);
        String nombre = nombres[indiceNombre];
        String apellido = apellidos[indiceApellido];
        return nombre + " " + apellido;
    }

    public void cargarSocios(int cantidad) {

        for (int i = 0; i < cantidad; i++) {
             if(listaSocios.size() >= 30){
            JOptionPane.showMessageDialog(null, "Limite maximo de socios alcanzado (30)"); // se valida que el limite tiene que ser 30 nada mas
            return;
        }


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

    public void mostrarSocios() {
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
    
    public  void resumenSocios(){

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
 
    
    
    public ArrayList<Socio> getListaSocios() {
        return listaSocios;
    }

    public void setListaSocios(ArrayList<Socio> listaSocios) {
        this.listaSocios = listaSocios;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public String[] getNombres() {
        return nombres;
    }

    public void setNombres(String[] nombres) {
        this.nombres = nombres;
    }

    public String[] getApellidos() {
        return apellidos;
    }

    public void setApellidos(String[] apellidos) {
        this.apellidos = apellidos;
    }
}


