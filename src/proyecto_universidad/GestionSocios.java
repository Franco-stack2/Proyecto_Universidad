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
     generarIdUnico();
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
     
     public static String generarIdUnico() {

    String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    String id;
    boolean repetido;

    do {
        String randomID = "";

        for (int i = 0; i < 4; i++) {
            int pos = (int)(Math.random() * caracteres.length());
            randomID += caracteres.charAt(pos);
        }

        id = "SOC-" + randomID;

        repetido = false;

        for (Socio s : listaSocios) {
            if (s.getIdSocio().equals(id)) {
                repetido = true;
                break;
            }
        }

    } while (repetido); 

    return id;}

    
    
    
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
        String id = generarIdUnico();
        String nombre = generarNombre();
        String fecha = fechaActual();
       System.out.println("Socio registrado correctamente");
    System.out.println("ID: " + id  );
    System.out.println("Nombre: " + nombre);
    System.out.println("Fecha: " + fecha);
    System.out.println("Estado: " );
    return id;
    
    
    }
          
}





     
     
     
     
     
     
     
     
     
     
     
     
     
     
     

