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

        GeneradorSocios.cargarSocios(cantidad);
        GeneradorSocios.mostrarSocios();
        
      Libro[] libros = new Libro[50];
        int totalLibros = 0;

        totalLibros = Generadorlibros.cargarLibros(libros, totalLibros, 10);
        
        if (totalLibros >= 2) {
        libros[0].devolver();
        libros[1].extraviado();
}

        Menu.menuPrincipal(libros, totalLibros); // se llama al primer menu que va a visualizar el usuario que viene con sus submenus respectivos
 
 
    }
    

    }

     
    

