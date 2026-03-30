/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_universidad;


    import javax.swing.JOptionPane;
import java.util.ArrayList;
public class GestionPrestamos {
static ArrayList<Prestamo> listaPrestamos = new ArrayList<>();

    public void registrarPrestamo(Libro[] libros, int totalLibros,GeneradorSocios socios){

        
        String id = JOptionPane.showInputDialog("Ingrese ID del socio:"); // se le socilita al usuario el id del socio

        Socio socioEncontrado = null;

        for(int i = 0; i < socios.getListaSocios().size(); i++){

            Socio s = socios.getListaSocios().get(i);

            if(s.getIdSocio().equals(id)){
                socioEncontrado = s;
                break;
            }
        }

        if(socioEncontrado == null){
            JOptionPane.showMessageDialog(null, "El socio no existe");
            return;
        }

        if(socioEncontrado.getEstadoSocio() != Estadosocio.ACTIVO){
            JOptionPane.showMessageDialog(null, "El socio no está activo");
            return;
        }

       //aqui se solicita el isbn 
        String isbn = JOptionPane.showInputDialog("Ingrese ISBN del libro:");

        Libro libroEncontrado = null;

        for(int i = 0; i < totalLibros; i++){

            if(libros[i].getIsbn().equals(isbn)){
                libroEncontrado = libros[i];
                break;
            }
        }

        if(libroEncontrado == null){ // de aqui todo los ifs tienen el objetivo de darle al usuario retroalimentacion de que los libros no estan disponibles
            JOptionPane.showMessageDialog(null, "El libro no existe");
            return;
        }

        if(libroEncontrado.getEstadoLibro() != EstadoLibro.DISPONIBLE){ 
            JOptionPane.showMessageDialog(null, "El libro no está disponible");
            return;}
         
        if(libroEncontrado.getEstadoLibro() == EstadoLibro.EXTRAVIADO){
            JOptionPane.showMessageDialog(null, "El libro está extraviado");
            return;}
        if(libroEncontrado.getEstadoLibro() == EstadoLibro.EN_REPARACION){
            JOptionPane.showMessageDialog(null, "El libro no está en reparacion");
            return;}

       // se crea el prestamo utilizando el constructor de "Prestamo"
        Prestamo p = new Prestamo(socioEncontrado, libroEncontrado, "");
        
        

        listaPrestamos.add(p);


        libroEncontrado.prestar();

        JOptionPane.showMessageDialog(null, "Préstamo registrado correctamente"); // aquí se hace un system out print line para dar el registro del prestamo

  
        System.out.println("==== NUEVO PRESTAMO ====");
        System.out.println("ID: " + p.getIdPrestamo());
        System.out.println("Socio: " + socioEncontrado.getNombreCompleto());
        System.out.println("Libro: " + libroEncontrado.getTitulo());
        System.out.println("Estado: " + p.getEstadoPrestamo());
        
    }
    
    public  void consultarPrestamo(){

    String input = JOptionPane.showInputDialog("Ingrese ID del prestamo:");
    int id = Integer.parseInt(input);

    for(int i = 0; i < listaPrestamos.size(); i++){

        Prestamo p = listaPrestamos.get(i);

        if(p.getIdPrestamo() == id){

            JOptionPane.showMessageDialog(null,
                "ID: " + p.getIdPrestamo() + "\n" +
                "Estado: " + p.getEstadoPrestamo()
            );

            return;
        }
    }

    JOptionPane.showMessageDialog(null, "Prestamo no existe");
}
    public void registrarDevolucion(){

    String input = JOptionPane.showInputDialog("Ingrese ID del prestamo:");
    int id = Integer.parseInt(input);

    for(int i = 0; i < listaPrestamos.size(); i++){

        Prestamo p = listaPrestamos.get(i);

        if(p.getIdPrestamo() == id){

            if(p.getEstadoPrestamo() != EstadoPrestamo.ACTIVO){
                JOptionPane.showMessageDialog(null, "El prestamo no esta activo");
                return;
            }

            // se da la simulacion de una devolucion sin atrasos
            p.devolverLibros("HOY", false);

            // se cambia el estado del libro
            p.getLibro().devolver();

            JOptionPane.showMessageDialog(null, "Libro devuelto correctamente");

            return;
        }
    }

    JOptionPane.showMessageDialog(null, "Prestamo no existe");
}
    
    
}

