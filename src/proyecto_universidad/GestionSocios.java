/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_universidad;

import java.util.Random;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author bbadi
 */
public class GestionSocios {
    
    
     public void registrarSocio(GeneradorSocios socios ) {
         
         
    String id =generarIdUnico(socios);
     String nombre =generarNombre(socios);
    String fecha= fechaActual();
    String estado = "ACTIVO";
    double multa=0.0;
    int libros = 0;
    
    
     mensaje(socios);
        
     }
     

    
    

     
   private String generarIdUnico(GeneradorSocios socios) {
       int x = socios.getListaSocios().size() + 1;//se llama a la lista de socios y se toma el ultimo valor de la lista para sumarle 1 
    String id = "SOC-"+ String.format("%04d", x);
    x++;
    return id;

    } // Este método se usa para generar el ID único.

  

      

    
    
    
    
     Random random = new Random();

    private String generarNombre(GeneradorSocios socios) {

        int i = random.nextInt(socios.getNombres().length);
        int j = random.nextInt(socios.getApellidos().length);

        String nombre = socios.getNombres()[i];
        String apellido = socios.getApellidos()[j];

        return nombre + " " + apellido;
    }
    
    
    
    
    private String fechaActual(){
        
         LocalDateTime ahora = LocalDateTime.now();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        String fecha = ahora.format(formato);

        return fecha;
        
}
    
    private void mensaje(GeneradorSocios socios){
      String id = generarIdUnico(socios);
      String estado = "ACTIVO";
      if (socios.getListaSocios().size() >= 30) {
             System.out.println("Limite maximo de socios alcanzado");
         }else if(socios.getListaSocios().size() < 30){
             
        String nombre = generarNombre(socios);
        String fecha = fechaActual();
        Socio nuevoSocio = new Socio(nombre); // se crea el objeto nuevo socio donde solo se le pasa el nombre al objeto Socio donde el constructor hace el resto
        socios.getListaSocios().add(nuevoSocio); // se agrega a la lista privada que se encuentra en socios
       System.out.println("Socio registrado correctamente");
    System.out.println("ID: " + id );
    System.out.println("Nombre: " + nombre);
    System.out.println("Fecha: " + fecha);
    System.out.println("Estado: " + estado  );}
      
    }
    
    public static void ConsultarSocioID(GeneradorSocios socios){
        
          while (true) {
            String idBuscado = JOptionPane.showInputDialog("Ingrese el ID del socio:");

            if (idBuscado == null) {
                return;
            }

            boolean encontrado = false;

            for (Socio s : socios.getListaSocios()) {
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
    
 
    
    
    public void actualizarEstadoSocio(GeneradorSocios socios){
         String idBuscado = JOptionPane.showInputDialog("Ingrese el ID del socio:");
         

            if (idBuscado == null) {
                return;
            }
        if (idBuscado.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un ID");
            return;
        }

            boolean encontrado = false;
            
            Socio socioEncontrado =null;

            for (Socio s : socios.getListaSocios()) {
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
    
    
    public void multas(GeneradorSocios socios){
    
           while (true) {
            String idBuscado = JOptionPane.showInputDialog("Ingrese el ID del socio:");

            if (idBuscado == null) {
                return;
            }
               if (idBuscado.equals("")) {
                   JOptionPane.showMessageDialog(null, "Debe ingresar un ID");
                   return;
               }

            boolean encontrado = false;
             Socio socioEncontrado =null;
    
    
                for (Socio s : socios.getListaSocios()) {
                if (s.getIdSocio().equalsIgnoreCase(idBuscado)) {
                     JOptionPane.showMessageDialog(null, "Multas: " + s.getMultasAcumuladas());
                     socioEncontrado = s;
                }

            }
                
                  
             if(socioEncontrado.getMultasAcumuladas()!=0) {  
     String op= JOptionPane.showInputDialog("""
                    MENU SOCIOS

                    1. Pagar la totalidad
                    2. Pagar un monto parcial:
                """);
                 if (op == null) {
                     JOptionPane.showMessageDialog(null, "operacion cancelada");
                     break;
                 }//validacion
                 
                 if(op.equals("")){
                  JOptionPane.showMessageDialog(null, "opcion invalida");
                  return;
                 }

                switch (op) {

                    case "1":
                       socioEncontrado.setMultasAcumuladas(0);
                       socioEncontrado.setEstadoSocio(Estadosocio.ACTIVO);
                       
                       JOptionPane.showMessageDialog(null, "Todas las multas quedaron pagadas");
                       
                       
                        break;

                    case "2":
                        
                        
                        
                        try { //Se realiza un try catch para verificar que el usuario no ingrese numero invalidos 
                            double cantidad = Integer.parseInt(JOptionPane.showInputDialog("Indique la cantidad que desea pagar"));
                            double monto = socioEncontrado.getMultasAcumuladas()-cantidad ;

                            JOptionPane.showMessageDialog(null, "Su multa era de " + socioEncontrado.getMultasAcumuladas() + "Usted pago la cantidad de " + cantidad + " El total restante es de " + monto);
                            JOptionPane.showMessageDialog(null, "El pago parcial se realizo con exito");

                            if (monto == 0.0) { //si el monton da 0.0 se realiza los cambios de estado y multas 
                                socioEncontrado.setEstadoSocio(Estadosocio.ACTIVO);
                                socioEncontrado.setMultasAcumuladas(0.0);

                            }

                            break;

                        } catch (NumberFormatException e) {

                            JOptionPane.showMessageDialog(null,
                                    "Error: Debe ingresar un número válido");

                        }
      
    }
    }else{
             JOptionPane.showMessageDialog(null, "El socio no tiene multas");
             }
        
    }
    }  
    
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
          
}





     
     
     
     
     
     
     
     
     
     
     
     
     
     
     

