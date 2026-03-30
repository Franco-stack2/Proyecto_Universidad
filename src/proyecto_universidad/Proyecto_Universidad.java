/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_universidad;


import javax.swing.JOptionPane;

public class Proyecto_Universidad {


    public static void main(String[] args) {
  
        String input = JOptionPane.showInputDialog("Cuantos socios desea generar?");
        int cantidad = Integer.parseInt(input);
    
        
        GestionPrestamos gestion = new GestionPrestamos(); // se crean los objetos ya que todo se encuentra encapsulado por lo tanto para el menu y las otras clases 
        // se le llaman estos objetos
        GeneradorSocios socios = new GeneradorSocios();
        
        GestionSocios gestionsocios = new GestionSocios();
        
        socios.cargarSocios(cantidad);
        socios.mostrarSocios();

       Generadorlibros generador = new Generadorlibros();
       generador.cargarLibros(10);
        
       Libro[] libros = generador.getLibros(); // se llama a get Libros con el objeto generador ya que libros es private y solo se puede llamar con un get 
    
       
if (generador.getTotalLibros() >= 2) {
    libros[0].prestar();
    libros[1].extraviado();
}
       Menu menu = new Menu(); // al ser el metodo menuprincipal public pero no static hay que crear el objeto menu para poder llamarlo 
       menu.menuPrincipal(generador,socios,gestion,gestionsocios); // se llama al primer menu que va a visualizar el usuario que viene con sus submenus respectivos
 
 
    }
    

    }

     
    

