/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_universidad;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author bbadi
 */
public class GestionSocios {
    
    
     public static void registrarSocio() {
     registrarNuevoSocio();
     //generarIdUnico();
     generarNombre();
     fechaActual();
     mensaje();
     }
    
    static ArrayList<Socio> listaSocios = new ArrayList<>();
     public static void registrarNuevoSocio() {
         if (GeneradorSocios.listaSocios.size() >= 30) {
             System.out.println("Límite máximo de socios alcanzado");
             return;
         }
      
     }
     
    // public static String generarIdUnico() {}

  

      

    
    
    
    
    static Random random = new Random();

    public static String generarNombre() {

        int i = random.nextInt(GeneradorSocios.nombres.length);
        int j = random.nextInt(GeneradorSocios.apellidos.length);

        String nombre = GeneradorSocios.nombres[i];
        String apellido = GeneradorSocios.apellidos[j];

        return nombre + " " + apellido;
    }
    
    
    
    
    public static String fechaActual(){
        
         LocalDateTime ahora = LocalDateTime.now();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        String fecha = ahora.format(formato);

        return fecha;
        
}
    
    public static String mensaje(){
      // String id = generarIdUnico();
        String nombre = generarNombre();
        String fecha = fechaActual();
       System.out.println("Socio registrado correctamente");
    //System.out.println("ID: " + id  );
    System.out.println("Nombre: " + nombre);
    System.out.println("Fecha: " + fecha);
    System.out.println("Estado: "   );
    return nombre;
    
    
    }
    
    public static void ConsultarSocioID(){
        
          while (true) {
            String idBuscado = JOptionPane.showInputDialog("Ingrese el ID del socio:");

            if (idBuscado == null) {
                return;
            }

            boolean encontrado = false;

            for (Socio s : GeneradorSocios.listaSocios) {
                if (s.getIdSocio().equalsIgnoreCase(idBuscado)) {
                     JOptionPane.showMessageDialog(null,
                    "ID Socio: " + s.getIdSocio() + "\n"
                    + "Nombre: " + s.getNombreCompleto() + "\n"
                    + "Fecha Registro: " + s.getFechaRegistro() + "\n"
                    + "Estado: " + s.getEstadoSocio() + "\n"
                    + "Multas Acumuladas: " + s.getMultasAcumuladas() + "\n"
                    + "Libros Prestados Actualmente: " + s.getCantidadLibrosPrestadosActual());
                }

            }
    
    
    
    
    }
    }
    
    
    public static void actualizarEstadoSocio(){
         String idBuscado = JOptionPane.showInputDialog("Ingrese el ID del socio:");

            if (idBuscado == null) {
                return;
            }

            boolean encontrado = false;
            
            Socio socioEncontrado =null;

            for (Socio s : GeneradorSocios.listaSocios) {
                if (s.getIdSocio().equalsIgnoreCase(idBuscado)) {
                     JOptionPane.showMessageDialog(null, "Estado: " + s.getEstadoSocio());
                     socioEncontrado=s;
                }

            }
            
            
                Object[] opciones = {"ACTIVO", "SUSPENDIDO", "INACTIVO"};
                
        String estadoActual = socioEncontrado.getEstadoSocio().toString();

        int opcion = JOptionPane.showOptionDialog(
                null,
                "Estado actual: " + estadoActual + "\nSeleccione el nuevo estado:",
                "Actualizar Estado de Socio",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );
        
        switch (opcion){
            
            case 0:
                socioEncontrado.setEstadoSocio(Estadosocio.ACTIVO);
                break;
                
            case 1:
                socioEncontrado.setEstadoSocio(Estadosocio.SUSPENDIDO);
                break;
               
                
            case 2:
                socioEncontrado.setEstadoSocio(Estadosocio.INACTIVO);
                break;
               

        }
            JOptionPane.showMessageDialog(null,
                    "ID Socio: " + socioEncontrado.getIdSocio() + "\n"
                    + "Nombre: " + socioEncontrado.getNombreCompleto() + "\n"
                    + "Fecha Registro: " + socioEncontrado.getFechaRegistro() + "\n"
                    + "Estado: " + socioEncontrado.getEstadoSocio() + "\n"
                    + "Multas Acumuladas: " + socioEncontrado.getMultasAcumuladas() + "\n"
                    + "Libros Prestados Actualmente: " + socioEncontrado.getCantidadLibrosPrestadosActual());
        

    
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
          
}





     
     
     
     
     
     
     
     
     
     
     
     
     
     
     

